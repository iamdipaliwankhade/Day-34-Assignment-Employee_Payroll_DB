package com.employeepayrolldb;

import java.sql.Connection;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

public class EmployeePayrollDB {

	static Connection con = null;

	public static void main(String[] args) throws EmployeeCustomException, SQLException {
		con = connected();
		reteriveData(con);
		updateData(con);
	}

	public static Connection connected() throws EmployeeCustomException {
		String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false&&allowPublicKeyRetrieval=true";
		String userName = "root";
		String password = "dipali";
		Connection connection = null;

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
		return connection;
	}

	public static void reteriveData(Connection connection) throws EmployeeCustomException, SQLException {
		PreparedStatement ps = connection.prepareStatement("Select * from employee_payroll");
		ResultSet result = ps.executeQuery();
		while (result.next()) {
			System.out.print(result.getInt(1));
			System.out.print(" | ");
			System.out.print(result.getString(2));
			System.out.print(" | ");
			System.out.print(result.getString(3));
			System.out.print(" | ");
			System.out.print(result.getDouble(4));
			System.out.print(" | ");
		}

	}
	public static void updateData(Connection connection)throws EmployeeCustomException, SQLException{
		PreparedStatement ps = connection.prepareStatement("update employee_payroll set salary = ? where id = ?;");
		ps.setDouble(1,3000000.00);
		ps.setInt(2, 1);
		
		ps.executeUpdate();
		System.out.println("Updated Successfully");
		
	}

	public static void listDrivers() {
		Enumeration<Driver> driverList = DriverManager.getDrivers();
		while (driverList.hasMoreElements()) {
			Driver driverClass = (Driver) driverList.nextElement();
			System.out.println(""+driverClass.getClass().getName());
		}
	}