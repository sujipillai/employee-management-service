package com.login;


import java.sql.*;

public class TestConn {
	public static void main(String[] argv) throws SQLException {

		System.out.println("-------- MySQL JDBC Connection Testing ------------");

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}

		System.out.println("MySQL JDBC Driver Registered!");
		Connection connection = null;

		try {
			connection = DriverManager
			.getConnection("jdbc:mysql://localhost:3306/emp_mgmt","root", "root");

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
			System.out.println("Connection: "+connection);
			String username="shitals@cybage.com";
			String pass="shital@123";
            String strQuery = "select * from login WHERE emailid='"
	                + username + "' and password='" + pass+ "'";
	        Statement st = null;
			try {
				st = connection.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        ResultSet rs = st.executeQuery(strQuery);
	        System.out.println("ResultSet: "+rs);
		} else {
			System.out.println("Failed to make connection!");
		}
	  }

}
