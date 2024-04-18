package com.xc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xc.common.ServerResponse;
import com.xc.dao.FundsSecuritiesInfoMapper;
import com.xc.pojo.FundsSecuritiesInfo;
import com.xc.service.IFundsSecuritiesInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service("IFundsSecuritiesInfoService")
public class FundsSecuritiesInfoServiceImpl
  implements IFundsSecuritiesInfoService
{
  @Resource
  private FundsSecuritiesInfoMapper fundsSecuritiesInfoMapper;
  
  public int insert(FundsSecuritiesInfo model)
  {
    int ret = 0;
    if (model == null) {
      return 0;
    }
    ret = this.fundsSecuritiesInfoMapper.insert(model);
    return ret;
  }
  
  public int update(FundsSecuritiesInfo model)
  {
    int ret = this.fundsSecuritiesInfoMapper.update(model);
    return ret > 0 ? ret : 0;
  }
  
  public ServerResponse save(FundsSecuritiesInfo model)
  {
    int ret = 0;
    if ((model != null) && (model.getId().intValue() > 0)) {
      ret = this.fundsSecuritiesInfoMapper.update(model);
    } else {
      ret = this.fundsSecuritiesInfoMapper.insert(model);
    }
    if (ret > 0) {
      return ServerResponse.createBySuccessMsg("操作成功");
    }
    return ServerResponse.createByErrorMsg("操作失败");
  }
  
  public ServerResponse<PageInfo> getList(int pageNum, int pageSize, String keyword, HttpServletRequest request)
  {
    Page<FundsSecuritiesInfo> page = PageHelper.startPage(pageNum, pageSize);
    List<FundsSecuritiesInfo> listData = this.fundsSecuritiesInfoMapper.pageList(pageNum, pageSize, keyword);
    PageInfo pageInfo = new PageInfo(page);
    pageInfo.setList(listData);
    return ServerResponse.createBySuccess(pageInfo);
  }
  
  public ServerResponse getDetail(int id)
  {
    return ServerResponse.createBySuccess(this.fundsSecuritiesInfoMapper.load(id));
  }
  
  public ServerResponse<PageInfo> getEnabledList()
  {
    List<FundsSecuritiesInfo> listData = this.fundsSecuritiesInfoMapper.getEnabledList();
    PageInfo pageInfo = new PageInfo();
    pageInfo.setList(listData);
    return ServerResponse.createBySuccess(pageInfo);
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.impl.FundsSecuritiesInfoServiceImpl

 * JD-Core Version:    0.7.0.1

 */