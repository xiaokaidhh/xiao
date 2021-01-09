package cn.edu.jsu.xk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import cn.edu.jsu.xk.dbc.DatabaseConnectionSql;
import cn.edu.jsu.xk.dbc.DatabaseConnectionSqlPet;
import cn.edu.jsu.xk.vo.Cat;
import cn.edu.jsu.xk.vo.Dog;

public class BrowsingDao{

		Connection conn=new DatabaseConnectionSqlPet().getConnection();
	
	public List<Cat> getCatdata() throws SQLException{
		
		 List<Cat> list=new ArrayList<Cat>();
		 String sql="select * from Cat ";
		 PreparedStatement pstmt=conn.prepareStatement(sql);
		 ResultSet rs=pstmt.executeQuery();
		 while(rs.next()) {
			 Cat cat=new Cat();
			 cat.setId(rs.getInt(1));
			 cat.setName(rs.getString(2));
			 cat.setSex(rs.getString(3));
			 cat.setColor(rs.getString(4));
			 cat.setAge(rs.getInt(5));
			 cat.setGetdata(rs.getString(6));
			 
			 
			 list.add(cat);
		 }
		 return list;
		 }
	public List<Cat> getCatdata(int id) throws SQLException{
		
		 List<Cat> list=new ArrayList<Cat>();
		 String sql="select * from Cat where id="+id;
		 PreparedStatement pstmt=conn.prepareStatement(sql);
		 ResultSet rs=pstmt.executeQuery();
		 while(rs.next()) {
			 Cat cat=new Cat();
			 cat.setId(rs.getInt(1));
			 cat.setName(rs.getString(2));
			 cat.setSex(rs.getString(3));
			 cat.setColor(rs.getString(4));
			 cat.setAge(rs.getInt(5));
			 cat.setGetdata(rs.getString(6));
			 
			 
			 list.add(cat);
		 }
		 return list;
		 }
	
	public List<Cat> getCatdata(String name) throws SQLException{
		
		 List<Cat> list=new ArrayList<Cat>();
		 String sql="select * from Cat where name like'%"+name+"%'";
		 PreparedStatement pstmt=conn.prepareStatement(sql);
		 ResultSet rs=pstmt.executeQuery();
		 while(rs.next()) {
			 Cat cat=new Cat();
			 cat.setId(rs.getInt(1));
			 cat.setName(rs.getString(2));
			 cat.setSex(rs.getString(3));
			 cat.setColor(rs.getString(4));
			 cat.setAge(rs.getInt(5));
			 cat.setGetdata(rs.getString(6)); 
			 list.add(cat);
		 }
		 return list;
		 }
		 
	public  Vector<Vector> getTabledata(List<Cat> list){
			Vector<Vector> rows=new Vector<Vector>();
			for(int i=0;i<list.size();i++) 
			{
			  Vector row=new Vector();
			 Cat cat=list.get(i);
		     Collections.addAll(row,cat.getId(),cat.getName(),cat.getSex(),cat.getColor(),cat.getAge(),cat.getGetdata());
		     rows.add(row);
			    }
			return rows;
			}
		 
	
	
	//dog
	public List<Dog> getDogdata() throws SQLException{
		
		 List<Dog> list=new ArrayList<Dog>();
		 String sql="select * from Dog ";
		 PreparedStatement pstmt=conn.prepareStatement(sql);
		 ResultSet rs=pstmt.executeQuery();
		 while(rs.next()) {
			 Dog dog=new Dog();
			 dog.setId(rs.getInt(1));
			 dog.setName(rs.getString(2));
			 dog.setSex(rs.getString(3));
			 dog.setColor(rs.getString(4));
			 dog.setAge(rs.getInt(5));
			 dog.setGetdata(rs.getString(6));
			 
			 
			 list.add(dog);
		 }
		 return list;
		 }
	public List<Dog> getDogdata(int id) throws SQLException{
		
		 List<Dog> list=new ArrayList<Dog>();
		 String sql="select * from Dog where id="+id;
		 PreparedStatement pstmt=conn.prepareStatement(sql);
		 ResultSet rs=pstmt.executeQuery();
		 while(rs.next()) {
			 Dog dog=new Dog();
			 dog.setId(rs.getInt(1));
			 dog.setName(rs.getString(2));
			 dog.setSex(rs.getString(3));
			 dog.setColor(rs.getString(4));
			 dog.setAge(rs.getInt(5));
			 dog.setGetdata(rs.getString(6));
			 
			 
			 list.add(dog);
		 }
		 return list;
		 }
	
	public List<Dog> getDogdata(String name) throws SQLException{
		
		 List<Dog> list=new ArrayList<Dog>();
		 String sql="select * from Dog where name like'%"+name+"%'";
		 PreparedStatement pstmt=conn.prepareStatement(sql);
		 ResultSet rs=pstmt.executeQuery();
		 while(rs.next()) {
			 Dog dog=new Dog();
			 dog.setId(rs.getInt(1));
			 dog.setName(rs.getString(2));
			 dog.setSex(rs.getString(3));
			 dog.setColor(rs.getString(4));
			 dog.setAge(rs.getInt(5));
			 dog.setGetdata(rs.getString(6));
			 
			 
			 list.add(dog);
		 }
		 return list;
		 }
		 
	public  Vector<Vector> getTabledata2(List<Dog> list){
			Vector<Vector> rows=new Vector<Vector>();
			for(int i=0;i<list.size();i++) 
			{
			  Vector row=new Vector();
			 Dog dog=list.get(i);
		     Collections.addAll(row,dog.getId(),dog.getName(),dog.getSex(),dog.getColor(),dog.getAge(),dog.getGetdata());
		     rows.add(row);
			    }
			return rows;
			}
		
		
		
		
	}
	
	
	
	
	
	
	
	

