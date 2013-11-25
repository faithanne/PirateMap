package com.tunabytes.piratemap;

public class Event {
	public String date;
	public String header;
	public String info;

	public Event(String date, String header, String info) {
		this.date = date;
		this.header = header;
		this.info = info;
	}

	public String getDate() {
		return date;
	}

	public String getHeader() {
		return header + " " + date;
	}

	public String getInfo() {
		return info;
	}
}