package models;

import java.util.Date;

public class Client {
private String name;
private String tel;
private Date registeredAt;

public Client(String name, String tel) {
	this.name = name;
	this.tel = tel;
	this.setRegisteredAt(new Date());
}

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

}
