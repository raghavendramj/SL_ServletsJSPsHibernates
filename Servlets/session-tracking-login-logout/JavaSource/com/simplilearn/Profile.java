package com.simplilearn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Profile() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		request.getRequestDispatcher("link.html").include(request, response);
		HttpSession session = request.getSession();

		if (session != null) {
			String username = (String) session.getAttribute("username");
			out.println("Hello " + username + ", Welcome to the your profile page!");
		} else {
			out.println("Please login before you continue!");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
