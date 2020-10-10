package com.webjjang.forum.controller;

import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webjjang.forum.service.ForumService;
import com.webjjang.forum.vo.ForumVO;

import net.webjjang.util.PageObject;

@Controller
@RequestMapping("/forum")
public class ForumController {

	private final String MODULE_NAME = "forum";
	
	@Autowired
	private ForumService service;

	// 게시글 리스트
	@GetMapping("/list.do")
	public String list(Model model, PageObject pageObject) {
		System.out.println("ForumController.list().pageObjet:" + pageObject);
		// DB에서 데이터 가져오기 - Controller - Service - Mapper (DAO 자동 생성)
		model.addAttribute("list", service.list(pageObject));
		model.addAttribute("pageObject", pageObject);
		return MODULE_NAME + "/list";
	}

	// 게시글 보기
	@GetMapping("/view.do")
	public String view(Model model, int no, int inc) {
		model.addAttribute("vo", service.view(no, inc));
//		model.addAttribute("pageObject", pageObject);
		return MODULE_NAME + "/view";
	}

	// 글 쓰기 폼
	@GetMapping("/write.do")
	public String writeForm() {
		return MODULE_NAME + "/write";
	}

	// 글 쓰기 처리 - 제목, 내용, 작성자, 비밀번호
	@PostMapping("/write.do")
	public String write(ForumVO vo) throws Exception{
		System.out.println("ForumController.write().vo:"+vo);
		service.write(vo);

		// 화면에 JSP를 보여주지 않고 바로 list로 이동한다.
		return "redirect:list.do";
	}

	// 글 수정 폼
	@GetMapping("/update.do")
	public String updateForm(Model model, int no, int inc) {
		model.addAttribute("vo", service.view(no, inc));
		return MODULE_NAME + "/update";
	}

	// 글 수정 처리 - 글번호, 제목, 내용, 작성자, 확인용 비밀번호
	@PostMapping("/update.do")
	public String update(ForumVO vo, PageObject pageObject) throws Exception{
		System.out.println("ForumController.update().vo:"+vo);
		System.out.println("ForumController.update().pageObject:"+pageObject);
		// DB 처리
		service.update(vo);
		
		// 검색어가 null이면 null이 아닌 ""로 변경
		if(pageObject.getWord() == null) pageObject.setWord("");
		
		// 화면에 JSP를 보여주지 않고 바로 글 보기로 이동한다.
		return "redirect:view.do?no=" + vo.getNo() + "&inc=0" 
		+ "&page=" + pageObject.getPage()
		+ "&perPageNum=" + pageObject.getPerPageNum()
		+ "&key=" + pageObject.getKey()
		// 검색어 한글 처리
		+ "&word=" + URLEncoder.encode(pageObject.getWord(), "utf-8");
	}

	// 글 삭제 처리 - 글 번호, 확인용 비밀번호
	@PostMapping("/delete.do")
	public String delete(ForumVO vo) throws Exception{
		System.out.println("ForumController.delete().vo:"+vo);
		
		service.delete(vo);
		return "redirect:list.do";
	}
}
