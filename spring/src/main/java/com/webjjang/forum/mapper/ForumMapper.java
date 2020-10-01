package com.webjjang.forum.mapper;

import java.util.List;

import com.webjjang.forum.vo.ForumVO;

import net.webjjang.util.PageObject;

public interface ForumMapper {

	// 게시판 리스트
	public List<ForumVO> list(PageObject pageObject);
	// 전체 데이터 가져오기
	public Integer getCount();
	// 게시판 글 보기
	public ForumVO view(int no);
	// 조회수 1 증가
	public Integer increase(int no);
	// 게시판 글 쓰기
	public Integer write(ForumVO vo);
	// 게시판 글 수정
	public Integer update(ForumVO vo);
	// 게시판 글 삭제
	public Integer delete(int no);
}
