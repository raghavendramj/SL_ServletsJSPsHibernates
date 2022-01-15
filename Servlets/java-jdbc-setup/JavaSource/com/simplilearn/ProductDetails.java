package com.simplilearn;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductDetails() {
		super();
	}

	/**
	 * Gets all the products in the database -> productdb
	 * 
	 * @param connection
	 * @param response
	 * @throws SQLException
	 */
	public void getProducts(Connection connection, HttpServletResponse response) throws SQLException {
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			// Step: 03 Create a Statement
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			// Step 04.1 : Execute the query
			String sqlQuery = "select * from products";
			resultSet = statement.executeQuery(sqlQuery);

			// Step 04.2 Manipulate the result and send it to the UI
			PrintWriter out = response.getWriter();
			out.println("The Product detaila are...");
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String quantity = resultSet.getString(3);
				String unitPrice = resultSet.getString(3);
				out.println("Id :- " + id + "\tName :- " + name + "\tQuantity :- " + quantity + "\tUnit Price :- "
						+ unitPrice);
			}

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

	/**
	 * Gets the product based on id parameter from the database -> productdb
	 * 
	 * @param connection
	 * @param response
	 * @param request
	 * @throws SQLException
	 * @throws IOException
	 */

	public void getProductById(Connection connection, HttpServletResponse response, HttpServletRequest request)
			throws SQLException, IOException {

		String paramterizedSQLQuery = "select * from products where product_id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(paramterizedSQLQuery);
		String product_id = request.getParameter("product_id");
		preparedStatement.setInt(1, Integer.parseInt(product_id));

		ResultSet resultSet = preparedStatement.executeQuery();
		PrintWriter out = response.getWriter();
		out.println("The Product detais with id : " + product_id + " is...");

		while (resultSet.next()) {
			int id = resultSet.getInt(1);
			String name = resultSet.getString(2);
			String quantity = resultSet.getString(3);
			String unitPrice = resultSet.getString(3);
			out.println(
					"Id :- " + id + "\tName :- " + name + "\tQuantity :- " + quantity + "\tUnit Price :- " + unitPrice);
		}
	}

	/**
	 * Gets the product based on name parameter from the database -> productdb
	 * 
	 * @param connection
	 * @param response
	 * @param productName
	 * @throws SQLException
	 * @throws IOException
	 */

	public void getProductByName(Connection connection, HttpServletResponse response, String productName)
			throws SQLException, IOException {

		String paramterizedSQLQuery = "select * from products where name=?";
		PreparedStatement preparedStatement = connection.prepareStatement(paramterizedSQLQuery);
		preparedStatement.setString(1, productName);

		ResultSet resultSet = preparedStatement.executeQuery();
		PrintWriter out = response.getWriter();
		out.println("The Product detais with name : " + productName + " is...");

		while (resultSet.next()) {
			int id = resultSet.getInt(1);
			String name = resultSet.getString(2);
			String quantity = resultSet.getString(3);
			String unitPrice = resultSet.getString(3);
			out.println(
					"Id :- " + id + "\tName :- " + name + "\tQuantity :- " + quantity + "\tUnit Price :- " + unitPrice);
		}
	}

	/**
	 * Creates the product row in the database.
	 * 
	 * @param connection
	 * @param response
	 * @param request
	 * @throws SQLException
	 * @throws IOException
	 */
	public void createProduct(Connection connection, HttpServletResponse response, HttpServletRequest request)
			throws SQLException, IOException {
		String paramterizedSQLQuery = "insert into products(name, quantity_in_stock, unit_price) values(?, ?, ?);";
		PreparedStatement preparedStatement = connection.prepareStatement(paramterizedSQLQuery);

		String productName = request.getParameter("productName");

		preparedStatement.setString(1, productName);
		preparedStatement.setInt(2, Integer.parseInt(request.getParameter("quantity_in_stock")));
		preparedStatement.setInt(3, Integer.parseInt(request.getParameter("unit_price")));

		int status = preparedStatement.executeUpdate();
		PrintWriter out = response.getWriter();
		out.println("The Product succesfully got added to the database... and status : " + status);
		
		getProductByName(connection, response, productName);

	}

	/**
	 * Get the connection to the database
	 * @return
	 */
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Connection connection = getConnection();
			String product_id = request.getParameter("product_id");

			if (product_id == null || product_id.isEmpty()) {
				getProducts(connection, response);
			} else {
				getProductById(connection, response, request);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Connection connection = getConnection();
			createProduct(connection, response, request);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
