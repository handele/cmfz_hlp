package com.baizhi.hlp.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Chapter {
	private String id;		//id
	private String title;	//标题
	private String size;	//大小
	
	private String url;		//路径
	private String duration;//时长
	@JSONField(format="yyyy-MM-dd")
	private Date pub_date;//上传时间
	
	private String album_id;//专辑id;

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

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Date getPub_date() {
		return pub_date;
	}

	public void setPub_date(Date pub_date) {
		this.pub_date = pub_date;
	}

	public String getAlbum_id() {
		return album_id;
	}

	public void setAlbum_id(String album_id) {
		this.album_id = album_id;
	}

	@Override
	public String toString() {
		return "Chapter [id=" + id + ", title=" + title + ", size=" + size
				+ ", url=" + url + ", duration=" + duration + ", pub_date="
				+ pub_date + ", album_id=" + album_id + "]";
	}

	public Chapter(String id, String title, String size, String url,
			String duration, Date pub_date, String album_id) {
		super();
		this.id = id;
		this.title = title;
		this.size = size;
		this.url = url;
		this.duration = duration;
		this.pub_date = pub_date;
		this.album_id = album_id;
	}

	public Chapter() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
