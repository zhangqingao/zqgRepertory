/**
 * Project Name:DataCockpit
 * File Name:TableinfoService.java
 * Package Name:cn.bdqn.datacockpit.service
 * Date:2017年8月25日上午11:43:06
 * Copyright (c) 2017, bluemobi All Rights Reserved.
 *
*/

package cn.bdqn.datacockpit.service;

import cn.bdqn.datacockpit.entity.Tableinfo;

/**
 * Description:	   <br/>
 * Date:     2017年8月25日 上午11:43:06 <br/>
 * @author   caoS
 * @version  
 * @see 	 
 */
public interface TableinfoService {
    int deleteByPrimaryKey(Integer id);

    int insert(Tableinfo record);

    int insertSelective(Tableinfo record);

    Tableinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tableinfo record);

    int updateByPrimaryKey(Tableinfo record);
}

