package com.app;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.frame.Dao;
import com.frame.Service;
import com.vo.Item;
import com.vo.User;


public class App {

	public static void main(String[] args) {
		System.out.println("App Start ....");
		AbstractApplicationContext factory = new GenericXmlApplicationContext("com.xml");
		System.out.println("Spring Started....");

		// UserService
		User user = new User("id01", "pwd01", "james");
		Service<String, User> biz = (Service) factory.getBean("uservice");
//		try {
//			biz.register(user);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		biz.remove("");
//		biz.modify(user);
		try {
			User dbuser = biz.get("id01");
		} catch (Exception e) {
			e.printStackTrace();
		}
//		System.out.println(dbuser);
//		biz.get();
//
//		// UserDao
//		Dao<String, User> biz2 = (Dao) factory.getBean("udao");
//		biz2.insert(user);
//		biz2.delete("id01");
//		biz2.update(user);
//		User userdao = biz2.select("id01");
//		System.out.println(userdao);
//		ArrayList<User> udaolist = biz2.select();
//		for(User u:udaolist) {
//			System.out.println(u);
//		}
//
//		System.out.println("----------------------------------");
//
//		// ItemService
//		Item item = new Item("it01","pants",10000);
//		Service<String, Item> biz3 = (Service) factory.getBean("iservice");
//		biz3.register(item);
//		biz3.remove("it01");
//		biz3.modify(item);
//		biz3.get("it01");
//		biz3.get();
//
//		// ItemDao
//		Dao<String, Item> biz4 = (Dao) factory.getBean("idao");
//		biz4.insert(item);
//		biz4.delete("id01");
//		biz4.update(item);
//		Item itemdao = biz4.select("id01");
//		System.out.println(itemdao);
//		ArrayList<Item> idaolist = biz4.select();
//		for(Item i:idaolist) {
//			System.out.println(i);
//		}

		factory.close();
		System.out.println("Spring End....");
		System.out.println("App End ....");

		System.out.println("----------------------------------");

	}

}
