package com.hcl.hrms;

import java.util.Scanner;

import com.hcl.crud.EmployeesAPI;

public class EmployeeDelete {
	public static String input = "";
	
	public static void display() {
		Scanner scan = new Scanner(System.in);
		boolean confirm = false;
		while(!input.equals("RETURN")) {
			System.out.println("Please enter the ID of the employee who's records you wish to delete or 'RETURN' to go back:");
			input = scan.nextLine();
			if(input.equals("QUIT")) {
				Cli.quit();
			} else {
				try{
					int id = Integer.parseInt(input);
					while(!confirm) {
						System.out.println("Confirm you want to delete all records for Employee with ID " + id + " 'y' or 'n'");
						input = scan.nextLine();
						if(input.equals("y")) {
							confirm = true;
							EmployeesAPI.delete(id);
						}else if(!input.equals("n")) {
							System.out.println("Invalid input.");
						}else {
							confirm = true;
						}
					}
					confirm = false;
					
				}catch(Exception e) {
					System.out.println("Employee with id " + input + " does not exist.");
				}
			}
		}
	}

}
