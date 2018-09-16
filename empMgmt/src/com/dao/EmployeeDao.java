package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.EmployeeDetailsBean;
import com.mysql.jdbc.Connection;
import com.util.DbUtil;

public class EmployeeDao {
	
	public void updateEmployeeDetails(EmployeeDetailsBean bean) throws SQLException{
		Connection con = null; 
		  try{
		  con= DbUtil.createConnection();
		  if(con != null){ 
			  String query = "update employeedetails set userName=?, department=?, salary= ?, role=? where id=? ";
			  PreparedStatement pstm = con.prepareStatement(query);
		        pstm.setString(1, bean.getUserName());
		        pstm.setString(2, bean.getDepartment());
		        pstm.setString(3, bean.getSalary());
		        pstm.setString(4, bean.getRole());
		        pstm.setInt(5, bean.getId());
		 
		        int result = pstm.executeUpdate();
		        System.out.println("update result = " +result);
		  }
		  }catch(SQLException e){
			  System.out.println(e.getMessage());
		  }
		  finally{
			  //con.close();
		  }
	}

}
