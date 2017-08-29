package cn.bdqn.datacockpit.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.bdqn.datacockpit.datatable.DatatableResult;
import cn.bdqn.datacockpit.datatable.IsSearchCondition;
import cn.bdqn.datacockpit.datatable.SearchCondition;
import cn.bdqn.datacockpit.entity.Tableinfo;
import cn.bdqn.datacockpit.entity.XsTable;
import cn.bdqn.datacockpit.service.TableinfoService;
import cn.bdqn.datacockpit.service.XsTableService;

/**
 * Project Name:DataCockpit
 * File Name:Json2Controller.java
 * Package Name:
 * Date:2017年8月26日下午6:18:40
 * Copyright (c) 2017, bluemobi All Rights Reserved.
 *
 */

/**
 * Description: <br/>
 * Date: 2017年8月26日 下午6:18:40 <br/>
 * 
 * @author yuanX
 * @version
 * @see
 */
@Controller
public class Json2Controller {
    @Autowired
    private XsTableService xs;

    @Autowired
    private TableinfoService ts;

    @ResponseBody
    @RequestMapping(value = "shuju_1")
    public DatatableResult<Map<String, String>> datatable2(@RequestBody SearchCondition searchCondition) {
        DatatableResult<Map<String, String>> list = new DatatableResult<>();
        Map<String, String> map = new HashMap<String, String>();
        map.put("startTime", "1995-3-5 16:20:21");
        map.put("stopTime", "1995-7-5 16:20:21");
        map.put("zt", "已完成");
        List<Map<String, String>> lists = new ArrayList<Map<String, String>>();
        lists.add(map);
        list.setData(lists);
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "shuju_2")
    public DatatableResult<Tableinfo> datatable(@IsSearchCondition SearchCondition searchCondition) {
        DatatableResult<Tableinfo> list = new DatatableResult<>();
        List<Tableinfo> lists = ts.selectAll();
        list.setData(lists);
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "shuju_3")
    public DatatableResult<XsTable> datatable3(@IsSearchCondition SearchCondition searchCondition) {
        DatatableResult<XsTable> list = new DatatableResult<>();
        List<XsTable> lists = xs.selectAll();
        list.setData(lists);
        return list;
    }
}
