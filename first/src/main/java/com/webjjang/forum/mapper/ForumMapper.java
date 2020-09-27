package com.webjjang.forum.mapper;

import java.util.List;

import com.webjjang.forum.vo.ForumVO;

import net.webjjang.util.PageObject;

public interface ForumMapper {
	
	// 게시판 리스트
	public List<ForumVO> list(PageObject pageObject);
	// 전체 데이터를 가져오는 메서드
	public Integer getCount();
	//  게시판 글 보기
	public Object view(int no);
}