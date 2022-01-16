package com.simplilearn;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DatabaseUtil {

	/**
	 * Fetches the properties from the config fole
	 * 
	 * @param resourcePath
	 * @return
	 * @throws IOException
	 */
	public static Properties getProperties(String resourcePath, ServletContext servletContext) throws IOException {
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
	public static Connection getDatabaseConnetion(String databaseName, ServletContext servletContext) {
		try {

			// Step :01
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step : 2.2 Get the connection.
			Properties properties = getProperties("/WEB-INF/configuration.properties", servletContext);
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
}
