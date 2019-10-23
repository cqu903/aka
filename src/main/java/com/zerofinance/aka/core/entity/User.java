package com.zerofinance.aka.core.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.zerofinance.aka.core.entity.base.BaseBasicData;

@Entity
public class User extends BaseBasicData<User> {
	
	
	@ManyToOne(optional=false)
	private Position position;
	
	private String loginName;
	
	private String password;
	
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
