package cn.bdqn.datacockpit.controller;

import java.lang.ProcessBuilder.Redirect;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.bdqn.datacockpit.entity.Analysistasks;
import cn.bdqn.datacockpit.entity.Companyinfo;
import cn.bdqn.datacockpit.entity.Datarelation;
import cn.bdqn.datacockpit.entity.Info;
import cn.bdqn.datacockpit.entity.Tableinfo;
import cn.bdqn.datacockpit.entity.Tablerelation2;
import cn.bdqn.datacockpit.entity.Userinfo;
import cn.bdqn.datacockpit.service.AnalysistasksService;
import cn.bdqn.datacockpit.service.CompanyinfoService;
import cn.bdqn.datacockpit.service.DatarelationService;
import cn.bdqn.datacockpit.service.InfoService;
import cn.bdqn.datacockpit.service.RelevanceTableService;
import cn.bdqn.datacockpit.service.TableinfoService;
import cn.bdqn.datacockpit.service.UserinfoService;
import cn.bdqn.datacockpit.utils.ChineseToPinYin;
import cn.bdqn.datacockpit.utils.JdbcUtil;

/**
 * Created by ehsy_it on 2016/8/10.
 */
@Controller
public class AdminTilesController {
    @Autowired
    private TableinfoService ts;

    @Autowired
    private UserinfoService us;

    @Autowired
    private InfoService is;

    @Autowired
    private CompanyinfoService companyinfo;

    @Autowired
    private DatarelationService dataService;

    @Autowired
    private RelevanceTableService releTable;
    
    @Autowired
    private TableinfoService tableinfo;
    
    @Autowired
    private AnalysistasksService as;

    @RequestMapping("/admin_index")
    public String index(Model model) {
    	 List<Companyinfo> lists = companyinfo.selectnoPassCompanies();
         model.addAttribute("menus", "5");
         model.addAttribute("lists", lists);
        return "admin_index.page";
    }
   

    /**
     * 

     * Description: 管理员通知页面<br/>

     * @author dengJ
     * @param model
     * @return
     */
    @RequestMapping("/admin_tongzhi1")
    public String tongzhi1(Model model) {
        model.addAttribute("menus", "1");
        return "admin_tongzhi1.page";
    }

    /**
     * 
     * Description: 管理员通知页面<br/>

     *
     * @author dengJ
     * @param model
     * @return
     */
    @RequestMapping("/admin_tongzhi2")
    public String tongzhi2(Model model) {
        return "admin_tongzhi2.page";
    }

    @RequestMapping("/admin_tongzhi3")
    public String tongzhi3(Model model, HttpServletRequest req) {

    	// 获取id

        Integer id = Integer.parseInt(req.getParameter("id"));
        Info info = is.selectByPrimaryKey(id);
        model.addAttribute("info", info);
        return "admin_tongzhi3.page";
    }

    @RequestMapping("/tongzhi_update")
    public String tongzhi_update(Info info) {

    	 // 获取实体类信息

        is.updateByPrimaryKeySelective(info);
        return "admin_tongzhi1.page";
    }

    /**
     * 
     * Description: 娣诲姞閫氱煡<br/>
     *
     *
     * @author dengJ
     * @param info
     * @return
     */
    @RequestMapping("/tongzhi_insert")
    public String tongzhi_insert(Info info) {

    	// 获取实体类信息，将新增数据存入数据库

        is.insertSelective(info);

     // 获取本地时间与数据库时间格式一致


        java.util.Date date = new java.util.Date();
        java.sql.Date data1 = new java.sql.Date(date.getTime());
        info.setPublishDate(data1);

     // 获取最新一条记录ID

        Integer infoMax = is.selectMaxId();
        info.setId(infoMax);

     // 将时间存入最后一条记录中

        is.updateByPrimaryKey(info);
        return "admin_tongzhi1.page";
    }

    @RequestMapping("/tongzhi_delete")
    public String tongzhi_delete(HttpServletRequest req) {

    	// 获取id

        Integer id = Integer.parseInt(req.getParameter("id"));
        is.deleteByPrimaryKey(id);
        return "admin_tongzhi1.page";
    }

