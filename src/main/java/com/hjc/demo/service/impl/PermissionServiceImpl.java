package com.hjc.demo.service.impl;


import com.hjc.demo.dao.PermissionDao;
import com.hjc.demo.dao.impl.PermissionDaoImpl;
import com.hjc.demo.model.Permission;

import shiro.hjc.demo.service.PermissionService;

public class PermissionServiceImpl implements PermissionService{

	private PermissionDao permissionDao = new PermissionDaoImpl();
	
	public Permission createPermission(Permission permission) {
		return permissionDao.createPermission(permission);
	}

	public void deltePermission(Long permissionId) {
		permissionDao.deletePermission(permissionId);
	}

}
