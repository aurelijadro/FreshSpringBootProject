package it.akademija.parduotuve.cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.akademija.parduotuve.cartproduct.CartProduct;

@Repository
public interface CartRepository extends JpaRepository<CartProduct, Long> {

}
