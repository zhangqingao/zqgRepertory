package cn.bdqn.datacockpit.utils;

import java.util.HashMap;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
// @classDescription: 用户单点登录session监听 
public class SessionListener implements HttpSessionListener {
	public static HashMap<String, HttpSession> sessionMap = new HashMap();       
	public void sessionCreated(HttpSessionEvent event) {              
 		// TODO Auto-generated method stub                
		HttpSession session = event.getSession(); 
		// 初始化当前session                
		sessionMap.put(session.getId(), session);  
		System.out.println("初始化session："+session.getId());
	  }
	public void sessionDestroyed(HttpSessionEvent event) {
    HttpSession session = event.getSession();
	 // 判断当前session phone是否有值               
	 if (session.getAttribute("phone")!= null&&session.getAttribute("phone").toString().length()>0) {           
		 // session销毁清空map 更新map                        
		 sessionMap.remove(session.getAttribute("phone").toString());                        
		 session.removeAttribute("phone");
		 System.out.println("完全销毁session："+session.getId());
	 }      
   }
}