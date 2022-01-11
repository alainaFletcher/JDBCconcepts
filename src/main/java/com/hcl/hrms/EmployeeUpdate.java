package com.hcl.hrms;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

import com.hcl.crud.EmployeesAPI;

public class EmployeeUpdate {

	public static String input = "";
	private static Scanner scan = new Scanner(System.in);
	
	public static void display() {
		while(!input.equals("RETURN")) {
			System.out.println("Please enter the ID of the user you wish to edit.");
			input = scan.nextLine();
			try {
				int id = Integer.parseInt(input);
				EmployeesAPI.getEmployee(id);
				while(!input.equals("RETURN")) {
				System.out.println("Please enter what you would like to update, 'RETURN' to go back, or 'QUIT' to exit:\n"
						+ "NAME\n"
						+ "AGE\n"
						+ "DOB\n"
						+ "SALARY\n");
				
				input = scan.nextLine();
					switch(input) {
						case "NAME":
							updateName(id);
							break;
						case "AGE":
							updateAge(id);
							break;
						case "DOB":
							updateDob(id);
							break;
						case "SALARY":
							updateSalary(id);
							break;
						case "RETURN":
							break;
						case "QUIT":
							Cli.quit();
						default:
							System.out.println("Invalid input");
							break;
						
					}
				}
				
			} catch(Exception e) {
				System.out.println("Either user doesn't exist or input is invalid");
			}
		}
	}
	private static void updateSalary(int id) {
		boolean valid = false;
		while(!input.equals("RETURN") && !valid) {
			System.out.println("Please enter the new salary:");
			input = scan.nextLine();
			if(input.equals("QUIT")) {
				Cli.quit();
			}
			if(!input.equals("RETURN")) {
				try {
					int salary = Integer.parseInt(input);
					EmployeesAPI.updateSalary(id, salary);
					valid = true;
				} catch(Exception e) {
					System.out.println("Invalid input");
				}
			}
		}
	}
	private static void updateDob(int id) {
		int year = 0;
		int month = 0;
		int day = 0;
		boolean valid = false;
		while(!input.equals("RETURN") && !valid) {
			System.out.println("Please enter the new birth year:");
			input = scan.nextLine();
			if(input.equals("QUIT")) {
				Cli.quit();
			}
			if(!input.equals("RETURN")) {
				try {
					int y = Integer.parseInt(input);
					year = y;
					valid = true;
				} catch(Exception e) {
					System.out.println("Invalid input");
				}
			}
		}
		valid = false;
		while(!input.equals("RETURN") && !valid) {
			System.out.println("Please enter the new birth month:");
			input = scan.nextLine();
			if(input.equals("QUIT")) {
				Cli.quit();
			}
			if(!input.equals("RETURN")) {
				try {
					int m = Integer.parseInt(input);
					month = m;
					valid = true;
				} catch(Exception e) {
					System.out.println("Invalid input");
				}
			}
		}
		valid = false;
		while(!input.equals("RETURN") && !valid) {
			System.out.println("Please enter the new birth day:");
			input = scan.nextLine();
			if(input.equals("QUIT")) {
				Cli.quit();
			}
			if(!input.equals("RETURN")) {
				try {
					int d = Integer.parseInt(input);
					day = d;
					valid = true;
				} catch(Exception e) {
					System.out.println("Invalid input");
				}
			}
		}
		LocalDate newDate = LocalDate.of(year, month, day);
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(newDate.atStartOfDay(defaultZoneId).toInstant());
		EmployeesAPI.updateDob(id, date);
	}
	
	private static void updateAge(int id) {
		boolean valid = false;
		while(!input.equals("RETURN")) {
			System.out.println("Please enter the new age:");
			input = scan.nextLine();
			if(input.equals("QUIT")) {
				Cli.quit();
			}
			if(!input.equals("RETURN")) {
				try {
					int age = Integer.parseInt(input);
					EmployeesAPI.updateAge(id, age);
					valid = true;
				} catch(Exception e) {
					System.out.println("Invalid input");
				}
			}
		}
	}
	
	private static void updateName(int id) {
		boolean valid = false;
		while(!input.equals("RETURN")) {
			System.out.println("Please enter the new name:");
			input = scan.nextLine();
			if(input.equals("QUIT")) {
				Cli.quit();
			}
			if(!input.equals("RETURN")) {
				try {
					EmployeesAPI.updateName(id, input);
					valid = true;
				} catch(Exception e) {
					System.out.println("Invalid input");
				}
			}
		}
	}
}