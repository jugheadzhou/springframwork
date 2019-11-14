package com.jugheadzhou;

import static org.junit.Assert.assertTrue;

import com.jugheadzhou.common.entity.Score;
import com.jugheadzhou.common.entity.User;
import com.jugheadzhou.config.SpringConfig;
import com.jugheadzhou.controller.UserController;
import com.jugheadzhou.dao.UserDao;
import com.jugheadzhou.server.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class AppTest {


    /**
     * 使用spring xml配置文件注册bean
     */
    @Test
    public void springXmlTest(){

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        User user = (User) classPathXmlApplicationContext.getBean("user");

        System.out.println(user);
    }

    /**
     * 使用注解注册bean
     *
     * @JAVA配置文件 com.jugheadzhou.config.SpringConfig
     */
    @Test
    public void springAnnotationTest(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        Score score = (Score) annotationConfigApplicationContext.getBean("score");
        System.out.println(score);

        String[] beanNamesForType = annotationConfigApplicationContext.getBeanNamesForType(Score.class);
        System.out.println(Arrays.toString(beanNamesForType));
    }

    /**
     * 使用扫描的方式找到对应的bean
     *
     * @JAVA配置文件 com.jugheadzhou.config.SpringConfig
     */
    @Test
    public void springScanTest(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);

        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();

        System.out.println("Spring容器扫描到的bean: \n"+Arrays.toString(beanDefinitionNames));


        UserDao userDao = (UserDao) annotationConfigApplicationContext.getBean("userDao");
        System.out.println(userDao.getUser());

        UserService userService = (UserService) annotationConfigApplicationContext.getBean("userServiceImpl");
        System.out.println(userService.getUser());

        UserController userController = (UserController) annotationConfigApplicationContext.getBean("userController");
        System.out.println(userController.getUserName());
    }















}
