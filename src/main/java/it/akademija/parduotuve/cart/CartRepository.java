package it.akademija.parduotuve.cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import it.akademija.parduotuve.cart.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
	Cart findByUsernameIgnoreCase(String username);
}
