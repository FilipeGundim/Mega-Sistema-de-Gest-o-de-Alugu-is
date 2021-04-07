package models;

import java.util.Date;

import interfaces.GenericClassMethods;

public class Client implements GenericClassMethods {
	private String name;
	private String tel;
	private Date registeredAt;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Date getRegisteredAt() {
		return registeredAt;
	}

	public void setRegisteredAt(Date registeredAt) {
		this.registeredAt = registeredAt;
	}

	public String getAllPropertys() {
		return "nome: " + getName() + " telefone " + getTel();
	}

}
