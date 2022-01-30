package com.simplilearn.model;

public class LoginDao {
	public static boolean validate(LoginUser user) {
		// database connection
		if (user.getEmail().equalsIgnoreCase("raghav") && user.getPassword().equals("admin@123")) {
			return true;
		} else {
			return false;
		}
	}
}
