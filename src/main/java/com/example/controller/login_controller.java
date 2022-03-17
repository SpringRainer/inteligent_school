package com.example.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class login_controller {

    @PostMapping("/get_information")
    @ResponseBody
    public String get_information(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(request.getParameter("user_name"),request.getParameter("user_password"));
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            return "未知错误";
        } catch (AuthenticationException e){
            return "缺少权限";
        }catch (AuthorizationException e) {
            return "账号密码错误";
        }
        return "登录成功";
    }

}
