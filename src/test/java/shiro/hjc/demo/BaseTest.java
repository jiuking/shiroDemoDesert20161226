package shiro.hjc.demo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;
import org.junit.Before;

import com.hjc.demo.model.Permission;
import com.hjc.demo.model.Role;
import com.hjc.demo.model.User;
import com.hjc.demo.service.impl.PermissionServiceImpl;
import com.hjc.demo.service.impl.RoleServiceImpl;
import com.hjc.demo.service.impl.UserServiceImpl;
import com.hjc.demo.util.JdbcTemplateUtils;

import shiro.hjc.demo.service.PermissionService;
import shiro.hjc.demo.service.RoleService;
import shiro.hjc.demo.service.UserService;

public abstract class BaseTest {
	protected PermissionService permissionService = new PermissionServiceImpl();
    protected RoleService roleService = new RoleServiceImpl();
    protected UserService userService = new UserServiceImpl();

    protected String password = "123456";

    protected Permission p1;
    protected Permission p2;
    protected Permission p3;
    protected Role r1;
    protected Role r2;
    protected User u1;
    protected User u2;
    protected User u3;
    protected User u4;
    
    @Before
    public void setUp(){
    	JdbcTemplateUtils.getJdbcTemplate().update("delete from sys_users");
        JdbcTemplateUtils.getJdbcTemplate().update("delete from sys_roles");
        JdbcTemplateUtils.getJdbcTemplate().update("delete from sys_permissions");
        JdbcTemplateUtils.getJdbcTemplate().update("delete from sys_users_roles");
        JdbcTemplateUtils.getJdbcTemplate().update("delete from sys_roles_permissions");
        
        //1、新增權限
        p1 = new Permission("user:create", "用户模块新增", Boolean.TRUE);
        p2 = new Permission("user:update", "用户模块修改", Boolean.TRUE);
        p3 = new Permission("menu:create", "菜单模块新增", Boolean.TRUE);
        permissionService.createPermission(p1);
        permissionService.createPermission(p2);
        permissionService.createPermission(p3);
        //2、新增角色
        r1 = new Role("admin","管理員",Boolean.TRUE);
        r2 = new Role("user","用戶管理員",Boolean.TRUE);
        roleService.createRole(r1);
        roleService.createRole(r2);
        //3、關聯角色-權限
        roleService.correlationPermissions(r1.getId(), p1.getId());
        roleService.correlationPermissions(r1.getId(), p2.getId());
        roleService.correlationPermissions(r1.getId(), p3.getId());
        
        roleService.correlationPermissions(r2.getId(), p1.getId());
        roleService.correlationPermissions(r2.getId(), p2.getId());
        //新增用戶
        u1 = new User("zhang",password);
        u2 = new User("li", password);
        u3 = new User("wu", password);
        u4 = new User("wang", password);
        u4.setLocked(Boolean.TRUE);
        userService.createUser(u1);
        userService.createUser(u2);
        userService.createUser(u3);
        userService.createUser(u4);
        //5、關聯用戶-角色
        userService.correlationRoles(u1.getId(), r1.getId());
    }
    
    @After
    public void tearDown() throws Exception{
    	//退出時請解除綁定Subject到線程 否則對下次測試造成影響
    	ThreadContext.unbindSubject();
    }
    
    protected void login(String configFile,String username,String password){
    	Factory<SecurityManager> factory = new IniSecurityManagerFactory(configFile);
    	SecurityManager securityManager = factory.getInstance();
    	SecurityUtils.setSecurityManager(securityManager);
    	Subject subject = SecurityUtils.getSubject();
    	UsernamePasswordToken token = new UsernamePasswordToken(username,password);
    	subject.login(token);
    }
    
    public Subject subject(){
    	return SecurityUtils.getSubject();
    }
}
