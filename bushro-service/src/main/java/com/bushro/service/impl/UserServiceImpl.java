package com.bushro.service.impl;

import com.bushro.config.TargetDataSource;
import com.bushro.mapper.UserMapper;
import com.bushro.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author BushRo
 * @Description: TOTO
 * @date 2019-09-30
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @TargetDataSource("master")
    @Override
    public List getUserMaster() {
        return userMapper.getUserList();
    }
    @TargetDataSource("slave")
    @Override
    public List getUserSlave() {
        return userMapper.getUserList();
    }
}
