package com.xc.utils.pay;

import com.alibaba.fastjson.JSON;
import com.xc.common.CmcPayConfig;
import com.xc.controller.protol.UserPayController;
import org.apache.commons.collections.map.LinkedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Date;

public class CmcPayTool
{
  private static final Logger log = LoggerFactory.getLogger(UserPayController.class);
  
  public static String submitOrder(String amount, String orderid, String pay_id, HttpServletRequest request)
    throws Exception
  {
    if ((orderid == null) || (orderid.trim().equals(""))) {
      orderid = "OF" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    }
    LinkedMap params = new LinkedMap();
    params.put("merchantid", "LXHKVG11");
    params.put("orderno", orderid);
    params.put("orderamount", amount);
    params.put("paytype", "bank");
    params.put("ordercurrency", "CNY");
    String userAgent = request.getHeader("user-agent");
    String returnUrl = CmcPayConfig.RETURN_URL;
    if ((userAgent.indexOf("Android") != -1) || (userAgent.indexOf("iPhone") != -1) || (userAgent.indexOf("iPad") != -1)) {
      returnUrl = returnUrl.replace("/homes/", "/wap/");
    }
    params.put("callbackurl", returnUrl);
    params.put("serverbackurl", CmcPayConfig.NOTIFY_URL);
    params.put("signtype", "md5");
    Encoder encoder = Base64.getEncoder();
    log.info("提交支付订单key=1ee6fa81e2471cacdc14714f704bf5ec11");
    String _sign = CmcPayOuterRequestUtil.getSign(params, "1ee6fa81e2471cacdc14714f704bf5ec11");
    params.put("sign", _sign);
    params.put("url", "https://zf.flyotcpay.com/payment/");
    String par = JSON.toJSONString(params).toString();
    log.info("提交支付订单参数=" + par);
    
    return par;
  }
  
  public static String submitOrderH5(String amount, String orderid, String pay_id)
    throws Exception
  {
    if ((orderid == null) || (orderid.trim().equals(""))) {
      orderid = "OF" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    }
    LinkedMap params = new LinkedMap();
    params.put("appid", "318543172911");
    params.put("data", orderid);
    Double d = Double.valueOf(Double.parseDouble(amount));
    DecimalFormat df = new DecimalFormat("0.00");
    String s = df.format(d);
    params.put("money", s);
    params.put("type", pay_id);
    InetAddress addr = InetAddress.getLocalHost();
    params.put("uip", addr.getHostAddress());
    Encoder encoder = Base64.getEncoder();
    log.info("提交支付订单key=0aa9ac8194025b7721648cdf541e4e0b11");
    String _sign = CmcPayOuterRequestUtil.getSignH5(params, "0aa9ac8194025b7721648cdf541e4e0b11");
    params.put("token", _sign);
    String urlWithParams = CmcPayOuterRequestUtil.post("http://yunpay.waa.cn/", params);
    return urlWithParams;
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.utils.pay.CmcPayTool

 * JD-Core Version:    0.7.0.1

 */