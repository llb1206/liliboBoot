package com.Redis.redisCatch.controller;

import com.Redis.redisCatch.dao.UserDao;
import com.Redis.redisCatch.entity.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * @Author: MaoLin
 * @Date: 2019/3/26 17:03
 * @Version 1.0
 */
//https://blog.csdn.net/chachapaofan/article/details/88829265?utm_medium=distribute.pc_relevant.none-task-blog-baidulandingword-2&spm=1001.2101.3001.4242

@RestController
public class testController implements Serializable {
    @Resource
    private UserDao userDao;

    /**
     * 查询出一条数据并且添加到缓存
     *
     * @param userId
     * @return
     */
    @RequestMapping("/getUser")
    @Cacheable(value = {"userCache"})
    public User getUser(String userId) {
        System.out.println("如果没有缓存，就会调用下面方法，如果有缓存，则直接输出，不会输出此段话");
        return userDao.getUser(Integer.parseInt(userId));
    }

    /**
     * 删除一个缓存
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/deleteUser")
    @CacheEvict("userCache")
    public String deleteUser(@RequestParam(required = true) String userId) {
        return "删除成功";
    }

    /**
     * 添加一条保存的数据到缓存，缓存的key是当前user的id
     *
     * @param user
     * @return
     */
    @RequestMapping("/saveUser")
    @CachePut(value = "userCache", key = "#result.userId +''")
    public User saveUser(User user) {
        return user;
    }


    /**
     * 返回结果userPassword中含有nocache字符串就不缓存
     *
     * @param userId
     * @return
     */
    @RequestMapping("/getUser2")
    @CachePut(value = "userCache", unless = "#result.userPassword.contains('nocache')")
    public User getUser2(@RequestParam(required = true) String userId) {
        System.out.println("如果走到这里说明，说明缓存没有生效！");
        User user = new User(Integer.parseInt(userId), "name_nocache" + userId, "nocache");
        return user;
    }


    @RequestMapping("/getUser3")
    @Cacheable(value = "userCache", key = "#root.targetClass.getName() + #root.methodName + #userId")
    public User getUser3(@RequestParam(required = true) String userId) {
        System.out.println("如果第二次没有走到这里说明缓存被添加了");
        return userDao.getUser(Integer.parseInt(userId));
    }

}
