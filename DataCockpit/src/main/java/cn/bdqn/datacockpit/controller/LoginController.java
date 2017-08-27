/**
 * Project Name:DataCockpit
 * File Name:LoginController.java
 * Package Name:cn.bdqn.datacockpit.controller
 * Date:2017年8月23日上午9:44:48
 * Copyright (c) 2017, bluemobi All Rights Reserved.
 *
 */

package cn.bdqn.datacockpit.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.bdqn.datacockpit.entity.Companyinfo;
import cn.bdqn.datacockpit.entity.Info;
import cn.bdqn.datacockpit.entity.Userinfo;
import cn.bdqn.datacockpit.service.CompanyinfoService;
import cn.bdqn.datacockpit.service.InfoService;
import cn.bdqn.datacockpit.service.UserinfoService;
import cn.bdqn.datacockpit.utils.LoggerUtils;
import cn.bdqn.datacockpit.utils.VerifyCodeUtils;

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
    private static final Exception IncorrectCredentialsException = null;

    @Autowired
    private CompanyinfoService companyinfo;

    @Autowired
    private UserinfoService userinfo;

    @Autowired
    private InfoService infoService;

    @RequestMapping(value = "getYzm")
    public @ResponseBody List<String> getYzm(HttpServletResponse response, HttpServletRequest request) {
        List<String> lists = new ArrayList<String>();
        try {
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/jpeg");

            // 生成随机字串
            String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
            // 存入会话session
            HttpSession session = request.getSession(true);
            session.setAttribute("_code", verifyCode.toLowerCase());
            // 生成图片
            int w = 146, h = 33;
            VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);

            lists.add("OK");
            return lists;
        } catch (Exception e) {
            LoggerUtils.fmtError(getClass(), e, "获取验证码异常：%s", e.getMessage());
        }
        return lists;

    }

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
    public String login(String phone, String password, HttpServletResponse res, HttpServletRequest req) {
        Companyinfo compi = companyinfo.selectByPhone(phone);
        Userinfo ui = userinfo.getByPhone(phone);
        List<Info> infoList = infoService.selectAllInfo();
        HttpSession session = req.getSession();
        // 判断账号密码是否正确(用户)
        if (compi != null) {
            if (phone.equals(compi.getPhone()) && password.equals(compi.getPassword())) {

                session.setAttribute("infos", compi);
                session.setAttribute("tongzhi", infoList);
                return "redirect:/user_index.shtml";

            }
        }
        // 判断账号密码是否正确（管理员）
        if (ui != null) {
            if (phone.equals(ui.getPhone()) && password.equals(ui.getPassword())) {

                session.setAttribute("infos", ui);
                return "redirect:/selectAllCompanyinfo.shtml";
            }
        }
        session.setAttribute("mess", "*账号或者密码输入有误！");
        return "redirect:/login.jsp";

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
        Companyinfo compi = (Companyinfo) session.getAttribute("infos");
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
        Companyinfo compi = (Companyinfo) session.getAttribute("infos");
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

    /**
     * 公告详情
     * 
     * @param req
     * @return
     */
    @RequestMapping("/gongGao")
    public String gongGao(Integer id, Model model) {
        // System.out.println(id);
        Info info = infoService.selectByPrimaryKey(id);
        model.addAttribute("gg", info);
        return "user_gongGao.pages";
    }

    /**
     * 公告详情
     * 
     * @param req
     * @return
     */
    @RequestMapping("/selectTongzhi")
    public String selectTongzhi(Model model) {
        // System.out.println(id);
        List<Info> lists = infoService.selectAllInfo();
        model.addAttribute("infoList", lists);
        return "user_tongzhi.pages";
    }
}
