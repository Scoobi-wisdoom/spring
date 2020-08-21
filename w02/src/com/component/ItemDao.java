package com.component;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.frame.Dao;
import com.vo.Item;

@Repository("idao")
public class ItemDao implements Dao<String, Item> {

	@Override
	public void insert(Item v) {
		System.out.println("ItemDao Insert"+v);
		
	}

	@Override
	public void delete(String k) {
		System.out.println("ItemDao delete"+k);
		
	}

	@Override
	public void update(Item v) {
		System.out.println("ItemDao update"+v);
		
	}

	@Override
	public Item select(String k) {
		Item item = new Item(k, "pants", 10000);
		return item;
	}

	@Override
	public ArrayList<Item> select() {
		ArrayList<Item> list = new ArrayList<Item>();
		list.add(new Item("it01","pants",10000));
		list.add(new Item("it02","pants",20000));
		list.add(new Item("it03","pants",30000));
		list.add(new Item("it04","pants",40000));
		list.add(new Item("it05","pants",50000));

		return list;
	}

}
