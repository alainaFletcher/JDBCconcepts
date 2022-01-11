package com.hcl.hrms;

import java.util.Scanner;

import com.hcl.crud.EmployeesAPI;

public class EmployeesGetAll {
	public static String input = "";
	
	public static void display() {
		Scanner scan = new Scanner(System.in);
		EmployeesAPI.getAll();
		while(!input.equals("RETURN")) {
			System.out.println("\nEnter 'RETURN' to go back or 'QUICK' to exit");
			input = scan.nextLine();
			if(input.equals("QUIT")) {
				Cli.quit();
			} else if(!input.equals("RETURN")) {
				System.out.println("Invalid Input!");
			}
		}
	}
}
