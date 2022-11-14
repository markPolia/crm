package com.powermode.web;

import com.powernode.web.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

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
        String date = "2022-11-13";
        String now = String.format("%1$tY-%1$tm-%1$td", new Date());
        System.out.println("now " + now);
        System.out.println("date " + date);
        System.out.println(date.compareTo(now));
    }
}
