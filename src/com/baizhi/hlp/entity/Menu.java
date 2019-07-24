package com.baizhi.hlp.entity;

import java.util.List;

//菜单栏
public class Menu {
	
	private String id; 			//id
	private String title;		//标题
	private String iconCls;		//小图标
	
	private String url;			//路径
	private String parenr_id;	//父类id
	private List<Menu> menu;	//进行表的自连接   实体类中进行表的关系
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getParenr_id() {
		return parenr_id;
	}
	public void setParenr_id(String parenr_id) {
		this.parenr_id = parenr_id;
	}
	public List<Menu> getMenu() {
		return menu;
	}
	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}
	@Override
	public String toString() {
		return "Menu [id=" + id + ", title=" + title + ", iconCls=" + iconCls
				+ ", url=" + url + ", parenr_id=" + parenr_id + ", menu="
				+ menu + "]";
	}
	public Menu(String id, String title, String iconCls, String url,
			String parenr_id, List<Menu> menu) {
		super();
		this.id = id;
		this.title = title;
		this.iconCls = iconCls;
		this.url = url;
		this.parenr_id = parenr_id;
		this.menu = menu;
	}
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
