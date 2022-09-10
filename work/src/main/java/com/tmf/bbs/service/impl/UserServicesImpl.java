package com.tmf.bbs.service.impl;


import com.tmf.bbs.dao.UserDao;
import com.tmf.bbs.entity.Comment;
import com.tmf.bbs.entity.Topic;
import com.tmf.bbs.entity.User;
import com.tmf.bbs.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

@Service("userServicesImpl")
public class UserServicesImpl implements UserServices{

	@Resource
	private UserDao userDao;
	
	/**
	 * 可根据Id和用户名查询用户是否存在
	 */
	public void queryUser(HttpServletRequest request, User user) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 用来用户登录
	 */
    @Override
	public boolean queryUserByUserName(HttpServletRequest request, HttpServletResponse response,String username, String password) {
		// TODO Auto-generated method stub
		//username="admin";
		//password="123456";
	    //System.out.println(username);
		//System.out.println(password);
		boolean flag=false;
		User user = userDao.queryUserByUserName(username, password);
		//System.out.println(user);
		if(user!=null) {
			flag = true;
			request.getSession().setAttribute("user", user);
		}else {
			request.setAttribute("msg", "输入的密码不正确,请重新输入");
			request.setAttribute("path", request.getContextPath()+"/login.jsp");
			try {
				request.getRequestDispatcher("common/success.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}
	@Override
	public boolean saveUser(HttpServletRequest request, HttpServletResponse response,String username, String password){
		boolean flag=false;
		User user=userDao.queryUserByUserName(username, password);
		if(user!=null){
			flag=false;
			request.setAttribute("msg","账号已经存在");
			request.setAttribute("path",request.getContextPath()+"al.jsp");
			try {
				request.getRequestDispatcher("common/success.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			flag=true;
			if(username!=null&&password!=null){
			userDao.saveUser(username, password);
			}
		}
		return flag;
	}

	@Override
	public void getById(HttpServletRequest request,Integer id,String password) {
		List<Topic> list1 = userDao.getTopicById(id, password);
		List<Comment> list2 = userDao.getCommentById(id, password);
		//request.setAttribute("topicList", list1);
		//request.setAttribute("commentList", list2);
		//System.out.println("topicList"+"\n"+list1);
		if(id==null||password==null){
			request.setAttribute("msg","账号、密码为空");
			request.setAttribute("path",request.getContextPath()+"getById.jsp");
		}else{
			Stream.of(list1).forEach(System.out::println);
			System.out.println("====================================");
			Stream.of(list2).forEach(System.out::println);
			//System.out.println("commentList"+"\n"+list2);
		}
	}
}
