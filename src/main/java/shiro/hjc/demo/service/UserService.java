package shiro.hjc.demo.service;

import java.util.Set;

import com.hjc.demo.model.User;

public interface UserService {
	public User createUser(User user);
	public void changePassword(Long userId,String newPassword);
	public void correlationRoles(Long userId,Long... roleIds);
	public void uncorrelationRoles(Long userId,Long...roleIds);
	public User findByUsername(String username);
	public Set<String> findRoles(String username);
	public Set<String> findPermissions(String username);
}
