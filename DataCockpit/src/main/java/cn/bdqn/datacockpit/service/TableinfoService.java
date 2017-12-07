/**
 * Project Name:DataCockpit
 * File Name:TableinfoService.java
 * Package Name:cn.bdqn.datacockpit.service
 * Date:2017年8月25日上午10:53:12
 * Copyright (c) 2017, bluemobi All Rights Reserved.
 *
 */

package cn.bdqn.datacockpit.service;

import java.util.List;

import cn.bdqn.datacockpit.entity.Tableinfo;

/**
 * Description: <br/>
 * Date: 2017年8月25日 上午10:53:12 <br/>
 * 
 * @author yuanX
 * @version
 * @see
 */
public interface TableinfoService {
    List<Tableinfo> selectAll(Integer id);

    int insert(Tableinfo record);
    
  //通过添加的表格名，修改更新时间
    int updateByTbname(String name);
   
  //通过添加的表明名，查询出更新时间
    Tableinfo selectByTbname(String name);
    }
