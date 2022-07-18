package com.luv2code.web.jdbc;

public final class Authentication {
	private static String url = "jdbc:mysql://localhost:3306/company";
	private static String username = "root";
	private static String password = "Abhimanyu@97";

	
	
	public static String getUrl() {
		return url;
	}
	public static String getUsername() {
		return username;
	}
	public static String getPassword() {
		return password;
	}
	
	
	
}
