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

	public static void CreatConnection() {

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_service", "root",
					"dipali");
			String Select = "select * from employee_payroll";
			PreparedStatement ps = con.prepareStatement(Select);
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				int id = res.getInt(1);
				String name = res.getString(2);
				String gender = res.getString(3);
				Double salary = res.getDouble(4);
				String date = res.getString(5);
				System.out.println("id- " + id + " Name -" + name + " gender- " + gender + "|" + " salary -" + salary
						+ " date- " + date);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws SQLException {
		CreatConnection();
	}
}