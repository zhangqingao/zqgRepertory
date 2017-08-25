/**
 * Project Name:DataCockpit
 * File Name:TableinfoServiceImpl.java
 * Package Name:cn.bdqn.datacockpit.service.impl
 * Date:2017年8月25日下午1:48:19
 * Copyright (c) 2017, bluemobi All Rights Reserved.
 *
*/

package cn.bdqn.datacockpit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.bdqn.datacockpit.entity.Tableinfo;
import cn.bdqn.datacockpit.mapper.TableinfoMapper;
import cn.bdqn.datacockpit.service.TableinfoService;

/**
 * Description:	   <br/>
 * Date:     2017年8月25日 下午1:48:19 <br/>
 * @author   caoS
 * @version  
 * @see 	 
 */
public class TableinfoServiceImpl implements TableinfoService {
    
    @Autowired
    TableinfoMapper tableinfo;
    
    @Override
    public List<Tableinfo> selectAllTableInfo() {
        return tableinfo.selectAllTableInfo();
    }
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        int flag=tableinfo.deleteByPrimaryKey(id);
        return flag;
    }

    @Override
    public int insert(Tableinfo record) {
        int flag=tableinfo.insert(record);
        return flag;
    }

    @Override
    public int insertSelective(Tableinfo record) {
        int flag=tableinfo.insertSelective(record);
        return flag;
    }

    @Override
    public Tableinfo selectByPrimaryKey(Integer id) {
        return tableinfo.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Tableinfo record) {
        int flag=tableinfo.updateByPrimaryKeySelective(record);
        return flag;
    }

    @Override
    public int updateByPrimaryKey(Tableinfo record) {
        int flag=tableinfo.updateByPrimaryKey(record);
        return flag;
    }

    

}

