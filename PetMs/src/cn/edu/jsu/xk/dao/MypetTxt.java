package cn.edu.jsu.xk.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;


import cn.edu.jsu.xk.vo.Cat;

public class MypetTxt {
	DefaultTableModel model;

	
	public MypetTxt() {
		
	}
		public DefaultTableModel getMypet(String username) {
			Vector<String> titles=new Vector<String>();
			Collections.addAll(titles, "���","����","�Ա�","��ɫ","�ȶ�","�������");
		       model=new DefaultTableModel(titles, 0);
		       
		       
			 File file=new File("d:/mypet/"+username+".txt");
			try (BufferedReader fr = new BufferedReader(new FileReader(file))) {
				String row1=null;
			    while((row1=fr.readLine())!=null) {//���ж�ȡ����
			      model.addRow(row1.split("\t"));//����ȡ���а��ָ�����ֳ��ַ��������������ģ�ͣ��ؼ�����

				  }
				} catch (Exception e1) {
				  e1.printStackTrace();
				}
			return model;
			
			}
		
}
