package it.akademija.parduotuve.product.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import it.akademija.parduotuve.PagingData;
import it.akademija.parduotuve.product.Product;

@Qualifier("repoProductDao")
@Repository
public class DBProductDAO implements ProductDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private PagingData pagingData;

	public List<Product> getProducts() {
		return entityManager.createQuery("SELECT p from Product p", Product.class).setMaxResults(pagingData.getLimit())
				.getResultList();
	}

	public void createProduct(Product product) {
		entityManager.persist(product);
	}

	public void deleteProduct(Long id) {
		Product product = entityManager.createQuery("SELECT p from Product p where id = :pid", Product.class)
				.setParameter("pid", id).getSingleResult();
		if (entityManager.contains(product)) {
			entityManager.remove(product);
		} else {
			entityManager.remove(entityManager.merge(product));
		}
	}
}
