package cn.edu.jsu.xk.vo;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cn.edu.jsu.xk.dao.BrowsingDao;



public class TableDogModel {

public DefaultTableModel gettableDogdata() throws SQLException {

	Vector<String> titles=new Vector<String>();
	Collections.addAll(titles, "编号","姓名","性别","颜色","热度","添加日期");
	Vector<Vector> data=new BrowsingDao().getTabledata2(new BrowsingDao().getDogdata());
	DefaultTableModel model=new DefaultTableModel(data,titles)
	{
	public 	Class getColumnClass(int column) {
			return    getValueAt(0,column).getClass();
		}
	};
	
	return model;
	
}
public DefaultTableModel gettableDogdata(int id) throws SQLException {

	Vector<String> titles=new Vector<String>();
	Collections.addAll(titles, "编号","姓名","性别","颜色","热度","添加日期");
	Vector<Vector> data=new BrowsingDao().getTabledata2(new BrowsingDao().getDogdata(id));
	DefaultTableModel model=new DefaultTableModel(data,titles)
	{
	public 	Class getColumnClass(int column) {
			return    getValueAt(0,column).getClass();
		}
	};
	
	return model;
	
}
public DefaultTableModel gettableDogdata(String name) throws SQLException {

	Vector<String> titles=new Vector<String>();
	Collections.addAll(titles, "编号","姓名","性别","颜色","热度","添加日期");
	Vector<Vector> data=new BrowsingDao().getTabledata2(new BrowsingDao().getDogdata(name));
	DefaultTableModel model=new DefaultTableModel(data,titles)
	{
	public 	Class getColumnClass(int column) {
			return  getValueAt(0,column).getClass();
		}
	};
	
	return model;
	
}

}
