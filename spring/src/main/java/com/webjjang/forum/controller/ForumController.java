package com.webjjang.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.webjjang.util.PageObject;

@Controller
@RequestMapping("/forum")
public class ForumController {
	private final String MODULE_NAME = "forum";
	
	@Autowired
	private ForumService service;
	
	@GetMapping("/list.do")
	public String list(Model model, PageObject pageObject) {
		System.out.println("ForumController.list.pageObject:"+ pageObject);
		return MODULE_NAME + "/list";
	}
}
