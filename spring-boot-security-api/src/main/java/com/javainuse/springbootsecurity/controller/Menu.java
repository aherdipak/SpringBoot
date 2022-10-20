package com.javainuse.springbootsecurity.controller;

import java.util.List;

public class Menu {

	private String name;
	private String url;
	private List<Permission> permission;
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
	public List<Permission> getPermission() {
		return permission;
	}
	public void setPermission(List<Permission> permission) {
		this.permission = permission;
	}
	public Menu(String name, String url, List<Permission> permission) {
		super();
		this.name = name;
		this.url = url;
		this.permission = permission;
	}
	
	
}
