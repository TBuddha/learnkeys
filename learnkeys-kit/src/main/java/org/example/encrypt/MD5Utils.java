package org.example.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * MD5工具类
 * 
 * @date 2017-08-24
 * @author wangll
 */
public class MD5Utils {

	private final static Logger logger = LoggerFactory.getLogger(MD5Utils.class);

	private MD5Utils() {
	}

	/**
	 * 将传入字符串MD5
	 * 
	 * @param plainText
	 * @return
	 */
	public static String encode(String plainText) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0) {
					i += 256;
				}
				if (i < 16) {
					buf.append("0");
				}
				buf.append(Integer.toHexString(i));
			}
			return buf.toString();
		} catch (NoSuchAlgorithmException e) {
			logger.error(plainText + " 转换异常", e);
		}
		return null;
	}
}
