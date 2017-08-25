package cn.bdqn.datacockpit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ehsy_it on 2016/8/10.
 */
@Controller
public class UserTilesController {

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

}
