package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class orderutil {
	public static Connection getConnection(){
		Connection conn=null;
		String driverName="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://192.168.1.89:3306/restaurantsys?"
				+"useUnicode=true&characterEncoding=utf8";
		String user="root";
		String password="123456";
		
		
			try {
				Class.forName(driverName);
				conn=DriverManager.getConnection(url,user,password);
			} catch(SQLException e){
				throw new ServiceException("Can't get conncetion",e);
			}catch (ClassNotFoundException e) {
				throw new ServiceException("Can't get connection",e);
			}
			
			return conn;
		
	}
	public static void closeConnection(Connection conn){
		try {
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			throw new ServiceException("Can't close connection",e);
		}
	}
	
	public static void closeStatement(ResultSet rs,Statement stmt){
		try {
			if(rs!=null){
				rs.close();
			}
			if(stmt!=null){
				stmt.close();
			}
		} catch (SQLException e) {
			throw new ServiceException("Can't not close statement",e);
		}
	}
	public static void main(String[] args) {
		Connection con=getConnection();
		if(con!=null) System.out.println("连接成功");
	}
}
