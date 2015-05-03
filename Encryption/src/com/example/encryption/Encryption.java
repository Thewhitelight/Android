package com.example.encryption;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import android.annotation.SuppressLint;
import android.util.Base64;
import android.util.Log;

public class Encryption {
	public static String MD5(String str) throws Exception {
		// TODO Auto-generated method stub
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.update(str.getBytes());
		return Base64.encodeToString(md5.digest(), Base64.DEFAULT);
	}

	public static String SHA(String str) throws Exception {
		MessageDigest sha = MessageDigest.getInstance("SHA");
		sha.update(str.getBytes());
		return Base64.encodeToString(sha.digest(), Base64.DEFAULT);
	}

	@SuppressLint("TrulyRandom")
	public static String initMacKey() throws Exception {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
		SecretKey secrekey = keyGenerator.generateKey();
		return Base64.encodeToString(secrekey.getEncoded(), Base64.DEFAULT);
	}

	public static String Encryption_HMAC(String str, String key)
			throws Exception {
		SecretKey secretKey = new SecretKeySpec(Base64.decode(key,
				Base64.DEFAULT), "HmacMD5");
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());
		mac.init(secretKey);
		return Base64.encodeToString(mac.doFinal(str.getBytes()),
				Base64.DEFAULT);
	}

	/**
	 * AES加密
	 * 
	 * @param str
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String AES(String str, String key) throws Exception {
		if (key == null) {
			Log.i("aes_error", "key不能为空");
			return null;
		}
		if (key.length() != 16) {
			Log.i("aes_error", "key长度不是16位");
			return null;
		}
		byte[] raw = key.getBytes();
		SecretKeySpec keySpec = new SecretKeySpec(raw, "AES");
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		IvParameterSpec iv = new IvParameterSpec("0102030405060708".getBytes());
		cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv);
		byte[] encrypted = cipher.doFinal(str.getBytes());
		return Base64.encodeToString(encrypted, Base64.DEFAULT);
	}

	public static String decrypt_AES(String str, String key) throws Exception {
		if (key == null) {
			Log.i("key_error", "key不能为空");
			return null;
		}
		if (key.length() != 16) {
			Log.i("key_error", "key长度不是16位");
			return null;
		}
		byte[] raw = key.getBytes("ASCII");
		SecretKeySpec keySpec = new SecretKeySpec(raw, "AES");
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		IvParameterSpec iv = new IvParameterSpec("0102030405060708".getBytes());
		cipher.init(Cipher.DECRYPT_MODE, keySpec, iv);
		byte[] encryted = Base64.decode(str, Base64.DEFAULT);
		try {
			byte[] original = cipher.doFinal(encryted);
			String originalString = new String(original);
			return originalString;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
}
