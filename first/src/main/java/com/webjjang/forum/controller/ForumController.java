package com.webjjang.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webjjang.forum.service.ForumService;

import net.webjjang.util.PageObject;

@Controller
@RequestMapping("/forum")
public class ForumController {
	
	// 자동 DI 적용시키는 애너테이션 두 가지 - Inject, Autowired
	@Autowired
	private ForumService service;
	
	@GetMapping("/list.do")
	// 실행할 메서드 만들기
	// model 안 에 request가 있다. model에 데이터를 저장하면 request에 저장된다.
	public String list(PageObject pageObject, Model model) {
		System.out.println("ForumController.list()");
		model.addAttribute("list", service.list(pageObject));
		// /WEB-INF/views/ + forum/list + .jsp
		return "forum/list";
	}
}
