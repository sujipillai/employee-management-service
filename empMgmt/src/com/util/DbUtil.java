package com.util;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.bean.EmployeeBean;
import com.mysql.jdbc.Connection;

public class DbUtil {
	public static Connection createConnection() {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/mydb"; // MySQL URL
																// followed by
																// the database
																// name
		String username = "root"; // MySQL username
		String password = "password"; // MySQL password

		try {
			try {
				Class.forName("com.mysql.jdbc.Driver"); // loading MySQL
														// drivers. This differs
														// for database servers
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			con = (Connection) DriverManager.getConnection(url, username, password); // attempting to connect to mysql db
			System.out.println("Printing connection object " + con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void closeConnection(java.sql.Connection conn) {
	       try {
	           conn.close();
	       } catch (Exception e) {
	       }
	   }
	
	public static EmployeeBean findUser(Connection conn, String userName, String password, String ip) throws SQLException {
		String encryptPassword = CryptoghraphyUtil.encrypt(password);
		System.out.println("Encrypted password is "+encryptPassword);
		System.out.println("Username="+userName+"password="+password+"ip="+ip);
		String sql = "Select userName, password, ip, role from loginuser where userName = ? and password= ? and ip= ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
        pstm.setString(2, password);
        pstm.setString(3, ip);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
        	String dbuser=rs.getString("userName");
            EmployeeBean user = new EmployeeBean();
            user.setUserName(userName);
            user.setPassword(password);
            user.setRole(rs.getString(4));
            return user;
        }
        return null;
	}
}
