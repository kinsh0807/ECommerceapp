package com.aster.ecom.controller;

import com.aster.ecom.domain.Product;
import com.aster.ecom.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
    @RequestMapping("/api/products")
    public class ProductController {

        @Autowired
        private ProductService productService;

        @GetMapping("/{sku}")
        public ResponseEntity<Product> getProductBySKU(@PathVariable String sku) {
            Product product = productService.getProductBySKU(sku);
            if (product == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(product, HttpStatus.OK);
        }

        @PostMapping
        public ResponseEntity<Product> addProductToCart(@RequestBody Product product) {
            return new ResponseEntity<>(product, HttpStatus.CREATED);
        }

        @PutMapping
        public ResponseEntity<Product> updateCart(@RequestBody Product product) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }

        @DeleteMapping("/{sku}")
        public ResponseEntity<Void> removeProductFromCart(@PathVariable String sku) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        @GetMapping("/cart")
        public ResponseEntity<List<Product>> viewCartDetails() {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
