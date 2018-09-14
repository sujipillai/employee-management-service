package com.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.bean.EmployeeBean;
import com.bean.EmployeeDetailsBean;
import com.util.DbUtil;
import com.util.commonUtils;

/**
 * Servlet implementation class EmployeeProfileServ
 */
@WebServlet("/empProfile")
public class EmployeeProfileServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeProfileServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 //Connection conn = commonUtils.getoldConnection(request);****************
		Connection conn=DbUtil.createConnection();
		 HttpSession session = request.getSession();
		 EmployeeBean loginedUsr = commonUtils.getLoginUserInfo(session);
			//User is not logged in then sent to directly on login page
			if(loginedUsr == null){
				response.sendRedirect(request.getContextPath() + "/login");
		        return;
			}
			request.setAttribute("user", loginedUsr);
			
			String errInfo=null;
			EmployeeDetailsBean employeeDetailsBean=new EmployeeDetailsBean();
			try{
				employeeDetailsBean=commonUtils.searchEmployee(conn, loginedUsr.getUserName());
			}
			catch (SQLException e) {
	            e.printStackTrace();
	            errInfo = e.getMessage();
	        }
			
			// Request attribute stored
	        request.setAttribute("errorInformation", errInfo);
	        request.setAttribute("user", employeeDetailsBean);
	        
	        RequestDispatcher dispatcher = request.getServletContext()
	                .getRequestDispatcher("/employeeViewDetail.jsp");
	        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
