package shiro.hjc.demo;

import java.util.Arrays;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
	private void login(String configFile){
		Factory<SecurityManager> factory = new IniSecurityManagerFactory(configFile);
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");
		subject.login(token);
		
	}
	
	@Test
	public void testhelloworld(){
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");
		
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");
		try{
			subject.login(token);
			
			System.out.println(subject.getPrincipals());
		}catch(AuthenticationException e){
			e.printStackTrace();
		}
		Assert.assertEquals(true, subject.isAuthenticated());
		if(subject.isAuthenticated())
			System.out.println("login success");
	}
	
	@Test
	public void testAllSuccessfulStrategyWithSuccess(){
		login("classpath:shiro-authenticator-all-success.ini");
		Subject subject = SecurityUtils.getSubject();
		PrincipalCollection principalCollection = subject.getPrincipals();
		Assert.assertEquals(2, principalCollection.asList().size());
	}
	
	@Test
	public void testHasRole(){
		login("classpath:shiro-role.ini");
		Subject subject = SecurityUtils.getSubject();
		Assert.assertTrue(subject.hasRole("role1"));
		Assert.assertEquals(true, subject.hasRole("role2"));
		Assert.assertTrue(subject.hasAllRoles(Arrays.asList("role1","role2")));
		boolean[] result = subject.hasRoles(Arrays.asList("role1","role2","role3"));
		Assert.assertTrue(result[0]);
		Assert.assertTrue(result[1]);
		Assert.assertFalse(result[2]);
	}
	
	@Test(expected=UnauthorizedException.class)
	public void testIsPermitted(){
		login("classpath:shiro-permission.ini");
		Subject subject = SecurityUtils.getSubject();
		subject.isPermitted("user:create");
		subject.isPermitted("user:update");
		subject.isPermittedAll("user:create","user:update");
		subject.isPermitted("user:view");
	}
}
