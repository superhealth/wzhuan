<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<base href="<%=basePath%>">
		<meta charset="utf-8" />
		<title></title>
		<meta name="description" content="overview & stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link href="static/css/bootstrap.min.css" rel="stylesheet" />
		<link href="static/css/bootstrap-responsive.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="static/css/font-awesome.min.css" />
		<!-- 下拉框 -->
		<link rel="stylesheet" href="static/css/chosen.css" />
		
		<link rel="stylesheet" href="static/css/ace.min.css" />
		<link rel="stylesheet" href="static/css/ace-responsive.min.css" />
		<link rel="stylesheet" href="static/css/ace-skins.min.css" />
		
		<link rel="stylesheet" href="static/css/datepicker.css" /><!-- 日期框 -->
		<style>
			.spanwr{width:70px;text-align:right;display: inline-block;}
		</style>
		<script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>
		<script type="text/javascript" src="static/js/jquery.tips.js"></script>
		
<script type="text/javascript">
	
	
	//保存
	function save(){
		if($("#TITLE").val()==""){
			$("#TITLE").tips({
				side:3,
	            msg:'请输入标题',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#TITLE").focus();
			return false;
		}
		/*if($("#AUTHOR").val()==""){
			$("#AUTHOR").tips({
				side:3,
	            msg:'请输入作者',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#AUTHOR").focus();
			return false;
		}
		if($("#CONTENT").val()==""){
			$("#CONTENT").tips({
				side:3,
	            msg:'请输入内容',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#CONTENT").focus();
			return false;
		}
		if($("#SEO_TITLE").val()==""){
			$("#SEO_TITLE").tips({
				side:3,
	            msg:'请输入页面标题',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#SEO_TITLE").focus();
			return false;
		}
		if($("#SEO_KEYWORDS").val()==""){
			$("#SEO_KEYWORDS").tips({
				side:3,
	            msg:'请输入页面关键词',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#SEO_KEYWORDS").focus();
			return false;
		}
		if($("#SEO_DESCRIPTION").val()==""){
			$("#SEO_DESCRIPTION").tips({
				side:3,
	            msg:'请输入页面描述',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#SEO_DESCRIPTION").focus();
			return false;
		}
		if($("#IS_PUBLICATION").val()==""){
			$("#IS_PUBLICATION").tips({
				side:3,
	            msg:'请输入是否发布',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#IS_PUBLICATION").focus();
			return false;
		}
		if($("#IS_TOP").val()==""){
			$("#IS_TOP").tips({
				side:3,
	            msg:'请输入是否置顶',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#IS_TOP").focus();
			return false;
		}*/
		if($("#ARTICLE_CATEGORY").val()==""){
			$("#ARTICLE_CATEGORY").tips({
				side:3,
	            msg:'请输入文章分类',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#ARTICLE_CATEGORY").focus();
			return false;
		}
		$("#Form").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	}
	
</script>
	</head>
<body>
	<form action="article/${msg }.do" name="Form" id="Form" method="post">
		<input type="hidden" name="ARTICLE_ID" id="ARTICLE_ID" value="${pd.ARTICLE_ID}"/>
		<div id="zhongxin">
		<table>
			<tr>
				<td><span class="spanwr">标&nbsp;&nbsp;题：</span><input type="text" style="margin-bottom:5px;" name="TITLE" id="TITLE" value="${pd.TITLE}" maxlength="32" placeholder="这里输入标题" title="标题"/></td>
			</tr>
			<tr>
				<td><span class="spanwr">文章分类：</span>
					<select name="ARTICLE_CATEGORY" id="ARTICLE_CATEGORY"  title="文章分类:" style="margin-bottom:5px;">
					<c:forEach items="${articlecates}" var="var" varStatus="vs">
						<option value="${var.ARTICLECATEGORY_ID}" <c:if test="${var.ARTICLECATEGORY_ID== pd.ARTICLE_CATEGORY}">selected</c:if>>
						<c:if test="${var.GRADE != 0}">		 
							<c:forEach  begin="0" end="${var.GRADE}" >&nbsp;&nbsp;</c:forEach> 
						</c:if>
						${var.NAME}</option>
					</c:forEach>
					</select>
					
				
			<!-- 	<input type="number" style="margin-bottom:5px;" name="ARTICLE_CATEGORY" id="ARTICLE_CATEGORY" value="${pd.ARTICLE_CATEGORY}" maxlength="32" placeholder="这里输入文章分类" title="文章分类"/> --></td>
			</tr>
			<tr>
				<td><span class="spanwr">作&nbsp;&nbsp;者：</span>
				<input type="text" name="AUTHOR" id="AUTHOR" value="${pd.AUTHOR}" maxlength="32" placeholder="这里输入作者" title="作者"/></td>
			</tr>
			<tr>
				<td><span class="spanwr">是否发布：</span>
				<select name="IS_PUBLICATION" id="IS_PUBLICATION"  title="是否发布" >
						<option value="0" <c:if test="${pd.IS_PUBLICATION == 0}">selected</c:if>>是</option>
						<option value="1" <c:if test="${pd.IS_PUBLICATION == 1 }">selected</c:if>>否</option>
				</select>
				
				<!--  <input type="number" name="IS_PUBLICATION" id="IS_PUBLICATION" value="${pd.IS_PUBLICATION}" maxlength="32" placeholder="这里输入是否发布" title="是否发布"/>--></td>
			</tr>
			<tr>
				<td><span class="spanwr">是否置顶：</span>
				<select name="IS_TOP" id="IS_TOP"  title="是否置顶" >
						<option value="0" <c:if test="${pd.IS_TOP == 0}">selected</c:if>>是</option>
						<option value="1" <c:if test="${pd.IS_TOP == 1 }">selected</c:if>>否</option>
				</select>				
				
				<!-- <input type="number" name="IS_TOP" id="IS_TOP" value="${pd.IS_TOP}" maxlength="32" placeholder="这里输入是否置顶" title="是否置顶"/> --></td>
			</tr>
			<tr>
				<td><span class="spanwr">内容：</span><textarea id="CONTENT" name="CONTENT" class="editor" value="${pd.CONTENT}"  placeholder="这里输入内容" title="内容"></textarea>
				<!-- <input type="text" name="CONTENT" id="CONTENT" value="${pd.CONTENT}" maxlength="32" placeholder="这里输入内容" title="内容"/> --></td>
			</tr>
			<tr>
				<td><span class="spanwr">页面标题：</span><input type="text" name="SEO_TITLE" id="SEO_TITLE" value="${pd.SEO_TITLE}" maxlength="200" placeholder="这里输入页面标题" title="页面标题"/></td>
			</tr>
			<tr>
				<td><span class="spanwr">关键词：</span><input type="text" name="SEO_KEYWORDS" id="SEO_KEYWORDS" value="${pd.SEO_KEYWORDS}" maxlength="200" placeholder="这里输入页面关键词" title="页面关键词"/></td>
			</tr>
			<tr>
				<td><span class="spanwr">页面描述：</span><input type="text" name="SEO_DESCRIPTION" id="SEO_DESCRIPTION" value="${pd.SEO_DESCRIPTION}" maxlength="200" placeholder="这里输入页面描述" title="页面描述"/></td>
			</tr>
			<tr>
				<td style="text-align: center;">
					<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
					<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a>
				</td>
			</tr>
		</table>
		</div>
		
		<div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><br/><br/><img src="static/images/jiazai.gif" /><br/><h4 class="lighter block green">提交中...</h4></div>
		
	</form>
	
	
		<!-- 引入 -->
		<script type="text/javascript">window.jQuery || document.write("<script src='static/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
		<script src="static/js/bootstrap.min.js"></script>
		<script src="static/js/ace-elements.min.js"></script>
		<script src="static/js/ace.min.js"></script>
		<script type="text/javascript" src="static/js/chosen.jquery.min.js"></script><!-- 下拉框 -->
		<script type="text/javascript" src="static/js/bootstrap-datepicker.min.js"></script><!-- 日期框 -->
		<script type="text/javascript">
		$(top.hangge());
		$(function() {
			
			//单选框
			$(".chzn-select").chosen(); 
			$(".chzn-select-deselect").chosen({allow_single_deselect:true}); 
			
			//日期框
			$('.date-picker').datepicker();
			
		});
		
		</script>
</body>
</html>