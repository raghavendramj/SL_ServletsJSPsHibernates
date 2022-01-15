package com.simplilearn;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JDBCSetup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public JDBCSetup() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			System.out.println("Reached The Servlet!");
			// Step :01 Register the driver.
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step : 02 Get the connection.
			String databaseURL = "jdbc:mysql://localhost:3306/sljdbc";
			String username = "root";
			String password = "admin@123";

			Connection connection = DriverManager.getConnection(databaseURL, username, password);

			// Step: 03 Create a SQL Query
			Statement statement = connection.createStatement();

			// Step 04.1 : Execute the query
			String sqlQuery = "select * from student";
			ResultSet resultSet = statement.executeQuery(sqlQuery);

			// Step 04.2 Manipulate the result and send it to the UI
			PrintWriter out = response.getWriter();
			out.println("The Students present in the database are...");
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String email = resultSet.getString(3);
				out.println("Id :- " + id + " Name :- " + name + " Email :- "+ email);
			}

			// Step 05: Close the connection
			resultSet.close();
			statement.close();
			connection.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
