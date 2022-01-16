package com.simplilearn;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentsDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentsDetails() {
		super();
	}

	public void deleteStudent(Connection connection, HttpServletResponse response, int student_id)
			throws SQLException, IOException {
		String paramterizedSQLQuery = "delete from student where student_id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(paramterizedSQLQuery);
		preparedStatement.setInt(1, student_id);
		int status = preparedStatement.executeUpdate();
		PrintWriter out = response.getWriter();

		out.println("The Student succesfully got deleted from database... and status : " + status);
		response.setContentType("text/html");
		out.println("<a class='nav-link' href='crud_operations.html'>Home</a>");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			Connection connection = DatabaseUtil.getDatabaseConnetion("sljdbc", getServletContext());
			String operation = request.getParameter("operation");

			if (operation == null || operation.isEmpty()) {
				getStudents(connection, response);
			} else {
				if (operation.equals("delete")) {
					String studentId = request.getParameter("student_id");
					deleteStudent(connection, response, Integer.parseInt(studentId));
				} else if (operation.equals("update")) {

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void getStudents(Connection connection, HttpServletResponse response) throws SQLException {
		Statement statement = null;
		ResultSet resultSet = null;
		try {

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<head>");
			out.println("<link rel='stylesheet'\r\n"
					+ "	href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css'\r\n"
					+ "	integrity='sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO'\r\n"
					+ "	crossorigin='anonymous' />");
			out.println("</head>");
			out.println("<body>");

			out.println("<div class='container'>");
			out.println("<nav class='navbar-nav mr-auto'>");
			out.println("<li class='nav-item'><a class='nav-link' href='crud_operations.html'>Home</a></li>");
			out.println(
					"<li class='nav-item'><a class='nav-link' href='createStudent.html'>Create New Student</a></li>");
			out.println("</nav>");
			out.println("<form action='students'>");

			// Step: 03 Create a Statement
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			// Step 04.1 : Execute the query
			String sqlQuery = "select * from student";
			resultSet = statement.executeQuery(sqlQuery);

			// Step 04.2 Manipulate the result and send it to the UI

			out.println("<h3>The Student detaila are...<h3>");
			out.println("<table class='table table-striped'>");
			out.println("<tr>");
			out.println("<th>Id</th>");
			out.println("<th>Name</th>");
			out.println("<th>Email</th>");
			out.println("<th>Operations</th>");
			out.println("</tr>");

			while (resultSet.next()) {
				out.println("<tr>");

				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String email = resultSet.getString(3);

				out.println("<td>" + id + "</td>");
				out.println("<td>" + name + "</td>");
				out.println("<td>" + email + "</td>");
				out.println("<td>");
				out.println("<td>");
				out.println(
						"<button type='submit' formmethod='update' class='btn btn-primary' name='operation' value='update'>Update</button>");
				out.println(
						"<button type='submit' formmethod='delete' class='btn btn-danger' name='operation' value='delete' student_id='"
								+ id + "'>Delete</button>");
				out.println("</td>");

				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</form>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (resultSet != null) {
				resultSet.close();
			}
		}
	}

	public void createStudent(Connection connection, HttpServletResponse response, HttpServletRequest request)
			throws SQLException, IOException {
		String paramterizedSQLQuery = "insert into student(name, email) values(?, ?);";
		PreparedStatement preparedStatement = connection.prepareStatement(paramterizedSQLQuery);

		String studentName = request.getParameter("name");
		preparedStatement.setString(1, studentName);
		preparedStatement.setString(2, request.getParameter("email"));

		int status = preparedStatement.executeUpdate();
		PrintWriter out = response.getWriter();
		out.println("The Student succesfully got added to the database... and status : " + status);
		response.setContentType("text/html");
		out.println("<li class='nav-item'><a class='nav-link' href='crud_operations.html'>Home</a></li>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Connection connection = DatabaseUtil.getDatabaseConnetion("sljdbc", getServletContext());
			createStudent(connection, response, request);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("\n ******** Case : 02 doDelete..");

		Enumeration<String> requestParamNames = request.getParameterNames();

		while (requestParamNames.hasMoreElements()) {
			String key = requestParamNames.nextElement();
			String value = request.getParameter(key);
			out.println("From Enumeration... Key : " + key + " and  value is : " + value);
		}
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("\n ******** Case : 02 doDelete..");

		Enumeration<String> requestParamNames = request.getParameterNames();

		while (requestParamNames.hasMoreElements()) {
			String key = requestParamNames.nextElement();
			String value = request.getParameter(key);
			out.println("From Enumeration... Key : " + key + " and  value is : " + value);
		}

	}
}