    @RequestMapping("/admin_delete")
    public String admin_delete(HttpServletRequest req) {

    	// 获取id

        Integer id = Integer.parseInt(req.getParameter("id"));
        us.deleteByPrimaryKey(id);
        return "admin_shuju4.page";
    }

    @RequestMapping("/adminus_delete")
    public String adminus_delete(HttpServletRequest req) {

    	// 获取id

        Integer id = Integer.parseInt(req.getParameter("id"));
        companyinfo.deleteByPrimaryKey(id);
        return "admin_userDsh.page";
    }
    @RequestMapping("/adminus_delete1")
    public String adminus_delete1(HttpServletRequest req) {
        // 鑾峰彇id
        Integer id = Integer.parseInt(req.getParameter("id"));
        companyinfo.deleteByPrimaryKey(id);
        return "admin_index.page";
    }

    @RequestMapping("/aduser_update")
    public String aduser_update(Model model, HttpServletRequest req) {

    	// 获取实体类信息

        Integer id = Integer.parseInt(req.getParameter("id"));
        Companyinfo comp = companyinfo.selectByPrimaryKey(id);
        model.addAttribute("comp", comp);
        return "aduser_update.page";
    }

    /***
     * 
     * @param req:閫氳繃id鏇存柊approval鐘舵�
     * @return
     */
    @RequestMapping("/adminuss_updatee")
    public String adminuss_updatee(HttpServletRequest req) {

    	// 获取实体类信息

        Integer id = Integer.parseInt(req.getParameter("id"));
        Companyinfo comp = companyinfo.selectByPrimaryKey(id);
        comp.setApproval(1);
        Userinfo record=new Userinfo();
//        record.setId(comp.getId());
        record.setName(comp.getName());
        record.setJob(comp.getJob());
        record.setPassword(comp.getPassword());
        record.setPhone(comp.getPhone());
        record.setEmail(comp.getEmail());
        record.setState(comp.getState());
        int flag = us.insertSelective(record);
        companyinfo.updateByPrimaryKey(comp);
        return "admin_userDsh.page";
    }

    @RequestMapping("/adminuss_updatee1")
    public String adminuss_updatee1(HttpServletRequest req) {
        // 鑾峰彇瀹炰綋绫讳俊鎭�
        Integer id = Integer.parseInt(req.getParameter("id"));
        Companyinfo comp = companyinfo.selectByPrimaryKey(id);
        comp.setApproval(1);
        Userinfo record=new Userinfo();
//        record.setId(comp.getId());
        record.setName(comp.getName());
        record.setJob(comp.getJob());
        record.setPassword(comp.getPassword());
        record.setPhone(comp.getPhone());
        record.setEmail(comp.getEmail());
        record.setState(comp.getState());
        int flag = us.insertSelective(record);
        companyinfo.updateByPrimaryKey(comp);
        return "admin_index.page";
    }
    /***
     * 
     * @param req:閫氳繃id鏇存柊approval鐘舵�
     * @return
     */
    @RequestMapping("/adminuss_updatee0")
    public String adminuss_updatee0(HttpServletRequest req) {

    	// 获取实体类信息

        Integer id = Integer.parseInt(req.getParameter("id"));
        Companyinfo comp = companyinfo.selectByPrimaryKey(id);
        comp.setApproval(0);
        companyinfo.updateByPrimaryKey(comp);
        return "admin_userDsh.page";
    }

    /***
     * 
     * @param req:閫氳繃id鏇存柊state鐘舵�:1
     * @return
     */
    @RequestMapping("/aduser_update1")
    public String aduser_update1(HttpServletRequest req) {

    	 // 获取实体类信息

        Integer id = Integer.parseInt(req.getParameter("id"));
        Companyinfo comp = companyinfo.selectByPrimaryKey(id);
        comp.setState(1);
        companyinfo.updateByPrimaryKey(comp);
        return "admin_userMan.page";
    }

