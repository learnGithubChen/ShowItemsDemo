package com.sql.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * �������ݿ������
 */
public class DBHelper {
	private static String URL = "jdbc:mysql://localhost:3306/shopping?serverTimezone=UTC&characterEncoding=utf-8";
	private static String username = "root";
	private static String password = "mysql123";
	private static Connection conn = null;
	 // ��̬���������
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// ��ȡ���ݿ�����
	public static Connection getConnection() {
		try {
			conn = DriverManager.getConnection(URL, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void main(String[] args) {
		conn = getConnection();
		if (conn != null) {
			System.out.println("���ݿ����ӳɹ�");
		}
	}
}
