package com.zhstar.demo.nbamanager.entity;


import java.io.Serializable;

public class DayInLog implements Serializable {

	private Long day_in_id;
	private Integer ev_change;
	private Integer fans_change;
	private Integer arena_in;
	private Integer pay;
	private Integer profit;
	private String day_in_date;
	private Long team_id;

	public Long getDay_in_id() {
		return day_in_id;
	}

	public void setDay_in_id(Long day_in_id) {
		this.day_in_id = day_in_id;
	}

	public Integer getEv_change() {
		return ev_change;
	}

	public void setEv_change(Integer ev_change) {
		this.ev_change = ev_change;
	}

	public Integer getFans_change() {
		return fans_change;
	}

	public void setFans_change(Integer fans_change) {
		this.fans_change = fans_change;
	}

	public Integer getArena_in() {
		return arena_in;
	}

	public void setArena_in(Integer arena_in) {
		this.arena_in = arena_in;
	}

	public Integer getPay() {
		return pay;
	}

	public void setPay(Integer pay) {
		this.pay = pay;
	}

	public Integer getProfit() {
		return profit;
	}

	public void setProfit(Integer profit) {
		this.profit = profit;
	}

	public String getDay_in_date() {
		return day_in_date;
	}

	public void setDay_in_date(String day_in_date) {
		this.day_in_date = day_in_date;
	}

	public Long getTeam_id() {
		return team_id;
	}

	public void setTeam_id(Long team_id) {
		this.team_id = team_id;
	}
}
