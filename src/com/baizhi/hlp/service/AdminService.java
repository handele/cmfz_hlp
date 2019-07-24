package com.baizhi.hlp.service;


import com.baizhi.hlp.entity.Admin;

public interface AdminService {

	//管理员登陆
	public Admin login(String username,String password);
	
	//管理员修改 密码
	public void updateAdmin(String id,String password);
}
