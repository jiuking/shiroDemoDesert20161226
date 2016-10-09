package com.shiro.chapter06.servicer.impl;


import com.shiro.chapter06.dao.PermissionDao;
import com.shiro.chapter06.dao.impl.PermissionDaoImpl;
import com.shiro.chapter06.entity.Permission;
import com.shiro.chapter06.servicer.PermissionService;

public class PermissionServiceImpl implements PermissionService {

	private PermissionDao permissionDao = new PermissionDaoImpl();
//	private JdbcTemplate jdbcTemplate = JdbcTemplateUtils.jdbcTemplate();
	@Override
	public Permission createPermission(final Permission permission) {
		/*final String sql = "insert into sys_permissions(permission,description,available) values(?,?,?)";
		GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement psst = conn.prepareStatement(sql,new String[]{"id"});
				psst.setString(1, permission.getPermission());
				psst.setString(2, permission.getDescription());
				psst.setBoolean(3, permission.getAvailable());
				return psst;
			}
		},keyHolder);
		permission.setId(keyHolder.getKey().longValue());
		return permission;*/
		return permissionDao.createPermission(permission);
	}

	@Override
	public void deletePermission(Long permissionId) {
		/*String sql = "delete from sys_roles_permissions where permission_id=?";
		jdbcTemplate.update(sql,permissionId);
		
		sql = "delete from sys_permissions where id=?";
		jdbcTemplate.update(sql,permissionId);*/
		permissionDao.deletePermission(permissionId);
	}

}
