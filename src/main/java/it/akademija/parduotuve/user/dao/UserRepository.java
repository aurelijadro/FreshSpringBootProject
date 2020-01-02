package it.akademija.parduotuve.user.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.akademija.parduotuve.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);

	List<User> findUsersByEmailContaining(String partOfEmail);

	void deleteByUsername(String username);
}
