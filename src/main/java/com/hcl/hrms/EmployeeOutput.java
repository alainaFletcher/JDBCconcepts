package com.hcl.hrms;

import java.util.Scanner;

import com.hcl.crud.EmployeesAPI;

public class EmployeeOutput {
	public static String input = "";
	
	public static void display() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter the ID number of the Employee you would like to see, 'RETURN' to go back, or 'QUIT' to exit:\n");
		
		input = scan.nextLine();
		
		if(input.equals("QUIT")) {
			System.out.println("QUITTING PROGRAM");
			System.exit(0);
		} else if(!input.equals("RETURN")) {
			while(!input.equals("RETURN")) {
				try {
					int id = Integer.parseInt(input);
					EmployeesAPI.getEmployee(id);
				
					System.out.println("\nEnter 'RETURN' to go back or 'QUICK' to exit");
					input = scan.nextLine();
					if(input.equals("QUIT")) {
						Cli.quit();
					} else if(!input.equals("RETURN")) {
						System.out.println("Invalid Input!");
					}
				} catch(Exception e) {
					System.out.println(e.getMessage());
					System.out.println("Invalid input. Employee with ID of " + input + " does not exist");
					System.out.println("Please enter the ID number of the Employee you would like to see, 'RETURN' to go back, or 'QUIT' to exit:\n");
					
					input = scan.nextLine();
					
					if(input.equals("QUIT")) {
						Cli.quit();
					}
				}
			}
		}
	}
}


