package com.StudentManager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.StudentManager.entities.User;

public interface UserDao extends JpaRepository<User, String>{
	
	public User findByUserName(String userName);
}
