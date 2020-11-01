package com.zoro.multi.datasource.mapper.oracle;

import com.zoro.multi.datasource.entity.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author zoro
 * @version 1.0
 * @date 2020/11/2 0:37
 * @desc
 */
@Repository("oracleUserMapper")
public interface UserMapper {
    @Select("select * from userinfo where username = #{userName}")
    UserInfo getUserByName(String userName);

    @Insert("insert into userinfo values(#{id},#{userName})")
    void insert(UserInfo userInfo);

}
