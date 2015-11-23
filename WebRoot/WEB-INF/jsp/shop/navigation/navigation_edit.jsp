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
	            msg:'请输入序列',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#ORDERS").focus();
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
		if($("#POSITION").val()==""){
			$("#POSITION").tips({
				side:3,
	            msg:'请输入位置',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#POSITION").focus();
			return false;
		}
		if($("#URL").val()==""){
			$("#URL").tips({
				side:3,
	            msg:'请输入链接地址',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#URL").focus();
			return false;
		}
		if($("#ISBLANKTARGET").val()==""){
			$("#ISBLANKTARGET").tips({
				side:3,
	            msg:'请输入是否新窗口打开',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#ISBLANKTARGET").focus();
			return false;
		}
		$("#Form").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	}
	
</script>
	</head>
<body>
	<form action="navigation/${msg }.do" name="Form" id="Form" method="post">
		<input type="hidden" name="NAVIGATION_ID" id="NAVIGATION_ID" value="${pd.NAVIGATION_ID}"/>
		<div id="zhongxin">
		<table>
			<tr>
				<td><input type="text" name="NAME" id="NAME" value="${pd.NAME}" maxlength="200" placeholder="这里输入名称" title="名称"/></td>
			</tr>
			<tr>
			<td>
				<select name="POSITION" id="POSITION"  title="位置" >
						<option value="0" <c:if test="${pd.POSITION == 0}">selected</c:if>>顶部</option>
						<option value="1" <c:if test="${pd.POSITION == 1 }">selected</c:if>>中间</option>
						<option value="2" <c:if test="${pd.POSITION == 2 }">selected</c:if>>底部</option>
				</select>
			<!-- <input type="number" name="POSITION" id="POSITION" value="${pd.POSITION}" maxlength="32" placeholder="这里输入位置" title="位置"/> -->	</td>
			</tr>
			<tr>
				<td><input type="text" name="URL" id="URL" value="${pd.URL}" maxlength="200" placeholder="这里输入链接地址" title="链接地址"/></td>
			</tr>
			<tr>
				<td>
				<select name="ISBLANKTARGET" id="ISBLANKTARGET"  title="位置" >
						<option value="0" <c:if test="${pd.ISBLANKTARGET == 0}">selected</c:if>>是</option>
						<option value="1" <c:if test="${pd.ISBLANKTARGET == 1 }">selected</c:if>>否</option>
				</select>
				
				<!-- <input type="number" name="ISBLANKTARGET" id="ISBLANKTARGET" value="${pd.ISBLANKTARGET}" maxlength="32" placeholder="这里输入是否新窗口打开" title="是否新窗口打开"/> --></td>
			</tr>
			<tr>
				<td><input type="number" name="ORDERS" id="ORDERS" value="${pd.ORDERS}" maxlength="9" placeholder="这里输入序列" title="序列"/></td>
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