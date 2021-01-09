package cn.edu.jsu.xk.vo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class PutExcel {
	public void exportExcel(List<Cat> listcat) {
		File file = new File("d:/pet.xlsx");// 定位要操作的excel文件
		Workbook workbook=new XSSFWorkbook();
		Sheet sheet=workbook.createSheet("pet");
		int i=0;
		for(Cat cat:listcat) {
			Row row = sheet.createRow(i);// 创建行对象，下标从0开始
			Cell cell1 = row.createCell(0);// 创建单元格，从0开始
			cell1.setCellValue(cat.getId());
			Cell cell2 = row.createCell(1);
			cell2.setCellValue(cat.getName());
			Cell cell3 = row.createCell(2);
			cell3.setCellValue(cat.getSex());
			Cell cell4 = row.createCell(3);
			cell4.setCellValue(cat.getColor());	
			Cell cell5 = row.createCell(4);
			cell5.setCellValue(cat.getGetdata());
			i++;
		}
		try(FileOutputStream fos = new FileOutputStream(file);) {
			workbook.write(fos);// 将内容写入到指定的excel文档
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
		
		
	
}
