package com.example.springmvc.springmvc.Service;

import com.example.springmvc.springmvc.model.Product;
import com.example.springmvc.springmvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void deleteProductById(String id) {
        productRepository.delete(id);
    }

    public List<Product> showProducts() {
         return productRepository.findAll();
    }
}
