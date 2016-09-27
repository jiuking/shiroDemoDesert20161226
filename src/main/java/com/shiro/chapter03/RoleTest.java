package com.shiro.chapter03;

import org.junit.Assert;
import org.junit.Test;

import com.shiro.util.BaseTest;



public class RoleTest extends BaseTest{
	
	@Test
	public void testHasRole(){
		login("classpath:shiro-role.ini","zhang","123");
		Assert.assertTrue(subject().hasRole("role2"));
	}
}
