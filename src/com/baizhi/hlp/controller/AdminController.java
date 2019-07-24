package com.baizhi.hlp.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;






import org.springframework.web.bind.annotation.ResponseBody;

import com.baizhi.hlp.entity.Admin;
import com.baizhi.hlp.service.AdminService;

@Controller
@RequestMapping("admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	private Map<String,Object> map = new HashMap<String,Object>();
	
	@RequestMapping("login")
	@ResponseBody
	public Map<String,Object> login(String username,String password,String code,HttpSession session){
		System.out.println(username+password+code);
		//获取生成的验证码
		String attribute = (String)session.getAttribute("validationCode");
		//进行前台输入的验证码和后台生成的验证码是否一致
		if(attribute.equals(code)){
			Admin login = adminService.login(username, password);
			//判断输入的账号密码是否正确
			if(login!=null){
				session.setAttribute("admin",login);
				map.put("message","ok");
				return map;
			}else{
				map.put("message","no1");
				return map;
			}
		}else{
			map.put("message","no2");
			return map;
		}
	}

	//退出登录
	@RequestMapping("quit")
	public String quit(HttpSession session){
		session.invalidate();
		return "redirect:/login.jsp";
	}
	
	//修改管理员密码
	@RequestMapping("adminUpdate")
	public void adminUpdate(String password,HttpSession session,HttpServletResponse response) throws Exception{
		System.out.println(";password========="+password);
		
			Admin aa = (Admin)session.getAttribute("admin");
			adminService.updateAdmin(aa.getId(), password);
			session.invalidate();
	}
}
