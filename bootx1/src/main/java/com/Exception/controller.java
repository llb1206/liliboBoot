package com.Exception;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.Mapper.User;
import com.Mapper.UserTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class controller {
    @Autowired
    service ss;

    @Autowired
    UserTest userTest;

    @RequestMapping("addSession")
    public void asd(String a ) {
        try {
            System.out.println("11111");
        } catch (Exception e) {
            System.out.printf("ccc");
            e.printStackTrace();
        }
    }
    @RequestMapping("online")
    public void asd222(String a ) {
        try {
            System.out.println("222222");
        } catch (Exception e) {
            System.out.printf("ccc");
            e.printStackTrace();
        }
    }

    @RequestMapping("asdasd")
    public PageInfo asdad() {
        PageHelper.startPage(3, 1);
        List<User> userList = userTest.sel();//使用pagehelper分页
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        System.out.println(userList.toString());
        System.out.println("*" + pageInfo.getList().toString());
        return pageInfo;
    }
}
