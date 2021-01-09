package cn.edu.jsu.xk.vo;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class PutTxt {
	public void exportTxt(List<Cat> listcat) {
		File file = new File("d:/pet.txt");// 定位要操作的excel文件
		try(FileWriter fos = new FileWriter(file,true);
				BufferedWriter bw=new BufferedWriter(fos)) {
			int i=0;
			for(Cat cat:listcat) {
				bw.write(cat.toString());
				bw.newLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
	}
}
