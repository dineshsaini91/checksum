package org.javatut.checksum;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

/**
 * Checksum Calculator.
 *
 */
public class ChecksumCalculator {
	
	public static void main(String[] args) {
		String string = "Hello World!";
		
		String checksumMD5 = getChecksumMD5(string);
		System.out.println("MD5 Checksum: " + checksumMD5);
		
		String checksumSHA256 = getChecksumSHA256(string);
		System.out.println("SHA-256 Checksum: " + checksumSHA256);
	}

	private static String getChecksumMD5(final String data) {
		String checksum = null;
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			byte[] digest = messageDigest.digest(data.getBytes("UTF-8"));
			checksum = DatatypeConverter.printHexBinary(digest).toLowerCase();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return checksum;
	}

	private static String getChecksumSHA256(final String data) {
		String checksum = null;
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			byte[] digest = messageDigest.digest(data.getBytes("UTF-8"));
			checksum = DatatypeConverter.printHexBinary(digest).toLowerCase();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return checksum;
	}
}
