package com.workout.utility;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserUtilsTest {

	UserUtils userUtils;
	
	@Before
	public void init(){
		userUtils = new UserUtils();
	}
	
	@Test
	public void testVerifyEmail1() {
		assertTrue(userUtils.verifyEmail("tomjas@gmail.com"));
	}
	
	@Test
	public void testVerifyEmail2() {
		assertTrue(userUtils.verifyEmail("tomjas_@1gmail.com"));
	}
	
	@Test
	public void testVerifyEmail3() {
		assertTrue(userUtils.verifyEmail("TOMJAS@GMAIL.COM"));
	}
	
	@Test
	public void testVerifyEmail4() {
		assertFalse(userUtils.verifyEmail("@"));
	}
	
	@Test
	public void testVerifyEmail5() {
		assertFalse(userUtils.verifyEmail("tomjas@gmail.com1"));
	}
	
	@Test
	public void testVerifyEmail6() {
		assertFalse(userUtils.verifyEmail("tomjas.gmail.com"));
	}
	
	@Test
	public void testVerifyEmail7() {
		assertFalse(userUtils.verifyEmail("!@#123@1gmail.com"));
	}

}
