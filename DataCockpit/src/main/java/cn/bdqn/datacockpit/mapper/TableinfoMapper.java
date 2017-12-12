package cn.bdqn.datacockpit.mapper;


import java.util.HashMap;
import java.util.List;

import cn.bdqn.datacockpit.entity.Datarelation;
import cn.bdqn.datacockpit.entity.Tableinfo;
import cn.bdqn.datacockpit.entity.Tablerelation2;

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
      
    //新建表时查询是否已经存在该表
    List<Tableinfo> selecttableByName(HashMap<String, Object> map);
    //查询现有的关联关系
    List<Tablerelation2> selecttablerelation(Integer cid);
    //查询当前企业的所有表
    List< Tableinfo> selectallbyid(Integer cid);
    //查询单张表的信息
    String selectnamebyid(Integer id);
    //修改关联关系状态
    int updaterestate(HashMap map);
    
    //查询关联关系是否唯一
    List<Datarelation> listreonlyone(HashMap map);
    //插入关联关系
    int myinsert(HashMap map);
    //单个查询关联关系的信息
    List<Datarelation> selectstate(HashMap map);
    
    //查询关联关系的name是否重复
    List<Datarelation> selectname(HashMap map);

}
