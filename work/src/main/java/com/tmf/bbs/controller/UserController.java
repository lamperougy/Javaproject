package com.tmf.bbs.controller;

import com.tmf.bbs.dao.UserDao;
import com.tmf.bbs.service.UserServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {
    @Resource
    UserServices services;
    //登录
    @RequestMapping(value = "/user_Login.do")
    //不用@ResponseBody,使用这个则默认返回数据，非jsp文件路径
    public String queryUser(HttpServletRequest request, HttpServletResponse response, String username, String password) {
        if (services.queryUserByUserName(request, response, username, password)) {
            return "index";
        } else {
            return "login";
        }
    }
    //注册
    @RequestMapping(value = "/user_Regist.do")    //注册后就创建账号，不需要重复验证
    //@ResponseBody
    public String regist(HttpServletRequest request, HttpServletResponse response, String username, String password) {
        if (services.saveUser(request, response, username, password)) {
            return "WEB-INF/regist";
        } else {
            return "al";
        }
    }
    //个人中心
    @RequestMapping("/user_GoHome.do")
    //@ResponseBody
    public String goUserHome() {
        return "u/home";
    }
    //通过ID查询帖子、回复
    @RequestMapping("/getById.do")
    @ResponseBody
    public String getById(HttpServletRequest request,Integer id){
        services.getById(request,id);
        return "successfully get";
    }
}
