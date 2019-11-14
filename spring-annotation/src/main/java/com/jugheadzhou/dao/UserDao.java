package com.jugheadzhou.dao;

import com.jugheadzhou.common.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: UserDao
 * @Description:
 * @Author: zhaoRong
 * @Create: 2019/11/13 21:46
 **/
@Repository
public class UserDao {
    public User getUser() {
        return new User(2L,"xiaoli",5);
    }
}
