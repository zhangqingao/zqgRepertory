/**
 * Project Name:DataCockpit
 * File Name:RelevanceTable.java
 * Package Name:cn.bdqn.datacockpit.mapper
 * Date:2017年8月29日上午9:12:33
 * Copyright (c) 2017, bluemobi All Rights Reserved.
 *
 */
/**
 * 
 */

package cn.bdqn.datacockpit.mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.bdqn.datacockpit.utils.ChineseToPinYin;
import cn.bdqn.datacockpit.utils.JdbcUtils;

/**
 * Description: <br/>
 * Date: 2017年8月29日 上午9:12:33 <br/>
 * 
 * @author jiaoHJ
 * @version
 * @see
 */

public class RelevanceTable implements RelevanceTableMapper {

//    @Override
//    public List<Map<String, Object>> selectAll() throws Exception {
//        List<Map<String, Object>> lists = new ArrayList<Map<String, Object>>();
//        Connection conn = JdbcUtils.getConnection();
//        String str = "SELECT tt1.id,tt1.name,tt1.tbName AS tbName1,tt1.tcName AS tcName1,tt2.tbName,tt2.tcName FROM (SELECT d.id,d.`name`,t.`name` AS tbName,w.`lie_name` AS tcName FROM datarelation d, tableinfos t,weidulie w WHERE d.`tid1`=t.`id` AND d.`col1`=w.`id` ) AS tt1,(SELECT d.id,d.`name`,t.`name` AS tbName,w.`lie_name` AS tcName FROM datarelation d, tableinfos t,weidulie w WHERE d.`tid2`=t.`id` AND d.`col2`=w.`id`) AS tt2 WHERE tt1.id = tt2.id;";
//        Statement st = conn.createStatement();
//        ResultSet rs = st.executeQuery(str);
//        while (rs.next()) {
//            Integer id = rs.getInt("id");
//            String name = rs.getString("name");
//            String tbName1 = rs.getString("tbName1");
//            String tcName1 = rs.getString("tcName1");
//            String tbName = rs.getString("tbName");
//            String tcName = rs.getString("tcName");
//            Map<String, Object> hm = new HashMap<String, Object>();
//            hm.put("id", id);
//            hm.put("name", name);
//            hm.put("tbName1", tbName1);
//            hm.put("tcName1", tcName1);
//            hm.put("tbName", tbName);
//            hm.put("tcName", tcName);
//            lists.add(hm);
//        }
//        JdbcUtils.close(conn, st, rs);
//        return lists;
//    }
	
	public List<String> selectAll(String name1,int i,String name2,int j) throws Exception {
        List<String> lists = new ArrayList<String>();
        Connection conn = JdbcUtils.getConnection();
        ChineseToPinYin ctp = new ChineseToPinYin();
       String pyname1= ctp.getPingYin(name1);
       String pyname2= ctp.getPingYin(name2);
       System.out.println("pyname1:"+pyname1+"pyname2:"+pyname2);
       String str="SELECT a.*  FROM  "+pyname1+" a WHERE 1=2";
       String str2="SELECT a.*  FROM "+pyname2+" a WHERE 1=2";
        PreparedStatement st1 = conn.prepareStatement(str);
        PreparedStatement st2 = conn.prepareStatement(str2);
       // st1.getParameterMetaData();
        ResultSetMetaData ssr=st1.getMetaData();
        ResultSetMetaData ssr2=st2.getMetaData();
      //  ssr.getColumnCount();//返回有多少个列
        String tbname=ssr.getColumnName(i);
        String tbname2=ssr2.getColumnName(i);
        System.out.println(name1+":"+tbname+"   "+name2+":"+tbname2);
        lists.add(0, tbname);
        lists.add(1, tbname2);//列名
        return lists;
    }

@Override
public HashMap<Integer, Object> selectallname(String name)throws Exception  {
	// TODO Auto-generated method stub
	//List<String> list2=new ArrayList<String>();
	HashMap<Integer, Object> map=new HashMap<Integer, Object>();
	  Connection conn = JdbcUtils.getConnection();
        ChineseToPinYin ctp = new ChineseToPinYin();
       String pyname1= ctp.getPingYin(name);
       String str="SELECT a.*  FROM  "+pyname1+" a WHERE 1=2";
        PreparedStatement st1 = conn.prepareStatement(str);
        ResultSetMetaData ssr=st1.getMetaData();	     
      //  ssr.getColumnCount();//返回有多少个列
        int num=ssr.getColumnCount();
        System.out.println(pyname1+"表一共有多少列"+num);
        String sum;
   
        map.put(0, num);
        for(int i=1;i<num;i++){
        	  String tbname=ssr.getColumnName(i);
        	  map.put(i, tbname);
        	 // list2.add(tbname);
        }
	return map;
}

}