package models;

import java.text.SimpleDateFormat;
import java.util.Date;

import interfaces.IGenericClassMethods;

public class Client implements IGenericClassMethods {
	private String name;
	private String tel;
	private Date registeredAt;
	private static String FORMAT = "dd/MM/yyyy";

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
		SimpleDateFormat formatter = new SimpleDateFormat(FORMAT);
		return  getName() + ";" + getTel()+";" + formatter.format(getRegisteredAt()) + ";";
	}

}
