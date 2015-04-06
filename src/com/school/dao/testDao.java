package com.school.dao;

import java.sql.*;

public class testDao {

	public static  void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;	
		conn = ConnectionManager.getConnection();
		String sql ="select * from person";
		try {
			ps = conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				System.out.print(rs.getString("name"));
				System.out.print(rs.getString("sex"));
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection(conn);
			ConnectionManager.closeResultSet(rs);
			ConnectionManager.closeStatement(ps);
		}
	}
	
}
