package com.jugheadzhou.server.impl;

import com.jugheadzhou.common.entity.User;
import com.jugheadzhou.dao.UserDao;
import com.jugheadzhou.server.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: UserServiceImpl
 * @Description:
 * @Author: zhaoRong
 * @Create: 2019/11/13 21:41
 **/
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Override
    public User getUser() {
        return userDao.getUser();
    }
}
