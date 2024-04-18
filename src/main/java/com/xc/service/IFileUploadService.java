package com.xc.service;

import com.xc.common.ServerResponse;
import org.springframework.web.multipart.MultipartFile;

public abstract interface IFileUploadService
{
  public abstract ServerResponse upload(MultipartFile paramMultipartFile, String paramString);
}


/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\
 * Qualified Name:     com.xc.service.IFileUploadService
 * JD-Core Version:    0.7.0.1
 */