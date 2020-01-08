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

	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Transactional(readOnly = true)
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Transactional
	public void createUser(User user) {
		userRepository.save(user);
	}

	@Transactional
	public void deleteUser(String username) {
		userRepository.deleteByUsername(username);
	}
}
