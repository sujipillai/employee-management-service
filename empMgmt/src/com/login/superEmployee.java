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
 * Servlet implementation class superEmployee
 */
@WebServlet("/superEmployee")
public class superEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public superEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();

	       // Check User has logged on
	       EmployeeBean loginUser = commonUtils.getLoginUserInfo(session);

	       // Not logged in
	       if (loginUser == null) {
	           // Redirect to login page.
	           response.sendRedirect(request.getContextPath() + "/login");
	           return;
	       }
	       // Store info to the request attribute before forwarding.
	       request.setAttribute("user", loginUser);

	       // If the user has logged in, then forward to the page
	       // /WEB-INF/views/userInfoView.jsp
	       RequestDispatcher dispatcher //
	               = this.getServletContext().getRequestDispatcher("/superEmpView.jsp");
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
