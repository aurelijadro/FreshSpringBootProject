package it.akademija.parduotuve.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);

	List<User> findUsersByEmailContaining(String partOfEmail);

	void deleteByUsername(String username);
}
