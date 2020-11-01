package com.zoro.multi.datasource.service.oracle.impl;

import com.zoro.multi.datasource.entity.UserInfo;
import com.zoro.multi.datasource.mapper.oracle.UserMapper;
import com.zoro.multi.datasource.service.oracle.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zoro
 * @version 1.0
 * @date 2020/11/2 0:58
 * @desc
 */
@Service("oracleService")
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("oracleUserMapper")
    UserMapper userMapper ;
    @Override
    public UserInfo getUserByName(String userName) {
        return userMapper.getUserByName(userName);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(UserInfo userInfo) {
        userMapper.insert(userInfo);
        int i =1/0 ;
    }
}
