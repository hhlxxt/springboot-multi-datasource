package com.zoro.multi.datasource.service.oracle;

import com.zoro.multi.datasource.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zoro
 * @version 1.0
 * @date 2020/11/2 1:02
 * @desc
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserServiceTest {

    @Autowired
    private UserService userService ;

    @Autowired
    private com.zoro.multi.datasource.service.mysql.UserService mysqlUserService ;

    @Test
    public void getUserByName() {
        UserInfo mysqlUser = mysqlUserService.getUserByName("用户-1");
        log.info("mysql 数据:"+mysqlUser);

        UserInfo oracleUser = userService.getUserByName("zoro");
        log.info("oracle 数据:"+oracleUser);

        mysqlUserService.insert("zoro");

        userService.insert(oracleUser);

    }
}