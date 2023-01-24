package com.aster.ecom.services;

import com.aster.ecom.domain.Cart;
import com.aster.ecom.reposit.CartRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceimpl implements CartService {

    private CartRepository cartRepository;

    @Override
    public Cart createCart() {
        Cart cart = new Cart();
        return cartRepository.save(cart);
    }

    @Override
    public Cart getCart(Long id) {
        return cartRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cart not found with id " + id));
    }

    @Override
    public Cart updateCart(Long id, Cart cart) {
        Cart existingCart = cartRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cart not found with id " + id));
        existingCart.setEntries(cart.getEntries());
        return cartRepository.save(existingCart);
    }

    @Override
    public void deleteCart(Long id) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cart not found with id " + id));
        cartRepository.delete(cart);
    }

    @Override
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

}
