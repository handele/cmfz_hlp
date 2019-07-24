package com.baizhi.hlp.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.baizhi.hlp.entity.Album;
import com.baizhi.hlp.service.AlbumService;

@RequestMapping("album")
@Controller
public class AlbumController {

	@Resource
	private AlbumService albumService;
	
	private Map<String,Object> map = new HashMap<String,Object>();
	
	/*
	 * 专辑展示 分页
	 * */
	@RequestMapping("albumPage")
	@ResponseBody
	public Map<String,Object> albumPage(Integer page,Integer rows){
		List<Album> queryPaging = albumService.queryPaging(page,rows);
		int count = albumService.count();
		
		map.put("total",count);
		map.put("rows",queryPaging);
		
		return map;
	}
	
	/*
	 * 专辑的添加
	 * */
	@RequestMapping("insert")
	public String insert(Album album,MultipartFile ph,HttpSession session) throws Exception, Exception{
		
		ServletContext sc = session.getServletContext();
		String realPath = sc.getRealPath("/upload");
		
		File file = new File(realPath+"/"+ph.getOriginalFilename());
		
		ph.transferTo(file);
		
		album.setImg_path("/upload/"+ph.getOriginalFilename());
		
		albumService.insertAlbum(album);
		return "ok";
	}
	
	
	
}
