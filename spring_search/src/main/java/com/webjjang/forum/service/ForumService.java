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
	
	public List<ForumVO> list(PageObject pageObject) {
		// paeObject에 전체 데이터의 개수를 셋팅하는 것이 필요
		pageObject.setTotalRow(mapper.getCount(pageObject));
		return mapper.list(pageObject);
	}
}
