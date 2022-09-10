package com.tmf.bbs.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface TopicServices {
	void getIndexHotTopic(HttpServletRequest request);

	void getIndexNiceTopic(HttpServletRequest request);

	void getIndexFreshTopic(HttpServletRequest request);

	void addTopic(HttpServletRequest request,HttpServletResponse response,String title,String content,Integer topics_user_id,String password);


	//删帖
	void deleteTopic(Integer topicId);

	void updateTopic(Integer id,Integer topics_user_id,String content,String password);
}
