package com.hexaware.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.hexaware.exception.DbConnectionException;

public class DbConnectionUtil {
	
	static {
		try {
			Class.forName(DbProperties.getDriver());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public static Connection getDbConnection() throws DbConnectionException {
		Connection conn=null;
		try {
			conn = DriverManager.getConnection(DbProperties.getDbURL(),DbProperties.getProps());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new DbConnectionException();
		}
		return conn;
	}
	
	public static void closeConnection(Connection conn) {
			try {
				if(conn != null) 
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}


