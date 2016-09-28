package com.shiro.chapter03;

import java.util.Arrays;

import org.apache.shiro.authz.UnauthorizedException;
import org.junit.Assert;
import org.junit.Test;

import com.shiro.util.BaseTest;



public class RoleTest extends BaseTest{
	
	@Test
	public void testHasRole(){
		login("classpath:shiro-role.ini","zhang","123");
		Assert.assertTrue(subject().hasRole("role2"));
		Assert.assertTrue(subject().hasAllRoles(Arrays.asList("role1","role2")));
//		Assert.assertTrue(subject().hasAllRoles(Arrays.asList("role1","role2","role3")));
		boolean[] result = subject().hasRoles(Arrays.asList("role1","role2","role3"));
		Assert.assertEquals(true,result[0]);
		Assert.assertEquals(true,result[1]);
		Assert.assertEquals(true,result[2]);
	}
	
	@Test//(expected = UnauthorizedException.class)
	public void testCheckRole(){
		login("classpath:shiro-role.ini","zhang","123");
		subject().checkRole("role1");
		subject().checkRoles("role1","role3");
	}
}
