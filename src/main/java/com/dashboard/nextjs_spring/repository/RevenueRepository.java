package com.dashboard.nextjs_spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.dashboard.nextjs_spring.entity.Revenue;

public interface RevenueRepository extends JpaRepository<Revenue, String> {
}