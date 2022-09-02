package com.tmf.bbs.controller;


import com.tmf.bbs.service.PostServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 帖子的管理
 *
 * @author Administrator
 */
@Controller
public class PostController {

    @Resource(name = "postServicesImpl")
    PostServices services;


    // 热帖的查询
    @RequestMapping("/topic_GetHotTopic.do")
    //@ResponseBody
    public String queryHot(HttpServletRequest request, Integer indexPage) {
        if (indexPage == null) {
            indexPage = 1;
        }
        services.getHotTopic(request, indexPage);
        return "hotTopic";
    }

    // 精贴的查询
    @RequestMapping("/topic_GetNiceTopic.do")
    //@ResponseBody
    public String queryNice(HttpServletRequest request, Integer indexPage) {
        if (indexPage == null) {
            indexPage = 1;
        }
        services.getNiceTopic(request, indexPage);
        return "niceTopic";
    }

    //全部帖子的查询
    @RequestMapping("/topic_GetAllTopic.do")
    //@ResponseBody
    public String queryAll(HttpServletRequest request, Integer indexPage) {
        if (indexPage == null) {
            indexPage = 1;
        }
        services.getAllTopic(request, indexPage);
        return "allTopic";
    }

    //进入到帖子具体页面
    @RequestMapping("/topic_goTopic.do")
    //@ResponseBody
    public String goTopic(HttpServletRequest request, Integer id, Integer indexPage) {
        if (indexPage == null) {
            indexPage = 1;
        }
        services.goTopic(request, id, indexPage);
        return "u/theTopic";
    }
}
