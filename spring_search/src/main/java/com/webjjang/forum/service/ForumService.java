package com.webjjang.forum.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.webjjang.forum.mapper.ForumMapper;
import com.webjjang.forum.vo.ForumVO;

import net.webjjang.util.PageObject;

// 보통은 ForumService를 interface로 만든 후에 ForumServiceImpl을 만들어 상속한다. 지금은 그렇게 안 한다.
@Service
public class ForumService {
	
	@Inject
	private ForumMapper mapper;
	
	// 게시판 글 보기
	public List<ForumVO> list(PageObject pageObject) {
		// paeObject에 전체 데이터의 개수를 셋팅하는 것이 필요
		pageObject.setTotalRow(mapper.getCount(pageObject));
		return mapper.list(pageObject);
	}
	
	public ForumVO view(int no, int inc) {
		if(inc == 1) {
			mapper.increase(no);
		}
		return mapper.view(no);
	}
	
	// 검색 게시판 글 수정
	public void update(ForumVO vo) throws Exception {
		if(mapper.update(vo) == 0) {
			throw new Exception("입력한 정보를 확인해주세요.");
		}
	}

	public void write(ForumVO vo) throws Exception {
		if(mapper.write(vo) == 0) {
			throw new Exception("입력한 정보를 확인해주세요.");
		}
	}

	public Integer delete(int no) throws Exception{
		if(mapper.delete(no) == 0) {
			throw new Exception("입력한 정보를 확인해주세요.");
		}
		return mapper.delete(no);
	}
	
}
