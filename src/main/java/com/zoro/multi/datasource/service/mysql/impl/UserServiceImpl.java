package com.zoro.multi.datasource.service.mysql.impl;

import com.zoro.multi.datasource.entity.UserInfo;
import com.zoro.multi.datasource.mapper.mysql.UserMapper;
import com.zoro.multi.datasource.service.mysql.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zoro
 * @version 1.0
 * @date 2020/11/2 0:57
 * @desc
 */
@Service("mysqlService")
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("mysqlUserMapper")
    UserMapper userMapper ;
    @Override
    public UserInfo getUserByName(String userName) {
        return userMapper.getUserByName(userName);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(String userName) {
        userMapper.insert(userName);
        int i= 1/0;
    }
}
