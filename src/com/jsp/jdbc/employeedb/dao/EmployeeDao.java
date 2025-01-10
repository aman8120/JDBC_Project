package com.jsp.jdbc.employeedb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeDao {

	Scanner scan = new Scanner(System.in);

	public static Connection buildConnection() {
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_employeedb?user=root&password=tiger");

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void addEmployee() {

		Connection conn = buildConnection();
		try {
			PreparedStatement pst = conn.prepareStatement("INSERT INTO employee VALUES(?,?,?,?,?)");

			System.out.println("ENTER EMPLOYEE ID");
			pst.setInt(1, scan.nextInt());
			System.out.println("ENTER EMPLOYEE NAME");
			pst.setString(2, scan.next());
			System.out.println("ENTER EMPLOYEE EMAIL");
			pst.setString(3, scan.next());
			System.out.println("ENTER EMPLOYEE DECS");
			pst.setString(4, scan.next());
			System.out.println("ENTER EMPLOYEE SALARY");
			pst.setInt(5, scan.nextInt());

			int rowInserted = pst.executeUpdate();

			if (rowInserted > 0)
				System.out.println(rowInserted + " Data Inserted");
			else
				System.out.println("Data Not Inserted");

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void findEmployeeByName() {

		Connection conn = buildConnection();
		try {
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM employee WHERE employeeName=?");
			System.out.println("ENTER EMPLOYEE NAME");
			pst.setString(1, scan.next());
			ResultSet rs = pst.executeQuery();
			System.out.println("EmployeeId\tEmployeeName\tEmployeeEmail\tEmployeeDesc\tEmployeeSalary");
			while (rs.next()) {
				System.out.print(rs.getInt(1) + "\t\t");
				System.out.print(rs.getString(2) + "\t\t");
				System.out.print(rs.getString("employeeEmail") + "\t");
				System.out.print(rs.getString("employeeDesc") + "\t");
				System.out.print(rs.getInt(5) + "\t");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void findEmployeeWithSalaryBetween() {

		Connection conn = buildConnection();
		try {
			PreparedStatement pst = conn
					.prepareStatement("SELECT * FROM employee WHERE employeeSalary BETWEEN ? AND ?");
			System.out.println("Enter Salary Between");
			System.out.print("ENTER Salary :");
			pst.setInt(1, scan.nextInt());
			System.out.print("ENTER Salary Between :");
			pst.setInt(2, scan.nextInt());

			ResultSet rs = pst.executeQuery();
			System.out.println("EmployeeId\tEmployeeName\tEmployeeEmail\tEmployeeDesc\tEmployeeSalary");
			while (rs.next()) {
				System.out.print(rs.getInt(1) + "\t\t");
				System.out.print(rs.getString(2) + "\t\t");
				System.out.print(rs.getString("employeeEmail") + "\t");
				System.out.print(rs.getString("employeeDesc") + "\t\t");
				System.out.print(rs.getInt(5) + "\t");
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateEmployeeSalarybyDesc() {
		Connection conn = buildConnection();
		try {
			PreparedStatement pst = conn.prepareStatement("UPDATE employee SET employeeSalary=? WHERE employeeDesc=?");

			System.out.println("ENTER EMPLOYEE SALARY");
			pst.setInt(1, scan.nextInt());
			System.out.println("ENTER EMPLOYEE DESC");
			pst.setString(2, scan.next());

			int rowUpdated = pst.executeUpdate();

			if (rowUpdated > 0)
				System.out.println(rowUpdated + " Data Updated");
			else
				System.out.println("Data Not Updated");
			pst.setInt(1, scan.nextInt());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deleteEmployeeById() {
		Connection conn = buildConnection();
		try {
			PreparedStatement pst = conn.prepareStatement("DELETE  FROM employee WHERE employeeId=?");
			System.out.println("ENTER EMPLOYEE ID");
			pst.setInt(1, scan.nextInt());
			int rowDeleted = pst.executeUpdate();

			if (rowDeleted > 0)
				System.out.println(rowDeleted + " Data Deleted");
			else
				System.out.println("Data Not Deleted");
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
