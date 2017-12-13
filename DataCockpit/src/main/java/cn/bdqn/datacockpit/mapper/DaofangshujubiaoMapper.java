package cn.bdqn.datacockpit.mapper;

import java.util.List;

import cn.bdqn.datacockpit.entity.Daofangshujubiao;
import cn.bdqn.datacockpit.entity.Xiaoshoushujubiao;

public interface DaofangshujubiaoMapper {
	 //通过表名，查询出相应数据信息
    List<Daofangshujubiao> selectByBname(String name);
}
