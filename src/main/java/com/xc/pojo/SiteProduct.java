package com.xc.pojo;

public class SiteProduct
{
  private Integer id;
  private Boolean stockDisplay;
  private Boolean kcStockDisplay;
  private Boolean indexDisplay;
  private Boolean futuresDisplay;
  private Boolean realNameDisplay;
  private Boolean fundsDisplay;
  private Boolean delayDisplay;
  private Boolean expandDisplay;
  private Boolean marginDisplay;
  private Boolean endDisplay;
  private Boolean stockMarginDisplay;
  private Boolean holidayDisplay;
  
  public SiteProduct(Integer id, Boolean stockDisplay, Boolean kcStockDisplay, Boolean indexDisplay, Boolean futuresDisplay, Boolean realNameDisplay, Boolean fundsDisplay, Boolean delayDisplay, Boolean expandDisplay, Boolean marginDisplay, Boolean endDisplay, Boolean stockMarginDisplay, Boolean holidayDisplay)
  {
    this.id = id;
    this.stockDisplay = stockDisplay;
    this.kcStockDisplay = kcStockDisplay;
    this.indexDisplay = indexDisplay;
    this.futuresDisplay = futuresDisplay;
    this.realNameDisplay = realNameDisplay;
    this.fundsDisplay = fundsDisplay;
    this.delayDisplay = delayDisplay;
    this.expandDisplay = expandDisplay;
    this.marginDisplay = marginDisplay;
    this.endDisplay = endDisplay;
    this.stockMarginDisplay = stockMarginDisplay;
    this.holidayDisplay = holidayDisplay;
  }
  
  public SiteProduct() {}
  
  public Integer getId()
  {
    return this.id;
  }
  
  public void setId(Integer id)
  {
    this.id = id;
  }
  
  public Boolean getStockDisplay()
  {
    return this.stockDisplay;
  }
  
  public void setStockDisplay(Boolean stockDisplay)
  {
    this.stockDisplay = stockDisplay;
  }
  
  public Boolean getKcStockDisplay()
  {
    return this.kcStockDisplay;
  }
  
  public void setKcStockDisplay(Boolean kcStockDisplay)
  {
    this.kcStockDisplay = kcStockDisplay;
  }
  
  public Boolean getIndexDisplay()
  {
    return this.indexDisplay;
  }
  
  public void setIndexDisplay(Boolean indexDisplay)
  {
    this.indexDisplay = indexDisplay;
  }
  
  public Boolean getFuturesDisplay()
  {
    return this.futuresDisplay;
  }
  
  public void setFuturesDisplay(Boolean futuresDisplay)
  {
    this.futuresDisplay = futuresDisplay;
  }
  
  public Boolean getRealNameDisplay()
  {
    return this.realNameDisplay;
  }
  
  public Boolean getStockMarginDisplay()
  {
    return this.stockMarginDisplay;
  }
  
  public void setStockMarginDisplay(Boolean stockMarginDisplay)
  {
    this.stockMarginDisplay = stockMarginDisplay;
  }
  
  public Boolean getFundsDisplay()
  {
    return this.fundsDisplay;
  }
  
  public void setFundsDisplay(Boolean fundsDisplay)
  {
    this.fundsDisplay = fundsDisplay;
  }
  
  public Boolean getDelayDisplay()
  {
    return this.delayDisplay;
  }
  
  public void setDelayDisplay(Boolean delayDisplay)
  {
    this.delayDisplay = delayDisplay;
  }
  
  public Boolean getExpandDisplay()
  {
    return this.expandDisplay;
  }
  
  public void setExpandDisplay(Boolean expandDisplay)
  {
    this.expandDisplay = expandDisplay;
  }
  
  public Boolean getMarginDisplay()
  {
    return this.marginDisplay;
  }
  
  public void setMarginDisplay(Boolean marginDisplay)
  {
    this.marginDisplay = marginDisplay;
  }
  
  public Boolean getEndDisplay()
  {
    return this.endDisplay;
  }
  
  public void setEndDisplay(Boolean endDisplay)
  {
    this.endDisplay = endDisplay;
  }
  
  public Boolean getHolidayDisplay()
  {
    return this.holidayDisplay;
  }
  
  public void setHolidayDisplay(Boolean holidayDisplay)
  {
    this.holidayDisplay = holidayDisplay;
  }
}


/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\
 * Qualified Name:     com.xc.pojo.SiteProduct
 * JD-Core Version:    0.7.0.1
 */