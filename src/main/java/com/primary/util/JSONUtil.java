package com.primary.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class JSONUtil {
	public static String getJsonObj(Object... args) {
		if (args == null || args.length % 2 > 0) {
			return null;
		}
		
		JSONObject result = new JSONObject();
		
		for (int i = 0, len = args.length; i < len;) {
			result.put((String)args[i++], args[i++]);
		}
		
		return result.toString();
	}
	
	public static JSONObject getJSonList(Integer total, List datas) {
		if (CheckUtil.nullCheck(datas)) {
			return null;
		}
		
		JSONObject result = new JSONObject();
		
		if (total != null) {
			result.put("total", total);
		}
		
		JSONArray array = new JSONArray();
		for (Object object : datas) {
			Class<? extends Object> classes = object.getClass();
			JSONObject jsonObject = new JSONObject();
			List<Field> fields = new ArrayList<Field>();
			
			for (Class<? extends Object> c = classes; c != Object.class; c = c.getSuperclass()) {
				for (Field field : c.getDeclaredFields()) {
					fields.add(field);
				}
			}
			
			for (Field field : fields) {
				Method getMethod = null;
				
				try {
					getMethod = classes.getMethod(ReflectUtil.getMethodForFied(field));
				} catch (SecurityException | NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
				try {
					jsonObject.put(field.getName(), getMethod.invoke(object));
				} catch (JSONException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			array.put(jsonObject);
		}
		result.put("rows", array);
		
		return result;
	}
	
	public static JSONArray addListCol(List data, List<List<String>> cols, String colName) {
		if (CheckUtil.nullCheck(data, cols, colName) || data.size() != cols.size()) {
			return null;
		}
		
		JSONArray jsonArray = new JSONArray();
		
		for (int i = 0, len = data.size(); i < len; i++) {
			JSONObject jsonObject = createBeanJSONObject(data.get(i));
			
			String str = "";
			for (String s : cols.get(i)) {
				if ("".equals(str)) {
					str = s;
				} else {
					str = str + ", " + s; 
				}
			}
			jsonObject.put(colName, str);
			
			jsonArray.put(jsonObject);
		}
		
		return jsonArray;
	}
	
	public static JSONObject createBeanJSONObject(Object object) {
		Class<? extends Object> classes = object.getClass();
		
		JSONObject jsonObject = new JSONObject();
		
		List<Field> fields = new ArrayList<Field>();
		
		for (Class<? extends Object> c = classes; c != Object.class; c = c.getSuperclass()) {
			for (Field field : c.getDeclaredFields()) {
				fields.add(field);
			}
		}
		
		for (Field field : fields) {
			Method getMethod = null;
			
			try {
				getMethod = classes.getMethod(ReflectUtil.getMethodForFied(field));
			} catch (SecurityException | NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			try {
				jsonObject.put(field.getName(), getMethod.invoke(object));
			} catch (JSONException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return jsonObject;
	}
}
