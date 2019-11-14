package com.jugheadzhou;

import com.jugheadzhou.common.entity.Score;
import com.jugheadzhou.config.SpringConfig;
import com.jugheadzhou.controller.UserController;
import com.jugheadzhou.dao.UserDao;
import com.jugheadzhou.server.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @ClassName: SpringConfigTest
 * @Description: 使用注解注册bean
 * @Author: zhaoRong
 * @Create: 2019/11/14 22:28
 **/
public class SpringConfigTest {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);

    /**
     * 使用注解注册bean
     *
     * @JAVA配置文件 com.jugheadzhou.config.SpringConfig
     */
    @Test
    public void springAnnotationTest(){

        Score score = (Score) applicationContext.getBean("score");
        System.out.println(score);

        String[] beanNamesForType = applicationContext.getBeanNamesForType(Score.class);
        System.out.println(Arrays.toString(beanNamesForType));
    }

    /**
     * 使用扫描的方式找到对应的bean
     *
     * @JAVA配置文件 com.jugheadzhou.config.SpringConfig
     */
    @Test
    public void springScanTest(){


        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

        System.out.println("Spring容器扫描到的bean: \n"+Arrays.toString(beanDefinitionNames));


        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        System.out.println(userDao.getUser());

        UserService userService = (UserService) applicationContext.getBean("userServiceImpl");
        System.out.println(userService.getUser());

        UserController userController = (UserController) applicationContext.getBean("userController");
        System.out.println(userController.getUserName());
    }
}
