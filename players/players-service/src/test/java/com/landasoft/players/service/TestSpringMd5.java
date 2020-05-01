package com.landasoft.players.service;

import org.junit.Test;
import org.springframework.util.DigestUtils;

/**
 * 測試spring的md5加密
 * 
 * @author zhaoyuan
 * @date 2020，Feb 12 3:44 pm
 */
public class TestSpringMd5 {
	
	@Test
	public void testSpringOfMd5() {
		String str = DigestUtils.md5DigestAsHex("suofeiya".getBytes());
		System.out.println(str);
	}

}
