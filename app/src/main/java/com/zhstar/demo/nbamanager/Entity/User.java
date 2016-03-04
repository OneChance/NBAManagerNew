package com.zhstar.demo.nbamanager.Entity;


import java.io.Serializable;

public class User implements Serializable {
	

	private Long id;
	private String user_name;
	private String password;
	private Team team;

	public User(String username,String password){
		this.user_name = username;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
}
