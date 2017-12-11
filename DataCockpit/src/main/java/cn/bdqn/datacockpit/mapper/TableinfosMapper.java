package cn.bdqn.datacockpit.mapper;

import java.util.List;

import cn.bdqn.datacockpit.entity.Tableinfos;

public interface TableinfosMapper {
	//通过关联的关系查出，关联的表
	List<Tableinfos> selectByguanlianId(Integer id);
}