    /***
     * 
     * @param req:閫氳繃id鏇存柊state鐘舵�:0
     * @return
     */
    @RequestMapping("/aduser_update0")
    public String aduser_update0(HttpServletRequest req) {

    	// 获取实体类信息

        Integer id = Integer.parseInt(req.getParameter("id"));
        Companyinfo comp = companyinfo.selectByPrimaryKey(id);
        comp.setState(0);
        companyinfo.updateByPrimaryKey(comp);
        return "admin_userMan.page";
    }

    @RequestMapping("/aduser_update2")
    public String aduser_insert(Companyinfo comps) {

    	// 获取实体类信息

        int flag = companyinfo.updateByPrimaryKey(comps);

        System.out.println(flag);
        return "admin_userMan.page";
    }

    @RequestMapping("/admin_cominfo")
    public String cominfo(Model model) {
        List<Companyinfo> lists = companyinfo.selectAllCompanies();
        model.addAttribute("menus", "3");
        model.addAttribute("lists", lists);
        return "admin_cominfo.page";
    }

    @RequestMapping("/admin_shuju1")
    public String shuju1(Model model, HttpServletRequest req) throws Exception {
        model.addAttribute("menus", "3");
        String id = req.getParameter("id");
        System.out.println("ddid"+id);
        HttpSession session = req.getSession();
        session.setAttribute("No1", id);//No1企业的id
       // List<Map<String, Object>> lists = releTable.selectAllTables();//所有的数据表
        //得到该企业的表关联关系
        int cid=Integer.parseInt(id);
        System.out.println("什么是cid"+cid);
        List<Tablerelation2> listtable2= ts.selecttablerelation(cid);
        
       int i = 0;
       int j = 0;
       String tb1;
       String tb2;
       if(listtable2.size()>0){
    	   for (Tablerelation2 table : listtable2) {
   			i=table.getCol1();
   			j=table.getCol2();
   			tb1=table.getTid1();
   			tb2=table.getTid2();
   			System.out.println("关联表"+tb1+":"+tb2);
   			List<String> listss=releTable.selectAll(tb1, i, tb2, j);
   			
   			table.setCname1(listss.get(0));//得到列名 ===根据表名去查询该字段的的值
   			table.setCname2(listss.get(1));
   			
   		}
    	 //遍历关联关系所需要的数据表
           List< Tableinfo> listf=ts.selectallbyid(cid);
     
        String ttb= listf.get(0).getName();
           //获取维度列
        HashMap<Integer, Object> maprtb=releTable.selectallname(ttb);
           //获取现存的分析任务
        List<Analysistasks> listas=as.selectdataBycid(cid);
           model.addAttribute("listf", listf);
           model.addAttribute("listtable2", listtable2);
           model.addAttribute("maprtb", maprtb);
           
           model.addAttribute("listas", listas);
       }      
        return "admin_shuju1.page";
        }
    

    @RequestMapping("/admin_shuju2")
    public String shuju2(Model model, HttpServletRequest req) {
        return "admin_shuju2.page";
    }

    @RequestMapping("/admin_shuju3")
    public String shuju3(Model model) {
        return "admin_shuju3.page";
    }

    @RequestMapping("/admin_shuju4")
    public String shuju4(Model model) {
        model.addAttribute("menus", "2");
        return "admin_shuju4.page";
    }

    @RequestMapping("insertAdminReg")
    public String insertAdminReg(Userinfo record) {
    	record.setState(2);
        int flag = us.insertSelective(record);
        // 杞彂
        return "admin_shuju4.page";
    }
    @RequestMapping("insertcomReg")
    public String insertComReg(Companyinfo record) {
    	record.setState(1);
        int flag = companyinfo.insertSelective(record);
        // 杞彂
        return "admin_userMan.page";
    }

