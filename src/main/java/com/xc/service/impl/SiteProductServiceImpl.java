package com.xc.service.impl;

import com.xc.common.ServerResponse;
import com.xc.dao.SiteProductMapper;
import com.xc.pojo.SiteProduct;
import com.xc.service.ISiteProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iSiteProductService")
public class SiteProductServiceImpl
  implements ISiteProductService
{
  private static final Logger log = LoggerFactory.getLogger(SiteProductServiceImpl.class);
  @Autowired
  SiteProductMapper siteProductMapper;
  
  public ServerResponse update(SiteProduct siteProduct)
  {
    if (siteProduct.getId() == null) {
      return ServerResponse.createByErrorMsg("修改id不能为空");
    }
    SiteProduct dbproduct = this.siteProductMapper.selectByPrimaryKey(siteProduct.getId());
    if (dbproduct == null) {
      return ServerResponse.createByErrorMsg("不存在产品设置记录");
    }
    int updateCount = this.siteProductMapper.updateByPrimaryKeySelective(siteProduct);
    if (updateCount > 0) {
      return ServerResponse.createBySuccessMsg("修改成功");
    }
    return ServerResponse.createByErrorMsg("修改失败");
  }
  
  public SiteProduct getProductSetting()
  {
    SiteProduct siteProduct = null;
    List list = this.siteProductMapper.findAllSiteSetting();
    if (list.size() > 0) {
      siteProduct = (SiteProduct)list.get(0);
    }
    return siteProduct;
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.impl.SiteProductServiceImpl

 * JD-Core Version:    0.7.0.1

 */