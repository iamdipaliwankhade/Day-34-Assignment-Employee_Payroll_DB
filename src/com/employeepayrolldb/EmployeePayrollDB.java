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

	public static void preparedStatement(String name, double salary) {

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_service", "root", "dipali");
			String q = "update  employee_payroll set salary=?  where name=?";
			PreparedStatement ps = con.prepareStatement(q);
			ps.setDouble(1, salary);
			ps.setString(2, name);
			ps.executeUpdate();
			boolean result = true;

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws SQLException {
		preparedStatement("Tony", 300000.00);
	}
}
