package com.jugheadzhou.config;

import com.jugheadzhou.common.entity.Score;
import com.jugheadzhou.common.entity.User;
import com.jugheadzhou.controller.UserController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @ClassName: SpringConfig
 * @Description: 使用Java代码配置的方式代替spring的xml配置文件,使用注解@Configuration
 * 注解@Configuration中：
 * value：指定要扫描的包
 * includeFilters：指定扫描的时候按照对应的规则只包含这些组件(就是只包含) 配合useDefaultFilters=false
 * excludeFilters：指定按照对应的规则排除掉那些组件（就是不包含）
 *
 * @Author: zhaoRong
 * @Create: 2019/11/13 21:05
 **/
@Configuration//标记这是一个spring配置类
@ComponentScan(value = "com.jugheadzhou",includeFilters = {
        //按注解扫描，扫描只包含@Service注解的类
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Service.class}),
        //按指定类类型扫描
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {UserController.class}),
        //自定义规则匹配UserDao （com.jugheadzhou.config.MyTypeFilter）
        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})
},useDefaultFilters = false
)

public class SpringConfig {

    /**
     * 给spring容器注册一个bean,bean的id就是方法名，类型是方法的返回值类型
     * @return
     */
    @Bean
    public Score score(){
        return new Score(1L,2);
    }
}
