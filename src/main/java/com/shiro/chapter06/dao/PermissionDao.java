package com.shiro.chapter06.dao;

import com.shiro.chapter06.entity.Permission;

public interface PermissionDao {

    public Permission createPermission(Permission permission);

    public void deletePermission(Long permissionId);

}
