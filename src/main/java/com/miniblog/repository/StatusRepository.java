package com.miniblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniblog.model.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {


}
