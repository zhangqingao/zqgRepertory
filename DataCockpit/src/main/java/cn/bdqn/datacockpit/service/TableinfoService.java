/**
 * Project Name:DataCockpit
 * File Name:TableinfoService.java
 * Package Name:cn.bdqn.datacockpit.service
 * Date:2017年8月25日上午10:53:12
 * Copyright (c) 2017, bluemobi All Rights Reserved.
 *
 */

package cn.bdqn.datacockpit.service;

import java.util.HashMap;
import java.util.List;

import cn.bdqn.datacockpit.entity.Datarelation;
import cn.bdqn.datacockpit.entity.Tableinfo;
import cn.bdqn.datacockpit.entity.Tablerelation2;

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
    
 List<Tablerelation2> selecttablerelation(Integer cid);
    
    List< Tableinfo> selectallbyid(Integer cid);
    
    String selectnamebyid(Integer id);
    
    int updaterestate(HashMap map);
    
    List<Datarelation> listreonlyone(HashMap map);
    
    int myinsert(HashMap map);
    
    List<Datarelation> selectstate(HashMap map);
    
    List<Datarelation> selectname(HashMap map);
    }
