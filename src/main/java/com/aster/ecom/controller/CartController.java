package com.aster.ecom.controller;

import com.aster.ecom.domain.Cart;
import com.aster.ecom.domain.CartEntry;
import com.aster.ecom.domain.Product;
import com.aster.ecom.services.CartEntryService;
import com.aster.ecom.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private CartEntryService cartEntryService;

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCart(@PathVariable Long id) {
        Cart cart = cartService.getCart(id);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cart> createCart() {
        Cart cart = cartService.createCart();
        return new ResponseEntity<>(cart, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/entries")
    public ResponseEntity<CartEntry> addProductToCart(@PathVariable Long id, @RequestBody Product product, @RequestParam int quantity) {
        CartEntry cartEntry = cartEntryService.addProductToCart(id, product.getProduct_id(), quantity);
        return new ResponseEntity<>(cartEntry, HttpStatus.CREATED);
    }

    @PutMapping("/entries/{id}")
    public ResponseEntity<CartEntry> updateCartEntry(@PathVariable Long id, @RequestParam int quantity) {
        CartEntry cartEntry = cartEntryService.updateCartEntry(id, quantity);
        return new ResponseEntity<>(cartEntry, HttpStatus.OK);
    }

    @DeleteMapping("/entries/{id}")
    public ResponseEntity<Void> removeProductFromCart(@PathVariable Long id) {
        cartEntryService.removeProductFromCart(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}/entries")
    public ResponseEntity<List<CartEntry>> getCartEntries(@PathVariable Long id) {
        List<CartEntry> cartEntries = cartEntryService.getCartEntries(id);
        return new ResponseEntity<>(cartEntries, HttpStatus.OK);
    }
}
