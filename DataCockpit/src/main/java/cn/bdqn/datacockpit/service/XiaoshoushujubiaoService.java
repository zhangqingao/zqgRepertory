package cn.bdqn.datacockpit.service;

import java.util.List;

import cn.bdqn.datacockpit.entity.Xiaoshoushujubiao;

public interface XiaoshoushujubiaoService {
	 //通过表名，查询出相应数据信息
    List<Xiaoshoushujubiao> selectByBname(String name);
}
