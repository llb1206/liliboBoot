package com.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface insertP {

     void insertP(@Param("p") person p);

     List<person> secP();
}
