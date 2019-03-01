package com.lee1314.raylee.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

/**
 * 加解密Utils
 * 
 * @author 雷力
 * @date 2019年1月17日 下午4:38:03
 */
@Component
public class EncryDecryUtils {

	/**
	 * 盐
	 */
	private static final String SALT = "2019";
	/**
	 * 加密算法
	 */
	private static final String ALGORITHM = "AES";
	/**
	 * 密钥
	 */
	private static SecretKey KEY;

	static {
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
			System.out.println(SALT);
			keyGenerator.init(128, new SecureRandom(SALT.getBytes()));
			KEY = keyGenerator.generateKey();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 加密
	 * 
	 * @param num
	 * @return
	 * @throws NoSuchPaddingException
	 * @throws NoSuchAlgorithmException
	 */
	public static String Encry(String str) throws Exception {
		if (StringUtils.isBlank(str))
			return null;

		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, KEY);
		return Base64Utils.encodeToString(cipher.doFinal(str.getBytes()));
	}

	/**
	 * 解密
	 * 
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static String Decry(String str) throws Exception {
		if (StringUtils.isBlank(str))
			return null;

		byte[] bytes = Base64Utils.decodeFromString(str);
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, KEY);
		return new String(cipher.doFinal(bytes));
	}

}
