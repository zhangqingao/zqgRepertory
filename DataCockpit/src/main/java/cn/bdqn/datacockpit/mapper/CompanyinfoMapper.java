package cn.bdqn.datacockpit.mapper;

import java.util.List;
import java.util.Set;

import cn.bdqn.datacockpit.entity.Companyinfo;
import cn.bdqn.datacockpit.entity.Userinfo;

public interface CompanyinfoMapper {
	List<Companyinfo> selectnoPassCompanies();
	List<Companyinfo> selectPassCompanies();
    List<Companyinfo> selectAllCompanies();

    int deleteByPrimaryKey(Integer id);

    int insert(Companyinfo record);

    int insertSelective(Companyinfo record);

    Companyinfo selectByPrimaryKey(Integer id);

    Companyinfo selectByPhone(String phone);
//
    int updateByPrimaryKeySelective(Companyinfo record);

    int updateByPrimaryKey(Companyinfo record);

    int selectPhoneNum(String phone);
    
    /**
     * shiro通过电话号查询用户
     * @param userName
     * @return
     */
    public Companyinfo getByCPhone(String phone);
    
    /**
     * shiro通过电话号查询角色信息
     * @param userName
     * @return
     */
    public Set<String> getCRoles(String phone);
    
    /**
     * shiro通过电话号查询权限信息
     * @param userName
     * @return
     */
    public Set<String> getCPermissions(String phone);
}