package com.filter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class SsController {

    @RequestMapping("login")
    public String login(String name, String pwd, HttpServletRequest request) {
        HttpSession session = request.getSession();

        if (name.equals("root") && pwd.equals("root")) {
            User user = new User();
            user.setName(name);
            session.setAttribute("user", user);
            return "登录成功";
        } else {
            return "用户名或密码错误!";
        }
    }

    @RequestMapping("ss")
    public String logins(String name, String pwd, HttpServletRequest request) {
        HttpSession session = request.getSession();

        if (name.equals("root") && pwd.equals("root")) {
            User user = new User();
            user.setName(name);
            session.setAttribute("user", user);
            return "登录成功";
        } else {
            return "用户名或密码错误!";
        }
    }

    public class User {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
