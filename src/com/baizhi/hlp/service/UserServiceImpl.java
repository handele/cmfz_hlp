package com.baizhi.hlp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baizhi.hlp.dao.UserDAO;
import com.baizhi.hlp.entity.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	
	
	@Override
	public List<User> queryUser(Integer begin, Integer end) {
		int beg = (begin-1)*end; 
	
		return	userDAO.queryUser(beg, end);
	}

	@Override
	public void updateUser(String id, String status) {
		userDAO.updateUser(id, status);
	}

	@Override
	public int queryCount() {
		return userDAO.queryCount();
	}

}
