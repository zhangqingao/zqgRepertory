package cn.bdqn.datacockpit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.bdqn.datacockpit.entity.XsTable;
import cn.bdqn.datacockpit.service.XsTableService;

/**
 * Created by ehsy_it on 2016/8/10.
 */
@Controller
public class UserTilesController {
    @Autowired
    private XsTableService xs;

    @RequestMapping("/user_pass")
    public String pass(Model model) {
        model.addAttribute("checks", "geren2");
        return "user_pass.pages";
    }

    @RequestMapping("/user_update")
    public String update(Model model) {
        model.addAttribute("checks", "geren1");
        return "user_update.pages";
    }

    @RequestMapping("/user_index")
    public String index(Model model) {
        return "user_index.pages";
    }

    @RequestMapping("/user_shuju1")
    public String shuju1(Model model) {
        model.addAttribute("checks", "shuju1");
        return "user_shuju1.pages";
    }

    @RequestMapping("/user_shuju2")
    public String shuju2(Model model) {
        model.addAttribute("checks", "shuju2");
        return "user_shuju2.pages";
    }

    @RequestMapping("/user_shuju3")
    public String shuju3(Model model) {
        model.addAttribute("checks", "shuju3");
        List<XsTable> lists = xs.selectAll();
        model.addAttribute("lists", lists);
        String fNums = "";
        for (int i = 0; i < lists.size(); i++) {
            if (i == lists.size() - 1) {
                fNums = fNums + lists.get(i).getfNums();
            } else {
                fNums = fNums + lists.get(i).getfNums() + ",";
            }
        }
        fNums = "[" + fNums + "]";

        String rNums = "";
        for (int i = 0; i < lists.size(); i++) {

            if (i == lists.size() - 1) {
                rNums = rNums + lists.get(i).getrNums();
            } else {
                rNums = rNums + lists.get(i).getrNums() + ",";
            }
        }
        rNums = "[" + rNums + "]";
        model.addAttribute("rNums", rNums);
        model.addAttribute("fNums", fNums);
        return "user_shuju3.pages";
    }

    @RequestMapping("/user_guanxitu")
    public String userGuanxitu(Model model) {
        model.addAttribute("checks", "shuju4");
        return "user_guanxitu.pages";
    }
}
