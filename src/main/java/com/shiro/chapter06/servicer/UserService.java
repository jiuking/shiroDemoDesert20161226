package com.shiro.chapter06.servicer;

import java.util.Set;

import com.shiro.chapter06.entity.User;

public interface UserService {
	public User createUser(User user);
	public void changePassword(Long userId,String newPassword);
	public void correlationRoles(Long userId,Long...rolesIds);
	public void uncorrelationRoles(Long userId,Long... rolesIds);
	public User findByUsername(String username);
	public Set<String> findRoles(String username);
	public Set<String> findPermissions(String username);
}
