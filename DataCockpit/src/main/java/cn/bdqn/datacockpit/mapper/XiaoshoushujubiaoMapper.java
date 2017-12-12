package cn.bdqn.datacockpit.mapper;

import java.util.List;

import cn.bdqn.datacockpit.entity.Tableinfo;
import cn.bdqn.datacockpit.entity.Xiaoshoushujubiao;

public interface XiaoshoushujubiaoMapper {
	 //通过表名，查询出相应数据信息
    List<Xiaoshoushujubiao> selectByBname(String name);
}
