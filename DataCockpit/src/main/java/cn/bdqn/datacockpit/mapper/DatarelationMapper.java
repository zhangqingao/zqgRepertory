package cn.bdqn.datacockpit.mapper;

import java.util.List;

import cn.bdqn.datacockpit.entity.Datarelation;

public interface DatarelationMapper {
    List<Datarelation> selectAlldatarelation();
    
  //根据企业cid查询出，关联关系
    List<Datarelation> selectDatarelationBycid(Integer cid);
    
    
    int deleteByPrimaryKey(Integer id);

    int insert(Datarelation record);

    int insertSelective(Datarelation record);
   
    Datarelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Datarelation record);

    int updateByPrimaryKey(Datarelation record);
}