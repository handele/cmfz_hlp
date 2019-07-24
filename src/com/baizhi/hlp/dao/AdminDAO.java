package com.baizhi.hlp.dao;

import org.apache.ibatis.annotations.Param;

import com.baizhi.hlp.entity.Admin;

public interface AdminDAO {

	//管理员登陆
	public Admin login(@Param("username")String username,@Param("password")String password);
	
	//管理员修改 密码
	public void updateAdmin(@Param("id")String id,@Param("password")String password);
}
