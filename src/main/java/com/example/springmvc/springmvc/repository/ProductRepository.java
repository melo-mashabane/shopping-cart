package com.example.springmvc.springmvc.repository;

import com.example.springmvc.springmvc.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mpumelelomashabane on 13/01/2018.
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
