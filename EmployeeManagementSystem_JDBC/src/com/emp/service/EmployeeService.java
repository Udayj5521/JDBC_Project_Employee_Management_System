package com.emp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.emp.DBConnection;
import com.emp.dto.Employee;

public class EmployeeService {
	Connection con;

	public void createEmployee(Employee emp) {
		con = DBConnection.createDBConnetion();
		String query = "insert into employee values(?,?,?,?)";
		try 
		{
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, emp.getId());
			ps.setString(2, emp.getName());
			ps.setDouble(3, emp.getSalary());
			ps.setInt(4, emp.getAge());
			
			int s = ps.executeUpdate();
			if (s != 0)
				System.out.println("Employee Inserted Successfully !!!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void showAllEmployee() 
	{
		con = DBConnection.createDBConnetion();
		String query = "select * from employee";
		System.out.println("Employee Details :");
		System.out.println("---------------------------------------------");

		System.out.format("%s\t%s\t%s\t\t%s\n", "ID", "Name", "Salary", "age");
		System.out.println("---------------------------------------------");

		try 
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				System.out.format("%d\t%s\t%f\t%d\n", rs.getInt(1), rs.getString(2), rs.getDouble(3),
						rs.getInt(4));
				System.out.println("=============================================");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void showEmployeeBasedOnID(int id)
	{
		con = DBConnection.createDBConnetion();
		String query = "select * from employee where id=" + id;
		System.out.println("---------------------------------------------");

		System.out.format("%s\t%s\t%s\t\t%s\n", "ID", "Name", "Salary", "age");
		System.out.println("---------------------------------------------");
		try 
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next())
			{
				System.out.format("%d\t%s\t%f\t%d\n", rs.getInt(1), rs.getString(2), rs.getDouble(3),
						rs.getInt(4));
				System.out.println("=============================================");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateEmployee(int id, String name)
	{
		con = DBConnection.createDBConnetion();
		String query = "update employee set name=? where id=?";
		try 
		{
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setInt(2, id);
			int s = ps.executeUpdate();
			if (s != 0)
				System.out.println("Employee Details updated successfully !!");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deleteEmployee(int id) 
	{
		con = DBConnection.createDBConnetion();
		String query = "delete from employee where id=?";
		try
		{
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			int s = ps.executeUpdate();
			if (s != 0)
				System.out.println("Employee Deleted Successfully!!! " + id);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
