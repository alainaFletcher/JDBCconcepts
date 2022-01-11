package com.hcl.hrms;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

import com.hcl.crud.EmployeesAPI;
import com.hcl.hibernate.util.HibernateUtil;
import com.hcl.models.Employee;

import org.apache.log4j.PropertyConfigurator;

public class Cli {
	
	public static String input = "";
	
	public static void quit() {
		System.out.println("QUITTING PROGRAM");
		HibernateUtil.getSessionFactory().close();
		System.exit(0);
	}
	
	public static void main(String[] args) {
		
		try (Scanner scany = new Scanner(System.in)) {
			while(!input.equals("6")) {
				System.out.println(
						"HRMS Main Menu"
						+ "1) View all employees\n"
						+ "2) View selected employee\n"
						+ "3) Create employee\n"
						+ "4) Update employee\n"
						+ "5) Delete employee\n"
						+ "6) Exit HRMS\n"
						+ "Enter Q at anytime to exit the program\n"
				);
				
				input = scany.nextLine();
				switch(input) {
					case("1"):
						EmployeesGetAll.display();
						break;
					case("2"):
						EmployeeOutput.display();
						break;
					case("3"):
						EmployeeCreate.display();
						break;
					case("4"):
						EmployeeUpdate.display();
						break;
					case("5"):
						EmployeeDelete.display();
						break;
					case("6"):
						quit();
						break;
					case("Q"):
						quit();
						break;
					default:
						System.out.println("That is not an option. Please do it right next time.");
				}
			}
		}
		quit();
	}

}
