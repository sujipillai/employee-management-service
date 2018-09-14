package com.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.RegisterBean;
import com.dao.RegisterDao;


/**
 * Servlet implementation class RegisterServ
 */

public class RegisterServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String fullName = request.getParameter("fullname");
		 String email = request.getParameter("email");
		 String contact = request.getParameter("contact");
		 String password = request.getParameter("password");
		 int status = Integer.parseInt(request.getParameter("status"));
		 System.out.println("In Register Servlet values"+fullName+"email"+email+"contact"+contact+"password"+password+"status"+status);
		 RegisterBean registerBean = new RegisterBean();
		 //Using Java Beans - An easiest way to play with group of related data
		 registerBean.setFullName(fullName);
		 registerBean.setEmail(email);
		 registerBean.setContact(contact);
		 registerBean.setPassword(password);
		 registerBean.setDelstatus(status);
		 RegisterDao registerDao = new RegisterDao();
		 String userRegistered = registerDao.registerUser(registerBean);
		 
		 if(userRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
		 {
		 request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
		 }
		 else   //On Failure, display a meaningful message to the User.
		 {
		 request.setAttribute("errMessage", userRegistered);
		 request.getRequestDispatcher("/Register.jsp").forward(request, response);
		 }
		 }
	}


