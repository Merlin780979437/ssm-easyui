<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../jslib/jquery-easyui-1.4.4/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../jslib/jquery-easyui-1.4.4/themes/icon.css">
<script type="text/javascript" src="../jslib/jquery-easyui-1.4.4/jquery.min.js"></script>
<script type="text/javascript" src="../jslib/jquery-easyui-1.4.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../jslib/jquery-easyui-1.4.4/locale/easyui-lang-zh_CN.js"></script>
<title>用户管理</title>
</head>
<body>

<table id="admin_userList_datagrid"></table> 

<div id="userList_tb" style="padding:2px 5px;">
   	<form id="userList_form">
    	姓名：<input id="name" name="name" class="easyui-validatebox" data-options=""  style="width: 182px;">
   		创建时间: <input id="startDate" class="easyui-datebox" name="startDate" style="width:182px">
    	To: <input id="endDate" class="easyui-datebox" name="endDate" style="width:182px">
    	<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="searchUserPaginationList()">查询</a>
   	</form>
   	<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="deleteUser()">删除</a>
</div>
<script type="text/javascript">
	$(function() {
		$('#admin_userList_datagrid').datagrid({    
		    title:'用户管理',
			url:'../user/findPage',  
		    columns:[[    
				{field:'',checkbox:true},  
		        {field:'id',title:'序号',width:100},    
		        {field:'name',title:'名称',width:100},    
		        {field:'createdatetime',title:'创建时间',width:200,formatter:function(value,row,index){
		        	if (value == null) {
		            	return null;
		            } else {
		            	var unixTimestamp = new Date(value);
			            var s = unixTimestamp.toLocaleString().replace(/\//g, "-");
			            return s.substring(0,18);
		            }
		        }},
		        {field:'modifydatetime',title:'修改时间',width:200,formatter:function(value,row,index){
		        	if (value == null) {
		            	return null;
		            } else {
		            	var unixTimestamp = new Date(value);
			            var s = unixTimestamp.toLocaleString().replace(/\//g, "-");
			            return s.substring(0,18);
		            }
		        }},
		    ]],
		    pagination: true,
		    fit: true,
		    singleSelect:true,
		    toolbar:'#userList_tb'
		});  
	})
	
	function searchUserPaginationList() {
		$('#admin_userList_datagrid').datagrid('load', {
			name: $("#name").val(),
			startDate: $("#startDate").datebox('getValue'),
			endDate: $("#endDate").datebox('getValue')
		});
	}
	
	function deleteUser() {
		var data = $("#admin_userList_datagrid").datagrid('getSelected');
		if (data == null) {
			alert("请选择一条需要删除的信息");
		}
		if (confirm("确定要删除吗?")) {
			$.ajax({
				type: 'post',
				url: '../user/deleteUser',
				data: {'id': data.id},
				dataType:'json',
				success: function(result) {
					if (result.success) {
						alert(result.message);
						searchUserPaginationList();
					} else {
						alert(result.message);
					}
				},
				error: function() {
					alert("系统错误，请联系管理员！");
				}
			})
		}
	}
</script>
</body>
</html>