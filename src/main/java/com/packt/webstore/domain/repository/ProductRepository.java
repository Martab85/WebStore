package com.packt.webstore.domain.repository;

import com.packt.webstore.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ProductRepository {
    List <Product> getAllProducts();
Product getProductById(String productId);
}

