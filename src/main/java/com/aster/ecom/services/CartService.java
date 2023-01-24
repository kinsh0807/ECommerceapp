package com.aster.ecom.services;

import com.aster.ecom.domain.Cart;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface CartService {
    Cart createCart();

    Cart getCart(Long id);

    Cart updateCart(Long id, Cart cart);

    void deleteCart(Long id);

    List<Cart> getAllCarts();
}


