package com.webjjang.forum.mapper;

import java.util.List;

import com.webjjang.forum.vo.ForumVO;

import net.webjjang.util.PageObject;

public interface ForumMapper {
	
	// 게시판 리스트
	public List<ForumVO> list(PageObject pageObject);
}