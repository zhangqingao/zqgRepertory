package cn.bdqn.datacockpit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.bdqn.datacockpit.entity.Userinfo;
import cn.bdqn.datacockpit.service.UserinfoService;

/**
 * Created by ehsy_it on 2016/8/10.
 */
@Controller
public class AdminTilesController {

    @Autowired
    private UserinfoService us;

    @RequestMapping("/admin_index")
    public String index(Model model) {
        return "admin_index.page";
    }

    @RequestMapping("/admin_tongzhi1")
    public String tongzhi1(Model model) {
        return "admin_tongzhi1.page";
    }

    @RequestMapping("/admin_tongzhi2")
    public String tongzhi2(Model model) {
        return "admin_tongzhi2.page";
    }

    @RequestMapping("/admin_tongzhi3")
    public String tongzhi3(Model model) {
        return "admin_tongzhi3.page";
    }

    @RequestMapping("/admin_shuju1")
    public String shuju1(Model model) {
        return "admin_shuju1.page";
    }

    @RequestMapping("/admin_shuju2")
    public String shuju2(Model model) {
        return "admin_shuju2.page";
    }

    @RequestMapping("/admin_shuju3")
    public String shuju3(Model model) {
        return "admin_shuju3.page";
    }

    @RequestMapping("/admin_shuju4")
    public String shuju4(Model model) {
        return "admin_shuju4.page";
    }

    @RequestMapping("insertAdminReg")
    public String insertAdminReg(Userinfo record) {
        System.out.println(record);
        int flag = us.insertSelective(record);
        System.out.println("------------------flag为：" + flag);
        // 转发
        return "login";
    }

    @RequestMapping("/selectAllUserinfo")
    @Transactional(readOnly = true)
    public String selectAllUserinfo(Model model) {

        List<Userinfo> lists = us.selectAllUserinfo();
        System.out.println(lists);
        model.addAttribute("lists", lists);

        // 转发
        return "admin_shuju4.page";
    }
}
