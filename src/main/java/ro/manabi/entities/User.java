package ro.manabi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class User {
	
	public User() {}
	
	
	public User(String username, String password, String name, int role) {
		this.username = username;
		this.password = password;
		this.name = name;
		if(role == 1) {
			this.role = Roles.ADMIN;
		}
		else {
			this.role = Roles.USER;
		}
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String username;
	private String password;
	private Roles role;
	
	
	public void setPassword(String newPassword) {
		this.password=newPassword;
	}
}
