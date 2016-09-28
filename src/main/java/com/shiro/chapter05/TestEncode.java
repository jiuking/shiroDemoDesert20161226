package com.shiro.chapter05;

import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Assert;
import org.junit.Test;

public class TestEncode {
	
	@Test
	public void testEncode(){
		String str = "hello";
		String base64Encode = Hex.encodeToString(str.getBytes());
		String str2 = new String(Hex.decode(base64Encode.getBytes()));
		System.out.println(base64Encode);
		System.out.println(str2);
		Assert.assertEquals(str, str2);
		String salt = "123";
		String simpleHash = new SimpleHash("SHA-1",str,salt).toString();
		System.out.println(simpleHash);
		DefaultHashService dhs = new DefaultHashService();
	}
}
