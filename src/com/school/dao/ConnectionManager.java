package com.school.dao;

import java.sql.*;

public class ConnectionManager {
	private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	private static String DatabaseName="test";
	private static String USER_NAME="root";
	private static String PASSWORD="1234";	
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3309/"+DatabaseName;//mysql有所不一样的地方在这个数据库连接路径。
	
	//数据库链接
	public static Connection getConnection(){
		
		Connection conn = null;
		try {
			Class.forName(DRIVER_CLASS);
			conn = DriverManager.getConnection(DATABASE_URL,USER_NAME,PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
	//关闭连接
	public static void closeConnection(Connection conn){
		try {
			if(conn!=null&&!(conn.isClosed())){		
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	//关闭结果集
	public static void closeResultSet(ResultSet res){
		if(res!=null){
			
			try {
				res.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			res=null;
		}
		
	}
	
	
	//关闭语句
	public static void closeStatement(PreparedStatement ps){
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ps = null;
		}
		
	}
}
