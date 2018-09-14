package com.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.EmployeeBean;
import com.bean.RegisterBean;
import com.mysql.jdbc.Connection;
import com.util.DbUtil;

public class RegisterDao {
	
	public PreparedStatement findUser(EmployeeBean loginBean){
		String email=loginBean.getUserName();
		String password=loginBean.getPassword();
		Connection con = null; PreparedStatement preparedStatement = null;
		try{
			  con= DbUtil.createConnection();
			  if(con != null){
				  if(con != null){ 
					  
					  String SQL = "SELECT * FROM userlogin WHERE emailid='" + email + "'";
					  PreparedStatement rs = con.prepareStatement(SQL); 
					  if(rs != null)
						  return rs;
				  }
			  }
		}
		catch(Exception e)
		  {
			e.printStackTrace();
		  }
		return null;
	}
	public String registerUser(RegisterBean registerBean)
	 {
	 String fullName = registerBean.getFullName();
	 String email = registerBean.getEmail();
	 String contact = registerBean.getContact();
	 String password = registerBean.getPassword();
	 int status=0;
	 
	  Connection con = null; PreparedStatement preparedStatement = null;
	  try{
	  con= DbUtil.createConnection();
	  if(con != null){ String query =
	  "insert into user(regid,name,contact,password,email,status) values (NULL,?,?,?,?,?)"
	  ; //Insert user details into the table 'USERS' int status=0;
	  preparedStatement = con.prepareStatement(query); //Making use of prepared
	   
	  preparedStatement.setString(1,fullName); 
	  preparedStatement.setString(2, contact);
	  preparedStatement.setString(3, password); 
	  preparedStatement.setString(4,email); 
	  preparedStatement.setInt(5, status);
	  
	  int i= preparedStatement.executeUpdate();
	  
				if (i != 0) {// Just to ensure data has been inserted into the
								// database
					query = "insert into loginuser(loginid,emailid,password) values(NULL,?,?)";
					preparedStatement = con.prepareStatement(query);
					preparedStatement.setString(1, email);
					preparedStatement.setString(2, password);
					int j = preparedStatement.executeUpdate();
					if(j != 0)
						return "SUCCESS";
				}
			}
		}
	  catch(SQLException e)
	  {
	  e.printStackTrace();
	  }
	 return null;
	}
}
