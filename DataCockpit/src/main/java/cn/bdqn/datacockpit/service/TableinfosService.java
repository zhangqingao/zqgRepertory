package cn.bdqn.datacockpit.service;

import java.util.List;

import cn.bdqn.datacockpit.entity.Tableinfos;

public interface TableinfosService {
	//通过关联的关系查出，关联的表
	List<Tableinfos> selectByguanlianId(Integer id);
}
