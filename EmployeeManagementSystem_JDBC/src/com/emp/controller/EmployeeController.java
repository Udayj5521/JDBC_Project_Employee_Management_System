package com.emp.controller;

import java.util.Scanner;

import com.emp.dto.Employee;
import com.emp.service.EmployeeService;


public class EmployeeController {
	public static void main(String[] args) {
		
		EmployeeService dao = new EmployeeService();
		System.out.println("WELCOME TO EMPLOYEE MANAGEMENT APPLICATION");

		Scanner s = new Scanner(System.in);
		do {
			System.out.println("1. Add Employee\n" + "2. Show All Employee\n" + "3. Show Employee based on id \n"
					+ "4. Update the employee\n" + "5. Delete the employee\n");

			System.out.println("ENTER CHOICE: ");
			int ch = s.nextInt();
			switch (ch)
			{
			case 1:
				Employee emp = new Employee();
				System.out.println("Enter ID : ");
				int id = s.nextInt();
				System.out.println("Enter name ");
				String name = s.next();
				System.out.println("Enter Salary ");
				double salary = s.nextDouble();
				System.out.println("Enter age");
				int age = s.nextInt();
				
				emp.setId(id);
				emp.setName(name);
				emp.setSalary(salary);
				emp.setAge(age);
				dao.createEmployee(emp);
				break;
				
			case 2:
				dao.showAllEmployee();
				break;
				
			case 3:
				System.out.println("Enter id to show the details ");
				int empid = s.nextInt();
				dao.showEmployeeBasedOnID(empid);
				break;
				
			case 4:
				System.out.println("Enter id to update the details");
				int empid1 = s.nextInt();
				System.out.println("Enter the new name");
				name = s.next();
				dao.updateEmployee(empid1, name);
				break;
				
			case 5:
				System.out.println("Enter the id to delete");
				id = s.nextInt();
				dao.deleteEmployee(id);
				break;

			case 6:
				System.out.println("Thank you for using our Application !!!");
				System.exit(0);
			default:
				System.out.println("Enter valid choice !");
				break;

			}

		} while (true);

	}

}
