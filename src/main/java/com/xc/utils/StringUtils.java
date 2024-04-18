package com.xc.utils;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils
{
  public static String UnicodeToCN(String unicodeStr)
  {
    Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
    Matcher matcher = pattern.matcher(unicodeStr);
    while (matcher.find())
    {
      String group = matcher.group(2);
      
      char ch = (char)Integer.parseInt(group, 16);
      
      String group1 = matcher.group(1);
      unicodeStr = unicodeStr.replace(group1, ch + "");
    }
    return unicodeStr.replace("\\", "").trim();
  }
  
  public static String CNToUnicode(String CN)
  {
    try
    {
      StringBuffer out = new StringBuffer("");
      
      byte[] bytes = CN.getBytes("unicode");
      for (int i = 0; i < bytes.length - 1; i += 2)
      {
        out.append("\\u");
        String str = Integer.toHexString(bytes[(i + 1)] & 0xFF);
        for (int j = str.length(); j < 2; j++) {
          out.append("0");
        }
        String str1 = Integer.toHexString(bytes[i] & 0xFF);
        out.append(str1);
        out.append(str);
      }
      return out.toString();
    }
    catch (UnsupportedEncodingException e)
    {
      e.printStackTrace();
    }
    return null;
  }
  
  public static String delHTMLTag(String htmlStr)
  {
    String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>";
    String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>";
    String regEx_html = "<[^>]+>";
    
    Pattern p_script = Pattern.compile(regEx_script, 2);
    Matcher m_script = p_script.matcher(htmlStr);
    htmlStr = m_script.replaceAll("");
    
    Pattern p_style = Pattern.compile(regEx_style, 2);
    Matcher m_style = p_style.matcher(htmlStr);
    htmlStr = m_style.replaceAll("");
    
    Pattern p_html = Pattern.compile(regEx_html, 2);
    Matcher m_html = p_html.matcher(htmlStr);
    htmlStr = m_html.replaceAll("");
    
    return htmlStr.trim();
  }
}


/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\
 * Qualified Name:     com.xc.utils.StringUtils
 * JD-Core Version:    0.7.0.1
 */