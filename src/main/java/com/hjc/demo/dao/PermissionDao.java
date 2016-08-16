package com.hjc.demo.dao;

import com.hjc.demo.model.Permission;

public interface PermissionDao {
	public Permission createPermission(Permission permission);
	public void deletePermission(Long permissionId);
}
