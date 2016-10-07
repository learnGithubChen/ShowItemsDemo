package com.sql.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * 创建数据库操作类
 */
public class DBHelper {
	private static String URL = "jdbc:mysql://localhost:3306/shopping?serverTimezone=UTC&characterEncoding=utf-8";
	private static String username = "root";
	private static String password = "mysql123";
	private static Connection conn = null;
	 // 静态块加载驱动
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 获取数据库连接
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
			System.out.println("数据库连接成功");
		}
	}
}
