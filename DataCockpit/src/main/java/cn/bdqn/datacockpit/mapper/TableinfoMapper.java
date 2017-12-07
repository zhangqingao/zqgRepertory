package cn.bdqn.datacockpit.mapper;


import java.util.List;

import cn.bdqn.datacockpit.entity.Tableinfo;

public interface TableinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tableinfo record);

    int insertSelective(Tableinfo record);

    Tableinfo selectByPrimaryKey(Integer id);

    List<Tableinfo> selectAll(Integer id);

    int updateByPrimaryKeySelective(Tableinfo record);

    int updateByPrimaryKey(Tableinfo record);
    
    //通过添加的表格名，修改更新时间
    int updateByTbname(String name);
    
    //通过添加的表明名，查询出更新时间
    Tableinfo selectByTbname(String name);
}