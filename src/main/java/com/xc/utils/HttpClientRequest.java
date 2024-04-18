package com.xc.utils;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HttpClientRequest {
    public static String doGet(String url) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        String result = "";
        try {
            httpClient = HttpClients.createDefault();

            HttpGet httpGet = new HttpGet(url);

            httpGet.setHeader("Authorization", "Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0");


            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(35000).setConnectionRequestTimeout(35000).setSocketTimeout(60000).build();

            httpGet.setConfig(requestConfig);

            response = httpClient.execute(httpGet);

            HttpEntity entity = response.getEntity();

            result = EntityUtils.toString(entity);
          try {
            response.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
          try {
            httpClient.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
          return result;
        } catch (IOException e) {
            e.printStackTrace();
            if (null != response) {
                try {
                    response.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
          try {
            httpClient.close();
          } catch (IOException e1) {
            e1.printStackTrace();
          }
        } finally {
            if (null != response) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != httpClient) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }

    public static String doPost(String url, Map<String, Object> paramMap) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse httpResponse = null;
        String result = "";

        httpClient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost(url);


        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(35000).setConnectionRequestTimeout(35000).setSocketTimeout(60000).build();

        httpPost.setConfig(requestConfig);

        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
        if ((null != paramMap) && (paramMap.size() > 0)) {
            List<NameValuePair> nvps = new ArrayList();

            Set<Entry<String, Object>> entrySet = paramMap.entrySet();

          for (Entry<String, Object> stringObjectEntry : entrySet) {
            Entry mapEntry = stringObjectEntry;
            nvps.add(new BasicNameValuePair((String) mapEntry.getKey(), mapEntry.getValue().toString()));
          }
            try {
                httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        try {
            httpResponse = httpClient.execute(httpPost);

            HttpEntity entity = httpResponse.getEntity();
            result = EntityUtils.toString(entity);
          try {
            httpResponse.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
          try {
            httpClient.close();
          } catch (IOException e) {
            e.printStackTrace();
          }

        } catch (ClientProtocolException e) {
            e.printStackTrace();
            if (null != httpResponse) {
                try {
                    httpResponse.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
          try {
            httpClient.close();
          } catch (IOException e1) {
            e1.printStackTrace();
          }
        } catch (IOException e) {
            e.printStackTrace();
            if (null != httpResponse) {
                try {
                    httpResponse.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
          try {
            httpClient.close();
          } catch (IOException e1) {
            e1.printStackTrace();
          }
        } finally {
            if (null != httpResponse) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != httpClient) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
      return result;
    }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.utils.HttpClientRequest

 * JD-Core Version:    0.7.0.1

 */