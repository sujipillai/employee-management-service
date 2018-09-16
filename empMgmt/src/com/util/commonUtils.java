package com.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import com.bean.EmployeeBean;
import com.bean.EmployeeDetailsBean;

public class commonUtils {
	public static final String ATT_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";
	
	// User info stored in session.
    public static void LoginedUser(HttpSession session, EmployeeBean userLogin) {
        session.setAttribute("loggedInUser", userLogin);
    }
    
    // Get the user information stored in the session.
    public static EmployeeBean getLoginUserInfo(HttpSession session) {
    	EmployeeBean loginedUser = (EmployeeBean) session.getAttribute("loggedInUser");
        return loginedUser;
    }
    
    // Get Connection attribute from request
    public static Connection getoldConnection(ServletRequest request) {
        Connection conn = (Connection) request.getAttribute(ATT_CONNECTION);
        return conn;
    }
    
    // Store Connection in request attribute.
    // (Information stored only exist during requests)
    public static void storeMyConnection(ServletRequest request, Connection conn) {
        request.setAttribute(ATT_CONNECTION, conn);
    }
    public static EmployeeDetailsBean searchEmployee(Connection conn, String userName) throws SQLException {
System.out.println(userName);
    	
    	String sql = "Select id, userName, department, salary, role from employeedetails where userName =?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
 
        ResultSet rs = pstm.executeQuery();
        EmployeeDetailsBean employeeDetailsBean =new EmployeeDetailsBean();
        System.out.println("Before Setting Employee Details value");
        while (rs.next()) {
        	employeeDetailsBean.setUserName(rs.getString("userName"));
        	employeeDetailsBean.setRole(rs.getString("role"));
        	employeeDetailsBean.setSalary(rs.getString("salary"));
        	employeeDetailsBean.setId(rs.getInt("id"));
        	employeeDetailsBean.setDepartment(rs.getString("department"));
        }
        System.out.println("Set Employee Details"+employeeDetailsBean);
        return employeeDetailsBean;
    }
    
    public static EmployeeBean findEmployee(Connection conn, String userName) throws SQLException {
        String sql = "Select userName, password, loginid from loginuser where userName=?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
 
        ResultSet rs = pstm.executeQuery();
 
        while (rs.next()) {
        	EmployeeBean employee = new EmployeeBean();
            employee.setUserName(rs.getString("userName"));
            employee.setPassword(rs.getString("password"));//(CryptoghraphyUtil.decrypt(rs.getString("password")));
            employee.setId(rs.getInt("loginid"));
            return employee;
        }
        return null;
    }
    
    public static List<EmployeeDetailsBean> getEmplList(Connection conn) throws SQLException{
    	List<EmployeeDetailsBean> list = new ArrayList<>();
    	
    	String sql = "Select id, userName, department, salary, role from employeedetails";
    	 
        PreparedStatement pstm = conn.prepareStatement(sql);
        
 
        ResultSet rs = pstm.executeQuery();
        
        
        System.out.println("Before Setting Employee Details value");
        while (rs.next()) {
        	EmployeeDetailsBean employeeDetailsBean = new EmployeeDetailsBean();
        	employeeDetailsBean.setId(rs.getInt("id"));
        	employeeDetailsBean.setUserName(rs.getString("userName"));
        	employeeDetailsBean.setRole(rs.getString("role"));
        	employeeDetailsBean.setSalary(rs.getString("salary"));
        	employeeDetailsBean.setDepartment(rs.getString("department"));        
            list.add(employeeDetailsBean);
        }
        System.out.println(list);
        return list;
    }
}
