package com.studec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studec.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
