package com.employeepayrolldb;

import java.sql.SQLException;

import org.junit.Test;

import junit.framework.Assert;

public class EmployeePayrollQueryTest {
	@Test
	public void UpdateQueryTest() {
		EmployeePayrollDB obj = new EmployeePayrollDB();
		String q = "update employee_payroll set salary = 3000000 where name = 'Tony'";
		Assert.assertEquals(true, EmployeePayrollDB.CreateConnection(q));
	}

	@Test
	public void CheckUpdateQuery() throws SQLException {
		EmployeePayrollDB obj = new EmployeePayrollDB();
		Assert.assertEquals(true, EmployeePayrollDB.preparedStatement("Tony", 3000000.0));
	}

}
