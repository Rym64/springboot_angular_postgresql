package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.User;



public interface UserRepository extends JpaRepository<User, Long>{
	 List<User> findByfirstname(String firstname );

	  List<User> findByadressContaining(String adress);
}
