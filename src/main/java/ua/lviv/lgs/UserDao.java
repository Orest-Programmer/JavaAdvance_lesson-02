package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
	private static String READ_ALL = "select * from user";
	private static String CREATE = "insert into user(`first_name`, `sur_name`, `email`) values (?,?,?)";
	private static String READ_BY_ID = "select * from user where id =?";
	private static String UPDATE_BY_ID = "update user set first_name=?, sur_name=?, email=? where id=?";
	private static String DELETE_BY_ID = "delete from user where id=?";
	
	private Connection connection;
	
	private PreparedStatement preparedStatement;
	
	public UserDao(Connection connection) {
		this.connection = connection;
	}
	
	public void insert(User user) throws SQLException {
		preparedStatement = connection.prepareStatement(CREATE);
		preparedStatement.setString(1, user.getFirstName());
		preparedStatement.setString(2, user.getSurName());
		preparedStatement.setString(3, user.getEmail());
		preparedStatement.executeUpdate();
	}
	
	public User read(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		
		return UserMapper.map(result);
		
	}
	
	public void update(User user) throws SQLException {
		preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setString(1, user.getFirstName());
		preparedStatement.setString(2, user.getSurName());
		preparedStatement.setString(3, user.getEmail());
		preparedStatement.setInt(4, user.getId());
		
		preparedStatement.executeUpdate();
		
	}
	
	public List<User> readAll() throws SQLException{
		List<User> listOfUsers = new ArrayList();
		preparedStatement = connection.prepareStatement(READ_ALL);
		ResultSet result = preparedStatement.executeQuery();
		
		while(result.next()) {
			listOfUsers.add(UserMapper.map(result));
		}
		return listOfUsers;
	}
	
	public void delete(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(DELETE_BY_ID);
		
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();

	}
	
	
}
