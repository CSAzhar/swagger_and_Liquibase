package com.studec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studec.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	public User findByMobile(String mobile);
}
