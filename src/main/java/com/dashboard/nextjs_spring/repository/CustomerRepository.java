package com.dashboard.nextjs_spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.dashboard.nextjs_spring.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}