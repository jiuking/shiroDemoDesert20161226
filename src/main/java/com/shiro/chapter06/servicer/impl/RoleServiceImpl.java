package com.shiro.chapter06.servicer.impl;

import com.shiro.chapter06.dao.RoleDao;
import com.shiro.chapter06.dao.impl.RoleDaoImpl;
import com.shiro.chapter06.entity.Role;
import com.shiro.chapter06.servicer.RoleService;

public class RoleServiceImpl implements RoleService {

	private RoleDao roleDao = new RoleDaoImpl();
//	private JdbcTemplate jdbcTemplate = JdbcTemplateUtils.jdbcTemplate();
	@Override
	public Role createRole(final Role role) {
//		final String sql = "insert into sys_roles(role,description, available) values(?,?,?)";
//		GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
//		jdbcTemplate.update(new PreparedStatementCreator() {
//			
//			@Override
//			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
//				PreparedStatement psst = conn.prepareStatement(sql,new String[]{"id"});
//				psst.setString(1, role.getRole());
//				psst.setString(2, role.getDescription());
//				psst.setBoolean(3, role.getAvailable());
//				return psst;
//			}
//		},keyHolder);
//		return role;
		return roleDao.createRole(role);
	}

	@Override
	public void deleteRole(Long roleId) {
//		String sql = "delete from sys_users_roles where role_id = ?";
//		jdbcTemplate.update(sql,roleId);
//		
//		sql = "delete from sys_roles where id=?";
//		jdbcTemplate.update(sql,roleId);
		roleDao.deleteRole(roleId);
	}

	@Override
	public void correlationPermissions(Long roleId, Long... permissionIds) {

//		if(permissionIds == null || permissionIds.length == 0){
//			return;
//		}
//		String sql = "insert into sys_roles_permissions(role_id,permissionIds) values(?,?)";
//		for(Long permissionId : permissionIds){
//			if(!exists(roleId,permissionId)){
//				jdbcTemplate.update(sql,roleId,permissionId);
//			}
//		}
		roleDao.correlationPermissions(roleId, permissionIds);
	}

	@Override
	public void uncorrelationPermissions(Long roleId, Long... permissionIds) {
//		if(permissionIds == null || permissionIds.length == 0 ){
//			return;
//		}
//		String sql = "delete from sys_roles_permissions where role_id=? and permission_id=?";
//		for(Long permissionId:permissionIds){
//			if(exists(roleId,permissionId)){
//				jdbcTemplate.update(sql,roleId,permissionId);
//			}
//		}
		 roleDao.uncorrelationPermissions(roleId, permissionIds);
	}
	
//	private boolean exists(Long roleId,Long permissionId){
//		String sql = "select count(1) from sys_roles_permissions where role_id=? and permission_id = ?";
//		return jdbcTemplate.update(sql,Integer.class,roleId,permissionId) != 0;
//	}
}
