package com.hcl.models;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name = "employees")
@Table(name="employees", 
	   uniqueConstraints={@UniqueConstraint(columnNames={"ID"})})
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false, unique=true, length=11)
	private int id;
	
	@Column(name="NAME", length=64, nullable=false)
	private String name;
	
	@Column(name="dateofbirth", nullable=false)
	private Date dob;
	
	@Column(name="SALARY", nullable=false)
	private int salary;
	
	@Column(name="AGE", nullable=false)
	private int age;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public void setDob(LocalDate dob) {
		int a = dob.compareTo(LocalDate.now());
		setAge(Math.abs(a));
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(dob.atStartOfDay(defaultZoneId).toInstant());
		this.dob = date;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int sal) {
		this.salary = sal;
	}
	public void setAge(int a) {
		this.age = a;
	}
	public int getAge() {
		return age;
	}
	
	public void displayData() {
		System.out.println("Id: " + this.id + "\nName: " + this.name + "\nSalary: " + this.salary + "\nDate Of Birth: " + this.dob.toString() + "\nAge: " + age + "\n");
	}
}
