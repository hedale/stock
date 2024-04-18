package com.xc.service.impl;

import com.xc.common.ServerResponse;
import com.xc.dao.FundsSettingMapper;
import com.xc.pojo.FundsSetting;
import com.xc.service.IFundsSettingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service("IFundsSettingService")
public class FundsSettingServiceImpl
  implements IFundsSettingService
{
  @Resource
  private FundsSettingMapper fundsSettingMapper;
  
  public int insert(FundsSetting fundsSetting)
  {
    int ret = 0;
    if (fundsSetting == null) {
      return 0;
    }
    ret = this.fundsSettingMapper.insert(fundsSetting);
    return ret;
  }
  
  public int update(FundsSetting fundsSetting)
  {
    int ret = this.fundsSettingMapper.update(fundsSetting);
    return ret > 0 ? ret : 0;
  }
  
  public FundsSetting load(int id)
  {
    return this.fundsSettingMapper.load(id);
  }
  
  public ServerResponse save(FundsSetting fundsSetting, HttpServletRequest paramHttpServletRequest)
  {
    int ret = 0;
    if ((fundsSetting == null) || (fundsSetting.getId() == null) || (fundsSetting.getId().intValue() == 0)) {
      ret = insert(fundsSetting);
    } else {
      ret = update(fundsSetting);
    }
    if (ret > 0) {
      return ServerResponse.createBySuccessMsg("操作成功");
    }
    return ServerResponse.createByErrorMsg("操作失败");
  }
  
  public FundsSetting getFundsSetting()
  {
    FundsSetting fundsSetting = null;
    List list = this.fundsSettingMapper.findAllFundsSetting();
    if (list.size() > 0) {
      fundsSetting = (FundsSetting)list.get(0);
    }
    return fundsSetting;
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.impl.FundsSettingServiceImpl

 * JD-Core Version:    0.7.0.1

 */