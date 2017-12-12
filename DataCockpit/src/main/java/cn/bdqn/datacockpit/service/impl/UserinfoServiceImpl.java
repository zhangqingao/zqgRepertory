/**
 * Project Name:DataCockpit
 * File Name:UserinfoServiceImpl.java
 * Package Name:service.impl
 * Date:2017年8月21日下午1:58:39
 * Copyright (c) 2017, bluemobi All Rights Reserved.
 *
 */

package cn.bdqn.datacockpit.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bdqn.datacockpit.entity.Userinfo;
import cn.bdqn.datacockpit.mapper.UserinfoMapper;
import cn.bdqn.datacockpit.service.UserinfoService;

/**
 * Description: <br/>
 * Date: 2017年8月21日 下午1:58:39 <br/>
 * 
 * @author caoS
 * @version
 * @see
 */
@Service
public class UserinfoServiceImpl implements UserinfoService {

    @Autowired
    UserinfoMapper userinfoMapper;

    @Override
    public List<Userinfo> selectAllUserinfo() {
        return userinfoMapper.selectAllUserinfo();
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        int flag = userinfoMapper.deleteByPrimaryKey(id);
        return flag;
    }

    @Override
    public int insert(Userinfo record) {
        int flag = userinfoMapper.insert(record);
        return flag;
    }

    @Override
    public int insertSelective(Userinfo record) {
        int flag = userinfoMapper.insertSelective(record);
        return flag;
    }

    @Override
    public Userinfo selectByPrimaryKey(Integer id) {
        return userinfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Userinfo record) {
        int flag = userinfoMapper.updateByPrimaryKeySelective(record);
        return flag;
    }

    @Override
    public int updateByPrimaryKey(Userinfo record) {
        int flag = userinfoMapper.updateByPrimaryKey(record);
        return flag;
    }

    @Override
    public Userinfo getByPhone(String phone) {
        return userinfoMapper.getByPhone(phone);
    }

    @Override
    public Set<String> getRoles(String phone) {
        return userinfoMapper.getRoles(phone);
    }

    @Override
    public Set<String> getPermissions(String phone) {
        return userinfoMapper.getPermissions(phone);
    }

}
