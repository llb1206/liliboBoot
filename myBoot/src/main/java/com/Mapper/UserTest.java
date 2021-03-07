package com.Mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserTest {

    void addUser(User user);

    List<User> sel();

    List<User> selectUserByUsernameAndSex(User user);

    List<User> selectUserByChoose(User user);

    List<User> selectUserByUsernameAndSex2(User user);

    void  updateUserById(User user);

    List<User> selectUserByUsernameAndSex22(User user);

    List<User> selectUserByListId(List<Integer> Ids);

    void batchSave(List<User> list);

    banjiA selAassociation(int id);

    List<banjiC>  selCollection(int id);


}
