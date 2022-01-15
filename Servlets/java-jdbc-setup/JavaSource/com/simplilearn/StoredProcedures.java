package com.simplilearn;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class StoredProcedures extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StoredProcedures() {
		super();
	}

	private Connection getConnection() {

		try {
			// Step :01 Register the driver.
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step: 2.1 Read configuration from properties.
			ServletContext servletContext = getServletContext();
			InputStream inputStream = servletContext.getResourceAsStream("/WEB-INF/configuration.properties");
			Properties properties = new Properties();
			properties.load(inputStream);

			// Step : 2.2 Get the connection.
			String databaseURL = properties.getProperty("databaseURL");
			String databaseName = properties.getProperty("databaseName");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");

			databaseURL = databaseURL + databaseName; // jdbc:mysql://localhost:3306/ + productdb
			Connection connection = DriverManager.getConnection(databaseURL, username, password);

			return connection;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String storedProcudureQuery = "{call add_product(?, ?, ?)}";
			
			Connection connection = getConnection();
			CallableStatement callableStatement = connection.prepareCall(storedProcudureQuery);
			callableStatement.setString(1, request.getParameter("productName"));
			callableStatement.setInt(2, Integer.parseInt(request.getParameter("quantity_in_stock")));
			callableStatement.setInt(3, Integer.parseInt(request.getParameter("unit_price")));

			int status = callableStatement.executeUpdate();
			PrintWriter out = response.getWriter();
			out.println("The Product succesfully got added to the database... and status : " + status);
			
			ProductDetails productDetails = new ProductDetails();
			productDetails.getProductByName(connection, response, request.getParameter("productName"));
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
