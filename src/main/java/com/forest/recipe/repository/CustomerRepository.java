package com.forest.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forest.recipe.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String>{
}
