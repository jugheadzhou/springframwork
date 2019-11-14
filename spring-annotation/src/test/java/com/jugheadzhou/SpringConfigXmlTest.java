package com.jugheadzhou;

import com.jugheadzhou.common.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName: SpringConfigXmlTest
 * @Description: 使用spring xml配置文件注册bean
 * @Author: zhaoRong
 * @Create: 2019/11/14 22:28
 **/
public class SpringConfigXmlTest {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    /**
     * 使用spring xml配置文件注册bean
     */
    @Test
    public void springXmlTest(){

        User user = (User) applicationContext.getBean("user");

        System.out.println(user);
    }
}
