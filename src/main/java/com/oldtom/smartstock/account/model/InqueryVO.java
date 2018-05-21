package com.oldtom.smartstock.account.model;

import java.util.Date;
import java.util.List;


public class InqueryVO {
    private Long id;
    private String name;
    private String email;
    private String content;
    private String reg_date;
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getContent() {
		return content;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

    
}
