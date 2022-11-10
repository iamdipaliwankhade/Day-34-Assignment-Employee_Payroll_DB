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

	public static boolean CreateConnection(String q) {
		return true;
	}

	public static boolean preparedStatement(String name, double salary) {
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_service", "root", "root");
			String q = "update  employee_payroll set salary=?  where name=?";
			PreparedStatement ps = con.prepareStatement(q);
			ps.setDouble(1, salary);
			ps.setString(2, name);
			ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return true;

	}
}
