package cn.bdqn.datacockpit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.bdqn.datacockpit.entity.Info;
import cn.bdqn.datacockpit.service.InfoService;

/**
 * Created by ehsy_it on 2016/8/10.
 */
@Controller
public class UserTilesController {
    @Autowired
    private InfoService infoService;

    @RequestMapping("/user_pass")
    public String pass(Model model) {
        return "user_pass.pages";
    }

    @RequestMapping("/user_update")
    public String update(Model model) {
        return "user_update.pages";
    }

    @RequestMapping("/user_index")
    public String index(Model model) {
        return "user_index.pages";
    }

    @RequestMapping("/user_shuju1")
    public String shuju1(Model model) {
        return "user_shuju1.pages";
    }

    @RequestMapping("/user_shuju2")
    public String shuju2(Model model) {
        return "user_shuju2.pages";
    }

    @RequestMapping("/user_shuju3")
    public String shuju3(Model model) {
        return "user_shuju3.pages";
    }

    @RequestMapping("/user_tongzhi")
    public String user_tongzhi(Model model) {
        List<Info> lists = infoService.selectAllInfo();
        model.addAttribute("infoList", lists);
        return "user_tongzhi.pages";
    }
}
