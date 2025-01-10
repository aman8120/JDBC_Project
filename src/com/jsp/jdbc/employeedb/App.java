package com.jsp.jdbc.employeedb;

import java.util.Scanner;

import com.jsp.jdbc.employeedb.dao.EmployeeDao;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EmployeeDao emp = new EmployeeDao();

		System.out.println("1.Add Employee");
		System.out.println("2.Update Enployee Salary By Desc");
		System.out.println("3.Delete Employee By ID");
		System.out.println("4.Find Employee By Name");
		System.out.println("5.Find Employee With Salary Between");
		System.out.println(" ");
		System.out.print("Choose Any Option : ");
		int choice = sc.nextInt();

		switch (choice) {
		case 1: {
			emp.addEmployee();
			break;
		}
		case 2: {
			emp.updateEmployeeSalarybyDesc();
			break;
		}
		case 3: {
			emp.deleteEmployeeById();
			break;
		}
		case 4: {
			emp.findEmployeeByName();
			break;
		}
		case 5: {
			emp.findEmployeeWithSalaryBetween();
			break;
		}
		default: {
			System.out.println("Invaild Option");
		}
		}

//		emp.addEmployee();
//		emp.updateEmployeeSalarybyDesc();
//		emp.deleteEmployeeById();
//		emp.findEmployeeByName();
//		emp.findEmployeeWithSalaryBetween();

	}
}
