package com.baizhi.hlp.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;


//轮播图
public class Banner {
	
	private String id;				//id
	private String title;			//标题
	private String img_path;		//图片路径
	
	private String status;			//状态
	@JSONField(format="yyyy-MM-dd")
	private Date pub_data;		//上传时间
	private String description;   	//描述
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
	public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	public Date getPub_data() {
		return pub_data;
	}
	public void setPub_data(Date pub_data) {
		this.pub_data = pub_data;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Banner [id=" + id + ", title=" + title + ", img_path="
				+ img_path + ", status=" + status + ", pub_data=" + pub_data
				+ ", description=" + description + "]";
	}
	public Banner(String id, String title, String img_path, String status,
			Date pub_data, String description) {
		super();
		this.id = id;
		this.title = title;
		this.img_path = img_path;
		this.status = status;
		this.pub_data = pub_data;
		this.description = description;
	}
	public Banner() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
