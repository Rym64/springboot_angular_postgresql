package com.frontbackend.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frontbackend.springboot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    List<User> findAllByFirstnameContaining(String firstname);
}
