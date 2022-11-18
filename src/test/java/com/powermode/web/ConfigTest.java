package com.powermode.web;

import com.powernode.web.SpringConfig;
import com.powernode.web.util.DateTimeUtil;
import com.powernode.web.util.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class ConfigTest {
    @Test
    public void contextTest() {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        applicationContext.close();
    }

    @Test
    public void expireDateTest() {
        String date = "2022-11-15";
        System.out.println(date.compareTo(DateTimeUtil.generateNowDate()));
        System.out.println("password = " + MD5Util.generateMD5("2415286134@qq.com"));

        System.out.println(DateTimeUtil.generateNowTime().compareTo("2018-11-27 21:50:05"));
    }
}
