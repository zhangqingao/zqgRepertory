package cn.bdqn.datacockpit.realm;


import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import cn.bdqn.datacockpit.entity.Companyinfo;
import cn.bdqn.datacockpit.entity.Userinfo;
import cn.bdqn.datacockpit.service.CompanyinfoService;
import cn.bdqn.datacockpit.service.UserinfoService;



public class MyRealm extends AuthorizingRealm{

	@Autowired
	private UserinfoService userService;
	@Autowired
	private CompanyinfoService companyService;
	
	/**
	 * 为当前登录的用户授予角色和权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String phone=(String)principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
		authorizationInfo.setRoles(userService.getRoles(phone));
		authorizationInfo.setRoles(companyService.getCRoles(phone));
		authorizationInfo.setStringPermissions(userService.getPermissions(phone));
		authorizationInfo.setStringPermissions(companyService.getCPermissions(phone));
		return authorizationInfo;
	}

	/**
	 * 验证当前登录的用户
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String phone=(String)token.getPrincipal();
			AuthenticationInfo authcInfo=null;
			try {
			    Userinfo user=userService.getByPhone(phone);
			    Companyinfo company=companyService.getByCPhone(phone);
			    if(company==null){
			    	 authcInfo=new SimpleAuthenticationInfo(user.getPhone(),user.getPassword(),"xx");
			    }else
			    if(user==null){
			    	authcInfo=new SimpleAuthenticationInfo(company.getPhone(),company.getPassword(),"xx");
			    }
                return authcInfo;
            } catch (Exception e) {
               
                e.printStackTrace();
                
            }
            return null;
	}

}
