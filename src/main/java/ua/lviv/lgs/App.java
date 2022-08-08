package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class App {

	
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		
		UserDao userDao = new UserDao(ConnectionUtils.openConnection());
		
		userDao.readAll().forEach(System.out::println);
		System.out.println("****************************************************************\n");
		
		
		//INSERT
		List<User> listOfUser = new ArrayList();
		listOfUser.add(new User("Orest", "Savko", "savko@gmail.com"));
		listOfUser.add(new User("Tony", "Stark", "starkindustry@gmail.com"));
		listOfUser.add(new User("Elvin", "Presly", "presly@gmail.com"));
		listOfUser.add(new User("Denys", "Yakov", "yakov@gmail.com"));
		listOfUser.add(new User("Oleh", "Bodnar", "bodnar@gmail.com"));
//		
//		
//		listOfUser.forEach(user->{
//			try {
//				userDao.insert(user);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		});
		
		//READ-ALL
		userDao.readAll().forEach(System.out::println);
		System.out.println("****************************************************************\n");
		
		//READ-BY-ID
		User userFromBd = userDao.read(1);
		System.out.println(userFromBd);
		
		//UPDATE-BY-ID
		userFromBd.setFirstName("Jhony");
		userDao.update(userFromBd);
		System.out.println(userFromBd);
		System.out.println("****************************************************************\n");
		
		//DELETE-BY-ID
		userDao.delete(1);
		userDao.readAll().forEach(System.out::println);
	}
}
