package com.mapper;

import lombok.Data;

import java.util.List;

@Data
public class banjiC {
    private int id;
    private String name;
    private List<User> users;
}
