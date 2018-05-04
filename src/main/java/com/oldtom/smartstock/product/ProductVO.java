package com.oldtom.smartstock.product;

import java.text.NumberFormat;

public class ProductVO {
    private String id;
    private String name;
    private int price;
    private long role_id;
    private String role_name;
    private int months;
	private String expire_date;  
	private long user_id;
	private String reg_date;
    
    public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {

		return price;
	}
	public long getRole_id() {
		return role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public int getMonths() {
		return months;
	}
	public String getExpire_date() {
		return expire_date;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setRole_id(long role_id) {
		this.role_id = role_id;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public void setMonths(int months) {
		this.months = months;
	}
	public void setExpire_date(String expire_date) {
		this.expire_date = expire_date;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
 
}
