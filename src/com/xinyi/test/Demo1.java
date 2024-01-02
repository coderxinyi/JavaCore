package com.xinyi.test;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author xinyi
 * @Date 2022/10/28 下午6:00
 */
public class Demo1 {

    private static MessageDigest md;

    static {
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {

        String url = "http://adpassport.xdf.cn/A2apis/GetEmailByEmpidOrUid";
        String appid = "619";
        String appKey = "8AD62D096886439AA50CAA32323A1B79";
        String signText = (appid + appKey).toLowerCase();
        String sign = encode(signText.trim());
        System.out.println("sign : " + sign);

        HashMap<String, String> header = new HashMap<String, String>();
        header.put("sign", sign);
        header.put("Content-Type", "application/json");
        //JSONObject json = HttpClientUtil.postJsonData(urlstr.toString(),paramObject.toJSONString(),header);


    }

    public static String convertToHex(byte[] data) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int two_halfs = 0;
            do {
                if ((0 <= halfbyte) && (halfbyte <= 9))
                    buf.append((char) ('0' + halfbyte));
                else
                    buf.append((char) ('a' + (halfbyte - 10)));
                halfbyte = data[i] & 0x0F;
            } while (two_halfs++ < 1);
        }
        return buf.toString();
    }

    public static String encode(String text) {
        byte[] md5hash = new byte[32];
        try {
            md.update(text.getBytes("UTF-8"), 0, text.length());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        md5hash = md.digest();
        return convertToHex(md5hash);
    }
}
