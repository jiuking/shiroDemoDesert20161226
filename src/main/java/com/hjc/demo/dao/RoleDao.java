package com.hjc.demo.dao;

import com.hjc.demo.model.Role;

public interface RoleDao {
	public Role createRole(Role role);
	public void delteRole(Long roleId);
	public void correlationPermissions(Long roleId,Long... permissionIds);
	public void uncorrelationPermissions(Long roleId,Long... permissionIds);
}
