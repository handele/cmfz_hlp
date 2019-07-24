package com.baizhi.hlp.entity;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class Album {

	private String id;				//id
	private String title;			//标题
	private Integer score;			//评分
	
	private String author;			//作者
	private String img_path;		//封面
	private String beam;			//播音

	private Integer count;			//集数
	private String countent;		//简介
	@JSONField(format="yyyy-MM-dd")
	private Date pub_date;			//上传时间
	
	private List<Chapter> children;	//表关系

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

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getImg_path() {
		return img_path;
	}

	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}

	public String getBeam() {
		return beam;
	}

	public void setBeam(String beam) {
		this.beam = beam;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getCountent() {
		return countent;
	}

	public void setCountent(String countent) {
		this.countent = countent;
	}

	public Date getPub_date() {
		return pub_date;
	}

	public void setPub_date(Date pub_date) {
		this.pub_date = pub_date;
	}

	public List<Chapter> getChildren() {
		return children;
	}

	public void setChildren(List<Chapter> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "Album [id=" + id + ", title=" + title + ", score=" + score
				+ ", author=" + author + ", img_path=" + img_path + ", beam="
				+ beam + ", count=" + count + ", countent=" + countent
				+ ", pub_date=" + pub_date + ", children=" + children + "]";
	}

	public Album(String id, String title, Integer score, String author,
			String img_path, String beam, Integer count, String countent,
			Date pub_date, List<Chapter> children) {
		super();
		this.id = id;
		this.title = title;
		this.score = score;
		this.author = author;
		this.img_path = img_path;
		this.beam = beam;
		this.count = count;
		this.countent = countent;
		this.pub_date = pub_date;
		this.children = children;
	}

	public Album() {
		super();
		// TODO Auto-generated constructor stub
	}


}
