package com.xc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xc.common.ServerResponse;
import com.xc.dao.FundsAppendMapper;
import com.xc.dao.FundsApplyMapper;
import com.xc.dao.FundsLeverMapper;
import com.xc.pojo.FundsAppend;
import com.xc.pojo.FundsApply;
import com.xc.pojo.FundsLever;
import com.xc.pojo.User;
import com.xc.service.IFundsAppendService;
import com.xc.service.IUserService;
import com.xc.utils.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service("IFundsAppendService")
public class FundsAppendServiceImpl
  implements IFundsAppendService
{
  @Resource
  private FundsAppendMapper fundsAppendMapper;
  @Autowired
  IUserService iUserService;
  @Autowired
  FundsApplyMapper fundsApplyMapper;
  @Autowired
  FundsLeverMapper fundsLeverMapper;
  
  public int insert(FundsAppend model)
  {
    int ret = 0;
    if (model == null) {
      return 0;
    }
    ret = this.fundsAppendMapper.insert(model);
    return ret;
  }
  
  public int update(FundsAppend model)
  {
    int ret = this.fundsAppendMapper.update(model);
    return ret > 0 ? ret : 0;
  }
  
  @Transactional
  public ServerResponse save(FundsAppend model, HttpServletRequest request)
  {
    int ret = 0;
    if ((model.getApplyId() == null) || (model.getApplyId().intValue() == 0)) {
      return ServerResponse.createByErrorMsg("操作异常，请稍后再试");
    }
    FundsApply fundsApply = this.fundsApplyMapper.load(model.getApplyId().intValue());
    if (fundsApply == null) {
      return ServerResponse.createByErrorMsg("子账户不存在，请稍后再试");
    }
    User user = this.iUserService.getCurrentRefreshUser(request);
    if (user == null) {
      return ServerResponse.createBySuccessMsg("请登录后操作");
    }
    if ((model != null) && (model.getId().intValue() > 0))
    {
      FundsAppend fundsAppend = this.fundsAppendMapper.load(model.getId().intValue());
      model.setAuditTime(DateTimeUtil.getCurrentDate());
      SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      if (fundsAppend.getAppendType().intValue() != 1) {
        if (fundsAppend.getAppendType().intValue() == 3)
        {
          String endtime = df.format(fundsApply.getEndTime());
          Date endDate = DateTimeUtil.strToDate(endtime);
          endDate = DateTimeUtil.addDay(endDate, fundsAppend.getAppendCycle().intValue());
          model.setEndTime(endDate);
          model.setTradersCycle(Integer.valueOf(fundsAppend.getTradersCycle().intValue() + fundsAppend.getAppendCycle().intValue()));
          
          fundsApply.setEndTime(endDate);
          this.fundsApplyMapper.update(fundsApply);
        }
        else if (fundsAppend.getAppendType().intValue() == 4)
        {
          if (model.getStatus().intValue() == 1)
          {
            fundsApply.setStatus(Integer.valueOf(4));
            this.fundsApplyMapper.update(fundsApply);
          }
        }
      }
      ret = this.fundsAppendMapper.update(model);
    }
    else
    {
      model.setUserId(user.getId());
      model.setUserName(user.getRealName());
      model.setUserPhone(user.getPhone());
      model.setMargin(fundsApply.getMargin());
      model.setFundsAmount(fundsApply.getFundsAmount());
      model.setLever(fundsApply.getLever());
      model.setManageFee(fundsApply.getManageFee());
      model.setTotalTradingAmount(fundsApply.getTotalTradingAmount());
      model.setLineWarning(fundsApply.getLineWarning());
      model.setLineUnwind(fundsApply.getLineUnwind());
      model.setRatioWarning(fundsApply.getRatioWarning());
      model.setRatioUnwind(fundsApply.getRatioUnwind());
      model.setEndTime(fundsApply.getEndTime());
      if (model.getAppendType().intValue() == 1)
      {
        model.setTradersCycle(fundsApply.getTradersCycle());
        FundsLever fundsLever = this.fundsLeverMapper.getLeverRateInfo(Integer.valueOf(1), fundsApply.getLever());
        BigDecimal appendServiceFee = model.getAppendMargin().multiply(fundsLever.getManageRate());
        model.setAppendServiceFee(appendServiceFee);
        model.setPayAmount(model.getAppendMargin());
      }
      else if (model.getAppendType().intValue() == 2)
      {
        model.setTradersCycle(fundsApply.getTradersCycle());
        model.setPayAmount(model.getAppendMargin());
      }
      else if (model.getAppendType().intValue() == 3)
      {
        model.setTradersCycle(model.getAppendCycle());
        model.setPayAmount(model.getAppendServiceFee());
      }
      else if (model.getAppendType().intValue() == 4)
      {
        int isAppendEnd = this.fundsAppendMapper.isAppendEnd(model.getApplyId());
        if (isAppendEnd > 0) {
          return ServerResponse.createByErrorMsg("申请已提交，无需重复操作！");
        }
        model.setTradersCycle(model.getAppendCycle());
        model.setPayAmount(model.getAppendServiceFee());
      }
      ret = this.fundsAppendMapper.insert(model);
    }
    if (ret > 0) {
      return ServerResponse.createBySuccessMsg("操作成功");
    }
    return ServerResponse.createByErrorMsg("操作失败");
  }
  
  public ServerResponse<PageInfo> getList(int pageNum, int pageSize, String keyword, Integer status, Integer userId, Integer appendType, HttpServletRequest request)
  {
    PageHelper.startPage(pageNum, pageSize);
    List<FundsAppend> listData = this.fundsAppendMapper.pageList(pageNum, pageSize, keyword, status, userId, appendType);
    PageInfo pageInfo = new PageInfo(listData);
    pageInfo.setList(listData);
    return ServerResponse.createBySuccess(pageInfo);
  }
  
  public ServerResponse getDetail(int id)
  {
    return ServerResponse.createBySuccess(this.fundsAppendMapper.load(id));
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.impl.FundsAppendServiceImpl

 * JD-Core Version:    0.7.0.1

 */