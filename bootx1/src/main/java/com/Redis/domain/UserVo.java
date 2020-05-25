package com.Redis.domain;

import lombok.Data;

@Data
public class UserVo {

    public  static final String Table = "t_user";

    private String name;
    private String address;
    private Integer age;
}
