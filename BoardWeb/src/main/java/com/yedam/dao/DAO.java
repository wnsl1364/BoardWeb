package com.yedam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	// Connection 생성
	public Connection getConnect() {
		// 1. 데이터베이스 연결을 위한 기본 정보 (Oracle 기준)
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 오라클 DB 접속 URL
		String userId = "scott"; // 데이터베이스 사용자 계정
		String userPw = "tiger"; // 데이터베이스 사용자 비밀번호

		// 2. 데이터베이스 연결(Connection 객체 생성)
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, userId, userPw);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
