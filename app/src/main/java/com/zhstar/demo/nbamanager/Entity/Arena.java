package com.zhstar.demo.nbamanager.Entity;


import java.io.Serializable;

public class Arena implements Serializable {

	private Long id;
	private String arena_name;
	private Integer cap;
	private Double attendance;
	private String arena_img;
	private Team team;
	private Integer today_in;
	private Integer ticket_price;
	private Integer eq_level;
	private Integer cap_level;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getArena_name() {
		return arena_name;
	}

	public void setArena_name(String arena_name) {
		this.arena_name = arena_name;
	}

	public Integer getCap() {
		return cap;
	}

	public void setCap(Integer cap) {
		this.cap = cap;
	}

	public Double getAttendance() {
		return attendance;
	}

	public void setAttendance(Double attendance) {
		this.attendance = attendance;
	}

	public String getArena_img() {
		return arena_img;
	}

	public void setArena_img(String arena_img) {
		this.arena_img = arena_img;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Integer getToday_in() {
		return today_in;
	}

	public void setToday_in(Integer today_in) {
		this.today_in = today_in;
	}

	public Integer getTicket_price() {
		return ticket_price;
	}

	public void setTicket_price(Integer ticket_price) {
		this.ticket_price = ticket_price;
	}

	public Integer getEq_level() {
		return eq_level;
	}

	public void setEq_level(Integer eq_level) {
		this.eq_level = eq_level;
	}

	public Integer getCap_level() {
		return cap_level;
	}

	public void setCap_level(Integer cap_level) {
		this.cap_level = cap_level;
	}
}
