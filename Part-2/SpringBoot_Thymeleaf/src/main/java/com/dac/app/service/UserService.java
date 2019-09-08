package com.dac.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dac.app.bean.User;

@Service
public class UserService {

	private List<User> list = new ArrayList<>();
	
	public void addUser(User user){
		list.add(user);
	}
	
	public List<User> getAllUser(){
		return list;
	}
}
