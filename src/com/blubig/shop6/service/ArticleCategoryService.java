package com.blubig.shop6.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.util.PageData;


@Service("articlecategoryService")
public class ArticleCategoryService {

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/*
	* 新增
	*/
	public void save(PageData pd)throws Exception{
		this.setValue(pd);
		dao.save("ArticleCategoryMapper.save", pd);
	}
	
	/*
	* 删除
	*/
	public void delete(PageData pd)throws Exception{
		dao.delete("ArticleCategoryMapper.delete", pd);
	}
	
	/*
	* 修改
	*/
	public void edit(PageData pd)throws Exception{
		//String articleId=(String) pd.get("ARTICLECATEGORY_ID");
		PageData articleCategory=this.findById(pd);
		String parentId = (String) articleCategory.get("PARENT");
		//if(parentId !=null && !parentId.equals("")){
		if((parentId==null && pd.get("PARENT").equals(""))||((pd.get("PARENT")).equals(parentId))){
			pd.put("TREE_PATH", articleCategory.get("TREE_PATH"));
			pd.put("GRADE", articleCategory.get("GRADE"));
			dao.update("ArticleCategoryMapper.edit", pd);
		}else{
			this.setValue(pd);
			dao.update("ArticleCategoryMapper.edit", pd);
			
		}
	}
	
	/*
	*列表
	*/
	public List<PageData> list(Page page)throws Exception{
		return (List<PageData>)dao.findForList("ArticleCategoryMapper.datalistPage", page);
	}
	
	/*
	*列表(全部)
	*/
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("ArticleCategoryMapper.listAll", pd);
	}
	
	/*
	* 通过id获取数据
	*/
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("ArticleCategoryMapper.findById", pd);
	}
	
	/*
	* 批量删除
	*/
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		dao.delete("ArticleCategoryMapper.deleteAll", ArrayDATA_IDS);
	}
	/**
	 * 排序文章分类
	 * 
	 * @param articleCategories
	 *            文章分类
	 * @param parent
	 *            上级文章分类
	 * @return 文章分类
	 */
	public List<PageData> sort(List<PageData> articleCategories, PageData parent) {
		List<PageData> result = new ArrayList<PageData>();
		if (articleCategories != null) {
			for (PageData articleCategory : articleCategories) {
				if ((articleCategory.get("PARENT")!= null && parent !=null && articleCategory.get("PARENT").equals(parent.get("ARTICLECATEGORY_ID"))) || (articleCategory.get("PARENT") == null && parent == null)) {
					result.add(articleCategory);
					result.addAll(sort(articleCategories, articleCategory));
				}
			}
		}
		return result;
	}
	/**
	 * 设置值
	 * 
	 * @param articleCategory
	 *            文章分类
	 */
	private void setValue(PageData articleCategory) {
		if (articleCategory == null) {
			return;
		}
		String parentId = (String) articleCategory.get("PARENT");
		if (null!=parentId &&!parentId.equals("") ) {
			PageData parent=new PageData();
			parent.put("ARTICLECATEGORY_ID", parentId);
			try {
				parent=this.findById(parent);
			} catch (Exception e) {
				e.printStackTrace();
			}
			articleCategory.put("TREE_PATH",parent.get("TREE_PATH") + parentId + ",");
		} else {
			articleCategory.put("TREE_PATH",",");
		}
		articleCategory.put("GRADE",this.getTreePaths((String) articleCategory.get("TREE_PATH")).size());
	}
	/**
	 * 获取树路径
	 * 
	 * @return 树路径
	 */
	public List<String> getTreePaths(String treePath) {
		List<String> treePaths = new ArrayList<String>();
		String[] ids = StringUtils.split(treePath, ",");
		if (ids != null) {
			for (String id : ids) {
				treePaths.add(id);
			}
		}
		return treePaths;
	}
}

