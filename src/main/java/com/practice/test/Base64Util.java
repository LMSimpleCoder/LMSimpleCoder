package com.practice.test;
import org.apache.commons.codec.binary.Base64;
import java.nio.charset.StandardCharsets;

/**
 * @author luoming
 */
public class Base64Util {

	/**
	 * 解密加密后的字符串
	 * @param inputData
	 * @return
	 */
	public static String decodeData(String inputData) {
		if (null == inputData) {
			return null;
		}
		return new String(Base64.decodeBase64(inputData.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
	}

	/**
	 * 加密字符串
	 * @param inputData
	 * @return
	 */
	public static String encodeData(String inputData) {
		if (null == inputData) {
			return null;
		}
		return new String(Base64.encodeBase64(inputData.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
	}

	public static void main(String[] args) {
		String str = "我是中文";
		System.out.println(encodeData(str));
		String enStr = encodeData(str);
		System.out.println(decodeData(enStr));
	}
}
