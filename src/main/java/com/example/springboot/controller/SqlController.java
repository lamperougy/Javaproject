package com.example.springboot.controller;


import com.example.springboot.bean.Lost;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/user/login",method =RequestMethod.GET )
public class SqlController {
    @Autowired
    private UserService userService;
    /**
     * 查询
     * @return Lost
     */
    @PostMapping(value = "/look")
    public String look(Lost lost){
        return userService.look(lost);
    }
    /**
     * 删除
     * @return lost_id
     */
    @PostMapping(value = "/delete")
    public String delete(String lost_id){
        return userService.delete(lost_id);
    }
    /**
     * 增加
     * @return Lost
     */
    @PostMapping(value = "/add")
    public String add(Lost lost){
        return userService.add(lost);
    }
    /**
     * 修改
     *
     * @return is_returned,lost_id
     */
    public String update(Integer is_returned, String lost_id){
        return userService.update(is_returned, lost_id);
    }
}
