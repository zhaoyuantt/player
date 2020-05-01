package com.landasoft.players.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;

import java.util.Date;

/**
 * 测试RandomStringUtils工具类
 * @author zhaoyaun
 * @date 2020,Feb 22 12:38 pm
 */
public class TestApacheUtils {

    @Test
    public void testRandomNumber(){
        String str = RandomStringUtils.randomNumeric(3);
        System.out.println(str);
    }

    @Test
    public void testFormatDate(){
        String apacheTime = DateFormatUtils.format(new Date(), "yyyy-MM-dd");
        System.out.println(apacheTime);
    }
}
