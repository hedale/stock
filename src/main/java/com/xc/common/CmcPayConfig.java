package com.xc.common;


import com.xc.utils.PropertiesUtil;

public class CmcPayConfig {
    public static final String KEY = "1ee6fa81e2471cacdc14714f704bf5ec11";
    public static final String UID = "LXHKVG11";
    public static final String RETURN_URL = PropertiesUtil.getProperty("website.domain.url") + "/homes/#/rechargelist";
    public static final String NOTIFY_URL = PropertiesUtil.getProperty("website.domain.url") + "/api/pay/juhenewpayNotify.do";
    public static final String URL = "https://zf.flyotcpay.com/payment/";
    public static final String CHARSET = "utf-8";
    public static final String TOKEN = "ABCDEFG";
    public static final String H5UID = "318543172911";
    public static final String H5KEY = "0aa9ac8194025b7721648cdf541e4e0b11";
    public static final String H5URL = "http://yunpay.waa.cn/";
    public static final String H5NOTIFY_URL = "http://www.huijuwang888.com/api/pay/juheh5payNotify.do";

}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.common.CmcPayConfig

 * JD-Core Version:    0.7.0.1

 */