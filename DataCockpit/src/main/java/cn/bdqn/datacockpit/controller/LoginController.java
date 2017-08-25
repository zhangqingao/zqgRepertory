/**
 * Project Name:DataCockpit
 * File Name:LoginController.java
 * Package Name:cn.bdqn.datacockpit.controller
 * Date:2017年8月23日上午9:44:48
 * Copyright (c) 2017, bluemobi All Rights Reserved.
 *
 */
/**
 * 
 */

package cn.bdqn.datacockpit.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.bdqn.datacockpit.entity.Companyinfo;
import cn.bdqn.datacockpit.service.CompanyinfoService;

/**
 * Description: <br/>
 * Date: 2017年8月23日 上午9:44:48 <br/>
 * 
 * @author jiaoHJ
 * @version
 * @see
 */
@Controller
@Scope("prototype")
public class LoginController {
    @Autowired
    private CompanyinfoService companyinfo;

    @RequestMapping("/insertInfo")
    public void insertInfo() {
        Companyinfo record = new Companyinfo();
        record.setName("海军");
        int flag = companyinfo.insert(record);
        System.out.println(flag);
    }

    @RequestMapping("/deleteInfo")
    public void deleteInfo() {

        int flag = companyinfo.deleteByPrimaryKey(1);
        System.out.println(flag);
    }

    @RequestMapping("/login")
    public String login(String phone,String password,HttpServletRequest request){
       phone = request.getParameter("phone");
       password = request.getParameter("password");
       Subject subject = SecurityUtils.getSubject();
       UsernamePasswordToken token = new UsernamePasswordToken(phone, password);
       token.setRememberMe(true);
       try{
           subject.login(token);
           return "success";
       }catch (IncorrectCredentialsException e) {  
           token.clear();
           request.setAttribute("error", "用户或密码不正确！");
           return "login";
       }  
    }

    @RequestMapping("/testLogin")
    public String testLogin(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if ("login".equals(cookie.getName())) {
                return "front/success";
            }
        }

        return "front/error";
    }

    @RequestMapping("/register")
    public String register(Companyinfo cominfo) {
        int flag = companyinfo.insert(cominfo);
        if (flag >= 1) {
            return "front/shenqing";
        }

        return "front/error";
    }
}
