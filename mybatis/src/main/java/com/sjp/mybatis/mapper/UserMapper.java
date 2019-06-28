package com.sjp.mybatis.mapper;

import com.sjp.mybatis.enums.UserSexEnum;
import com.sjp.mybatis.model.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    /**
     * 获取所有用户
     * @return
     */
    @Select("SELECT * FROM user")
    @Results({
            @Result(property = "userSex",  column = "userSex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nickName")
    })
    List<User> getAll();

}
