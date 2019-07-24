package com.baizhi.hlp.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baizhi.hlp.dao.AlbumDAO;
import com.baizhi.hlp.dao.ChapterDAO;
import com.baizhi.hlp.entity.Album;
import com.baizhi.hlp.entity.Chapter;

public class AlbumTest {

	@Test
	public void insert(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
	
		AlbumDAO bean = (AlbumDAO)ac.getBean("albumDAO");
		
		//bean.insertAlbum(new Album("3","喜洋洋",5,"第十七","asda","王猛师兄",3,"喜洋洋与灰太狼",new Date()));
	}
	

	@Test
	public void insaaert(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
	
		AlbumDAO bean = (AlbumDAO)ac.getBean("albumDAO");
		
		List<Album> queryPaging = bean.queryPaging(0,10);
	
		for (Album album : queryPaging) {
			System.out.println(album);
		}
	}
	
	@Test
	public void insertCha(){
		ApplicationContext ac =new ClassPathXmlApplicationContext("spring.xml");

		ChapterDAO bean =(ChapterDAO) ac.getBean("chapterDAO");
		
		bean.insert(new Chapter("17","我好","24MB",null,"12分钟",new Date(),"2"));
	}
}
