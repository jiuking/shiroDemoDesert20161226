package shiro.hjc.demo.service;

import com.hjc.demo.model.Permission;

/**
 * 实现基本的创建/删除权限
 * @author Bravowhale
 *
 */
public interface PermissionService {
	public Permission createPermission(Permission permission);
	public void deltePermission(Long permissonId);
}
