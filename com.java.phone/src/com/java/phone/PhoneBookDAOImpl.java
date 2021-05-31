package com.java.phone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class PhoneBookDAOImpl implements PhoneBookDAO {
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(dburl, "C##bituser", "bituser");
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버에 로드 실패!");
		}
		return conn;
	}

	@Override
	public List<PhoneBookVO> getList() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<PhoneBookVO> list = new ArrayList<>();
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			
			String sql = "SELECT id, name, hp, tel " + "FROM phone_book";
			
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				Long id = rs.getLong(1);
				String name = rs.getString(2);
				String hp = rs.getString(3);
				String tel = rs.getString(4);
				
				PhoneBookVO vo = new PhoneBookVO(id, name, hp, tel);
				
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
				} catch (Exception e) {
					
				}
			}
			return list;
		}
	

	@Override
	public List<PhoneBookVO> search(String keyword) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<PhoneBookVO> list = new ArrayList<>();
		
		String sql = "SELECT id, name, hp, tel FROM phone_book " + 
					"WHERE name LIKE ?";
		
		try {
			conn = getConnection();
			pstmt = conn.preparedStatement(sql);
			
			pstmt.setString(1,  "%" + keyword + "%");
			
			rs = pstmt.executeQuery();
			
			
		}
		
		return null;
	}

	@Override
	public PhoneBookVO get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(PhoneBookVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(PhoneBookVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	

	
}
