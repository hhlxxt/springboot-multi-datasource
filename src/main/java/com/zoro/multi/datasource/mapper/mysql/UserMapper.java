package com.zoro.multi.datasource.mapper.mysql;

import com.zoro.multi.datasource.entity.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author zoro
 * @version 1.0
 * @date 2020/11/2 0:39
 * @desc
 */
@Repository("mysqlUserMapper")
public interface UserMapper {
    @Select("select id,user_name userName from users where user_name = #{userName} limit 1")
    UserInfo getUserByName(String userName);

    @Insert("insert into users(user_name) values(#{userName})")
    void insert(String userName);
}
