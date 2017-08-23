package cn.bdqn.datacockpit.mapper;

import java.util.List;

import cn.bdqn.datacockpit.entity.Userinfo;

public interface UserinfoMapper {
    
    List<Userinfo> selectAllUserinfo();
    
    int deleteByPrimaryKey(Integer id);

    int insert(Userinfo record);

    int insertSelective(Userinfo record);

    Userinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Userinfo record);

    int updateByPrimaryKey(Userinfo record);
}