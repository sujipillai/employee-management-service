package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.bean.EmployeeBean;
import com.bean.ErrorObject;
import com.util.DbUtil;
import com.util.commonUtils;



/**
 * Servlet implementation class LoginServ
 */

@WebServlet(urlPatterns = { "/login" })
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServ() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setAttribute("displayError", "none");
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);
		System.out.println("in doget");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.setContentType("text/html");	

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String ip = request.getRemoteAddr();
		boolean invalidUser = false;
		System.out.println("UserName" + userName + "Password" + password + "IP" + ip);
		if(userName != null && password != null){
			EmployeeBean loginBean= new EmployeeBean();
			loginBean.setUserName(userName);
			loginBean.setPassword(password);
			Connection con = DbUtil.createConnection();
			EmployeeBean user=null;
			if(con != null){
				try{
					user=DbUtil.findUser((com.mysql.jdbc.Connection) con, userName, password, ip);
					if(user == null){
						System.out.println("User name or password invalid");
						invalidUser=true;
					}
				}catch(SQLException e){
					e.printStackTrace();
					invalidUser = true;
				}
				//if email or password is invalid
				if (invalidUser) {
					//String responseData = "ERROR_CODE_404:'Incorrect username or password!...";
					//ErrorObject errObject=new ErrorObject();
					//errObject.setErrorMessage("UserName or Password is incorrect");
					request.setAttribute("displayError", "block");
					request.setAttribute("errorMessage", "Invalid username or password");
					user = new EmployeeBean();
					user.setUserName(userName);
					
					//user.setPassword(password);----not a good policy
					request.setAttribute("userData", user);
					//response.setContentType("text/plain");
					//.getWriter().append(responseData);
					// Invalid user data Forward to login.jsp
					RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/login.jsp");
					dispatcher.include(request, response);
					//response.sendRedirect(request.getContextPath() + "/login");
				}
				else {
					HttpSession session = request.getSession();
					commonUtils.LoginedUser(session, user);
					// Redirect to userInfo page.
					System.out.println(user.getRole());
					request.setAttribute("con", con);
					if(user.getRole().equalsIgnoreCase("ADMIN")){
						response.sendRedirect(request.getContextPath() + "/admin");
					}else if(user.getRole().equals("SUPER_EMPLOYEE")){
						response.sendRedirect(request.getContextPath() + "/superEmployee");
					}else if(user.getRole().equals("EMPLOYEE")){
						response.sendRedirect(request.getContextPath() + "/employee");
					}
				}
			}
		}
	}
}


