package cn.edu.jsu.xk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import cn.edu.jsu.xk.dbc.DatabaseConnectionSqlPet;
import cn.edu.jsu.xk.vo.Time;

public class OpreationDao {
       

	Connection conn=new DatabaseConnectionSqlPet().getConnection();
	
	public void AddCat(int a,String b,String c, String d, int e,String f) throws SQLException {

	String sql="insert into Cat values(?,?,?,?,?,?)";
	PreparedStatement pstmt=conn.prepareStatement(sql);
	pstmt.setInt(1,a);
	pstmt.setString(2,b);
	pstmt.setString(3,c);
	pstmt.setString(4,d);
	pstmt.setInt(5,e);
	pstmt.setString(6,f);
	pstmt.executeUpdate();
	
	}
	
    public void DeleteCat(int selected) throws SQLException {
	 
		String sql="delete from Cat where id="+selected;
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.executeUpdate();
		
		
	}
    
    public void UpdateCat(int a,String b,String c, String d, int e,String f) throws SQLException {
    	
    	String sql="update Cat set id=? ,name=?,sex=?,color=?,age=?,getdata=? where id ="+a;
    	PreparedStatement pstmt=conn.prepareStatement(sql);
    	pstmt.setInt(1,a);
    	pstmt.setString(2,b);
    	pstmt.setString(3,c);
    	pstmt.setString(4,d);
    	pstmt.setInt(5,e);
    	pstmt.setString(6,f);
    	pstmt.executeUpdate();
    	
    	
 
    }
    //–°π∑¿‡
    public void AddDog(int a,String b,String c, String d, int e,String f) throws SQLException {

    	String sql="insert into Dog values(?,?,?,?,?,?)";
    	PreparedStatement pstmt=conn.prepareStatement(sql);
    	pstmt.setInt(1,a);
    	pstmt.setString(2,b);
    	pstmt.setString(3,c);
    	pstmt.setString(4,d);
    	pstmt.setInt(5,e);
    	pstmt.setString(6,f);
    	pstmt.executeUpdate();
    	
    	}
    	
        public void DeleteDog(int selected) throws SQLException {
    	 
    		String sql="delete from Dog where id="+selected;
    		PreparedStatement pstmt=conn.prepareStatement(sql);
    		pstmt.executeUpdate();
    		
    		
    	}
        
        public void UpdateDog(int a,String b,String c, String d, int e,String f) throws SQLException {
        	
        	String sql="update Dog set id=? ,name=?,sex=?,color=?,age=?,getdata=? where id ="+a;
        	PreparedStatement pstmt=conn.prepareStatement(sql);
        	pstmt.setInt(1,a);
        	pstmt.setString(2,b);
        	pstmt.setString(3,c);
        	pstmt.setString(4,d);
        	pstmt.setInt(5,e);
        	pstmt.setString(6,f);
        	pstmt.executeUpdate();
        	
        	
     
        }
    
	
	public static void main(String[] args) throws SQLException {
		String time=new Time().getTime();
		new OpreationDao().AddCat(1,"z","sas","ssas",1,time);
		System.out.println(time+"sdsa");
	}

	
	
}