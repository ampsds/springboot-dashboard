package com.dashboard.nextjs_spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.dashboard.nextjs_spring.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
}