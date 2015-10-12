package com.accumulate.utils;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	/**
	 *   �۲����·��
	 */
	public static final String JCP_PATH = "http://www.jucaipen.com/";

	/**
	 * @param string
	 * @return �ж�������ȷ��
	 */
	public static boolean isMail(String string) {
		if (null != string) {
			if (string
					.matches("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$")) {
				return true;
			}
		}
		return false;
	}

	/**
	 * �ж��ֻ��������ȷ��
	 * 
	 * @param mobiles
	 * @return
	 */
	public static boolean isMobileNumber(String mobiles) {

		if (null != mobiles) {
			Pattern p = Pattern
					.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$");
			Matcher m = p.matcher(mobiles);
			return m.matches();
		} else {
			return false;
		}
	}

	/**
	 * @param password
	 * @return ���볤���Ƿ���6-23֮��
	 */
	public static boolean isPassword(String password) {
		if (password.length() >= 6 && password.length() <= 23) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param nikName
	 * @return �ж��û��������Ƿ���1-9֮��
	 */
	public static boolean isUserName(String nikName) {
		if (nikName.length() > 0 && nikName.length() < 10) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * �Ƿ�Ϊ null ����Ϊ���ַ���
	 * 
	 * @param string
	 * @return false if null || ""
	 */
	public static boolean isNotNull(String string) {

		if (string == null || "".equals(string)) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * �ж��ַ����Ƿ�������
	 */
	public static boolean isInteger(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * �ַ������Ȳ���,�����ӡʱ����,������ӡҳ��,�������ļ�������е�����
	 * 
	 * @param strs
	 *            Դ�ַ�
	 * @param len
	 *            ָ���ַ�����
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String Fix_String_Lenth(int type, String strs, int len) {
		String strtemp = strs;
		// int len1 = strs.length();
		switch (type) {
		case 0:
			while (strtemp.length() < len * "��".length()) {
				strtemp += " ";
			}
			break;
		case 1:
			while (strtemp.length() < len) {
				strtemp += " ";
			}
			break;
		default:

			break;
		}
		System.out.println("    " + strtemp);
		return strtemp;
	}

}
