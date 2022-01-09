package com.simplilearn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("link.html").include(request, response);

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (password.equals("admin@123")) {
			out.println("Welcome to our website!");
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("password", password);
		} else {
			out.println("Invalid Credentials, Please try again!");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
