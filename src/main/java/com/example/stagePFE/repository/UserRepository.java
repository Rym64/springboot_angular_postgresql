package com.example.stagePFE.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.stagePFE.model.User;

public interface UserRepository extends JpaRepository<User, Long>{}
