package com.hjc.demo.service.impl;

import java.util.Set;

import com.hjc.demo.dao.UserDao;
import com.hjc.demo.dao.impl.UserDaoImpl;
import com.hjc.demo.model.User;
import com.hjc.demo.util.PasswordHelper;

import shiro.hjc.demo.service.UserService;

public class UserServiceImpl implements UserService{

	private UserDao userDao = new UserDaoImpl();
	private PasswordHelper passwordHelper = new PasswordHelper();
	
	public User createUser(User user) {
		passwordHelper.encryptPassword(user);
		return userDao.createUser(user);
	}

	public void changePassword(Long userId, String newPassword) {
		User user = userDao.findOne(userId);
		user.setPassword(newPassword);
		passwordHelper.encryptPassword(user);
		userDao.updateUser(user);
	}

	public void correlationRoles(Long userId, Long... roleIds) {
		userDao.correlationRoles(userId, roleIds);
	}

	public void uncorrelationRoles(Long userId, Long... roleIds) {
		userDao.uncorrelationRoles(userId, roleIds);
	}

	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	public Set<String> findRoles(String username) {
		// TODO Auto-generated method stub
		return userDao.findRoles(username);
	}

	public Set<String> findPermissions(String username) {
		// TODO Auto-generated method stub
		return userDao.findPermissions(username);
	}

}
