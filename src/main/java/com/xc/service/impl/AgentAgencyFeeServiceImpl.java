package com.xc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xc.common.ServerResponse;
import com.xc.dao.AgentAgencyFeeMapper;
import com.xc.dao.AgentUserMapper;
import com.xc.dao.UserMapper;
import com.xc.dao.UserPositionMapper;
import com.xc.pojo.AgentAgencyFee;
import com.xc.pojo.AgentUser;
import com.xc.pojo.User;
import com.xc.pojo.UserPosition;
import com.xc.service.IAgentAgencyFeeService;
import com.xc.service.IAgentUserService;
import com.xc.service.IUserPositionService;
import com.xc.utils.PropertiesUtil;
import com.xc.utils.redis.CookieUtils;
import com.xc.utils.redis.JsonUtil;
import com.xc.utils.redis.RedisShardedPoolUtils;
import com.xc.vo.agent.AgentAgencyFeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

@Service("IAgentAgencyFeeService")
public class AgentAgencyFeeServiceImpl
  implements IAgentAgencyFeeService
{
  @Resource
  private AgentAgencyFeeMapper agentAgencyFeeMapper;
  @Autowired
  IAgentUserService iAgentUserService;
  @Autowired
  IUserPositionService iUserPositionService;
  @Autowired
  AgentUserMapper agentUserMapper;
  @Autowired
  UserPositionMapper userPositionMapper;
  @Autowired
  UserMapper userMapper;
  
  public int insert(AgentAgencyFee agentAgencyFee)
  {
    int ret = 0;
    if (agentAgencyFee == null) {
      return 0;
    }
    ret = this.agentAgencyFeeMapper.insert(agentAgencyFee);
    return ret;
  }
  
  public int update(AgentAgencyFee agentAgencyFee)
  {
    int ret = this.agentAgencyFeeMapper.update(agentAgencyFee);
    return ret > 0 ? ret : 0;
  }
  
  private BigDecimal getScale(AgentUser agentUser, int feeType)
  {
    BigDecimal scale = new BigDecimal(0);
    if ((feeType == 1) || (feeType == 2)) {
      scale = agentUser.getPoundageScale();
    } else if (feeType == 3) {
      scale = agentUser.getDeferredFeesScale();
    } else if (feeType == 4) {
      scale = agentUser.getReceiveDividendsScale();
    }
    return scale;
  }
  
  public int AgencyFeeIncome(int feeType, String positionSn)
  {
    int ret = 0;
    int businessId = 0;
    int agentId = 0;
    int level = 0;
    BigDecimal totalMoney = new BigDecimal(0);
    BigDecimal oneProfitMoney = new BigDecimal(0);
    BigDecimal upProfitMoney = new BigDecimal(0);
    BigDecimal selfProfitMoney = new BigDecimal(0);
    BigDecimal downProfitMoney = new BigDecimal(0);
    BigDecimal scale = new BigDecimal(0);
    String remarks = "";
    int downAgentId = 0;
    AgentUser agentUser = null;
    UserPosition userPosition = null;
    userPosition = this.userPositionMapper.findPositionBySn(positionSn);
    agentUser = this.agentUserMapper.findAgentByAgentId(userPosition.getAgentId().intValue());
    agentId = agentUser.getId().intValue();
    level = agentUser.getAgentLevel().intValue();
    businessId = userPosition.getId().intValue();
    if (feeType == 1)
    {
      totalMoney = userPosition.getOrderFee();
      remarks = "【入仓收入】入仓手续费总额：" + userPosition.getOrderFee() + "，单号：" + userPosition.getPositionSn();
    }
    else if (feeType == 2)
    {
      totalMoney = userPosition.getAllProfitAndLose().multiply(new BigDecimal(-1));
      remarks = "【平仓收入】平仓手续费总额：" + userPosition.getOrderFee() + "，单号：" + userPosition.getPositionSn();
    }
    else if (feeType == 3)
    {
      totalMoney = userPosition.getOrderStayFee();
      remarks = "【递延费收入】递延费总额：" + userPosition.getOrderFee() + "，单号：" + userPosition.getPositionSn();
    }
    else if (feeType == 4)
    {
      totalMoney = userPosition.getAllProfitAndLose().multiply(new BigDecimal(-1));
      remarks = "【分红收入】分红总额：" + userPosition.getOrderFee() + "，单号：" + userPosition.getPositionSn();
    }
    if (totalMoney.compareTo(new BigDecimal(0)) <= 0) {
      return -1;
    }
    User user = this.userMapper.selectByPrimaryKey(userPosition.getUserId());
    if ((user.getAccountType().intValue() != 0) || (user.getIsLock().intValue() != 0) || (user.getIsActive().intValue() != 2)) {
      return -2;
    }
    List<AgentUser> agentlist = this.iAgentUserService.getAgentSuperiorList(agentUser.getId().intValue());
    if ((agentlist != null) && (agentlist.size() > 0)) {
      if (agentlist.size() == 1)
      {
        AgentAgencyFee agentAgencyFee = new AgentAgencyFee();
        scale = getScale(agentUser, feeType);
        selfProfitMoney = totalMoney.multiply(scale).setScale(4, 4);
        agentAgencyFee.setAgentId(agentUser.getId());
        agentAgencyFee.setStatus(Integer.valueOf(1));
        agentAgencyFee.setAymentType(Integer.valueOf(1));
        agentAgencyFee.setBusinessId(Integer.valueOf(businessId));
        agentAgencyFee.setFeeType(Integer.valueOf(feeType));
        agentAgencyFee.setTotalMoney(totalMoney);
        agentAgencyFee.setProfitMoney(selfProfitMoney);
        agentAgencyFee.setRemarks(remarks);
        saveAgencyFee(agentAgencyFee);
        
        agentUser = this.agentUserMapper.findAgentByAgentId(agentUser.getParentId().intValue());
        AgentAgencyFee totalAgent = new AgentAgencyFee();
        totalAgent.setAgentId(agentUser.getId());
        totalAgent.setStatus(Integer.valueOf(1));
        totalAgent.setAymentType(Integer.valueOf(1));
        totalAgent.setBusinessId(Integer.valueOf(businessId));
        totalAgent.setFeeType(Integer.valueOf(feeType));
        upProfitMoney = totalMoney.subtract(selfProfitMoney);
        totalAgent.setTotalMoney(totalMoney);
        totalAgent.setProfitMoney(upProfitMoney);
        totalAgent.setRemarks(remarks);
        saveAgencyFee(totalAgent);
      }
      else if (agentlist.size() > 1)
      {
        for (int i = 1; i < agentlist.size(); i++)
        {
          AgentUser model = (AgentUser)agentlist.get(i);
          if (i == 1)
          {
            AgentAgencyFee agentAgencyFee = new AgentAgencyFee();
            if (agentlist.size() == 2)
            {
              AgentUser selfAgentUser = this.agentUserMapper.findAgentByAgentId(agentId);
              scale = getScale(model, feeType);
              oneProfitMoney = totalMoney.multiply(scale).setScale(4, 4);
              scale = getScale(selfAgentUser, feeType);
              downProfitMoney = oneProfitMoney.multiply(scale).setScale(4, 4);
              selfProfitMoney = oneProfitMoney.subtract(downProfitMoney);
            }
            else
            {
              AgentUser modeldown = (AgentUser)agentlist.get(i + 1);
              scale = getScale(model, feeType);
              oneProfitMoney = totalMoney.multiply(scale).setScale(4, 4);
              scale = getScale(modeldown, feeType);
              downProfitMoney = oneProfitMoney.multiply(scale).setScale(4, 4);
              selfProfitMoney = oneProfitMoney.subtract(downProfitMoney);
            }
            agentAgencyFee.setAgentId(model.getId());
            agentAgencyFee.setStatus(Integer.valueOf(1));
            agentAgencyFee.setAymentType(Integer.valueOf(1));
            agentAgencyFee.setBusinessId(Integer.valueOf(businessId));
            agentAgencyFee.setFeeType(Integer.valueOf(feeType));
            agentAgencyFee.setTotalMoney(totalMoney);
            agentAgencyFee.setProfitMoney(selfProfitMoney);
            agentAgencyFee.setRemarks(remarks);
            
            saveAgencyFee(agentAgencyFee);
            
            agentUser = this.agentUserMapper.findAgentByAgentId(model.getParentId().intValue());
            AgentAgencyFee totalAgent = new AgentAgencyFee();
            totalAgent.setAgentId(agentUser.getId());
            totalAgent.setStatus(Integer.valueOf(1));
            totalAgent.setAymentType(Integer.valueOf(1));
            totalAgent.setBusinessId(Integer.valueOf(businessId));
            totalAgent.setFeeType(Integer.valueOf(feeType));
            upProfitMoney = totalMoney.subtract(oneProfitMoney);
            totalAgent.setTotalMoney(totalMoney);
            totalAgent.setProfitMoney(upProfitMoney);
            totalAgent.setRemarks(remarks);
            saveAgencyFee(totalAgent);
            upProfitMoney = downProfitMoney;
            ret += 1;
          }
          else
          {
            AgentAgencyFee agentAgencyFee = new AgentAgencyFee();
            if (i == level - 1)
            {
              AgentUser selfAgentUser = this.agentUserMapper.findAgentByAgentId(agentId);
              scale = getScale(selfAgentUser, feeType);
              downProfitMoney = upProfitMoney.multiply(scale).setScale(4, 4);
              selfProfitMoney = upProfitMoney.subtract(downProfitMoney);
            }
            else
            {
              AgentUser modeldown = (AgentUser)agentlist.get(i + 1);
              scale = getScale(modeldown, feeType);
              downProfitMoney = upProfitMoney.multiply(scale).setScale(4, 4);
              selfProfitMoney = upProfitMoney.subtract(downProfitMoney);
            }
            agentAgencyFee.setAgentId(model.getId());
            agentAgencyFee.setStatus(Integer.valueOf(1));
            agentAgencyFee.setAymentType(Integer.valueOf(1));
            agentAgencyFee.setBusinessId(Integer.valueOf(businessId));
            agentAgencyFee.setFeeType(Integer.valueOf(feeType));
            agentAgencyFee.setTotalMoney(totalMoney);
            agentAgencyFee.setProfitMoney(selfProfitMoney);
            agentAgencyFee.setRemarks(remarks);
            saveAgencyFee(agentAgencyFee);
            upProfitMoney = downProfitMoney;
            ret += 1;
          }
        }
        AgentAgencyFee agentAgencyFee = new AgentAgencyFee();
        agentAgencyFee.setAgentId(Integer.valueOf(agentId));
        agentAgencyFee.setStatus(Integer.valueOf(1));
        agentAgencyFee.setAymentType(Integer.valueOf(1));
        agentAgencyFee.setBusinessId(Integer.valueOf(businessId));
        agentAgencyFee.setFeeType(Integer.valueOf(feeType));
        agentAgencyFee.setTotalMoney(totalMoney);
        agentAgencyFee.setProfitMoney(downProfitMoney);
        agentAgencyFee.setRemarks(remarks);
        saveAgencyFee(agentAgencyFee);
      }
    }
    return ret;
  }
  
  public int saveAgencyFee(AgentAgencyFee model)
  {
    int k = 0;
    
    k = insert(model);
    
    AgentUser user = new AgentUser();
    user.setId(model.getAgentId());
    user.setTotalMoney(model.getProfitMoney());
    k = this.agentUserMapper.updateTotalMoney(user);
    return k;
  }
  
  public ServerResponse<PageInfo> getAgentAgencyFeeList(int pageNum, int pageSize, HttpServletRequest request)
  {
    Page<AgentAgencyFeeVO> page = PageHelper.startPage(pageNum, pageSize);
    AgentUser agentUser = getCurrentAgent(request);
    List<AgentAgencyFee> agentAgencyFees = this.agentAgencyFeeMapper.getAgentAgencyFeeList(agentUser.getId());
    PageInfo pageInfo = new PageInfo(page);
    pageInfo.setList(agentAgencyFees);
    return ServerResponse.createBySuccess(pageInfo);
  }
  
  public AgentUser getCurrentAgent(HttpServletRequest request)
  {
    String loginToken = CookieUtils.readLoginToken(request, PropertiesUtil.getProperty("agent.cookie.name"));
    String agentJson = RedisShardedPoolUtils.get(loginToken);
    AgentUser agentUser = (AgentUser)JsonUtil.string2Obj(agentJson, AgentUser.class);
    return this.agentUserMapper.selectByPrimaryKey(agentUser.getId());
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.impl.AgentAgencyFeeServiceImpl

 * JD-Core Version:    0.7.0.1

 */