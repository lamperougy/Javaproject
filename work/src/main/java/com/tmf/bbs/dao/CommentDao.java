package com.tmf.bbs.dao;

import com.tmf.bbs.entity.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

/**
 * @author tmf
 * 评论 回复 dao层数据访问接口
 */
@Mapper
public interface CommentDao {
    /**
     * 查询所有评论
     *
     * @return
     */
    List<Comment> queryCommentByList();

    /**
     * 根据帖子id,查询评论
     *
     * @return
     */
    @Select("select * from t_comment where comments_topic_id=#{comments_topic_id}")
    List<Comment> queryCommentByTopicId(Integer comments_topic_id, RowBounds row);

    @Select("select count(1) from t_comment where comments_topic_id=#{comments_topic_id}")
    int countByTopicId(Integer comments_topic_id);

    /**
     * 根据回复id查询回复
     *
     * @param id
     * @return
     */
    Comment find(Integer id);

    /**
     * 添加回复
     *
     * @param content
     * @param floor
     * @param comment_time
     * @param comments_user_id
     * @param comments_topic_id
     * @return
     */
    @Insert("insert into t_comment(content,floor,comment_time,comments_user_id,comments_topic_id) values(#{content},#{floor},#{now()},#{comments_user_id},#{comments_topic_id})")
    int addComment(String content, Integer floor, Date comment_time, Integer comments_user_id,Integer comments_topic_id);

    /**
     * 更新回复
     *
     * @param comment
     * @return
     */
    int update(Comment comment);

    /**
     * 删除回复
     *
     * @param commentId
     * @return
     */

    @Delete("delete from t_comment where id=#{commentId}")
    int delete(Integer commentId);


}
