package com.simplilearn;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBOperations extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DBOperations() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * Fetches the properties from the config fole
	 * 
	 * @param resourcePath
	 * @return
	 * @throws IOException
	 */
	private Properties getProperties(String resourcePath) throws IOException {
		ServletContext servletContext = getServletContext();
		InputStream inputStream = servletContext.getResourceAsStream(resourcePath);
		Properties properties = new Properties();
		properties.load(inputStream);
		return properties;
	}

	/**
	 * Gets the database connection to a cretain database.
	 * 
	 * @param request
	 * @param response
	 * @param databaseName
	 * @return
	 */
	private Connection getDatabaseConnetion(HttpServletRequest request, HttpServletResponse response,
			String databaseName) {
		try {

			// Step :01
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step : 2.2 Get the connection.
			Properties properties = getProperties("/WEB-INF/configuration.properties");
			String databaseURL = properties.getProperty("databaseURL");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");

			if (databaseName != null && !databaseName.isEmpty()) {
				databaseURL = databaseURL + databaseName;
			}
			return DriverManager.getConnection(databaseURL, username, password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Creates or drops the database from the DB
	 * 
	 * @param connection
	 * @param query
	 * @param response
	 */
	private void operateOnDatabase(Connection connection, String query, HttpServletResponse response) {

		Statement statement = null;
		try {
			statement = connection.createStatement();
			int status = statement.executeUpdate(query);
			PrintWriter out = response.getWriter();
			out.println("Operation completed successfuly : status is " + status);

			getDatabases(connection, response);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Fetches all the database names from the database
	 * 
	 * @param connection
	 * @param response
	 */

	private void getDatabases(Connection connection, HttpServletResponse response) {

		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("show databases");

			PrintWriter out = response.getWriter();
			out.println("\nList of databases available are...");
			while (resultSet.next()) {
				String existingDBName = resultSet.getString(1);
				out.println("Database Name :" + existingDBName);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// name="operation" value="getAll"
		// name="databaseName" value=""
		String operation = request.getParameter("operation");

		Connection connection = getDatabaseConnetion(request, response, null);

		if (operation.equals("getAll")) {
			getDatabases(connection, response);
		} else {
			String databaseName = request.getParameter("databaseName");
			if (databaseName == null || databaseName.isEmpty()) {
				PrintWriter out = response.getWriter();
				out.println("Please enter a valid database....");
				return;
			} else {
				if (operation.equals("create")) {
					String query = "create database if not exists " + databaseName;
					operateOnDatabase(connection, query, response);
				} else {
					// String query = "drop database " + databaseName;
					String query = "drop database if exists " + databaseName;
					operateOnDatabase(connection, query, response);
				}
			}
		}
	}
}
