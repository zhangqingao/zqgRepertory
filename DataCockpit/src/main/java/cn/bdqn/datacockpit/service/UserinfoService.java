/**
 * Project Name:DataCockpit
 * File Name:UserinfoService.java
 * Package Name:service
 * Date:2017年8月21日下午1:57:45
 * Copyright (c) 2017, bluemobi All Rights Reserved.
 *
*/

package cn.bdqn.datacockpit.service;

import java.util.List;

import cn.bdqn.datacockpit.entity.Userinfo;

/**
 * Description: <br/>
 * Date: 2017年8月21日 下午1:57:45 <br/>
 * 
 * @author caoS
 * @version
 * @see
 */
public interface UserinfoService {

    List<Userinfo> selectAllUserinfo();

    int deleteByPrimaryKey(Integer id);

    int insert(Userinfo record);

    int insertSelective(Userinfo record);

    Userinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Userinfo record);

    int updateByPrimaryKey(Userinfo record);
}
