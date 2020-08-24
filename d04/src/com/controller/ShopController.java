package com.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.ShopVO;

public class ShopController {
	
	@Resource(name="sbiz")
	Biz<Integer, ShopVO> biz;
	
	@RequestMapping("/shopadd.mc")
	public ModelAndView shopadd(ModelAndView mv) {
		mv.addObject("centerpage", "shop/register");
		return mv;
	}
	
	@RequestMapping("/shopaddimpl.mc")
	public ModelAndView shopaddimpl(ModelAndView mv, ShopVO shop) {
		String imgname = shop.getMf().getOriginalFilename();
		shop.setImg(imgname);		
		try {
			biz.register(shop);	
			Util.saveFile(shop.getMf());
		} catch (Exception e) {
			mv.addObject("centerpage", "shop/registerfail");
			e.printStackTrace();
		}
		mv.addObject("registershop", shop);
		mv.addObject("centerpage", "shop/registerok");
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/shopselect.mc")
	public ModelAndView shopselect(ModelAndView mv) {
		ArrayList<ShopVO> list = null;
		try {
			list = biz.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("shoplist", list);
		mv.addObject("centerpage", "shop/get");
		mv.setViewName("main");
		return mv;
	}
}
