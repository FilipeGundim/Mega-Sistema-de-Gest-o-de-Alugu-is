package models;

import interfaces.IGenericClassMethods;

public class Theme implements IGenericClassMethods {
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
