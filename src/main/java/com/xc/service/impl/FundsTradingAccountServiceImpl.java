package com.xc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xc.common.ServerResponse;
import com.xc.dao.FundsTradingAccountMapper;
import com.xc.pojo.FundsTradingAccount;
import com.xc.service.IFundsTradingAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service("IFundsTradingAccountService")
public class FundsTradingAccountServiceImpl
  implements IFundsTradingAccountService
{
  @Resource
  private FundsTradingAccountMapper fundsTradingAccountMapper;
  
  public int insert(FundsTradingAccount model)
  {
    int ret = 0;
    if (model == null) {
      return 0;
    }
    ret = this.fundsTradingAccountMapper.insert(model);
    return ret;
  }
  
  public int update(FundsTradingAccount model)
  {
    int ret = this.fundsTradingAccountMapper.update(model);
    return ret > 0 ? ret : 0;
  }
  
  public ServerResponse save(FundsTradingAccount model)
  {
    int ret = 0;
    if ((model != null) && (model.getId().intValue() > 0)) {
      ret = this.fundsTradingAccountMapper.update(model);
    } else {
      ret = this.fundsTradingAccountMapper.insert(model);
    }
    if (ret > 0) {
      return ServerResponse.createBySuccessMsg("操作成功");
    }
    return ServerResponse.createByErrorMsg("操作失败");
  }
  
  public ServerResponse<PageInfo> getList(int pageNum, int pageSize, String keyword, Integer status, HttpServletRequest request)
  {
    PageHelper.startPage(pageNum, pageSize);
    List<FundsTradingAccount> listData = this.fundsTradingAccountMapper.pageList(pageNum, pageSize, keyword, status);
    PageInfo pageInfo = new PageInfo(listData);
    pageInfo.setList(listData);
    return ServerResponse.createBySuccess(pageInfo);
  }
  
  public ServerResponse getDetail(int id)
  {
    return ServerResponse.createBySuccess(this.fundsTradingAccountMapper.load(id));
  }
  
  public ServerResponse getMaxNumber()
  {
    int ret = this.fundsTradingAccountMapper.getMaxNumber();
    return ServerResponse.createBySuccess(String.valueOf(ret));
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.impl.FundsTradingAccountServiceImpl

 * JD-Core Version:    0.7.0.1

 */