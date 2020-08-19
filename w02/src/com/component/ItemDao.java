package com.component;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.frame.Dao;
import com.vo.Item;

@Component("idao")
public class ItemDao implements Dao<String, Item> {

	@Override
	public void insert(Item v) {
		System.out.println("ItemDao Insert");
		
	}

	@Override
	public void delete(String k) {
		System.out.println("ItemDao delete");
		
	}

	@Override
	public void update(Item v) {
		System.out.println("ItemDao update");
		
	}

	@Override
	public Item select(String k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Item> get() {
		// TODO Auto-generated method stub
		return null;
	}

}
