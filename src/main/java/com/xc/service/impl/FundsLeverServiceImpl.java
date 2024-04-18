package com.xc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xc.common.ServerResponse;
import com.xc.dao.FundsLeverMapper;
import com.xc.pojo.FundsLever;
import com.xc.service.IFundsLeverService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service("IFundsLeverService")
public class FundsLeverServiceImpl
  implements IFundsLeverService
{
  @Resource
  private FundsLeverMapper fundsLeverMapper;
  
  public int insert(FundsLever fundsLever)
  {
    int ret = 0;
    if (fundsLever == null) {
      return 0;
    }
    ret = this.fundsLeverMapper.insert(fundsLever);
    return ret;
  }
  
  public int delete(int id)
  {
    int ret = this.fundsLeverMapper.delete(id);
    return ret > 0 ? ret : 0;
  }
  
  public int update(FundsLever fundsLever)
  {
    int ret = this.fundsLeverMapper.update(fundsLever);
    return ret > 0 ? ret : 0;
  }
  
  public ServerResponse<PageInfo> getFundsLeverList(int pageNum, int pageSize, HttpServletRequest request)
  {
    Page<FundsLever> page = PageHelper.startPage(pageNum, pageSize);
    List<FundsLever> fundsLevers = this.fundsLeverMapper.pageList(pageNum, pageSize);
    PageInfo pageInfo = new PageInfo(page);
    pageInfo.setList(fundsLevers);
    return ServerResponse.createBySuccess(pageInfo);
  }
  
  public ServerResponse saveFundsLever(FundsLever fundsLever)
  {
    int ret = 0;
    if ((fundsLever != null) && (fundsLever.getId().intValue() > 0)) {
      ret = this.fundsLeverMapper.update(fundsLever);
    } else {
      ret = this.fundsLeverMapper.insert(fundsLever);
    }
    if (ret > 0) {
      return ServerResponse.createBySuccessMsg("操作成功");
    }
    return ServerResponse.createByErrorMsg("操作失败");
  }
  
  public ServerResponse getFundsTypeList(Integer cycleType)
  {
    List<FundsLever> fundsLevers = this.fundsLeverMapper.getFundsTypeList(cycleType);
    PageInfo pageInfo = new PageInfo();
    pageInfo.setList(fundsLevers);
    return ServerResponse.createBySuccess(pageInfo);
  }
  
  public ServerResponse getLeverRateInfo(Integer cycleType, Integer lever)
  {
    FundsLever fundsLevers = this.fundsLeverMapper.getLeverRateInfo(cycleType, lever);
    return ServerResponse.createBySuccess(fundsLevers);
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.impl.FundsLeverServiceImpl

 * JD-Core Version:    0.7.0.1

 */