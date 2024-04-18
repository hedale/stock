package com.xc.common;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import java.io.Serializable;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class ServerResponse<T>
  implements Serializable
{
  private int status;
  private String msg;
  private T data;
  
  private ServerResponse(int status)
  {
    this.status = status;
  }
  
  private ServerResponse(int status, T data)
  {
    this.status = status;
    this.data = data;
  }
  
  private ServerResponse(int status, String msg)
  {
    this.status = status;
    this.msg = msg;
  }
  
  private ServerResponse(int status, String msg, T data)
  {
    this.status = status;
    this.msg = msg;
    this.data = data;
  }
  
  public static void main(String[] args)
  {
    ServerResponse serverResponse = new ServerResponse(1, new Object());
    ServerResponse serverResponse1 = new ServerResponse(1, "abc");
    System.out.print("ServerResponse");
  }
  
  @JsonIgnore
  public boolean isSuccess()
  {
    return this.status == ResponseCode.SUCCESS.getCode();
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public T getData()
  {
    return this.data;
  }
  
  public String getMsg()
  {
    return this.msg;
  }
  
  public static <T> ServerResponse<T> createBySuccess()
  {
    return new ServerResponse(ResponseCode.SUCCESS.getCode());
  }
  
  public static <T> ServerResponse<T> createBySuccessMsg(String msg)
  {
    return new ServerResponse(ResponseCode.SUCCESS.getCode(), msg);
  }
  
  public static <T> ServerResponse<T> createBySuccess(T data)
  {
    return new ServerResponse(ResponseCode.SUCCESS.getCode(), data);
  }
  
  public static <T> ServerResponse<T> createBySuccess(String msg, T data)
  {
    return new ServerResponse(ResponseCode.SUCCESS.getCode(), msg, data);
  }
  
  public static <T> ServerResponse<T> createByError()
  {
    return new ServerResponse(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMsg());
  }
  
  public static <T> ServerResponse<T> createByErrorMsg(String errormsg)
  {
    return new ServerResponse(ResponseCode.ERROR.getCode(), errormsg);
  }
  
  public static <T> ServerResponse<T> createByErrorCodeMsg(int errorcode, String errormsg)
  {
    return new ServerResponse(errorcode, errormsg);
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.common.ServerResponse

 * JD-Core Version:    0.7.0.1

 */