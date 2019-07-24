package com.baizhi.hlp.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.baizhi.hlp.entity.Banner;
import com.baizhi.hlp.service.BannerService;

@Controller
@RequestMapping("banner")
public class BannerController {

	@Autowired
	private BannerService bannerService;
	
	
	/*
	 *   分页查询  
	 * */
	@RequestMapping("paging")
	@ResponseBody
	public Map<String,Object> queryPaging(Integer page,Integer rows){
		//分页查询的数据
		List<Banner> queryPaging = bannerService.queryPaging(page, rows);
		//总条数
		int count1 = bannerService.count();
		System.out.println("总条数=="+count1+";数据=="+queryPaging);
		//页面需要map的形式接受参数 创建Map
		Map<String,Object> map = new HashMap<String,Object>();

		//把从页数和 查询的数据以map的形式响应到页面
		map.put("total",count1);
		map.put("rows", queryPaging);
		
		System.out.println("map======"+map);
		return map;
	}
	
	/*
	 * 修改冻结状态
	 * */
	@RequestMapping("update")
	@ResponseBody
	public Map<String,Object> bannerInsert(String id,String status){
		System.out.println("id======="+id+status);
		//页面需要map的形式接受参数 创建Map
		HashMap<String,Object> map = new HashMap<String,Object>();
		try{
			bannerService.update(id, status);
			map.put("success", 200);
			map.put("message","修改成功");
		}catch(Exception e){
			e.printStackTrace();
			map.put("success", 400);
			map.put("message","修改失败");
		}
		
		return map; 
	}
	
	/*
	 * 添加轮播图
	 * */
	@RequestMapping("insert")
	public String bannerInsert(Banner banner,MultipartFile uplo,HttpSession session) throws Exception, Exception{
		System.out.println("Banner======"+banner+uplo);
		
		//获取项目中的绝对位置
		ServletContext sc = session.getServletContext();
		String realPath = sc.getRealPath("/upload");
		File file = new File(realPath+"/"+uplo.getOriginalFilename());
		
		uplo.transferTo(file);
		
		banner.setImg_path("/upload/"+uplo.getOriginalFilename());
		
		bannerService.insert(banner);
		
		return "ok";
	}
	
	/*
	 * 删除
	 * */
	@RequestMapping("delete")
	public String deleteBanner(String id){
		System.out.println("id========================"+id);
		bannerService.delete(id);
		return "ok";
	}
}
