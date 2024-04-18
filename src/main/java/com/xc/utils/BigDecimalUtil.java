package com.xc.utils;

import java.math.BigDecimal;

public class BigDecimalUtil
{
  public static BigDecimal add(double v1, double v2)
  {
    BigDecimal b1 = new BigDecimal(Double.toString(v1));
    
    BigDecimal b2 = new BigDecimal(Double.toString(v2));
    
    return b1.add(b2);
  }
  
  public static BigDecimal sub(double v1, double v2)
  {
    BigDecimal b1 = new BigDecimal(Double.toString(v1));
    
    BigDecimal b2 = new BigDecimal(Double.toString(v2));
    
    return b1.subtract(b2);
  }
  
  public static BigDecimal mul(double v1, double v2)
  {
    BigDecimal b1 = new BigDecimal(Double.toString(v1));
    
    BigDecimal b2 = new BigDecimal(Double.toString(v2));
    
    return b1.multiply(b2);
  }
  
  public static BigDecimal div(double v1, double v2)
  {
    BigDecimal b1 = new BigDecimal(Double.toString(v1));
    
    BigDecimal b2 = new BigDecimal(Double.toString(v2));
    
    return b1.divide(b2, 2, 4);
  }
  
  public static double getTwoNum()
  {
    double num = Math.random();
    

    return new BigDecimal(num).setScale(2, 4).doubleValue();
  }
  
  public static void main(String[] args)
  {
    System.out.println(getTwoNum());
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.utils.BigDecimalUtil

 * JD-Core Version:    0.7.0.1

 */