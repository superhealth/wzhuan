package com.blubig.shop6.controller;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.blubig.shop6.service.NavigationService;
import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.entity.system.Menu;
import com.fh.service.system.dictionaries.DictionariesService;
import com.fh.util.AppUtil;
import com.fh.util.Const;
import com.fh.util.ObjectExcelView;
import com.fh.util.PageData;
import com.fh.util.Tools;

/** 
 * 类名称：NavigationController
 * 创建人：MAMY 
 * 创建时间：2015-04-14
 */
@Controller
@RequestMapping(value="/navigation")
public class NavigationController extends BaseController {
	
	@Resource(name="navigationService")
	private NavigationService navigationService;
	@Resource(name="dictionariesService")
	private DictionariesService dictionariesService;
	
	/**
	 * 新增
	 */
	@RequestMapping(value="/saveNavigation")
	public ModelAndView saveNavigation() throws Exception{
		logBefore(logger, "新增Navigation");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("NAVIGATION_ID", this.get32UUID());	//主键
		pd.put("CREATE_DATE", Tools.date2Str(new Date()));	//创建时间
		pd.put("MODIFY_DATE","");	//修改时间
		navigationService.save(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value="/deleteNavigation")
	public void deleteNavigation(PrintWriter out){
		logBefore(logger, "删除Navigation");
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			navigationService.delete(pd);
			out.write("success");
			out.close();
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value="/editNavigation")
	public ModelAndView editNavigation() throws Exception{
		logBefore(logger, "修改Navigation");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("MODIFY_DATE", Tools.date2Str(new Date()));	//修改时间
		navigationService.edit(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**
	 * 列表
	 */
	@RequestMapping(value="/listNavigation")
	public ModelAndView listNavigation(Page page){
		logBefore(logger, "列表Navigation");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			page.setPd(pd);
			List<PageData>	varList = navigationService.list(page);	//列出Navigation列表
			//dictionariesService.dictlistPage(page)
			this.getHC(); //调用权限
			mv.setViewName("shop/navigation/navigation_list");
			mv.addObject("varList", varList);
			mv.addObject("pd", pd);
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		return mv;
	}
	
	/**
	 * 去新增页面
	 */
	@RequestMapping(value="/goAddNavigation")
	public ModelAndView goAddNavigation(){
		logBefore(logger, "去新增Navigation页面");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		try {
			mv.setViewName("shop/navigation/navigation_edit");
			mv.addObject("msg", "saveNavigation");
			mv.addObject("pd", pd);
			//mv.addObject("roleList", roleList);
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}						
		return mv;
	}	
	
	/**
	 * 去修改页面
	 */
	@RequestMapping(value="/goEditNavigation")
	public ModelAndView goEditNavigation(){
		logBefore(logger, "去修改Navigation页面");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		try {
			pd = navigationService.findById(pd);	//根据ID读取
			mv.setViewName("shop/navigation/navigation_edit");
			mv.addObject("msg", "editNavigation");
			mv.addObject("pd", pd);
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}						
		return mv;
	}	
	
	/**
	 * 批量删除
	 */
	@RequestMapping(value="/deleteAll")
	@ResponseBody
	public Object deleteAll() {
		logBefore(logger, "批量删除Navigation");
		PageData pd = new PageData();		
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			pd = this.getPageData();
			List<PageData> pdList = new ArrayList<PageData>();
			String DATA_IDS = pd.getString("DATA_IDS");
			if(null != DATA_IDS && !"".equals(DATA_IDS)){
				String ArrayDATA_IDS[] = DATA_IDS.split(",");
				navigationService.deleteAll(ArrayDATA_IDS);
				pd.put("msg", "ok");
			}else{
				pd.put("msg", "no");
			}
			pdList.add(pd);
			map.put("list", pdList);
		} catch (Exception e) {
			logger.error(e.toString(), e);
		} finally {
			logAfter(logger);
		}
		return AppUtil.returnObject(pd, map);
	}
	
	/*
	 * 导出到excel
	 * @return
	 */
	@RequestMapping(value="/excel")
	public ModelAndView exportExcel(){
		logBefore(logger, "导出Navigation到excel");
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		try{
			Map<String,Object> dataMap = new HashMap<String,Object>();
			List<String> titles = new ArrayList<String>();
			titles.add("创建时间");	//1
			titles.add("修改时间");	//2
			titles.add("序列");	//3
			titles.add("名称");	//4
			titles.add("位置");	//5
			titles.add("链接地址");	//6
			titles.add("是否新窗口打开");	//7
			dataMap.put("titles", titles);
			List<PageData> varOList = navigationService.listAll(pd);
			List<PageData> varList = new ArrayList<PageData>();
			for(int i=0;i<varOList.size();i++){
				PageData vpd = new PageData();
				vpd.put("var1", varOList.get(i).getString("CREATE_DATE"));	//1
				vpd.put("var2", varOList.get(i).getString("MODIFY_DATE"));	//2
				vpd.put("var3", varOList.get(i).get("ORDERS").toString());	//3
				vpd.put("var4", varOList.get(i).getString("NAME"));	//4
				vpd.put("var5", varOList.get(i).get("POSITION").toString());	//5
				vpd.put("var6", varOList.get(i).getString("URL"));	//6
				vpd.put("var7", varOList.get(i).get("ISBLANKTARGET").toString());	//7
				varList.add(vpd);
			}
			dataMap.put("varList", varList);
			ObjectExcelView erv = new ObjectExcelView();
			mv = new ModelAndView(erv,dataMap);
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		return mv;
	}
	
	/* ===============================权限================================== */
	public void getHC(){
		ModelAndView mv = this.getModelAndView();
		HttpSession session = this.getRequest().getSession();
		Map<String, String> map = (Map<String, String>)session.getAttribute(Const.SESSION_QX);
		mv.addObject(Const.SESSION_QX,map);	//按钮权限
		List<Menu> menuList = (List)session.getAttribute(Const.SESSION_menuList);
		mv.addObject(Const.SESSION_menuList, menuList);//菜单权限
	}
	/* ===============================权限================================== */
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format,true));
	}
}