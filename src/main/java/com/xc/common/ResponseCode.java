package com.xc.common;


public enum ResponseCode {
  SUCCESS(0, "SUCCESS"), ERROR(-1, "ERROR"), NEED_LOGIN(10, "NEED_LOGIN"), ILLEGAL_ARGUMENT(2, "ILLEGAL_ARGUMENT");

  private int code;
  private String msg;

  private ResponseCode(int code, String msg)
  {
    this.code = code;
    this.msg = msg;
  }

  public int getCode()
  {
    return this.code;
  }

  public String getMsg(){
    return this.msg;
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.common.ResponseCode

 * JD-Core Version:    0.7.0.1

 */