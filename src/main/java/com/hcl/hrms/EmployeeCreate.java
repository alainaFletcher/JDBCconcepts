package com.hcl.hrms;

import java.time.LocalDate;
import java.util.Scanner;

import com.hcl.crud.EmployeesAPI;

public class EmployeeCreate {

	public static String input = "";
	public static void display() {
		int day = 1;
		int month = 1;
		int year = 1990;
		String name = "";
		int salary = 0;
		
		boolean valid = false; 
		try (Scanner scany = new Scanner(System.in)) {
			System.out.println("Enter name: ");
			name = scany.nextLine();
			
			while(!input.equals("RETURN") && !valid) {
				System.out.println("Enter Salary: ");
				input = scany.nextLine();
				if(input.equals("Q")) {
					Cli.quit();
				}
				if(!input.equals("RETURN")) {
					try {
						salary = Integer.parseInt(input);
						valid = true;
					} catch(Exception e) {
						System.out.println("That is not an integer.");
					}
				}
			}
			
			valid = false;
			
			while(!input.equals("RETURN") && !valid) {
				System.out.println("Enter date of birth:");
				input = scany.nextLine();
				if(input.equals("Q")) {
					Cli.quit();
				}
				if(!input.equals("RETURN")) {
					try {
						year = Integer.parseInt(input);
						valid = true;
					} catch(Exception e) {
						System.out.println("That is not an integer.");
					}
				}
			}
			
			valid = false;
			
			while(!input.equals("RETURN") && !valid) {
				System.out.println("Enter date of birth: ");
				input = scany.nextLine();
				if(input.equals("Q")) {
					Cli.quit();
				}
				if(!input.equals("RETURN")) {
					try {
						month = Integer.parseInt(input);
						valid = true;
					} catch(Exception e) {
						System.out.println("That is not an integer.");
					}
				}
			}
			
			valid = false;
			
			while(!input.equals("RETURN") && !valid) {
				System.out.println("Please enter the employee's day of birth as a number: ");
				input = scany.nextLine();
				if(input.equals("QUIT")) {
					Cli.quit();
				}
				if(!input.equals("RETURN")) {
					try {
						day = Integer.parseInt(input);
						valid = true;
					} catch(Exception e) {
						System.out.println("That is not an integer.");
					}
				}
			}
		}
		
		EmployeesAPI.insertEmployee(name, LocalDate.of(year, month, day), salary);
	}

}
