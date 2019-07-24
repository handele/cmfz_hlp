package com.baizhi.hlp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baizhi.hlp.dao.AdminDAO;
import com.baizhi.hlp.entity.Admin;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDAO adminDAO;
	
	
	@Override
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public Admin login(String username, String password) {
		return adminDAO.login(username, password);
	}


	@Override
	public void updateAdmin(String id, String password) {
		adminDAO.updateAdmin(id, password);
	}

}
