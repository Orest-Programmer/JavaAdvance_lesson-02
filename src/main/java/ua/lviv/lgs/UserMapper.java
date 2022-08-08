package ua.lviv.lgs;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {
	
	public static User map(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		String firstName = result.getString("first_name");
		String surName = result.getString("sur_name");
		String email = result.getString("email");
		
		return new User(id, firstName, surName, email);
		
	}
	
}
