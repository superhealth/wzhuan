package com.fh.controller.shop.article;

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

import com.fh.controller.base.BaseController;
import com.fh.entity.system.Menu;
import com.fh.entity.Page;
import com.fh.util.AppUtil;
import com.fh.util.ObjectExcelView;
import com.fh.util.Const;
import com.fh.util.PageData;
import com.fh.util.Tools;
import com.fh.service.shop.article.ArticleService;
import com.fh.service.system.dictionaries.DictionariesService;

/** 
 * 类名称：ArticleController
 * 创建人：FH 
 * 创建时间：2015-04-17
 */
@Controller
@RequestMapping(value="/article")
public class ArticleController extends BaseController {
	
	@Resource(name="articleService")
	private ArticleService articleService;	
	@Resource(name="dictionariesService")
	private DictionariesService dictionariesService;
	
	/**
	 * 新增
	 */
	@RequestMapping(value="/saveArticle")
	public ModelAndView saveArticle() throws Exception{
		logBefore(logger, "新增Article");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("ARTICLE_ID", this.get32UUID());	//主键
		pd.put("HITS", 0L);	//点击数
		articleService.save(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value="/deleteArticle")
	public void deleteArticle(PrintWriter out){
		logBefore(logger, "删除Article");
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			articleService.delete(pd);
			out.write("success");
			out.close();
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value="/editArticle")
	public ModelAndView editArticle() throws Exception{
		logBefore(logger, "修改Article");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		articleService.edit(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**
	 * 列表
	 */
	@RequestMapping(value="/listArticle")
	public ModelAndView listArticle(Page page){
		logBefore(logger, "列表Article");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		PageData dic = new PageData();
		PageData dicId = new PageData();
		dic.put("BIANMA", "ARTICLE_CATEGORY");
		try {
			PageData dicBybi=dictionariesService.findByBianma(dic);
			dicId.put("PARENT_ID", dicBybi.getString("ZD_ID"));
			List<PageData> dics=dictionariesService.findByParentId(dicId);
			mv.setViewName("shop/article/article_edit");
			pd = this.getPageData();
			page.setPd(pd);
			List<PageData>	varList = articleService.list(page);	//列出Article列表
			this.getHC(); //调用权限
			mv.setViewName("shop/article/article_list");
			mv.addObject("varList", varList);
			mv.addObject("pd", pd);
			mv.addObject("dics", dics);
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
		logBefore(logger, "去新增Article页面");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		PageData dic = new PageData();
		PageData dicId = new PageData();
		dic.put("BIANMA", "ARTICLE_CATEGORY");
		try {
			PageData dicBybi=dictionariesService.findByBianma(dic);
			dicId.put("PARENT_ID", dicBybi.getString("ZD_ID"));
			List<PageData> dics=dictionariesService.findByParentId(dicId);
			mv.setViewName("shop/article/article_edit");
			mv.addObject("msg", "saveArticle");
			mv.addObject("pd", pd);
			mv.addObject("dics", dics);
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
		logBefore(logger, "去修改Article页面");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		PageData dic = new PageData();
		PageData dicId = new PageData();
		dic.put("BIANMA", "ARTICLE_CATEGORY");
		try {
			PageData dicBybi=dictionariesService.findByBianma(dic);
			dicId.put("PARENT_ID", dicBybi.getString("ZD_ID"));
			List<PageData> dics=dictionariesService.findByParentId(dicId);
			pd = articleService.findById(pd);	//根据ID读取
			mv.setViewName("shop/article/article_edit");
			mv.addObject("msg", "editArticle");
			mv.addObject("pd", pd);
			mv.addObject("dics", dics);
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
		logBefore(logger, "批量删除Article");
		PageData pd = new PageData();		
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			pd = this.getPageData();
			List<PageData> pdList = new ArrayList<PageData>();
			String DATA_IDS = pd.getString("DATA_IDS");
			if(null != DATA_IDS && !"".equals(DATA_IDS)){
				String ArrayDATA_IDS[] = DATA_IDS.split(",");
				articleService.deleteAll(ArrayDATA_IDS);
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
		logBefore(logger, "导出Article到excel");
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		try{
			Map<String,Object> dataMap = new HashMap<String,Object>();
			List<String> titles = new ArrayList<String>();
			titles.add("标题");	//1
			titles.add("作者");	//2
			titles.add("内容");	//3
			titles.add("页面标题");	//4
			titles.add("页面关键词");	//5
			titles.add("页面描述");	//6
			titles.add("是否发布");	//7
			titles.add("是否置顶");	//8
			titles.add("点击数");	//9
			titles.add("文章分类");	//10
			dataMap.put("titles", titles);
			List<PageData> varOList = articleService.listAll(pd);
			List<PageData> varList = new ArrayList<PageData>();
			for(int i=0;i<varOList.size();i++){
				PageData vpd = new PageData();
				vpd.put("var1", varOList.get(i).getString("TITLE"));	//1
				vpd.put("var2", varOList.get(i).getString("AUTHOR"));	//2
				vpd.put("var3", varOList.get(i).getString("CONTENT"));	//3
				vpd.put("var4", varOList.get(i).getString("SEO_TITLE"));	//4
				vpd.put("var5", varOList.get(i).getString("SEO_KEYWORDS"));	//5
				vpd.put("var6", varOList.get(i).getString("SEO_DESCRIPTION"));	//6
				vpd.put("var7", varOList.get(i).get("IS_PUBLICATION").toString());	//7
				vpd.put("var8", varOList.get(i).get("IS_TOP").toString());	//8
				vpd.put("var9", varOList.get(i).get("HITS").toString());	//9
				vpd.put("var10", varOList.get(i).get("ARTICLE_CATEGORY").toString());	//10
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
