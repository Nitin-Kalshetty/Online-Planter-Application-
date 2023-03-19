package com.rocker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rocker.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

}
