package com.jugheadzhou;

import com.jugheadzhou.config.SpringConfig2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName: SpringConfig2Test
 * @Description: 使用注解注册bean
 * @Author: zhaoRong
 * @Create: 2019/11/14 22:28
 **/
public class SpringConfig2Test {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig2.class);

    /**
     * 测试按条件注册bean
     */
    @Test
    public void conditionalTest(){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        this.printBeanNames(beanDefinitionNames);

    }





    private void printBeanNames(String[] beanDefinitionNames){
        for (String beanName : beanDefinitionNames){
            System.out.println("beanName: "+ beanName);
        }
    }
}
