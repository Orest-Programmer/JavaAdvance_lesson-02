package ua.lviv.lgs;

import java.sql.Connection;

public class User {

	private int id;
	private String firstName;
	private String surName;
	private String email;
	public User(String firstName, String surName, String email) {
		this.firstName = firstName;
		this.surName = surName;
		this.email = email;
	}
	
	
	
	public User(int id, String firstName, String surName, String email) {
		this.id = id;
		this.firstName = firstName;
		this.surName = surName;
		this.email = email;
	}



	public User(Connection openConnection) {
		// TODO Auto-generated constructor stub
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getSurName() {
		return surName;
	}



	public void setSurName(String surName) {
		this.surName = surName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", surName=" + surName + ", email=" + email + "]";
	}
	
	
	
}
