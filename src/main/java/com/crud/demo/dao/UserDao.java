package com.crud.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.demo.model.User;

public interface UserDao extends JpaRepository<User, Integer>{

}
