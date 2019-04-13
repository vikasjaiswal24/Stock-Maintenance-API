package com.coremedia.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coremedia.jpa.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
