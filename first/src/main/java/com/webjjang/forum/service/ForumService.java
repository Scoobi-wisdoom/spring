package com.webjjang.forum.service;

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
	
	public List<ForumVO> list(PageObject pageObject){
		return mapper.list(pageObject);
	}
	
}
