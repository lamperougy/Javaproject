package com.tmf.bbs.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmf.bbs.entity.Comment;
import org.springframework.stereotype.Service;

import com.tmf.bbs.dao.CommentDao;
import com.tmf.bbs.dao.TopicDao;
import com.tmf.bbs.service.CommentServices;

import java.util.Date;


@Service("commentServicesImpl")
public class CommentServicesImpl implements CommentServices{
	@Resource //注入
	TopicDao topicDao;
	
	@Resource
	CommentDao commentDao;
	/**
	 * 删除评论 更新 comment_count
	 */
	@Override
	public void deleteComment(Integer commentId, Integer topicId) {
		// TODO Auto-generated method stub
		if(commentDao.delete(commentId)>0) {
			topicDao.updateCommment_count(topicId);
		}
	}

	@Override
	public void addComment(HttpServletRequest request, HttpServletResponse response, String content, Integer floor, Date comment_time, Integer comments_user_id, Integer comments_topic_id,String password) {
		// TODO Auto-generated method stub
		commentDao.addComment(content,floor,comment_time,comments_user_id,comments_topic_id,password);
		request.setAttribute("msg","添加评论成功");
	}

	@Override
	public void updateComment(Integer id,Integer comments_user_id,String content,String password){
		// TODO Auto-generated method stub
		commentDao.updateComment(id,comments_user_id,content,password);
	}
}
