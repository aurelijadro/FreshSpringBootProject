package it.akademija.parduotuve.user.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import it.akademija.parduotuve.user.User;

@Qualifier("repoUserDao")
@Primary
@Repository
public class DBUserDAO implements UserDAO {
	@PersistenceContext
	private EntityManager entityManager;

	public List<User> getUsers() {
		return entityManager.createQuery("SELECT u from User u", User.class).getResultList();
	}

	public void createUser(User user) {
		entityManager.persist(user);
	}

	public void deleteUser(String username) {
		User user = entityManager.createQuery("SELECT u from User u where username = :un", User.class)
				.setParameter("un", username).getSingleResult();
		if (entityManager.contains(user)) {
			entityManager.remove(user);
		} else {
			entityManager.remove(entityManager.merge(user));
		}
	}

}