    @RequestMapping("/selectAllCompanyinfo")
    public String selectAllCompanyinfo(Model model, HttpServletRequest req) {
        List<Companyinfo> lists = companyinfo.selectAllCompanies();
        model.addAttribute("lists", lists);
        List<Info> infoList = is.selectAllInfo();
        if (infoList != null) {
            for (Info info : infoList) {
                Date date = info.getPublishDate();
                System.out.println(date);
            }
        }
        HttpSession session = req.getSession();
        session.setAttribute("tongzhi", infoList);
        // 杞彂
        return "admin_index.page";
    }
//    @RequestMapping("/admin_index")
//    public String dshCompanyinfo1(Model model) {
//
//        List<Companyinfo> lists = companyinfo.selectnoPassCompanies();
//        model.addAttribute("menus", "5");
//        model.addAttribute("lists", lists);
//        
//        return "admin_index.page";
//    }

    @RequestMapping("/admin_userDsh")
    public String dshCompanyinfo(Model model) {

        List<Companyinfo> lists = companyinfo.selectnoPassCompanies();
        model.addAttribute("menus", "5");
        model.addAttribute("lists", lists);
        // 杞彂
        return "admin_userDsh.page";
    }

    @RequestMapping("/admin_userMan")
    public String userMan(Model model) {
        List<Companyinfo> lists = companyinfo.selectPassCompanies();
        model.addAttribute("menus", "4");
        model.addAttribute("lists", lists);

        // 转发


        return "admin_userMan.page";
    }


 // 新建数据表

    @ResponseBody
    @RequestMapping("/admin_create")
    public Map<String, String> creats(@RequestParam("values") String id, HttpServletRequest req) {
        String[] attr = id.split(",");
        ChineseToPinYin ctp = new ChineseToPinYin();
        Map<String, Object> map = new HashMap<String, Object>();
        String tbName = null;
        for (int i = 0; i < attr.length; i++) {
            if (i == 0) {
                map.put("shows", attr[0]);
            } else if (i == 1) {
                tbName = ctp.getPingYin(attr[1]);
            } else if (2 * i - 1 <= attr.length) {

                map.put(ctp.getPingYin(attr[2 * i - 2]), attr[2 * i - 1]);

            }
        }

        JdbcUtil creats = new JdbcUtil();
        ApplicationContext context = creats.getContext();
        context = new ClassPathXmlApplicationContext("spring-common.xml");
        JdbcTemplate jt = (JdbcTemplate) context.getBean("jdbcTemplate");
        creats.createTable(jt, tbName, map);

        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date = sdf.format(dt);
        Tableinfo record = new Tableinfo();
        record.setName(attr[1]);
        record.setUpdatetime(date);
        record.setShowtype(attr[0]);
        HttpSession session = req.getSession();
        String ids = (String) session.getAttribute("No1");
        Integer cid = Integer.parseInt(ids);
        record.setCid(cid);
        ts.insert(record);

        Map<String, String> maps = new HashMap<String, String>();
        maps.put("flag", "1");
        return maps;
    }

    @RequestMapping("/admin_selects")
    public String selects(Model model) {
        List<Companyinfo> lists = companyinfo.selectAllCompanies();
        System.out.println(lists);
        model.addAttribute("menus", "4");
        model.addAttribute("lists", lists);
        // 杞彂
        return "admin_userMan.page";
    }

    /**
     * 鍏憡璇︽儏
     * 
     * @param req
     * @return
     */
    @RequestMapping("/admin_gongGao")
    public String gongGao1(Integer id, Model model) {
        Info infos = is.selectByPrimaryKey(id);
        model.addAttribute("ggg", infos);
        return "admin_gongGao.page";
    }

    @RequestMapping("/insert_guanlian")
    public String insertGL(Datarelation record, HttpServletRequest req) {
//        String id = req.getParameter("id");
    	int cid=record.getCid();
        
        int flag = dataService.insert(record);        
        if (flag >= 1) {
        	
            return "redirect:/admin_shuju1.shtml?id="+cid;
        }

        return "admin_shuju1.page";
    }

    @RequestMapping("/admin_adds")
    public String adds(Model model) {

        List<Companyinfo> lists = companyinfo.selectAllCompanies();
        System.out.println(lists);
        model.addAttribute("menus", "4");
        model.addAttribute("lists", lists);

        // 杞彂
        return null;
    }

