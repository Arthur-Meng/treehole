package com.mjw.treehole.bean;

import lombok.Data;

@Data
public class Msg {
	String date;
	String msg;

	public Msg(String date, String msg) {
		this.date = date;
		this.msg = msg;
	}
	
}
