package com.baizhi.hlp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baizhi.hlp.entity.Menu;
import com.baizhi.hlp.service.MenuService;


@Controller
@RequestMapping("menu")
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	//菜单栏展示
	@RequestMapping("menuAll")
	@ResponseBody
	public List<Menu> menuAll(){
		return menuService.queryMenu();
	}
	
}
