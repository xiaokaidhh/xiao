package cn.edu.jsu.xk.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import cn.edu.jsu.xk.vo.Cat;



public class BuyPetTxt {
	public void buy(int row,DefaultTableModel model,String username) throws IOException {
		File file=new File("d:/mypet/"+username+".txt");

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(file,true))) {
				String row1 = model.getValueAt(row, 0).toString() + "\t" + model.getValueAt(row, 1).toString() + "\t"+ model.getValueAt(row, 2).toString() + "\t"+model.getValueAt(row, 3).toString()+"\t"+model.getValueAt(row, 4).toString()+"\t"+model.getValueAt(row, 5).toString();// 获取表格中每一行的每一个单元格
				   bw.write(row1);// 向文本文件中增加数据
				   bw.newLine();// 写入回车换
				   bw.close();
				  }
			
			
		}

		
		
		
	}

