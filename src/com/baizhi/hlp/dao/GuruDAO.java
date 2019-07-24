package com.baizhi.hlp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.hlp.entity.Guru;

public interface GuruDAO {

	//分页查询上师
	public List<Guru> queryGuru(@Param("begin")Integer page,@Param("end")Integer rows);
	
	//查询大师总条数
	public int count();
	
	//修改状态
	public void guruUpdate(@Param("id")String id,@Param("status")String status);
	
}
