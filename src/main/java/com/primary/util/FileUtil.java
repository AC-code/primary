package com.primary.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class FileUtil {
	public static boolean isXlsFile(String name) {
		if (name == null || !name.endsWith(".xls")) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * 从xls文件中获取学生信息
	 * @param xlsFile
	 * @return
	 * @throws IOException 
	 * @throws BiffException 
	 */
	public static List<List<String>> ReadXLS(InputStream xlsFile) throws BiffException, IOException {
		if (xlsFile == null || !(xlsFile instanceof InputStream)) {
			return null;
		}
		
		List<List<String>> result = new ArrayList<List<String>>();
		
		Workbook workbook = Workbook.getWorkbook(xlsFile); 
		
		//获取第一张Sheet表  
		Sheet sheet = workbook.getSheet(0);  
		
		for (int i = 0, row = sheet.getRows(); i < row; i++) {
			List<String> facter = new ArrayList<String>();
			for (int j = 0, col = sheet.getColumns(); j < col ; j++) {
				facter.add(sheet.getCell(j, i).getContents());
			}
			result.add(facter);
		}
		
		workbook.close();
		
		return result;
	}
}
