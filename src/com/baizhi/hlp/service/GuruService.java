package com.baizhi.hlp.service;

import java.util.List;

import com.baizhi.hlp.entity.Guru;

public interface GuruService {
		
	//分页查询上师
	public List<Guru> queryGuru(Integer page,Integer rows);
	
	//查询大师总条数
	public int count();
	
	//修改状态
	public void guruUpdate(String id,String status);
	

}
