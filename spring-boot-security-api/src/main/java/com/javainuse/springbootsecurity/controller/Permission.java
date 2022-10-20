package com.javainuse.springbootsecurity.controller;

import java.util.List;

public class Permission {

	private String name;
	private String url;
	private List<SubPermission> subPermission;
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
	public List<SubPermission> getSubPermission() {
		return subPermission;
	}
	public void setSubPermission(List<SubPermission> subPermission) {
		this.subPermission = subPermission;
	}
	public Permission(String name, String url, List<SubPermission> subPermission) {
		super();
		this.name = name;
		this.url = url;
		this.subPermission = subPermission;
	}
	
	
}
