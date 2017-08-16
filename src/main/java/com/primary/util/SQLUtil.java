package com.primary.util;

public class SQLUtil {
	public static String toLike(String str) {
		if (str == null) {
			return "%%";
		}
		
		return "%" + str + "%";
	}

}
