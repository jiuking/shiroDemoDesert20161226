package com.shiro.chapter06.servicer;

import com.shiro.chapter06.entity.Permission;

public interface PermissionService {
	public Permission createPermission(Permission permission);
	public void deletePermission(Long permissionId);
}
