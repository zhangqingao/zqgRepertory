package cn.bdqn.datacockpit.service;

import java.util.List;

import cn.bdqn.datacockpit.entity.Companyinfo;

public interface CompanyinfoService {

    /**
     * 查询所有公司信息
     * 
     * @return
     */
    List<Companyinfo> selectAllCompanies();
    
    /**查询通过审核的公司信息
     * @return
     * 
     * 
     */
    List<Companyinfo> selectPassCompanies();
    
    /**查询未通过审核的公司信息
     * @return
     * 
     * 
     */
    List<Companyinfo> selectnoPassCompanies();
    /**
     * 根据公司id删除公司信息
     * 
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 根据公司记录添加公司客户
     * 
     * @param record
     * @return
     */
    int insert(Companyinfo record);

    /**
     * 动态查询公司信息
     * 
     * @param record
     * @return
     */
    int insertSelective(Companyinfo record);

    /**
     * 根据公司id查公司信息
     * 
     * @param id
     * @return
     */
    Companyinfo selectByPrimaryKey(Integer id);

    /**
     * 动态更新公司信息
     * 
     * @param id
     * @return
     */
    int updateByPrimaryKeySelective(Companyinfo record);

    /**
     * 更新公司信息
     * 
     * @param id
     * @return
     */
    int updateByPrimaryKey(Companyinfo record);

    /**
     * 根据phone查登录状况
     * 
     * @param phone
     * @return
     */
    Companyinfo selectByPhone(String phone);

    /**
     * 根据phone查注册号码是否存在
     * 
     * @param phone
     * @return
     */
    int selectPhoneNum(String phone);

}
