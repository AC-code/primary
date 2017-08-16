package com.primary.util;

import java.util.HashMap;
import java.util.Map;

public class MapUtil {
	public static Map getMap(Object... objects) {
		if (objects == null || objects.length % 2 > 0) {
			return null;
		}
		
		Map result = new HashMap<Object, Object>();
		
		for (int i = 0, len = objects.length; i < len;) {
			result.put(objects[i++], objects[i++]);
		}
		
		return result;
	}
}
