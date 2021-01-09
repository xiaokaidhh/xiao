package cn.edu.jsu.xk.vo;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cn.edu.jsu.xk.dao.BrowsingDao;



public class TableCatModel {

public DefaultTableModel gettableCatdata() throws SQLException {

	Vector<String> titles=new Vector<String>();
	Collections.addAll(titles, "���","����","�Ա�","��ɫ","�ȶ�","�������");
	Vector<Vector> data=new BrowsingDao().getTabledata(new BrowsingDao().getCatdata());
	DefaultTableModel model=new DefaultTableModel(data,titles)
	{
	public 	Class getColumnClass(int column) {
			return    getValueAt(0,column).getClass();
		}
	};
	
	return model;
	
}
public DefaultTableModel gettableCatdata(int id) throws SQLException {

	Vector<String> titles=new Vector<String>();
	Collections.addAll(titles, "���","����","�Ա�","��ɫ","�ȶ�","�������");
	Vector<Vector> data=new BrowsingDao().getTabledata(new BrowsingDao().getCatdata(id));
	DefaultTableModel model=new DefaultTableModel(data,titles)
	{
	public 	Class getColumnClass(int column) {
			return    getValueAt(0,column).getClass();
		}
	};
	
	return model;
	
}
public DefaultTableModel gettableCatdata(String name) throws SQLException {

	Vector<String> titles=new Vector<String>();
	Collections.addAll(titles, "���","����","�Ա�","��ɫ","�ȶ�","�������");
	Vector<Vector> data=new BrowsingDao().getTabledata(new BrowsingDao().getCatdata(name));
	DefaultTableModel model=new DefaultTableModel(data,titles)
	{
	public 	Class getColumnClass(int column) {
			return    getValueAt(0,column).getClass();
		}
	};
	
	return model;
	
}

public DefaultTableModel getpageTable(Vector<Vector> data) throws SQLException{
	
	

	Vector<String> titles=new Vector<String>();
	Collections.addAll(titles, "���","����","�Ա�","��ɫ","�ȶ�","�������");
	DefaultTableModel model=new DefaultTableModel(data,titles)
	{
	public 	Class getColumnClass(int column) {
			return    getValueAt(0,column).getClass();
		}
	};
	
	return model;
	
}
}
