package cn.edu.jsu.xk.vo;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import cn.edu.jsu.xk.dbc.DatabaseConnectionSql;


public class Regbiao {

	public Regbiao(String a, String b) throws SQLException {
		 {
	  String sql="insert into logbiao values(?,?) ";
			Connection conn=new  DatabaseConnectionSql ().getConnection();
				PreparedStatement pstmt=conn.prepareStatement(sql);
	 {
				pstmt.setString(1, a);
				pstmt.setString(2, b);
				pstmt.executeUpdate();}
	}
	
}

}