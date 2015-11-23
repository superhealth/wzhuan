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
		<script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>
		<script type="text/javascript" src="static/js/jquery.tips.js"></script>
		
<script type="text/javascript">
	
	
	//保存
	function save(){
			if($("#ORDERS").val()==""){
			$("#ORDERS").tips({
				side:3,
	            msg:'请输入排序',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#ORDERS").focus();
			return false;
		}
		if($("#GRADE").val()==""){
			$("#GRADE").tips({
				side:3,
	            msg:'请输入层级',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#GRADE").focus();
			return false;
		}
		if($("#NAME").val()==""){
			$("#NAME").tips({
				side:3,
	            msg:'请输入名称',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#NAME").focus();
			return false;
		}
		if($("#SEO_DESCRIPTION").val()==""){
			$("#SEO_DESCRIPTION").tips({
				side:3,
	            msg:'请输入页面描述 ',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#SEO_DESCRIPTION").focus();
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
		if($("#TREE_PATH").val()==""){
			$("#TREE_PATH").tips({
				side:3,
	            msg:'请输入树路径',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#TREE_PATH").focus();
			return false;
		}
		if($("#PARENT").val()==""){
			$("#PARENT").tips({
				side:3,
	            msg:'请输入上级分类',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#PARENT").focus();
			return false;
		}
		$("#Form").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	}
	
</script>
	</head>
<body>
	<form action="articlecategory/${msg }.do" name="Form" id="Form" method="post">
		<input type="hidden" name="ARTICLECATEGORY_ID" id="ARTICLECATEGORY_ID" value="${pd.ARTICLECATEGORY_ID}"/>
		<div id="zhongxin">
		<table>
			<tr>
				<td><input type="number" name="ORDERS" id="ORDERS" value="${pd.ORDERS}" maxlength="32" placeholder="这里输入排序" title="排序"/></td>
			</tr>
			<tr>
				<td><input type="number" name="GRADE" id="GRADE" value="${pd.GRADE}" maxlength="32" placeholder="这里输入层级" title="层级"/></td>
			</tr>
			<tr>
				<td><input type="text" name="NAME" id="NAME" value="${pd.NAME}" maxlength="32" placeholder="这里输入名称" title="名称"/></td>
			</tr>
			<tr>
				<td><input type="text" name="SEO_DESCRIPTION" id="SEO_DESCRIPTION" value="${pd.SEO_DESCRIPTION}" maxlength="32" placeholder="这里输入页面描述 " title="页面描述 "/></td>
			</tr>
			<tr>
				<td><input type="text" name="SEO_KEYWORDS" id="SEO_KEYWORDS" value="${pd.SEO_KEYWORDS}" maxlength="32" placeholder="这里输入页面关键词" title="页面关键词"/></td>
			</tr>
			<tr>
				<td><input type="text" name="SEO_TITLE" id="SEO_TITLE" value="${pd.SEO_TITLE}" maxlength="32" placeholder="这里输入页面标题" title="页面标题"/></td>
			</tr>
			<tr>
				<td><input type="text" name="TREE_PATH" id="TREE_PATH" value="${pd.TREE_PATH}" maxlength="32" placeholder="这里输入树路径" title="树路径"/></td>
			</tr>
			<tr>
				<td><input type="number" name="PARENT" id="PARENT" value="${pd.PARENT}" maxlength="32" placeholder="这里输入上级分类" title="上级分类"/></td>
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