package com.oldtom.smartstock.account.model;

import java.util.Date;
import java.util.List;


public class UserVO {
    private Long id;
    private String username;
    private String password;
    private String passwordConfirm;
    private List<RoleVO> roles;
    private String name;
    private String nickname;
    private String birth_date;
    private String phone_no;
    private String address;
    private boolean contractAgreement;
    private String email_conf;
    private String reg_date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public List<RoleVO> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleVO> roles) {
        this.roles = roles;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", nickname=" + nickname + ", birth_date=" + birth_date + ", phone_no=" + phone_no + ", address="
				+ address + "]";
	}

	public boolean isContractAgreement() {
		return contractAgreement;
	}

	public void setContractAgreement(boolean contractAgreement) {
		this.contractAgreement = contractAgreement;
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

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
   
}
