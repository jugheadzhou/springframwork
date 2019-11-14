package com.jugheadzhou.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Arrays;

/**
 * @ClassName: WindowsCondition
 * @Description: 按条件在spring容器中注册bean
 * 如果是Windows系统就注册bean
 * @Author: zhaoRong
 * @Create: 2019/11/14 22:13
 **/
public class WindowsCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {

        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        System.out.println("------WindowsCondition------ \n" + Arrays.toString(beanDefinitionNames));
        //获取启动环境
        Environment environment = conditionContext.getEnvironment();
        //获取操作系统名称
        String property = environment.getProperty("os.name");
        System.out.println("当前操作系统名称："+property);
        //TODO 条件：操作系统名称包含Windows就注册
        if (property.contains("Windows")){
            System.out.println("WindowsCondition 匹配通过！！！");
            return true;
        }
        System.out.println("WindowsCondition 未匹配");
        return false;
    }
}
