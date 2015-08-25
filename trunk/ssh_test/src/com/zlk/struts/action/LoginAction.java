/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.zlk.struts.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.zlk.business.IUsersBusiness;
import com.zlk.pojo.Users;
import com.zlk.struts.form.LoginForm;

/** 
 * MyEclipse Struts
 * Creation date: 03-05-2010
 * 
 * XDoclet definition:
 * @struts.action path="/login" name="loginForm" parameter="methods" scope="request" validate="true"
 */
public class LoginAction extends DispatchAction {
	/*
	 * Generated Methods
	 */
	private IUsersBusiness usersBusiness;

	public void setUsersBusiness(IUsersBusiness usersBusiness) {
		this.usersBusiness = usersBusiness;
	}

	/** 
	 * 登陆的方法
	 */
	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		LoginForm loginForm = (LoginForm) form;// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			Users users = usersBusiness.getUser(loginForm);
			if(users!=null){
				HttpSession session = request.getSession();
				session.setAttribute("users", users);
				//session.setMaxInactiveInterval(5);
				out.print("<font color='red'>"+loginForm.getUsername()+"</font>恭喜你登陆成功！");
				out.println("<script>window.location.href='"+request.getContextPath()+"/jsp/news_index.jsp';</script>");
			}else{
				out.println("对不起，登陆失败");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 注册的方法
	 */
	public ActionForward register(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		LoginForm loginForm = (LoginForm) form;// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			if(!usersBusiness.isExitUserName(loginForm)){
				if(usersBusiness.addUser(loginForm)){
					out.print("<font color='red'>"+loginForm.getUsername()+"</font>恭喜你注册成功！");
					out.print("</br>");
					out.print("用户名："+loginForm.getUsername());
					out.print("</br>");
					out.print("密&nbsp;&nbsp;&nbsp;&nbsp;码："+loginForm.getPassword());
					out.print("</br>");
					out.print("<a href='"+request.getContextPath()+"/register.jsp'><<<返回</a>");
					out.print("&nbsp;&nbsp;&nbsp;&nbsp;");
					out.print("<a href='"+request.getContextPath()+"/login.jsp'>登陆>>></a>");
				}else{
					out.print("对不起注册失败!");
					out.print("</br>");
					out.print("<a href='"+request.getContextPath()+"/register.jsp'><<<返回</a>");
				}
			}else{
				out.print("用户<font color='red'>"+loginForm.getUsername()+"</font>名已存在!");
				out.print("</br>");
				out.print("<a href='"+request.getContextPath()+"/register.jsp'><<<返回</a>");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
