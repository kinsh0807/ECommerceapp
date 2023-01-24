package com.aster.ecom.services;

import com.aster.ecom.domain.Product;
import com.aster.ecom.reposit.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceimpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product getProductBySKU(String sku) {
        return productRepository.findBySku(sku);
    }

    @Override
    public Product addProductToCart(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateCart(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void removeProductFromCart(String sku) {
        productRepository.deleteBySku(sku);
    }

    @Override
    public List<Product> viewCartDetails() {
        return productRepository.findAll();
    }




}


