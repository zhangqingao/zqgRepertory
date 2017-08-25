package cn.bdqn.datacockpit.mapper;

import cn.bdqn.datacockpit.entity.Tableinfo;

public interface TableinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tableinfo record);

    int insertSelective(Tableinfo record);

    Tableinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tableinfo record);

    int updateByPrimaryKey(Tableinfo record);
}