/**
 * Project Name:DataCockpit
 * File Name:LoginController.java
 * Package Name:cn.bdqn.datacockpit.controller
 * Date:2017年8月23日上午9:44:48
 * Copyright (c) 2017, bluemobi All Rights Reserved.
 *
 */

package cn.bdqn.datacockpit.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    /**
     * 登录
     * 
     * @param phone
     * @param password
     * @param onLine
     * @param res
     * @param req
     * @return
     */

    @RequestMapping("/login")
    public String login(String phone,String password,HttpServletRequest request){
       phone = request.getParameter("phone");
       password = request.getParameter("password");
       Subject subject = SecurityUtils.getSubject();
       UsernamePasswordToken token = new UsernamePasswordToken(phone, password);
       token.setRememberMe(true);
       try{
           subject.login(token);
           return "redirect:/user_index.shtml";
       }catch (IncorrectCredentialsException e) {  
           token.clear();
          /* request.setAttribute("error", "用户或密码不正确！");*/
           return "login";
           }
       }  
    

    /**
     * 注册（申请合作）
     * 
     * @param cominfo
     * @return
     */
    @RequestMapping("/register")
    public String register(Companyinfo cominfo) {
        int flag = companyinfo.insert(cominfo);
        if (flag >= 1) {
            return "front/shenqing";
        }

        return "front/error";
    }

    /**
     * 修改资料，先获取存在session里面的实体类
     * 
     * @param req
     * @return
     */
    @RequestMapping("/updateInfo")
    public String updateInfo(HttpServletRequest req) {
        HttpSession session = req.getSession();
        Companyinfo compi = (Companyinfo) session.getAttribute("info");
        session.setAttribute("comp", compi);

        return "redirect:/user_update.shtml";
    }

    /**
     * 动态修改资料，修改密码不在此页面
     * 
     * @param company
     * @param req
     * @return
     */
    @RequestMapping("/updateInfo1")
    public String updateInfo1(Companyinfo company, HttpServletRequest req) {
        // System.out.println(company);
        HttpSession session = req.getSession();
        int flag = companyinfo.updateByPrimaryKeySelective(company);
        if (flag >= 1) {
            return "redirect:/user_index.shtml";
        }
        session.setAttribute("message", "*修改失败！");
        return "redirect:/user_update.shtml";
    }

    /**
     * 把密码带到页面
     * 
     * @param req
     * @return
     */
    @RequestMapping("/updatePassword")
    public String updatePassword(HttpServletRequest req) {
        HttpSession session = req.getSession();
        Companyinfo compi = (Companyinfo) session.getAttribute("info");
        System.out.println(compi);
        session.setAttribute("comp", compi);
        return "redirect:/user_pass.shtml";
    }

    /**
     * 修改密码
     * 
     * @param company
     * @return
     */
    @RequestMapping("/updatePassword1")
    public String updatePassword1(Companyinfo company) {
        int flag = companyinfo.updateByPrimaryKeySelective(company);
        if (flag >= 1) {
            return "redirect:/user_index.shtml";
        }
        return "redirect:/user_pass.shtml";
    }

    /**
     * 检验注册的手机号码是否存在
     * 
     * @param phone
     * @return
     */
    @RequestMapping("/testPhone")
    @ResponseBody
    public Map<String, Object> testPhone(String phone) {
        int flag = companyinfo.selectPhoneNum(phone);
        Map<String, Object> hm = new HashMap<String, Object>();
        if (flag >= 1) {
            hm.put("num", 1);
            hm.put("error", "*您输入的手机号码已存在！");
        } else {
            hm.put("num", 0);
            hm.put("error", "");
        }
        return hm;
    }

    /**
     * 退出登录
     * 
     * @param req
     * @return
     */
    @RequestMapping("/exit")
    public String exit(HttpServletRequest req) {
        req.getSession().removeAttribute("comp");

        return "user_exit.pages";
    }
}
