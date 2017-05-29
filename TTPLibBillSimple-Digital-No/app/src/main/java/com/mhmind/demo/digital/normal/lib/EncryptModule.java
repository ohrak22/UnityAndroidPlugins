package com.mhmind.demo.digital.normal.lib;

import java.io.UnsupportedEncodingException;

public class EncryptModule {
	private static final String ENCODING = "KSC5601";
	private static final int BUFFER_SIZE = 512;

	public static native int encrypt(byte[] key, byte[] plain, byte[] enc);
	public static native void decrypt(byte[] key, byte[] enc, byte[] buffer, int size);

	public static String Encrypt(String pKey, String pValue) {
		byte[] buffer = new byte[BUFFER_SIZE];
		byte[] pbValue = new byte[BUFFER_SIZE];
		byte[] key = new byte[16];
		String sEncValue = "";
		int iByteLength = 0;

	    try {
	    	pbValue = pValue.getBytes(ENCODING);
	    	iByteLength = pValue.getBytes(ENCODING).length;
			key = pKey.getBytes(ENCODING);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	    try {
	    	encrypt(key, pbValue, buffer);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }

	    int iBlockSize = ((iByteLength/16)+1)*16;
		for (int i=0; i<iBlockSize; i++) {
			sEncValue += (char)buffer[i];
		}

		return sEncValue;
	}
	
	public static String Decrypt(String pKey, String pValue, int pLength) {
		byte[] buffer = new byte[BUFFER_SIZE];
		byte[] pbValue = new byte[BUFFER_SIZE];
		byte[] key = new byte[16];
		String sDecValue = "";

	    try {
			key = pKey.getBytes(ENCODING);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		char[] arValue = pValue.toCharArray();
		for (int i=0; i<arValue.length; i++) {
			pbValue[i] = (byte)arValue[i];
		}
		
		try {
			decrypt(key, pbValue, buffer, pLength * 2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			sDecValue = new String(buffer, ENCODING);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return sDecValue.substring(0, pLength);
	}

}
