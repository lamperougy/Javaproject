package com.tmf.bbs.dao;

import com.tmf.bbs.entity.Comment;
import com.tmf.bbs.entity.New;
import com.tmf.bbs.entity.Topic;
import com.tmf.bbs.entity.User;
import com.tmf.bbs.util.UserSqlUtils;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
/**
 * 关于用户表的查询
 *
 * @author ls
 */
@Mapper
public interface UserDao {

    /**
     * 通用的查询方法         可以根据用户名和用户的id来查询
     *
     * @return User
     */
    @SelectProvider(type = UserSqlUtils.class, method = "selectWithParamSql")
    User queryUser(User user);

    @Select("select * from t_user where username=#{username} and password=#{password}")
    @RequestMapping("com.tmf.bbs.mappers.userMap.userBean")
    User queryUserByUserName(@Param("username") String username, @Param("password") String password);

    /**
     * 注册用户
     *
     *
     * @return
     */

    @Insert("insert into t_user(username,password)values(#{username},#{password})")
    @RequestMapping("com.tmf.bbs.mappers.userMap.userBean")
    int saveUser(@Param("username") String username, @Param("password") String password);

    /**
     * 根据userId 来修改 用户信息
     *
     * @param user
     * @return Integer
     */
    Integer updateByUserId(User user);


    //------------------------------------------

    /**
     * 查询所有的用户信息  （分页）
     *
     * @return List<User>
     */
    List<User> queryAllUser(int currentPage);

    /**
     * 通过id查询用户的所有评论
     *
     * @param comments_user_id 当前页面
     * @param password
     * @return List<Comment>
     */
    @Select("select id,content,floor,comment_time,comments_user_id from t_comment where comments_user_id=#{comments_user_id} and comments_user_id in (select id from t_user where password=#{password})")
    List<Comment> getCommentById(Integer comments_user_id,String password);

    /**
     * 通过id查询用户的所有消息
     *
     * @param currentPage 当前页面
     * @return List<New>
     */
    List<New> querySelfNew(int currentPage, User user);

    /**
     * 查询用户的所有的帖子
     *
     * @param topics_user_id 当前页面
     * @param password
     * @return List<Topic>
     */
    @Select("select id,title,content,topic_time,topics_user_id from t_topic where topics_user_id=#{topics_user_id} and topics_user_id in (select id from t_user where password=#{password})")
    List<Topic> getTopicById(Integer topics_user_id,String password);

}
