package com.simplilearn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccountDashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AccountDashboard() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie[] cookies = request.getCookies();

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");

		boolean foundUserId = false;
		for (Cookie eachCookie : cookies) {
			String userIdKey = eachCookie.getName();
			String userIdValue = eachCookie.getValue();

			if (userIdKey.contentEquals("userId") && userIdValue != null && !userIdValue.isEmpty()) {
				out.println("<b> UserId read from cookie :- " + userIdValue);
				foundUserId = true;
			}
		}

		if (!foundUserId) {
			out.println("<b>No UserId cookie was found ");
		}

		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
