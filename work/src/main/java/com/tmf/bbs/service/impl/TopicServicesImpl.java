package com.tmf.bbs.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.tmf.bbs.dao.TopicDao;
import com.tmf.bbs.entity.Topic;
import com.tmf.bbs.service.TopicServices;

@Service("topicServicesImpl")
public class TopicServicesImpl implements TopicServices{
	@Resource
	TopicDao topicDao;
	private Topic topic;

	//热帖
	@Override
	public void getIndexHotTopic(HttpServletRequest request) {
		// TODO Auto-generated method stub
		List<Topic> indexHotTopic = topicDao.getIndexHotTopic();
		request.setAttribute("indexHotTopic", indexHotTopic);
	}

	//精贴
	@Override
	public void getIndexNiceTopic(HttpServletRequest request) {
		// TODO Auto-generated method stub
		List<Topic> indexNiceTopic = topicDao.getIndexNiceTopic();
		request.setAttribute("indexNiceTopic", indexNiceTopic);
	}

	
	//新帖
	@Override
	public void getIndexFreshTopic(HttpServletRequest request) {
		// TODO Auto-generated method stub
		List<Topic> indexFreshTopic = topicDao.getIndexFreshTopic();
		request.setAttribute("indexFreshTopic", indexFreshTopic);
	}
	//发帖
	@Override
	public void addTopic(HttpServletRequest request, HttpServletResponse response,String title,String content,Integer topics_user_id){
		// TODO Auto-generated method stub
		topicDao.addTopic(request,response,title,content,topics_user_id);
		request.setAttribute("msg","添加问题成功");
	}
	//删帖
	@Override
	public void deleteTopic(Integer topicId){
		// TODO Auto-generated method stub
		topicDao.deleteTopic(topicId);
	}

	@Override
	public void updateTopic(Integer id,Integer user_id,String content){
		// TODO Auto-generated method stub
		topicDao.updateTopic(id,user_id,content);
	}
}
