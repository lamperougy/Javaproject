package com.example.springboot.service;

import com.example.springboot.bean.Lost;
import com.example.springboot.bean.Result;
import com.example.springboot.bean.User;
import com.example.springboot.mapper.SqlMapper;
import com.example.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class UserService {
    int f=0;
    @Autowired
    private UserMapper userMapper;
    /**
     * 注册
     * @param user 参数封装
     * @return Result
     */
    public Result regist(User user) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            User existUser = userMapper.findUserByName(user.getThe_name());
            if(existUser != null){
                //如果用户名已存在
                result.setMsg("用户名已存在");
            }else{
                userMapper.regist(user);
                //System.out.println(user.getId());
                result.setMsg("注册成功");
                result.setSuccess(true);
                result.setDetail(user);
                f=1;
            }
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 登录
     * @param user 用户名和密码
     * @return Result
     */
    public Result login(User user) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            Long userId= userMapper.login(user);
            if(userId == null){
                result.setMsg("用户名或密码错误");
                System.exit(0);
            }else{
                result.setMsg("登录成功");
                result.setSuccess(true);
                user.setStudent_no(String.valueOf(userId));
                result.setDetail(user);

            }
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
        /**
         * 增加
         * @param lost
         *
         */
        public String add (Lost lost){
        SqlMapper.add(lost);
        return "add sucessfully";
    }
        /**
         * 删除
         *
         *
         */
        public String delete(@Param("lost_id")String id){
            SqlMapper.delete(id);
            return "delete sucessfully";
        }
    /**
     * 更新
     *
     *
     */
    public String update(@Param("is_returned") Integer is_returned,@Param("lost_id") String id){
        SqlMapper.update(is_returned,id);
        return "update sucessfully";
    }
    /**
     * 查看
     * @param lost
     *
     */
    public String look(Lost lost){
        SqlMapper.look(lost);
        return "look sucessfully";
    }
}