package com.baizhi.hlp.dao;

import java.util.List;



import org.apache.ibatis.annotations.Param;

import com.baizhi.hlp.entity.User;

public interface UserDAO {

	//分页查询用户
	public List<User> queryUser(@Param("begin")Integer begin,@Param("end")Integer end);
	
	//查询用户总条数
	public int queryCount();
	
	//用户的冻结与解冻
	public void updateUser(@Param("id")String id,@Param("status")String status);

}
