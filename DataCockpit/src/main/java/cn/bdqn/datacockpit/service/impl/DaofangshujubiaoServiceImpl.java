package cn.bdqn.datacockpit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bdqn.datacockpit.entity.Daofangshujubiao;
import cn.bdqn.datacockpit.mapper.DaofangshujubiaoMapper;
import cn.bdqn.datacockpit.service.DaofangshujubiaoService;
@Service
public class DaofangshujubiaoServiceImpl implements DaofangshujubiaoService {
	@Autowired
	private DaofangshujubiaoMapper daofangshujubiao;
	@Override
	public List<Daofangshujubiao> selectByBname(String name) {
		// TODO Auto-generated method stub
		return daofangshujubiao.selectByBname(name);
	}
	
}
