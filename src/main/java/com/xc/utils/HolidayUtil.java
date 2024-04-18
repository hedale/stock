package com.xc.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HolidayUtil
{
  public static String request(String httpArg)
  {
    String httpUrl = "http://tool.bitefu.net/jiari/";
    BufferedReader reader = null;
    String result = null;
    StringBuffer sbf = new StringBuffer();
    httpUrl = httpUrl + "?d=" + httpArg;
    try
    {
      URL url = new URL(httpUrl);
      
      HttpURLConnection connection = (HttpURLConnection)url.openConnection();
      connection.setRequestMethod("GET");
      connection.connect();
      InputStream is = connection.getInputStream();
      reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
      String strRead = null;
      while ((strRead = reader.readLine()) != null) {
        sbf.append(strRead);
      }
      reader.close();
      result = sbf.toString();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return result;
  }
}


/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\
 * Qualified Name:     com.xc.utils.HolidayUtil
 * JD-Core Version:    0.7.0.1
 */