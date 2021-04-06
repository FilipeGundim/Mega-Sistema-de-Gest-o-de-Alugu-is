package models;

import java.util.Date;

public class Rent {
	private String address;
	private Date date;
	private Theme theme;

	public Rent(String address, Date date, Theme theme) {
		this.address = address;
		this.date = date;
		this.theme = theme;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
