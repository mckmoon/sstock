package com.oldtom.smartstock.account.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class LoginUser extends User {
	
	private static final long serialVersionUID = -3531439484732724601L;
	
	private final Long id;
    private final String name;
    private final String nickname;
    private final String birth_date;
    private final String phone_no;
    private final String address;
    private String email_conf;
    private final String reg_date;
    
	public LoginUser(String username, String password, Collection<? extends GrantedAuthority> authorities,
			Long id,
			String name,
			String nickname,
			String birth_date,
			String phone_no,
			String address,
			String email_conf,
			String reg_date) {
		
		super(username, password, authorities);
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.nickname = nickname;
		this.birth_date = birth_date;
		this.phone_no = phone_no;
		this.address = address;
		this.setEmail_conf(email_conf);
		this.reg_date = reg_date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getNickname() {
		return nickname;
	}

	public String getBirth_date() {
		return birth_date;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail_conf() {
		return email_conf;
	}

	public void setEmail_conf(String email_conf) {
		this.email_conf = email_conf;
	}

	public String getReg_date() {
		return reg_date;
	}	
}
