package cn.edu.jsu.xk.vo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.table.DefaultTableModel;

public class CustomReg {

	
	public void reg(String a,String b) throws IOException {
		File file=new File("source/custom.txt");
	
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(file,true))) {
				String row1 =a+"\t"+b;
				   bw.write(row1);
				   bw.newLine();// –¥»Îªÿ≥µªª
				   bw.close();
				  }
			
		}

		
	
}
