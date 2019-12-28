package com.api.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.jpa.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
