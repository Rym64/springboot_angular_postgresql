package com.example.stagePFE.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.example.stagePFE.model.User;


public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findByCin(String cin);
}

