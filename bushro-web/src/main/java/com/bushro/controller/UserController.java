package com.bushro.controller;

import com.bushro.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author BushRo
 * @Description: TOTO
 * @date 2019-09-30
 */
@RestController
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping("/getUserMaster")
    public List getUserMaster(){
        return userService.getUserMaster();
    }
    @RequestMapping("/getUserSlave")
    public List getUserSlave(){
        return userService.getUserSlave();
    }

}
