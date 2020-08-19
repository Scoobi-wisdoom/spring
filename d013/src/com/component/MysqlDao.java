package com.component;

import org.springframework.stereotype.Component;

import com.frame.Dao;

@Component("mysqldao")
public class MysqlDao implements Dao {

	@Override
	public void insert() {
		System.out.println("Mysql Inserted...");
	}

	@Override
	public void delete() {
		System.out.println("Mysql Deleted...");
	}

	@Override
	public void update() {
		System.out.println("Mysql Updated...");
	}

}
