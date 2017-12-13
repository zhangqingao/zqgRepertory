package cn.bdqn.datacockpit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bdqn.datacockpit.entity.Xiaoshoushujubiao;
import cn.bdqn.datacockpit.mapper.XiaoshoushujubiaoMapper;
import cn.bdqn.datacockpit.service.XiaoshoushujubiaoService;
@Service
public class XiaoshoushujubiaoServiceImpl implements XiaoshoushujubiaoService {
	@Autowired
	private XiaoshoushujubiaoMapper xiaoshoushujubiao;
	@Override
	public List<Xiaoshoushujubiao> selectByBname(String name) {
		// TODO Auto-generated method stub
		return xiaoshoushujubiao.selectByBname(name);
	}

}
