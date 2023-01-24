package com.aster.ecom.services;

import com.aster.ecom.domain.Product;

import java.util.List;

public interface ProductService {
    public Product getProductBySKU(String sku);
    public Product addProductToCart(Product product);
    public Product updateCart(Product product);
    public void removeProductFromCart(String sku);
    public List<Product> viewCartDetails();


}

