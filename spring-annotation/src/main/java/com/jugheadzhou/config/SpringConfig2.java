package com.jugheadzhou.config;

import com.jugheadzhou.common.entity.Role;
import com.jugheadzhou.common.entity.Score;
import com.jugheadzhou.common.entity.User;
import com.jugheadzhou.condition.LinuxCondition;
import com.jugheadzhou.condition.WindowsCondition;
import org.springframework.context.annotation.*;

/**
 * @ClassName: SpringConfig2
 * @Description:
 * @Author: zhaoRong
 * @Create: 2019/11/14 14:35
 **/
@Configuration
@Import(Role.class)//通过@Import注解快速注册bean,bean的id是全类名
public class SpringConfig2 {

    @Scope("prototype")//默认是单例的，这里设置多例
    @Lazy//开启懒加载，
    @Bean("score")
    public Score score(){
        return new Score();
    }

    @Bean
    @Conditional({LinuxCondition.class})
    public User linux(){
        return new User(1L,"linuxUser",5);
    }

    @Bean
    @Conditional({WindowsCondition.class})
    public User windows(){
        return new User(2L,"windowsUser",9);
    }
}
