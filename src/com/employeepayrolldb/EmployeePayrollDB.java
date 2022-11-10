package com.employeepayrolldb;

import java.sql.Connection;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

public class EmployeePayrollDB {

	public static void main(String[] args) {
		String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false&&allowPublicKeyRetrieval=true";
		String userName = "root";
		String password = "dipali";
		Connection connection;

		try { // jdbc:mysql://localhost;3306/payroll_service?useSSL=false&&allowPublicKeyRetrieval=true";
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		listDrivers();
		try {
			System.out.println("Connecting to database: " + jdbcURL);
			connection = DriverManager.getConnection(jdbcURL, userName, password);
			System.out.println("Connection is Successful" + connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void listDrivers() {
		Enumeration<Driver> driverList = DriverManager.getDrivers();
		while (driverList.hasMoreElements()) {
			Driver driverClass = (Driver) driverList.nextElement();
			System.out.println(" " + driverClass.getClass().getName());
		}
	}
}