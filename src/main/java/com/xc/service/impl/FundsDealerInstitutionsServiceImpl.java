package com.xc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xc.common.ServerResponse;
import com.xc.dao.FundsDealerInstitutionsMapper;
import com.xc.pojo.FundsDealerInstitutions;
import com.xc.service.IFundsDealerInstitutionsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service("IFundsDealerInstitutionsService")
public class FundsDealerInstitutionsServiceImpl
  implements IFundsDealerInstitutionsService
{
  @Resource
  private FundsDealerInstitutionsMapper fundsDealerInstitutionsMapper;
  
  public int insert(FundsDealerInstitutions model)
  {
    int ret = 0;
    if (model == null) {
      return 0;
    }
    ret = this.fundsDealerInstitutionsMapper.insert(model);
    return ret;
  }
  
  public int update(FundsDealerInstitutions model)
  {
    int ret = this.fundsDealerInstitutionsMapper.update(model);
    return ret > 0 ? ret : 0;
  }
  
  public ServerResponse save(FundsDealerInstitutions model)
  {
    int ret = 0;
    if ((model != null) && (model.getId().intValue() > 0)) {
      ret = this.fundsDealerInstitutionsMapper.update(model);
    } else {
      ret = this.fundsDealerInstitutionsMapper.insert(model);
    }
    if (ret > 0) {
      return ServerResponse.createBySuccessMsg("操作成功");
    }
    return ServerResponse.createByErrorMsg("操作失败");
  }
  
  public ServerResponse<PageInfo> getList(int pageNum, int pageSize, String keyword, Integer status, HttpServletRequest request)
  {
    Page<FundsDealerInstitutions> page = PageHelper.startPage(pageNum, pageSize);
    List<FundsDealerInstitutions> listData = this.fundsDealerInstitutionsMapper.pageList(pageNum, pageSize, keyword, status);
    PageInfo pageInfo = new PageInfo(page);
    pageInfo.setList(listData);
    return ServerResponse.createBySuccess(pageInfo);
  }
  
  public ServerResponse getDetail(int id)
  {
    return ServerResponse.createBySuccess(this.fundsDealerInstitutionsMapper.load(id));
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.impl.FundsDealerInstitutionsServiceImpl

 * JD-Core Version:    0.7.0.1

 */