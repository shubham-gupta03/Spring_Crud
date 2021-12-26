package com.crud.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.demo.dao.UserDao;
import com.crud.demo.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public User saveUser(User user) {
		return userDao.save(user);
	}
	
	public List<User> getUsers(){
		return userDao.findAll();
	}
	
	public User getUser(int id) {
		return userDao.findById(id).orElse(null);
	}
	
	public User updateUser(User user) {
		User u = userDao.findById(user.getUser_id()).orElse(null);
		u.setUsername(user.getUsername());
		return userDao.save(u);
	}
	
	public void deleteUser(int id) {
		userDao.deleteById(id);
	}
}
