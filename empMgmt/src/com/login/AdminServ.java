package com.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.bean.EmployeeBean;
import com.util.commonUtils;

/**
 * Servlet implementation class AdminServ
 */
@WebServlet("/admin")
public class AdminServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		EmployeeBean loginedUsr = commonUtils.getLoginUserInfo(session);
		//User is not logged in then sent to directly on login page
		if(loginedUsr == null){
			response.sendRedirect(request.getContextPath() + "/login");
	        return;
		}
		request.setAttribute("userInfo", loginedUsr);
		 RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/admin.jsp");
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
