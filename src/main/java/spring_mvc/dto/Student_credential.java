package spring_mvc.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
public class Student_credential {
	private String name;
	
	@Id
	private String email;
	private String Password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	@Override
	public String toString() {
		return "Student_credential [name=" + name + ", email=" + email + ", Password=" + Password + "]";
	}
	
}
