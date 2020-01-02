package it.akademija.parduotuve.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.akademija.parduotuve.user.dao.UserDAO;
import it.akademija.parduotuve.user.dao.UserRepository;

@Service
public class UserService {

	@Autowired
	@Qualifier("repoUserDao")
	private UserDAO userDao;

	@Autowired
	private UserRepository userRepository;

	@Transactional(readOnly = true)
	public List<User> getUsers() {
		return userDao.getUsers();
	}

	@Transactional
	public void createUser(User user) {
		userDao.createUser(user);
	}

	@Transactional
	public void deleteUser(String username) {
		userDao.deleteUser(username);
	}
}
