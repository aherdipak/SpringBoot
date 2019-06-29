package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Computer {

	private int cId;
	private String brand;

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "cId=" + cId + ", brand=" + brand;
	}

	public void execute() {
		System.out.println("Executing...!");
	}

	public Computer() {
		super();
		System.out.println("Computer object Created...!!");
	}

}
