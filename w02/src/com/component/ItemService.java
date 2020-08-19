package com.component;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.frame.Dao;
import com.frame.Service;

@Repository("iservice")
public class ItemService<Item> implements Service<String, Item> {
	
	@Override
	public void register(Item v) {
		System.out.println("Item register");
		
	}

	@Override
	public void remove(String k) {
		System.out.println("Item removed");
		
	}

	@Override
	public void modify(Item v) {
		System.out.println("Item modified");
		
	}

	@Override
	public Item get(String k) {
		System.out.println("Item get");
		return null;
	}

	@Override
	public ArrayList<Item> get() {
		System.out.println("All Items get");
		return null;
	}
	


}
