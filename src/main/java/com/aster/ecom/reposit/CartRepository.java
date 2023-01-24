package com.aster.ecom.reposit;

import com.aster.ecom.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUserId(String userId);
}

