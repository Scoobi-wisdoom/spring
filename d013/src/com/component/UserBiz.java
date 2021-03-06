package com.component;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.frame.Biz;
import com.frame.Dao;

@Repository("ubiz")
public class UserBiz implements Biz {
	
//	@Autowired // it works only if there are no duplicates.
//	@Resource(name="oracledao")
//	@Autowired
//	@Qualifier("oracledao")
	
	@Resource(name="oracledao")
	Dao dao;
	
	public UserBiz() {
	}
	
	public UserBiz(Dao dao) {
		this.dao = dao;
	}
	
//	public void setDao(Dao dao) {
//		this.dao = dao;
//	}
	@Override
	public void register() {
		dao.insert();
	}

	@Override
	public void remove() {
		dao.delete();
	}

	@Override
	public void modify() {
		dao.update();
	}

}
