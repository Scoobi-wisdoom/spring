package com.webjjang.forum.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.webjjang.forum.mapper.ForumMapper;
import com.webjjang.forum.vo.ForumVO;

import net.webjjang.util.PageObject;

@Service
public class ForumService {
	
	@Inject
	private ForumMapper mapper;
	
	public List<ForumVO> list(PageObject pageObject) {
		System.out.println("ForumService.list().pageObject:" + pageObject);
		pageObject.setTotalRow(mapper.getCount());
		return mapper.list(pageObject);
	}

	public Integer write(ForumVO vo) {
		System.out.println("ForumService.write().vo:" + vo);
		return mapper.write(vo);	
	}

}