    @RequestMapping("/admin_shujus")
    public String shuju3(Model model, HttpServletRequest req) {
        model.addAttribute("menus", "3");
        String names = req.getParameter("id");
        Tableinfo Tbinfo=tableinfo.selectByTbname(names);
        model.addAttribute("Tbinfo",Tbinfo);
        ChineseToPinYin ctp = new ChineseToPinYin();
        String name = ctp.getPingYin(names);
        model.addAttribute("name2", names);
        model.addAttribute("name1", name);
        JdbcUtil jdbc1 = new JdbcUtil();
        ApplicationContext context = jdbc1.getContext();
        context = new ClassPathXmlApplicationContext("spring-common.xml");
        JdbcTemplate jt = (JdbcTemplate) context.getBean("jdbcTemplate");
        List<Map<String, Object>> lists = jdbc1.selectObj(jt, name);
        if (lists != null) {
            try {
                int shows = (int) lists.get(0).get("shows");
                model.addAttribute("shows", shows);
                String time = "'";
                Date date = null;
                for (int i = 0; i < lists.size(); i++) {
                    date = (Date) lists.get(i).get("times");
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    time = time + sdf.format(date) + "','";
                    if (i == lists.size() - 1) {
                        date = (Date) lists.get(i).get("times");
                        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
                        time = time + sdf2.format(date);
                    }
                }
                time = "[" + time + "']";
                model.addAttribute("lists", time);
                String fNums = "";
                for (int i = 0; i < lists.size(); i++) {
                    if (i == lists.size() - 1) {
                        fNums = fNums + lists.get(i).get(name);
                    } else {
                        fNums = fNums + lists.get(i).get(name) + ",";
                    }
                }
                fNums = "[" + fNums + "]";

                String rNums = "";
                for (int i = 0; i < lists.size(); i++) {

                    if (i == lists.size() - 1) {
                        rNums = rNums + lists.get(i).get(name);
                    } else {
                        rNums = rNums + lists.get(i).get(name) + ",";
                    }
                }
                rNums = "[" + rNums + "]";
                model.addAttribute("rNums", rNums);
                model.addAttribute("fNums", fNums);
                Set<String> sets = new HashSet<String>();

                for (int i = 0; i < lists.size(); i++) {
                    sets = lists.get(i).keySet();
                }
                List<String> lists3 = new ArrayList<String>();
                for (String string : sets) {
                    lists3.add(string);
                }
                model.addAttribute("lists3", lists3);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "admin_shujus.page";
    }

    @RequestMapping("/admin_uppassword")
    public String admin_uppassword(Model model) {
        model.addAttribute("checks", "geren2");
        return "admin_pass.page";
    }
    
    @ResponseBody
    @RequestMapping("/admin_ajax")
    public  Object ajax(@RequestParam(value="rtname1",required=true) int rtname1,Model model)throws Exception{
    	System.out.println("当前表id"+rtname1);
    	//Map<String, String> mmap=new HashMap<String, String>();
    	Integer id=Integer.valueOf(rtname1);
    	//根据id查询表名
    	String tbname=ts.selectnamebyid(id);
    	//根据表名
    	ChineseToPinYin py=new ChineseToPinYin();
    	String tbpyname=py.getPingYin(tbname);
    	HashMap<Integer, Object>  hhmap=releTable.selectallname(tbpyname);
    	//mmap.put("flag", "1");
    	//System.out.println(hhmap.keySet());
    	//Object obj=JSONArray.toJSON(hhmap);
    	return hhmap;
    }
    
    @ResponseBody
    @RequestMapping("/admin_ajax2")
    public  Object ajax2(@RequestParam(value="rtname1",required=true) int rtname1,Model model)throws Exception{
    	System.out.println("当前表id"+rtname1);
    	//Map<String, String> mmap=new HashMap<String, String>();
    	Integer id=Integer.valueOf(rtname1);
    	//根据id查询表名
    	String tbname=ts.selectnamebyid(id);
    	//根据表名
    	ChineseToPinYin py=new ChineseToPinYin();
    	String tbpyname=py.getPingYin(tbname);
    	HashMap<Integer, Object>  hhmap=releTable.selectallname(tbpyname);
    	//mmap.put("flag", "1");
    	//System.out.println(hhmap.keySet());
    	//Object obj=JSONArray.toJSON(hhmap);
    	return hhmap;
    }
    
    @ResponseBody
    @RequestMapping("/admin_ajax3")
    public  Object ajax3(@RequestParam(value="state",required=true) int state,@RequestParam(value="id",required=true) int id,Model model,HttpServletRequest req)throws Exception{
    	System.out.println("关联id:"+id+"状态"+state);  
    	HashMap map=new HashMap();
    	map.put("state", state);
    	map.put("id", id);
    	String flag="1";
    	if(state==1){//判断是否已经有了相同的关联处于启动状态
	    		HashMap map2=new HashMap();
	    		map2.put("state", 2);
	        	map2.put("id", id);
    		List<Datarelation>  listd=ts.selectstate(map2);//查询到关联的具体的信息
	    		if(listd.size()>0){
	    			Datarelation dd=listd.get(0);
	        		map.put("tid1", dd.getTid1());
	        		map.put("tid2", dd.getTid2());
	        		map.put("cid", dd.getCid());	        		
	        		List<Datarelation> listdd=ts.listreonlyone(map);//查询是否存在当前表的关系处于启用状态
	        		if(listdd.size()>0){//存在
	        			flag="2";
	        		}else{
	        			//改变状态
	        			ts.updaterestate(map);
	        		}
	    		}    		
    	}else{
    		//说明由启用转为禁止
    		ts.updaterestate(map);
    	}

    
    	return flag;
    }
    
    
/*    @RequestMapping("/admin_ajaxre")
    public @ResponseBody String regajax(@RequestParam("tab1") String tab1,@RequestParam("tab2") String tab2,HttpServletRequest req)throws Exception{
    	 int state=1;
    	System.out.println("关联tab1:"+tab1+":"+tab2+"状态"+state);    
    	HttpSession session=req.getSession();
    	String id=(String)session.getAttribute("No1");
    	int cid=Integer.parseInt(id);
    	HashMap map=new HashMap();
    	map.put("state", state);
    	map.put("cid", cid);
    	map.put("tab1",tab1);
    	map.put("tab2",tab2);
    	List<Datarelation> listll=ts.listreonlyone(map);
    	String flag;
    	if(listll.size()>0){
    		flag="1";
    	}else{
    		flag="2";
    	}
    	
    	return flag;
    }
    */
    @RequestMapping("/aaaa222")
    public @ResponseBody String regajax22(@RequestParam("tab1") int tab1,@RequestParam("tab2") int tab2,@RequestParam("col1") int col1,@RequestParam("col2") String col2,@RequestParam("name") String name,HttpServletRequest req)throws Exception{   	
    	 int state=1;
     	System.out.println("关联tab1:"+tab1+":"+tab2+"状态"+state);    
     	HttpSession session=req.getSession();
     	String id=(String)session.getAttribute("No1");
     	int cid=Integer.parseInt(id);
     	HashMap map=new HashMap();
     	map.put("state", state);
     	map.put("cid", cid);
     	map.put("tid1",tab1);
     	map.put("tid2",tab2);
     	map.put("name", name);
     	List<Datarelation> listll=ts.listreonlyone(map);
     	String flag;
     	if(listll.size()>0){   		
     		flag="1";//已存在
     	}else{
     		flag=id;//关系不存在
     		map.put("col1", col1);
     		map.put("col2", col2);     		
     		ts.myinsert(map);
     	}    	
     	return flag;
    	
    }
    
    @RequestMapping("/admin_ajaxname")
    public @ResponseBody String getname(@RequestParam("name") String name,HttpServletRequest req) throws Exception{
    		String flag="1";
    	HttpSession session=req.getSession();
     	String id=(String)session.getAttribute("No1");
     	int cid=Integer.parseInt(id);
     	HashMap map=new HashMap();
     	map.put("name", name);
     	map.put("cid", cid);
     	List<Datarelation>  listnme=ts.selectname(map);
     	if(listnme.size()>0){
     		flag="2";//此名字已经存在
     	}
    	return flag;
    }
    

}
