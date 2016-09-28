package com.shiro.chapter03;

import org.junit.Assert;
import org.junit.Test;

import com.shiro.util.BaseTest;

public class PermissionTest extends BaseTest{
	
	@Test
	public void testIsPermitted(){
		login("classpath:shiro-permission.ini","zhang","123");
		Assert.assertTrue(subject().isPermitted("user:create"));
		Assert.assertTrue(subject().isPermitted("user:delete"));
	}
}
