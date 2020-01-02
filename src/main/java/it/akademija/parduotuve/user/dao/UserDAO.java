package it.akademija.parduotuve.user.dao;

import java.util.List;

import it.akademija.parduotuve.user.User;

public interface UserDAO {
	List<User> getUsers();

	void createUser(User user);

	void deleteUser(String username);
}
