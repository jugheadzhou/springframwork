package com.jugheadzhou.controller;

import com.jugheadzhou.server.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @ClassName: UserController
 * @Description:
 * @Author: zhaoRong
 * @Create: 2019/11/13 21:43
 **/
@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private final UserService userService;

    public String getUserName(){
        return userService.getUser().getName();
    }
}
