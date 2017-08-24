package cn.bdqn.datacockpit.tiles;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ehsy_it on 2016/8/10.
 */
@Controller
public class AdminTilesController {

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
}
