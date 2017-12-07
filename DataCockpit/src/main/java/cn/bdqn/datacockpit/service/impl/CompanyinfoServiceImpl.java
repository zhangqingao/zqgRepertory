package cn.bdqn.datacockpit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bdqn.datacockpit.entity.Companyinfo;
import cn.bdqn.datacockpit.mapper.CompanyinfoMapper;
import cn.bdqn.datacockpit.service.CompanyinfoService;

@Service
public class CompanyinfoServiceImpl implements CompanyinfoService {

    @Autowired
    private CompanyinfoMapper companyinfo;

    /**
     * 
     * 查询所有公司信息.
     * 
     * @see cn.bdqn.datacockpit.service.CompanyinfoService#selectAllCompanies()
     */
    @Override
    public List<Companyinfo> selectAllCompanies() {
        return companyinfo.selectAllCompanies();
    }

    /**
     * 
     * 根据指定的公司id删除公司客户.
     * 
     * @see cn.bdqn.datacockpit.service.CompanyinfoService#deleteByPrimaryKey(java.lang.Integer)
     */
    @Override
    public int deleteByPrimaryKey(Integer id) {
        int flag = companyinfo.deleteByPrimaryKey(id);
        return flag;
    }

    /**
     * 
     * 添加新的公司客户.
     * 
     * @see cn.bdqn.datacockpit.service.CompanyinfoService#insert(cn.bdqn.datacockpit.entity.Companyinfo)
     */
    @Override
    public int insert(Companyinfo record) {
        int flag = companyinfo.insert(record);
        return flag;
    }

    /**
     * 
     * 动态查询公司信息.
     * 
     * @see cn.bdqn.datacockpit.service.CompanyinfoService#insertSelective(cn.bdqn.datacockpit.entity.Companyinfo)
     */
    @Override
    public int insertSelective(Companyinfo record) {
        int flag = companyinfo.insertSelective(record);
        return flag;
    }

    /**
     * 
     * 查询指定的公司信息.
     * 
     * @see cn.bdqn.datacockpit.service.CompanyinfoService#selectByPrimaryKey(java.lang.Integer)
     */
    @Override
    public Companyinfo selectByPrimaryKey(Integer id) {
        return companyinfo.selectByPrimaryKey(id);
    }

    /**
     * 
     * 动态修改公司客户信息.
     * 
     * @see cn.bdqn.datacockpit.service.CompanyinfoService#updateByPrimaryKeySelective(cn.bdqn.datacockpit.entity.Companyinfo)
     */
    @Override
    public int updateByPrimaryKeySelective(Companyinfo record) {
        int flag = companyinfo.updateByPrimaryKeySelective(record);
        return flag;
    }

    /**
     * 
     * 修改指定公司的信息.
     * 
     * @see cn.bdqn.datacockpit.service.CompanyinfoService#updateByPrimaryKey(cn.bdqn.datacockpit.entity.Companyinfo)
     */
    @Override
    public int updateByPrimaryKey(Companyinfo record) {
        int flag = companyinfo.updateByPrimaryKey(record);
        return flag;
    }

    /**
     * 根据phone查询登录状况
     */
    @Override
    public Companyinfo selectByPhone(String phone) {

        return companyinfo.selectByPhone(phone);
    }

    /**
     * 根据phone查注册号码是否存在
     */
    @Override
    public int selectPhoneNum(String phone) {

        return companyinfo.selectPhoneNum(phone);
    }

	@Override
	public List<Companyinfo> selectPassCompanies() {
		// TODO Auto-generated method stub
		return companyinfo.selectPassCompanies();
	}

}
