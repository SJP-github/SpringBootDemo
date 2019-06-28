package com.sjp.mybatis.model;

import com.sjp.mybatis.enums.UserSexEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1044053805868215432L;
    private Long id;
    private String userName;
    private String passWord;
    private UserSexEnum userSex;
    private String nickName;

}
