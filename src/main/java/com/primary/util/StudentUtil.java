package com.primary.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.primary.bean.Student;

import jxl.read.biff.BiffException;

public class StudentUtil {
	public static List<Student> XLSToStudents(int start_id, InputStream xlsFile) {
		if (xlsFile == null || !(xlsFile instanceof InputStream)) {
			return null;
		}
		
		List<List<String>> datas = new ArrayList<List<String>>();
		
		try {
			datas = FileUtil.ReadXLS(xlsFile);
		} catch (BiffException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Student> result = new ArrayList<Student>();
		for (List<String> data : datas) {
			result.add(new Student(start_id, data.get(0), start_id + ""));
			start_id++;
		}
		
		return result;
	}
}
