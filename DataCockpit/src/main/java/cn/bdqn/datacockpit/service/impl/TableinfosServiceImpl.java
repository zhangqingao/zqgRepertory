package cn.bdqn.datacockpit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bdqn.datacockpit.entity.Tableinfos;
import cn.bdqn.datacockpit.mapper.TableinfosMapper;
import cn.bdqn.datacockpit.service.TableinfosService;



@Service
public class TableinfosServiceImpl implements TableinfosService {
	@Autowired
	private TableinfosMapper tbs;
	@Override
	public List<Tableinfos> selectByguanlianId(Integer id){
		return tbs.selectByguanlianId(id);
	}

}
