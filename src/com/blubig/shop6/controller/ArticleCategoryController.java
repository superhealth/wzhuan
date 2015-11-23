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

import com.blubig.shop6.service.ArticleCategoryService;
import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.entity.system.Menu;
import com.fh.util.AppUtil;
import com.fh.util.Const;
import com.fh.util.ObjectExcelView;
import com.fh.util.PageData;
import com.fh.util.Tools;

/** 
 * 类名称：ArticleCategoryController
 * 创建人：MAMY 
 * 创建时间：2015-04-20
 */
@Controller
@RequestMapping(value="/articlecategory")
public class ArticleCategoryController extends BaseController {
	
	@Resource(name="articlecategoryService")
	private ArticleCategoryService articlecategoryService;
	
	/**
	 * 新增
	 */
	@RequestMapping(value="/saveArticleCategory")
	public ModelAndView saveArticleCategory() throws Exception{
		logBefore(logger, "新增ArticleCategory");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("ARTICLECATEGORY_ID", this.get32UUID());	//主键
		pd.put("CREATE_DATE", Tools.date2Str(new Date()));	//创建日期
		pd.put("MODIFY_DATE", Tools.date2Str(new Date()));	//修改日期
//		if(null==pd.get("PARENT")|| "".equals(pd.get("PARENT"))){
//			pd.put("GRADE", 0);
//		}
		articlecategoryService.save(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value="/delete")
	public void delete(PrintWriter out){
		logBefore(logger, "删除ArticleCategory");
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			articlecategoryService.delete(pd);
			out.write("success");
			out.close();
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value="/editArticleCategory")
	public ModelAndView editArticleCategory() throws Exception{
		logBefore(logger, "修改ArticleCategory");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("MODIFY_DATE", Tools.date2Str(new Date()));	//修改日期
		articlecategoryService.edit(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**
	 * 列表
	 */
	@RequestMapping(value="/listArticleCategory")
	public ModelAndView listArticleCategory(Page page){
		logBefore(logger, "列表ArticleCategory");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			page.setPd(pd);
			List<PageData>	articleCategories = articlecategoryService.list(page);	//列出ArticleCategory列表
			List<PageData>	varList=articlecategoryService.sort(articleCategories, null);
			this.getHC(); //调用权限
			mv.setViewName("bluebig/shop6/articlecategory/articlecategory_list");
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
	@RequestMapping(value="/goAdd")
	public ModelAndView goAdd(){
		logBefore(logger, "去新增ArticleCategory页面");
		ModelAndView mv = this.getModelAndView();
		List<PageData> articlecates=new ArrayList<PageData>();
		try {
			List<PageData> articleCategories=articlecategoryService.listAll(new PageData());
			articlecates=articlecategoryService.sort(articleCategories, null);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		PageData pd = new PageData();
		pd = this.getPageData();
		try {
			mv.setViewName("bluebig/shop6/articlecategory/articlecategory_edit");
			mv.addObject("msg", "saveArticleCategory");
			mv.addObject("pd", pd);
			mv.addObject("articlecates", articlecates);
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}						
		return mv;
	}	
	
	/**
	 * 去修改页面
	 */
	@RequestMapping(value="/goEdit")
	public ModelAndView goEdit(){
		logBefore(logger, "去修改ArticleCategory页面");
		ModelAndView mv = this.getModelAndView();
		List<PageData> articlecates=new ArrayList<PageData>();
		try {
			List<PageData> articleCategories=articlecategoryService.listAll(new PageData());
			articlecates=articlecategoryService.sort(articleCategories, null);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		PageData pd = new PageData();
		pd = this.getPageData();
		try {
			pd = articlecategoryService.findById(pd);	//根据ID读取
			mv.setViewName("bluebig/shop6/articlecategory/articlecategory_edit");
			mv.addObject("msg", "editArticleCategory");
			mv.addObject("pd", pd);
			mv.addObject("articlecates", articlecates);
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
		logBefore(logger, "批量删除ArticleCategory");
		PageData pd = new PageData();		
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			pd = this.getPageData();
			List<PageData> pdList = new ArrayList<PageData>();
			String DATA_IDS = pd.getString("DATA_IDS");
			if(null != DATA_IDS && !"".equals(DATA_IDS)){
				String ArrayDATA_IDS[] = DATA_IDS.split(",");
				articlecategoryService.deleteAll(ArrayDATA_IDS);
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
		logBefore(logger, "导出ArticleCategory到excel");
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		try{
			Map<String,Object> dataMap = new HashMap<String,Object>();
			List<String> titles = new ArrayList<String>();
			titles.add("创建日期");	//1
			titles.add("修改日期");	//2
			titles.add("排序");	//3
			titles.add("层级");	//4
			titles.add("名称");	//5
			titles.add("页面描述 ");	//6
			titles.add("页面关键词");	//7
			titles.add("页面标题");	//8
			titles.add("树路径");	//9
			titles.add("上级分类");	//10
			dataMap.put("titles", titles);
			List<PageData> varOList = articlecategoryService.listAll(pd);
			List<PageData> varList = new ArrayList<PageData>();
			for(int i=0;i<varOList.size();i++){
				PageData vpd = new PageData();
				vpd.put("var1", varOList.get(i).getString("CREATE_DATE"));	//1
				vpd.put("var2", varOList.get(i).getString("MODIFY_DATE"));	//2
				vpd.put("var3", varOList.get(i).get("ORDERS").toString());	//3
				vpd.put("var4", varOList.get(i).get("GRADE").toString());	//4
				vpd.put("var5", varOList.get(i).getString("NAME"));	//5
				vpd.put("var6", varOList.get(i).getString("SEO_DESCRIPTION"));	//6
				vpd.put("var7", varOList.get(i).getString("SEO_KEYWORDS"));	//7
				vpd.put("var8", varOList.get(i).getString("SEO_TITLE"));	//8
				vpd.put("var9", varOList.get(i).getString("TREE_PATH"));	//9
				vpd.put("var10", varOList.get(i).get("PARENT").toString());	//10
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
