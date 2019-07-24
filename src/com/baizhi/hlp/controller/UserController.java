package com.baizhi.hlp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baizhi.hlp.entity.User;
import com.baizhi.hlp.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	
	private Map<String,Object> map = new HashMap<String,Object>();
	
	@RequestMapping("userpage")
	public Map<String,Object> userPage(Integer page,Integer rows){
		//查询分页的数据
		List<User> queryUser = userService.queryUser(page,rows);
		//查询总条数
		int queryCount = userService.queryCount();
		
		map.put("total",queryCount);
		map.put("rows", queryUser);
		System.out.println("========"+map);
		return map;
	}
	
	@RequestMapping("userUpadte")
	public Map<String,Object> userUpdate(String id,String status){
		try{
			userService.updateUser(id,status);
			map.put("message","修改成功");
		}catch(Exception e){
			e.printStackTrace();
			map.put("message","修改失败");	
		}
		return map;
	}
	
}
