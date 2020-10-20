package org.example.encrypt;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author zhout
 * @date 2020/9/14 16:30
 */
public class DigestUtil {

  public static void main(String[] args) {
    // MD5加密，返回32位字符串
    System.out.println(DigestUtils.md5Hex("123"));

    // SHA-1加密
    System.out.println(DigestUtils.sha1Hex("123"));
    // SHA-256加密
    System.out.println(DigestUtils.sha256Hex("123"));
    // SHA-512加密
    System.out.println(DigestUtils.sha512Hex("123"));
  }
}
