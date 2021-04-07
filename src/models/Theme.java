package models;

import interfaces.GenericClassMethods;

public class Theme implements GenericClassMethods {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getAllPropertys() {
		// TODO Auto-generated method stub
		return "tema: " + getName();
	}
}
