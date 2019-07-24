package com.baizhi.hlp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baizhi.hlp.dao.MenuDAO;
import com.baizhi.hlp.entity.Menu;

@Service
public class MenuServiceImpl implements MenuService{

	@Autowired
	private MenuDAO menuDAO;
	
	@Override
	public List<Menu> queryMenu() {
		return menuDAO.queryClazz();
	}

}
