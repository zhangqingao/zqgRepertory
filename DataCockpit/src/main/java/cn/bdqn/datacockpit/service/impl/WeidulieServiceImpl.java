package cn.bdqn.datacockpit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bdqn.datacockpit.entity.Weidulie;
import cn.bdqn.datacockpit.mapper.WeidulieMapper;
import cn.bdqn.datacockpit.service.WeidulieService;
@Service
public class WeidulieServiceImpl implements WeidulieService {
	@Autowired
	private WeidulieMapper weidulieMapper;
	
	@Override
	public List<Weidulie> selectByguanlianId(Integer id) {
		// TODO Auto-generated method stub
		return weidulieMapper.selectByguanlianId(id);
	}

}
