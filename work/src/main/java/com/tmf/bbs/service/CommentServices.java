package com.tmf.bbs.service;

import com.tmf.bbs.entity.Comment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 评论回复 业务处理类
 * @author Administrator
 *
 */
public interface CommentServices {
	/**
	 * 删除评论 并且更新t_topic中的comment_count
	 * @param commentId
	 * @param topicId
	 */
	void deleteComment(Integer commentId, Integer topicId);

	void addComment(HttpServletRequest request, HttpServletResponse response, String content, Integer floor, Date comment_time, Integer comments_user_id, Integer comments_topic_id);
}
