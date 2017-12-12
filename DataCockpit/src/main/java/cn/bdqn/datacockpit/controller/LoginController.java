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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.subject.Subject;
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
import cn.bdqn.datacockpit.utils.SessionListener;
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

	private Subject currentUser;

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
            session.setAttribute("code", verifyCode.toLowerCase()); 
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

    @RequestMapping("/login2")
    public String login(HttpSession session, HttpServletResponse res, HttpServletRequest req) {
        session = req.getSession();
        String phone = (String) session.getAttribute("phone");
        List<Map<String, Object>> lists = new ArrayList<Map<String, Object>>();
        Companyinfo compi = companyinfo.selectByPhone(phone);
        Userinfo ui = userinfo.getByPhone(phone);
        // 从session获取验证码方法中存入的验证码
        @SuppressWarnings("unused")
        String trueCode = (String) session.getAttribute("code");
        // 对比验证码
        /*
         * if(!trueCode.equals(code2)){ //验证码不正确则返回不正确
         * req.setAttribute("erroMessage", "*验证码不正确"); }
         */
        // 根据账号判断该用户属于公司还是管理员
        List<Info> infoList = infoService.selectAllInfo();
        Date time = new Date();
        Date ti1 = new Date(time.getTime() - 7 * 24 * 60 * 60 * 1000);
        for (Info info : infoList) {
            Date date = info.getPublishDate();
            Map<String, Object> map = new HashMap<String, Object>();
            if (ti1.before(date)) {//判定是否拥有登陆权限
                map.put("date", 1);
            } else {
                map.put("date", 0);
            }

            map.put("info", info);
            lists.add(map);

        }
        //验证输入不为空
        if (compi != null) {
            session.setAttribute("infos", compi);
            session.setAttribute("flag", lists);
            return "redirect:/user_index.shtml";
        }
        // 判断账号密码是否正确（管理员）
        if (ui != null) {
            session.setAttribute("infos", ui);
            session.setAttribute("flag", lists);
            return "redirect:/selectAllCompanyinfo.shtml";
        }
        session.setAttribute("erroMessage", "*请勿重复登陆同一账号！");
        return "redirect:/login.jsp";
    }

    /*
     * shiro方法登录
     */
    @RequestMapping("/login")
    public String login(Userinfo user, String code2, HttpSession session, HttpServletRequest request) {
        // 首先判断验证码是否正确
        String trueCode = (String) session.getAttribute("code");
        Map<String, String> loginUserMap =new HashMap<String, String>();
        if (!code2.equals(trueCode)) {
            session.setAttribute("erroMessage", "*验证码错误！");
            return "redirect:/login.jsp";
        }
        //从SecurityUtils里创建一个subject
        Subject subject = SecurityUtils.getSubject();
        //在认证提交前准备 toke（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(user.getPhone(), user.getPassword());
        try {
        	//执行认证（通过）subject载入令牌
            subject.login(token);
            //获取subject里的session
            Session session2 = subject.getSession();
            //判断是否认证通过
            boolean isAuthenticated= subject.isAuthenticated();
            if(isAuthenticated){
            	System.out.println("认证通过。");
            }
            //把验证的手机号存起来
            session.setAttribute("phone", user.getPhone());
            //把登陆的用户存进session监听
            if(SessionListener.sessionMap.get(user.getPhone().trim())!=null&&
            	SessionListener.sessionMap.get(user.getPhone().trim()).toString().length()>0){
            	// 当前用户已经在线 删除用户
                HttpSession sessionold = (HttpSession) SessionListener.sessionMap.get(user.getPhone().trim());
                // 注销已在线用户session
                //sessionold.invalidate();
                sessionold.removeAttribute("phone");
                //session = request.getSession(true);
                SessionListener.sessionMap.remove(user.getPhone().trim());
                // 清除已在线用户，更新map key 当前用户 value session对象
                SessionListener.sessionMap.put(user.getPhone().trim(), session);
                SessionListener.sessionMap.remove(session.getId());
		        } else {
		                // 根据当前sessionid 取session对象。 更新map key=用户名 value=session对象 删除map
		                // key= sessionid
		        	SessionListener.sessionMap.get(session.getId());
		        	SessionListener.sessionMap.put(user.getPhone().trim(),SessionListener.sessionMap.get(session.getId()));
		        	SessionListener.sessionMap.remove(session.getId());
		        }
            
            //shiro验证通过返回给login2，判断权限
            return "redirect:/login2.shtml";

        }catch (Exception e) {
        	//出现异常，重新登陆
            e.printStackTrace();
            session.setAttribute("erroMessage", "*用户名或密码错误！");
            return "redirect:/login.jsp";
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
            return "front/shenqing.jsp";
        }

        return "front/error.jsp";
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
    @RequestMapping("/updatePassword2")
    public String updatePassword2(Userinfo user ) {
        int flag = userinfo.updateByPrimaryKeySelective(user);
        if (flag >= 1) {
            return "redirect:/admin_index.shtml";
        }
        return "redirect:/admin_pass.shtml";
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
        Subject subject = SecurityUtils.getSubject();
		//退出操作
        subject.logout();
        //判断是否认证通过
        boolean isAuthenticated= subject.isAuthenticated();
        if(!isAuthenticated){
        	System.out.println("退出通过。");
        }
        return "front/exit.jsp";
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
        List<Info> lists = infoService.selectAllInfo();
        model.addAttribute("infoList", lists);
        return "user_tongzhi.pages";
    }
}
