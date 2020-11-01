package com.zoro.multi.datasource.service.oracle;

import com.zoro.multi.datasource.entity.UserInfo;

/**
 * @author zoro
 * @version 1.0
 * @date 2020/11/2 0:56
 * @desc
 */
public interface UserService {
    UserInfo getUserByName(String userName);
    void insert(UserInfo userInfo);
}
