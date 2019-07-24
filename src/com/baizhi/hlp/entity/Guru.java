package com.baizhi.hlp.entity;

public class Guru {

	private String id;			//id
	private String legal_name;	//法名
	private String head_img;	//头像
	
	private String status;		//状态
	private String reg_date;	//注册时间
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLegal_name() {
		return legal_name;
	}
	public void setLegal_name(String legal_name) {
		this.legal_name = legal_name;
	}
	public String getHead_img() {
		return head_img;
	}
	public void setHead_img(String head_img) {
		this.head_img = head_img;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	@Override
	public String toString() {
		return "Guru [id=" + id + ", legal_name=" + legal_name + ", head_img="
				+ head_img + ", status=" + status + ", reg_date=" + reg_date
				+ "]";
	}
	public Guru(String id, String legal_name, String head_img, String status,
			String reg_date) {
		super();
		this.id = id;
		this.legal_name = legal_name;
		this.head_img = head_img;
		this.status = status;
		this.reg_date = reg_date;
	}
	public Guru() {
		super();
		// TODO Auto-generated constructor stub
	}



}
