package com.tmf.bbs.controller;

import com.tmf.bbs.entity.Comment;
import com.tmf.bbs.service.CommentServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * comment控制层
 *
 * @author Administrator
 */
@Controller
public class CommentController {

    @Resource(name = "commentServicesImpl")
    CommentServices services;

    // 添加评论
    @RequestMapping("/addComment.do")
    @ResponseBody
    public String add(HttpServletRequest request, HttpServletResponse response, String content, Integer floor, Date comment_time, Integer comments_user_id, Integer comments_topic_id) {
        services.addComment(request,response,content,floor,comment_time,comments_user_id,comments_topic_id);
        return "add successfuly";
    }

    // 删除评论信息
    @RequestMapping("/comment_Delete.do")
   // @ResponseBody
    public String delete(Integer commentId, Integer topicId) {
        services.deleteComment(commentId, topicId);
        return "redirect:topic_goTopic.do?id=" + topicId;
    }
}
