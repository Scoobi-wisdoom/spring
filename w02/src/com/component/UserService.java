package com.component;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.frame.Service;

@Repository("uservice")
public class UserService<User> implements Service<String, User> {

	@Override
	public void register(User v) {
		System.out.println("User register");
		
	}

	@Override
	public void remove(String k) {
		System.out.println("User removed");
		
	}

	@Override
	public void modify(User v) {
		System.out.println("User modified");
		
	}

	@Override
	public User get(String k) {
		System.out.println("User get");
		return null;
	}

	@Override
	public ArrayList<User> get() {
		System.out.println("All User get");
		return null;
	}
	


}
