package com.javainuse.springbootsecurity.controller;


public class SubPermission {

	private String name;
	private String url;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public SubPermission(String name, String url) {
		super();
		this.name = name;
		this.url = url;
	}
	
	
}
