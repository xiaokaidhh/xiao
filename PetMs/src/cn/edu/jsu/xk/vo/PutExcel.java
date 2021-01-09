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
		File file = new File("d:/pet.xlsx");// ��λҪ������excel�ļ�
		Workbook workbook=new XSSFWorkbook();
		Sheet sheet=workbook.createSheet("pet");
		int i=0;
		for(Cat cat:listcat) {
			Row row = sheet.createRow(i);// �����ж����±��0��ʼ
			Cell cell1 = row.createCell(0);// ������Ԫ�񣬴�0��ʼ
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
			workbook.write(fos);// ������д�뵽ָ����excel�ĵ�
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
		
		
	
}
