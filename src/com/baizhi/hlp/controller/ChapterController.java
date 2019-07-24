package com.baizhi.hlp.controller;

import it.sauronsoftware.jave.Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.baizhi.hlp.entity.Chapter;
import com.baizhi.hlp.service.ChapterService;

@Controller
@RequestMapping("chapter")
public class ChapterController {

	@Resource
	private ChapterService chapterService;
	
	@RequestMapping("insert")
	public String insert(String id,String title,MultipartFile music,HttpSession session) throws Exception{
		
		System.out.println("+++============你好==="+id+"====="+title+"====="+music);
		
		ServletContext sc = session.getServletContext();
		String realPath = sc.getRealPath("/upload");
		File file = new File(realPath+"/"+music.getOriginalFilename());
		
		music.transferTo(file);
		
		Chapter cp = new Chapter();
		
		//获取文件的大小
		System.out.println("文件的大小"+music.getSize());
		cp.setSize(String.valueOf(music.getSize()));
		
		//获取文件的时长
		cp.setDuration("3分钟");
	    
	    
	    cp.setAlbum_id(id);
		cp.setUrl(music.getOriginalFilename());
		
		chapterService.insert(cp);
		return "ok";
	}
	
	//文件下载
	@RequestMapping("download")
	public void downloadAudio(String yn,String fileName,HttpServletRequest request,HttpServletResponse response) throws Exception{

		System.out.println("==========fileName="+fileName);

 

		//根据用户名去服务器中的指定位置获取文件

        String realPath = request.getSession().getServletContext().getRealPath("/upload");

        System.out.println(realPath+fileName);

        //读取文件输入流

        FileInputStream fis = new FileInputStream(new File(realPath, fileName));

        

        //设置响应的方式   响应头   //attachment;以附件形式下载   inline 在线打开
        
        if("y".equals(yn)){
        	response.setHeader("content-disposition","attachement;fileName=" + URLEncoder.encode(fileName,"UTF-8"));
        }else{
        	response.setHeader("content-disposition","inline;fileName=" + URLEncoder.encode(fileName,"UTF-8"));
        }
        

        //获取响应流

        ServletOutputStream os = response.getOutputStream();

        //下载文件

        IOUtils.copy(fis,os);

        //关闭资源

        IOUtils.closeQuietly(fis);

        IOUtils.closeQuietly(os);

	}

}
