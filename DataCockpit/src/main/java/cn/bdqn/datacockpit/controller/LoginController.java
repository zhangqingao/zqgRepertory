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
import javax.servlet.http.HttpServletResponse;

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
    public String login(String phone, String password, String onLine, HttpServletResponse res) {
        if ("18313184517".equals(phone) && "12345678".equals(password)) {
            if (onLine != null) {
                Cookie cookie = new Cookie("login", phone);
                Integer time = Integer.parseInt(onLine);
                cookie.setMaxAge(time * 20);
                res.addCookie(cookie);
            }
            return "front/success";
        }
        return "front/error";
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
