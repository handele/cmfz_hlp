package com.baizhi.hlp.entity;

public class User {
	private String id;			//id
	private String phone;		//手机号
	private String password;	//密码
		
	private String head_img; 	//头像
	private String name;		//姓名
	private String legal_name;	//法名
	
	private String sex;			//性别
	private String city;		//城市
	private String sign;		//签名
	
	private String status;		//状态
	private String reg_date;	//注册时间
	private String guru_id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHead_img() {
		return head_img;
	}
	public void setHead_img(String head_img) {
		this.head_img = head_img;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLegal_name() {
		return legal_name;
	}
	public void setLegal_name(String legal_name) {
		this.legal_name = legal_name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
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
	public String getGuru_id() {
		return guru_id;
	}
	public void setGuru_id(String guru_id) {
		this.guru_id = guru_id;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", phone=" + phone + ", password=" + password
				+ ", head_img=" + head_img + ", name=" + name + ", legal_name="
				+ legal_name + ", sex=" + sex + ", city=" + city + ", sign="
				+ sign + ", status=" + status + ", reg_date=" + reg_date
				+ ", guru_id=" + guru_id + "]";
	}
	public User(String id, String phone, String password, String head_img,
			String name, String legal_name, String sex, String city,
			String sign, String status, String reg_date, String guru_id) {
		super();
		this.id = id;
		this.phone = phone;
		this.password = password;
		this.head_img = head_img;
		this.name = name;
		this.legal_name = legal_name;
		this.sex = sex;
		this.city = city;
		this.sign = sign;
		this.status = status;
		this.reg_date = reg_date;
		this.guru_id = guru_id;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


}
