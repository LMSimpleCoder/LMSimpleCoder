package com.practice.httpclient;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author luoming
 */
public class TestMethod {
    final static String HEX = "0123456789abcdef";
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String sk = "thunisoft2020@123#JKL";
        String url = "172.25.8.125:8081/eams/pub/v1/logincommon";
        String username = "daxtadmin0";
        long stamp = System.currentTimeMillis();
        String uuurrrll = "http://172.25.8.125:8888/#/logincommon?username=daxtadmin0&stamp=" + stamp+ "&authcode=" +
                encryptMd5(username+stamp+sk) +
                "&ah=11111&fy=0&";
        System.out.println(uuurrrll);

    }


    public static String encoder(String str) throws UnsupportedEncodingException {
        if (StringUtils.isBlank(str)) {
            return "";
        }
        byte[] bytesKey;
        bytesKey = str.getBytes("UTF-8");
        StringBuilder sb = new StringBuilder();
        for (byte b : bytesKey) {
            sb.append(HEX.charAt((b >> 4) & 0x0f)).append(HEX.charAt(b & 0x0f));
        }
        return sb.toString();
    }

    public static String encryptMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");

        md5.update(str.getBytes("UTF-8"));
        byte[] abResult = md5.digest();

        return byte2hex(abResult);
    }
    public static String byte2hex(byte[] data) {
        if (data == null) {
            return null;
        }
        return new String(Hex.encodeHex(data));
    }
}
