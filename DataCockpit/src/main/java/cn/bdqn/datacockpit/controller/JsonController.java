/**
 * Project Name:adminlte
 * File Name:JsonController.java
 * Package Name:cn.bdqn.lesson.controller
 * Date:2017年8月21日下午3:45:28
 * Copyright (c) 2017, bluemobi All Rights Reserved.
 */

package cn.bdqn.datacockpit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.bdqn.datacockpit.datatable.DatatableResult;
import cn.bdqn.datacockpit.datatable.IsSearchCondition;
import cn.bdqn.datacockpit.datatable.SearchCondition;
import cn.bdqn.datacockpit.entity.Info;
import cn.bdqn.datacockpit.entity.Userinfo;
import cn.bdqn.datacockpit.service.InfoService;
import cn.bdqn.datacockpit.service.UserinfoService;

/**
 * Description: <br/>
 * Date: 2017年8月21日 下午3:45:28 <br/>
 * 
 * @author junwen.bao@airintelli.com
 * @version
 * @see
 */
@Controller
public class JsonController {
    @Autowired
    private UserinfoService us;

    @Autowired
    private InfoService ifo;

    @RequestMapping(value = "dt_list")
    public DatatableResult<Userinfo> datatable(@IsSearchCondition SearchCondition searchCondition) {
        DatatableResult<Userinfo> list = new DatatableResult<>();
        Userinfo rec = new Userinfo();
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "dt_list2")
    public DatatableResult<Userinfo> datatable2(@RequestBody SearchCondition searchCondition) {
        DatatableResult<Userinfo> list = new DatatableResult<>();
        List<Userinfo> list2 = us.selectAllUserinfo();
        list.setData(list2);
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "dt_lists3")
    public DatatableResult<Info> datatable23(@RequestBody SearchCondition searchCondition) {
        DatatableResult<Info> list = new DatatableResult<>();
        List<Info> list2 = ifo.selectAllInfo();
        list.setData(list2);
        return list;
    }
}
