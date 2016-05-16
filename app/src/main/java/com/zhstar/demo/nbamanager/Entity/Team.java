package com.zhstar.demo.nbamanager.entity;


import java.io.Serializable;
import java.util.List;

public class Team implements Serializable {


	private Long id;
	private String team_name;
	private String username;
	private String players;
	private Long user_id;
	private Integer team_money;
	private Integer ev;
	private Arena arena;
	private String fans_change_state;
	private DayInLog dil;
	private boolean treadable;
	private List<Player> playerList;

	public List<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public String getPlayers() {
		return players;
	}

	public void setPlayers(String players) {
		this.players = players;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Integer getTeam_money() {
		return team_money;
	}

	public void setTeam_money(Integer team_money) {
		this.team_money = team_money;
	}

	public Integer getEv() {
		return ev;
	}

	public void setEv(Integer ev) {
		this.ev = ev;
	}

	public Arena getArena() {
		return arena;
	}

	public void setArena(Arena arena) {
		this.arena = arena;
	}

	public String getFans_change_state() {
		return fans_change_state;
	}

	public void setFans_change_state(String fans_change_state) {
		this.fans_change_state = fans_change_state;
	}

	public DayInLog getDil() {
		return dil;
	}

	public void setDil(DayInLog dil) {
		this.dil = dil;
	}

	public boolean isTreadable() {
		return treadable;
	}

	public void setTreadable(boolean treadable) {
		this.treadable = treadable;
	}
}
