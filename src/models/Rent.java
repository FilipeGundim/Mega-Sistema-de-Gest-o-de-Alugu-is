package models;

import interfaces.IGenericClassMethods;

public class Rent implements IGenericClassMethods {
	private String address;
	private String date;
	private Theme theme;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
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

	@Override
	public String getAllPropertys() {
		// TODO Auto-generated method stub
		return getDate() + ";" + getTheme() + ";" + getAddress();
	}
}
