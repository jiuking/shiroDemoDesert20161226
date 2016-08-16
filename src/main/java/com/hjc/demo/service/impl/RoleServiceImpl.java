package com.hjc.demo.service.impl;

import com.hjc.demo.dao.RoleDao;
import com.hjc.demo.dao.impl.RoleDaoImpl;
import com.hjc.demo.model.Role;

import shiro.hjc.demo.service.RoleService;

public class RoleServiceImpl implements RoleService {
	
	private RoleDao roleDao = new RoleDaoImpl();
	public Role createRole(Role role) {
		
		return roleDao.createRole(role);
	}

	public void deleteRole(Long roleId) {
		roleDao.delteRole(roleId);
	}

	 /**
     * 添加角色-权限之间关系
     * @param roleId
     * @param permissionIds
     */
	public void correlationPermissions(Long roleId, Long... permissionIds) {
		roleDao.correlationPermissions(roleId, permissionIds);
	}

	/**
     * 移除角色-权限之间关系
     * @param roleId
     * @param permissionIds
     */
	public void uncorrelationPermissions(Long roleId, Long... permissionIds) {
		roleDao.uncorrelationPermissions(roleId, permissionIds);
	}

}
