package com.javainuse.springbootsecurity.controller;

public class Emp {

	public String empName;
	public String pass;
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "Emp [empName=" + empName + ", pass=" + pass + "]";
	}
	public Emp(String empName, String pass) {
		super();
		this.empName = empName;
		this.pass = pass;
	}
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
