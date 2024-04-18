package com.xc.vo.stock;

public class MarketVO
{
  private String name;
  private String nowPrice;
  private String increaseRate;
  private String increase;
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public void setNowPrice(String nowPrice)
  {
    this.nowPrice = nowPrice;
  }
  
  public void setIncreaseRate(String increaseRate)
  {
    this.increaseRate = increaseRate;
  }
  
  public void setIncrease(String increase)
  {
    this.increase = increase;
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof MarketVO)) {
      return false;
    }
    MarketVO other = (MarketVO)o;
    if (!other.canEqual(this)) {
      return false;
    }
    Object this$name = getName();Object other$name = other.getName();
    if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
      return false;
    }
    Object this$nowPrice = getNowPrice();Object other$nowPrice = other.getNowPrice();
    if (this$nowPrice == null ? other$nowPrice != null : !this$nowPrice.equals(other$nowPrice)) {
      return false;
    }
    Object this$increaseRate = getIncreaseRate();Object other$increaseRate = other.getIncreaseRate();
    if (this$increaseRate == null ? other$increaseRate != null : !this$increaseRate.equals(other$increaseRate)) {
      return false;
    }
    Object this$increase = getIncrease();Object other$increase = other.getIncrease();
    return this$increase == null ? other$increase == null : this$increase.equals(other$increase);
  }
  
  protected boolean canEqual(Object other)
  {
    return other instanceof MarketVO;
  }
  
  public int hashCode()
  {
    int PRIME = 59;
    int result = 1;
    Object $name = getName();
    result = result * 59 + ($name == null ? 43 : $name.hashCode());
    Object $nowPrice = getNowPrice();
    result = result * 59 + ($nowPrice == null ? 43 : $nowPrice.hashCode());
    Object $increaseRate = getIncreaseRate();
    result = result * 59 + ($increaseRate == null ? 43 : $increaseRate.hashCode());
    Object $increase = getIncrease();
    return result * 59 + ($increase == null ? 43 : $increase.hashCode());
  }
  
  public String toString()
  {
    return "MarketVO(name=" + getName() + ", nowPrice=" + getNowPrice() + ", increaseRate=" + getIncreaseRate() + ", increase=" + getIncrease() + ")";
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getNowPrice()
  {
    return this.nowPrice;
  }
  
  public String getIncreaseRate()
  {
    return this.increaseRate;
  }
  
  public String getIncrease()
  {
    return this.increase;
  }
}


/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\
 * Qualified Name:     com.xc.vo.stock.MarketVO
 * JD-Core Version:    0.7.0.1
 */