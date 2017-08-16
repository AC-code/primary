package com.primary.util;

import org.apache.log4j.Logger;

public class Log {
	private static Logger log = Logger.getLogger(Log.class);
	
	public static void debug(Object message) {
		log.debug(message);
	}
	
	public static void info(Object message) {
		log.info(message);
	}
	
	public static void warn(Object message) {
		log.warn(message);
	}
	
	public static void error(Object message) {
		log.error(message);
	}
}
