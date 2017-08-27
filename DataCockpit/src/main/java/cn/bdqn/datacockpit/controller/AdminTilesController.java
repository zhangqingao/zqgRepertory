package cn.bdqn.datacockpit.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.bdqn.datacockpit.entity.Companyinfo;
import cn.bdqn.datacockpit.entity.Info;
import cn.bdqn.datacockpit.entity.Userinfo;
import cn.bdqn.datacockpit.service.CompanyinfoService;
import cn.bdqn.datacockpit.service.InfoService;
import cn.bdqn.datacockpit.service.UserinfoService;

/**
 * Created by ehsy_it on 2016/8/10.
 */
@Controller
public class AdminTilesController {

    @Autowired
    private UserinfoService us;

    @Autowired
    private InfoService is;

    @Autowired
    private CompanyinfoService companyinfo;

    @RequestMapping("/admin_index")
    public String index(Model model) {
        return "admin_index.page";
    }

    /**
     * 
     * Description: 管理员通知页面<br/>
     *
     * @author dengJ
     * @param model
     * @return
     */
    @RequestMapping("/admin_tongzhi1")
    public String tongzhi1(Model model) {
        model.addAttribute("menus", "1");
        return "admin_tongzhi1.page";
    }

    /**
     * 
     * Description: 添加通知页面<br/>
     *
     * @author dengJ
     * @param model
     * @return
     */
    @RequestMapping("/admin_tongzhi2")
    public String tongzhi2(Model model) {
        return "admin_tongzhi2.page";
    }

    @RequestMapping("/admin_tongzhi3")
    public String tongzhi3(Model model, HttpServletRequest req) {
        // 获取id
        Integer id = Integer.parseInt(req.getParameter("id"));
        Info info = is.selectByPrimaryKey(id);
        model.addAttribute("info", info);
        return "admin_tongzhi3.page";
    }

    @RequestMapping("/tongzhi_update")
    public String tongzhi_update(Info info) {
        // 获取实体类信息
        is.updateByPrimaryKeySelective(info);
        return "admin_tongzhi1.page";
    }

    /**
     * 
     * Description: 添加通知<br/>
     *
     * @author dengJ
     * @param info
     * @return
     */
    @RequestMapping("/tongzhi_insert")
    public String tongzhi_insert(Info info) {
        // 获取实体类信息，将新增数据存入数据库
        is.insertSelective(info);
        // 获取本地时间与数据库时间格式一致
        java.util.Date date = new java.util.Date();
        java.sql.Date data1 = new java.sql.Date(date.getTime());
        info.setPublishDate(data1);
        // 获取最新一条记录ID
        Integer infoMax = is.selectMaxId();
        System.out.println(infoMax);
        info.setId(infoMax);
        // 将时间存入最后一条记录中
        is.updateByPrimaryKey(info);
        return "admin_tongzhi1.page";
    }

    @RequestMapping("/tongzhi_delete")
    public String tongzhi_delete(HttpServletRequest req) {
        // 获取id
        Integer id = Integer.parseInt(req.getParameter("id"));
        is.deleteByPrimaryKey(id);
        return "admin_tongzhi1.page";
    }

    @RequestMapping("/admin_delete")
    public String admin_delete(HttpServletRequest req) {
        // 获取id
        Integer id = Integer.parseInt(req.getParameter("id"));
        us.deleteByPrimaryKey(id);
        return "admin_shuju4.page";
    }

    @RequestMapping("/admin_shuju1")
    public String shuju1(Model model) {
        model.addAttribute("menus", "3");
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
        model.addAttribute("menus", "2");
        return "admin_shuju4.page";
    }

    @RequestMapping("insertAdminReg")
    public String insertAdminReg(Userinfo record) {
        System.out.println(record);
        int flag = us.insertSelective(record);
        System.out.println("------------------flag为：" + flag);
        // 转发
        return "admin_shuju4.page";
    }

    @RequestMapping("/selectAllCompanyinfo")
    public String selectAllCompanyinfo(Model model, HttpServletRequest req) {
        List<Companyinfo> lists = companyinfo.selectAllCompanies();
        System.out.println(lists);
        model.addAttribute("lists", lists);

        List<Info> infoList = is.selectAllInfo();
        if (infoList != null) {
            for (Info info : infoList) {
                Date date = info.getPublishDate();
                System.out.println(date);
            }
        }
        HttpSession session = req.getSession();
        session.setAttribute("tongzhi", infoList);
        // 转发
        return "admin_index.page";
    }

    @RequestMapping("/admin_userDsh")
    public String dshCompanyinfo(Model model) {

        List<Companyinfo> lists = companyinfo.selectAllCompanies();
        System.out.println(lists);
        model.addAttribute("menus", "5");
        model.addAttribute("lists", lists);

        // 转发
        return "admin_userDsh.page";
    }

    @RequestMapping("/admin_userMan")
    public String userMan(Model model) {

        List<Companyinfo> lists = companyinfo.selectAllCompanies();
        System.out.println(lists);
        model.addAttribute("menus", "4");
        model.addAttribute("lists", lists);

        // 转发
        return "admin_userMan.page";
    }
}
