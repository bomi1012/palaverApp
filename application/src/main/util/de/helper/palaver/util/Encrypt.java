package de.helper.palaver.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

public class Encrypt {
	
	private static final String SHA_1 = "SHA-1";
	private static final String UTF_8 = "UTF-8";
	private static MessageDigest m_messageDigest;
	private static Formatter m_formatter;
	
	public Encrypt() {
		super();
	}
	
	
	public String encryptPassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		m_messageDigest = MessageDigest.getInstance(SHA_1);
		m_messageDigest.reset();
		m_messageDigest.update(password.getBytes(UTF_8));
		return byteToHex(m_messageDigest.digest());
	}

	private static String byteToHex(final byte[] hash) {
		m_formatter = new Formatter();
		for (byte b : hash) {
			m_formatter.format("%02x", b);
		}
		String result = m_formatter.toString();
		m_formatter.close();
		return result;
	}
}
