package com.baizhi.hlp.test;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.Application;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baizhi.hlp.dao.AdminDAO;
import com.baizhi.hlp.dao.BannerDAO;
import com.baizhi.hlp.dao.ChapterDAO;
import com.baizhi.hlp.dao.GuruDAO;
import com.baizhi.hlp.dao.MenuDAO;
import com.baizhi.hlp.dao.UserDAO;
import com.baizhi.hlp.entity.Banner;
import com.baizhi.hlp.entity.Guru;
import com.baizhi.hlp.entity.Menu;
import com.baizhi.hlp.entity.User;
import com.mysql.fabric.xmlrpc.base.Data;

public class MenuTest {

	@Test
	public void query(){
		ApplicationContext ac =new ClassPathXmlApplicationContext("spring.xml");
		
		MenuDAO bean =(MenuDAO) ac.getBean("menuDAO");

		List<Menu> queryClazz = bean.queryClazz();
		for (Menu menu : queryClazz) {
			System.out.println(menu);
			
		}
	}
	
	@Test
	public void queryPaging(){
		ApplicationContext ac =new ClassPathXmlApplicationContext("spring.xml");

		BannerDAO bean =(BannerDAO) ac.getBean("bannerDAO");
		
		List<Banner> quer = bean.queryPaging(1,3);
	
		for (Banner banner: quer) {
			System.out.println(banner);
		}
	}
	

	
	@Test
	public void bannerUpdate(){
		ApplicationContext ac =new ClassPathXmlApplicationContext("spring.xml");

		BannerDAO bean =(BannerDAO) ac.getBean("bannerDAO");
		
		bean.update("1","1");
	}
	
	@Test
	public void guruPage(){
		ApplicationContext ac =new ClassPathXmlApplicationContext("spring.xml");

		GuruDAO bean =(GuruDAO) ac.getBean("guruDAO");
		
		List<Guru> queryGuru = bean.queryGuru(0, 5);
		
		for (Guru guru : queryGuru) {
			
			System.out.println(guru);
		}
	}
	
	@Test
	public void gurucount(){
		ApplicationContext ac =new ClassPathXmlApplicationContext("spring.xml");

		GuruDAO bean =(GuruDAO) ac.getBean("guruDAO");
		
		int count = bean.count();
		System.out.println(count);
	}
	
	@Test
	public void guruupdate(){
		ApplicationContext ac =new ClassPathXmlApplicationContext("spring.xml");

		GuruDAO bean =(GuruDAO) ac.getBean("guruDAO");

		bean.guruUpdate("1","0");
	}
	
	@Test
	public void bannerinsert(){
		ApplicationContext ac =new ClassPathXmlApplicationContext("spring.xml");

		BannerDAO bean =(BannerDAO) ac.getBean("bannerDAO");

		
		
		bean.insert(new Banner("9","玉曹市土地庙","/yucaoshi","1",new Date(),"你好"));
	
	}
	@Test
	public void deletebanner(){
		ApplicationContext ac =new ClassPathXmlApplicationContext("spring.xml");

		BannerDAO bean =(BannerDAO) ac.getBean("bannerDAO");
		bean.delete("9");

	}	
	
	@Test
	public void adminupdate(){
		ApplicationContext ac =new ClassPathXmlApplicationContext("spring.xml");

		AdminDAO bean =(AdminDAO) ac.getBean("adminDAO");
		bean.updateAdmin("1", "111111");
		
	}	
	
	@Test
	public void userPage(){
		ApplicationContext ac =new ClassPathXmlApplicationContext("spring.xml");

		UserDAO bean =(UserDAO) ac.getBean("userDAO");

		List<User> queryUser = bean.queryUser(0,3);
		
		for (User user : queryUser) {
			System.out.println(user);
		}
	
	}	
	
	@Test
	public void userupdate(){
		ApplicationContext ac =new ClassPathXmlApplicationContext("spring.xml");

		UserDAO bean =(UserDAO) ac.getBean("userDAO");

		int queryCount = bean.queryCount();
		System.out.println(queryCount);
	
	}	
}
