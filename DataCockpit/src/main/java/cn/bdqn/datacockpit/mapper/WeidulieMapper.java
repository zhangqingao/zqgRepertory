package cn.bdqn.datacockpit.mapper;

import java.util.List;

import cn.bdqn.datacockpit.entity.Weidulie;

public interface WeidulieMapper {
		//通过关联关系表名，来查询出维度列关联的字段
	List<Weidulie> selectByguanlianId(Integer id);
}
