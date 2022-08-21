package com.example.springboot.mapper;

import com.example.springboot.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * mapper的具体表达式
 */
@Mapper
@Repository
public interface UserMapper {

    /**
     * 查询用户名是否存在，若存在，不允许注册
     * 注解@Param(value) 若value与可变参数相同，注解可省略
     * 注解@Results  列名和字段名相同，注解可省略
     * @param the_name
     * @return
     */
    @Select(value = "select u.the_name,u.the_password from User u where u.the_name=#{the_name}")
    @Results
            ({@Result(property = "the_name",column = "the_name"),
                    @Result(property = "the_password",column = "the_password")})
    User findUserByName(@Param("the_name") String the_name);

    /**
     * 注册  插入一条user记录
     * @param user
     * @return
     */
    @Insert("insert into user values(#{student_no},#{the_password},#{institute},#{grade},#{the_class},#{the_name})")
    //加入该注解可以保存对象后，查看对象插入id
    @Options(useGeneratedKeys = true,keyProperty = "student_no",keyColumn = "student_no")
    void regist(User user);

    /**
     * 登录
     * @param user
     * @return
     */
    @Select("select u.student_no from User u where u.the_name = #{the_name} and the_password = #{the_password}")
    Long login(User user);
}

