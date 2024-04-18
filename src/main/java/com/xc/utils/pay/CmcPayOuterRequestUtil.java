package com.xc.utils.pay;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections.map.LinkedMap;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.Map.Entry;

public class CmcPayOuterRequestUtil {
    private static final String SIGN_KEY = "sign";
    private static final String SECRET_KEY = "key";

    public static String sendGet(String url) {
        StringBuilder result = new StringBuilder();
        BufferedReader in = null;
        try {
            URL realUrl = new URL(url);

            URLConnection connection = realUrl.openConnection();

            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");


            connection.connect();


            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result.toString();
    }

    public static String sendGet(String url, String param) {
        StringBuilder result = new StringBuilder();
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);

            URLConnection connection = realUrl.openConnection();

            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");


            connection.connect();


            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
      return result.toString();
    }

    public static String sendGet(String url, LinkedMap params) {
        StringBuilder result = new StringBuilder();
        BufferedReader in = null;
        try {
            String urlNameString = getUrlString(url, params);
            URL realUrl = new URL(urlNameString);

            URLConnection connection = realUrl.openConnection();

            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");


            connection.connect();


            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result.toString();
    }

    public static String getUrlString(String url, LinkedMap params)
            throws UnsupportedEncodingException {
        return url + "?" + getParamsString(params);
    }

    public static String post(String url, Map<String, String> paramMap)
            throws ClientProtocolException, IOException {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        List<NameValuePair> formparams = setHttpParams(paramMap);
        UrlEncodedFormEntity param = new UrlEncodedFormEntity(formparams, "utf-8");
        httpPost.setEntity(param);
        HttpResponse response = httpClient.execute(httpPost);
        String httpEntityContent = getHttpEntityContent(response);
        httpPost.abort();
        return httpEntityContent;
    }

    private static List<NameValuePair> setHttpParams(Map<String, String> paramMap) {
        List<NameValuePair> formparams = new ArrayList();
        Set<Entry<String, String>> set = paramMap.entrySet();
        for (Entry<String, String> entry : set) {
            formparams.add(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
        }
        return formparams;
    }

    private static String getHttpEntityContent(HttpResponse response)
            throws IOException, UnsupportedEncodingException {
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            InputStream is = entity.getContent();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String line = br.readLine();
            StringBuilder sb = new StringBuilder();
            while (line != null) {
                sb.append(line + "\n");
                line = br.readLine();
            }
            return sb.toString();
        }
        return "";
    }

    public static String sendPost(String url, LinkedMap params)
            throws IOException {
        String result = "";
        URL postUrl = new URL(url);

        HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();


        connection.setDoOutput(true);

        connection.setDoInput(true);

        connection.setRequestMethod("POST");


        connection.setUseCaches(false);

        connection.setInstanceFollowRedirects(true);


        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");


        connection.connect();
        DataOutputStream out = new DataOutputStream(connection.getOutputStream());


        String content = getParamsString(params);
        out.writeBytes(content);
        out.flush();
        out.close();

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            result = result + line;
        }
        reader.close();
        connection.disconnect();
        return result;
    }

    public static String getParamsString(LinkedMap params)
            throws UnsupportedEncodingException {
        String content = new String();
        Set<String> keySet = params.keySet();
        String[] keys = (String[]) keySet.toArray(new String[keySet.size()]);
        for (String key : keys) {
            String value = (String) params.get(key);
            if (value != null) {
                if (content.length() != 0) {
                    content = content + "&";
                }
                content = content + key + "=" + URLEncoder.encode(value, "UTF-8");
            }
        }
        return content;
    }

    public static String getSign(LinkedMap jsonObj, String md5Key) {
        if ((jsonObj == null) || (jsonObj.isEmpty())) {
            return null;
        }
        String str2Sign = buildParam4Sign(jsonObj, "sign", md5Key);
        try {
            byte[] data = str2Sign.getBytes("utf-8");
            return DigestUtils.md5Hex(data);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String buildParam4Sign(LinkedMap jsonObj, String signKey, String md5Key) {
        Set<String> keySet = jsonObj.keySet();
        StringBuilder param = new StringBuilder(20 * keySet.size());
        String[] keys = (String[]) keySet.toArray(new String[keySet.size()]);
        Arrays.sort(keys, String.CASE_INSENSITIVE_ORDER);


        param.append(jsonObj.get("merchantid"));
        param.append(jsonObj.get("orderno"));
        param.append(jsonObj.get("orderamount"));
        param.append(jsonObj.get("serverbackurl"));
        param.append(jsonObj.get("callbackurl"));
        param.append(md5Key);
        System.out.println(param.toString());
        return param.toString();
    }

    public static String getSignH5(LinkedMap jsonObj, String md5Key)
            throws Exception {
        if ((jsonObj == null) || (jsonObj.isEmpty())) {
            return null;
        }
        StringBuilder param = new StringBuilder();
        param.append("appid=" + jsonObj.get("appid"));
        param.append("&data=" + jsonObj.get("data"));
        param.append("&money=" + jsonObj.get("money"));
        param.append("&type=" + jsonObj.get("type"));
        param.append("&uip=" + jsonObj.get("uip"));
        param.append("&appkey=" + md5Key);
        String str2Sign = param.toString().toLowerCase();
        try {
            return encryption(str2Sign);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String encryption(String plainText)
            throws Exception {
        String re_md5 = new String();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte[] b = md.digest();


            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                int i = b[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
            re_md5 = buf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return re_md5;
    }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.utils.pay.CmcPayOuterRequestUtil

 * JD-Core Version:    0.7.0.1

 */