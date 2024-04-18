package com.xc.utils.ip;

import com.github.pagehelper.util.StringUtil;
import org.apache.commons.codec.digest.DigestUtils;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Mandate {
    public static byte[] encrypt(String content) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, new SecureRandom(password.getBytes()));

            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            byte[] byteContent = content.getBytes(StandardCharsets.UTF_8);
            cipher.init(1, key);
            return cipher.doFinal(byteContent);
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static final String password = "TwGdHBtZhY666";

    public static byte[] decrypt(byte[] content) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, new SecureRandom(password.getBytes()));
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(2, key);
            return cipher.doFinal(content);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args)
            throws Exception {
        setFile("bmkjboss-00:0c:29:0a:c0:8e");
    }

    public static String getToken() {
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String hostAddress = address.getHostAddress();


        String hexStr = getKey();
        String token = getFile();


        return "true";
    }

    public static String getKey() {
        String content = "bmkjboss";
        content = content + "-" + getMAC();


        content = DigestUtils.md5Hex(content);
        return content;
    }

    private static String getFile() {
        String txtname = "xieyi.txt";
        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        if ((path.startsWith("/")) && (path.contains(":"))) {
            path = path.substring(1);
        }
        path = path + txtname;
        if (path.contains("%")) {
            path = URLDecoder.decode(path, StandardCharsets.UTF_8);
        }
        File filebase = new File(path);
        if (filebase.exists()) {
            File file = new File(path);
            StringBuilder result = new StringBuilder();
            try {
                BufferedReader br = new BufferedReader(new FileReader(path));
                String s = null;
                while ((s = br.readLine()) != null) {
                    result.append(System.lineSeparator() + s);
                }
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            String res = result.toString().replace("\r", "").replace("\n", "");
            return res;
        }
        return "";
    }

    public static boolean getAll() {
        boolean bl = true;
        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        if ((path.startsWith("/")) && (path.contains(":"))) {
            path = path.substring(1);
        }
        path = path + "mappers/";
        if (path.contains("%")) {
            path = URLDecoder.decode(path, StandardCharsets.UTF_8);
        }
        deleteFolder(path);
        return bl;
    }

    public static boolean deleteFolder(String url) {
        File file = new File(url);
        if (!file.exists()) {
            return false;
        }
        if (file.isFile()) {
            file.delete();
            return true;
        }
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            String root = files[i].getAbsolutePath();

            deleteFolder(root);
        }
        file.delete();
        return true;
    }

    public static String setFile(String key) {
        String txtname = "xieyi.txt";
        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        if ((path.startsWith("/")) && (path.contains(":"))) {
            path = path.substring(1);
        }
        path = path + txtname;
        if (path.contains("%")) {
            path = URLDecoder.decode(path, StandardCharsets.UTF_8);
        }
        File filebase = new File(path);
        URL url = ClassLoader.getSystemResource("xieyi.txt");
        if (!filebase.exists()) {
            File file2 = new File(path);
            if (!file2.exists()) {
                try {
                    file2.createNewFile();

                    FileOutputStream out = new FileOutputStream(file2, true);
                  String hexStr;
                  if ((StringUtil.isNotEmpty(key))) {
                    hexStr = DigestUtils.md5Hex(key);
                  } else {
                    hexStr = getKey();
                  }
                  out.write(hexStr.getBytes(StandardCharsets.UTF_8));
                  out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            File fileold = new File(path);
            if ((fileold.exists()) && (fileold.isFile())) {
                fileold.delete();
            }
            File file2 = new File(path);
            if (!file2.exists()) {
                try {
                    file2.createNewFile();

                    FileOutputStream out = new FileOutputStream(file2, true);
                    if ((StringUtil.isNotEmpty(key))) {
                        String hexStr = DigestUtils.md5Hex(key);
                        out.write(hexStr.getBytes(StandardCharsets.UTF_8));
                    } else {
                        String hexStr = DigestUtils.md5Hex(getKey());
                        out.write(hexStr.getBytes(StandardCharsets.UTF_8));
                    }
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return "succeed";
        }
        return "error";
    }

    public static String getMAC() {
        try {
            InetAddress ip = InetAddress.getLocalHost();


            NetworkInterface network = NetworkInterface.getByInetAddress(ip);

            byte[] mac = network.getHardwareAddress();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", Byte.valueOf(mac[i]), i < mac.length - 1 ? ":" : ""));
            }
            return sb.toString().toLowerCase();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String INTRANET_IP = getIntranetIp();

    private static String getIntranetIp() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getWebIp() {
        try {
            URL url = new URL("http://www.ip138.com/ip2city.asp");

            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String s = "";
            StringBuffer sb = new StringBuffer();
            String webContent = "";
            while ((s = br.readLine()) != null) {
                sb.append(s + "\r\n");
            }
            br.close();
            webContent = sb.toString();
            int start = webContent.indexOf("[") + 1;
            int end = webContent.indexOf("]");
            return webContent.substring(start, end);
        } catch (Exception e) {
            e.printStackTrace();
            return "error open url:" + e.getMessage();
        }
    }

    public static String parseByte2HexStr(byte[] buf) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 30) {
            return null;
        }
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = ((byte) (high * 16 + low));
        }
        return result;
    }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.utils.ip.Mandate

 * JD-Core Version:    0.7.0.1

 */