package com.tmf.bbs.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tmf.bbs.service.TopicServices;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 首页帖子管理
 * @author Administrator
 *
 */

@Controller
public class TopicController {
	@Resource(name="topicServicesImpl")
	TopicServices services;
	//发帖
	@RequestMapping("/topic_addTopic.do")
	@ResponseBody
	public String add(HttpServletRequest request, HttpServletResponse response,String title,String content,Integer topics_user_id,String password){
       services.addTopic(request,response,title,content,topics_user_id,password);
	   return "add successfully";
	}
	//删帖
	@RequestMapping("/topic_deleteTopic.do")
	//@ResponseBody
	public String delete(Integer topicId){
		services.deleteTopic(topicId);
		return "redirect:topic_goTopic.do"+topicId;
	}
	//首页中的热帖查询
	@RequestMapping("/topic_getIndexHotTopic.do")
	//@ResponseBody
	public String queryIndexHotTopic(HttpServletRequest request) {
		services.getIndexHotTopic(request);
		return "indexHotTopic";
	}
	
	//首页中的精贴查询
	@RequestMapping("/topic_getIndexNiceTopic.do")
	//@ResponseBody
	public String queryIndexNiceTopic(HttpServletRequest request) {
		services.getIndexNiceTopic(request);
		return "indexNiceTopic";
	}
	//首页中的新帖查询
	@RequestMapping("/topic_getIndexFreshTopic.do")
	//@ResponseBody
	public String queryIndexFreshTopic(HttpServletRequest request) {
		services.getIndexFreshTopic(request);
		return "indexFreshTopic";
	}
	//更新帖子
	@RequestMapping("/updateTopic.do")
	@ResponseBody
	public String update(Integer id,Integer topics_user_id,String content,String password){
		services.updateTopic(id,topics_user_id,content,password);
		return "update successfully";
	}
}
