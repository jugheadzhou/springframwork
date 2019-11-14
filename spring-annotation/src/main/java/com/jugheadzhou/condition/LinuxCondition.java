package com.jugheadzhou.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Arrays;

/**
 * @ClassName: LinuxCondition
 * @Description: 按条件在spring容器中注册bean
 * 如果是Linux系统就注册bean
 * @Author: zhaoRong
 * @Create: 2019/11/14 22:12
 **/
public class LinuxCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        System.out.println("------LinuxCondition------ \n" + Arrays.toString(beanDefinitionNames));
        BeanDefinitionRegistry registry = conditionContext.getRegistry();

        //TODO 测试方法 如果容器中包含id为score的bean，就移除这个bean，或者做其他操作
//        if (registry.containsBeanDefinition("score")){
//            registry.removeBeanDefinition("score");
//        }

        //获取启动环境
        Environment environment = conditionContext.getEnvironment();
        //获取操作系统名称
        String property = environment.getProperty("os.name");
        System.out.println("当前操作系统名称："+property);
        //TODO 条件：操作系统名称包含Linux就注册
        if (property.contains("Linux")){
            System.out.println("LinuxCondition匹配通过！！！");
            return true;
        }
        System.out.println("LinuxCondition未匹配！！！");
        return false;
    }
}
