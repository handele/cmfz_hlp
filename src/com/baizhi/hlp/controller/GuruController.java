package com.baizhi.hlp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baizhi.hlp.entity.Guru;
import com.baizhi.hlp.service.GuruService;

@RestController
@RequestMapping("guru")
public class GuruController {

	@Autowired
	private GuruService guruService;
	
	private Map<String,Object> map = new HashMap<String,Object>();
	
	@RequestMapping("guruPage")
	public Map<String,Object> guruPage(Integer page,Integer rows){
		
		List<Guru> queryGuru = guruService.queryGuru(page, rows);
		int count = guruService.count();
		
		map.put("total",count);
		map.put("rows", queryGuru);
		
		return map;
	}
	
	@RequestMapping("update")
	public Map<String,Object> guruUpdate(String id,String status){
		System.out.println(id+status);
		try{
			guruService.guruUpdate(id, status);
			map.put("message","修改成功");
		}catch(Exception e){
			e.printStackTrace();
			map.put("message","修改失败");
		}		
		
		return map;
	}
	
	
}
