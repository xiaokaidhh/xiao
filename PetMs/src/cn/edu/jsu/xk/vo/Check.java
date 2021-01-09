package cn.edu.jsu.xk.vo;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import cn.edu.jsu.xk.dbc.DatabaseConnectionSql;

public class  Check {
	
	  /**
	 * @throws SQLException 
	 * 
	 */
	Connection conn=new  DatabaseConnectionSql ().getConnection();
	public boolean getcheckbiao(String a,String b,String c) throws SQLException {
		 if(b.equals(c)) {
		String sql="select * from logbiao where username='"+a+"'";
		
			PreparedStatement pstmt=conn.prepareStatement(sql);
	
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()) {
				JOptionPane.showMessageDialog(null, "此账户已被注册！");
				return false;
			}
			else {
				JOptionPane.showMessageDialog(null,"注册成功");
				return true;
			}
			}
		
		else {	
		    JOptionPane.showMessageDialog(null,"两次输入密码不一致");
			return false;}
			}
			
	public boolean getchecklog(String a,String b) throws HeadlessException, SQLException {
				String sql="select * from logbiao where username='"+a+"' and  password='"+b+"'";
				
					PreparedStatement pstmt=conn.prepareStatement(sql);
			
					ResultSet rs=pstmt.executeQuery();
					if(rs.next()) {
						
						return true;
					}
				
						return false;
					}
	
	
	public boolean checkCustomlog(String a,String b) throws IOException {
		
			    File file=new File("source/custom.txt");
				BufferedReader fr = new BufferedReader(new FileReader(file));
				String row1=null;
				    while((row1=fr.readLine())!=null) {//按行读取数据
				    	String s=row1.replaceAll("\t","");
				    	
			       if(s.equals(a+b))
				return true;
			       
			       
				}
                       return false;
                       }
	
         public boolean checkCustomname(String a,String b,String c ) throws IOException {
        	 if(b.equals(c)) {
        	   File file=new File("source/custom.txt");
        	   BufferedReader fr=new BufferedReader(new FileReader(file));
        	   String row1=null;
        	   while((row1=fr.readLine())!=null) {
        		   
        		   String[] s=row1.split("\t");
       			if(s[0].equals(a)) {
       				
       				JOptionPane.showMessageDialog(null, "此账户已被注册！");
       				return false;
       			}
       				
 
    
        	   }
        		JOptionPane.showMessageDialog(null,"注册成功");
        	   return true;
        	 }
        	 else 
        		 {JOptionPane.showMessageDialog(null, "两次密码不一致");
        		 
        		 return false;
        		 }
                    	   
                       }
	
		}
					
						
					
					
	
	
	
	


