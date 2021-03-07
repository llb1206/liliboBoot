package com.Mapper;

import lombok.Data;

import java.util.List;

@Data
public class banjiC {
    private int id;
    private String name;
    private List<User> users;
}
