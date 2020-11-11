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
<title>角色管理</title>
</head>
<body>

<table id="admin_roleList_datagrid"></table> 

<div id="roleList_tb" style="padding:2px 5px;">
   	<form id="roleList_form">
    	角色姓名：<input id="name" name="name" class="easyui-validatebox" data-options=""  style="width: 182px;">
    	<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="searchRolePaginationList()">查询</a>
   	</form>
   	<a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="deleteRole()">删除</a>
   	<a href="#" class="easyui-linkbutton" iconCls="icon-man" onclick="roleAndPermission()">角色分配权限</a>
</div>



<script type="text/javascript">
	$(function() {
		$('#admin_roleList_datagrid').datagrid({    
		    title:'角色管理',
			url:'../sysRole/findPage',  
		    columns:[[    
				{field:'',checkbox:true},  
		        {field:'id',title:'序号',width:100},    
		        {field:'name',title:'角色姓名',width:100},
		        {field:'avialable',title:'状态',width:100,formatter:function(value,row,index){
		        	if (value == 0) {
		            	return "可用";
		            } else {
		            	return "锁定";
		            }
		        }}
		    ]],
		    pagination: true,
		    fit: true,
		    singleSelect:true,
		    toolbar:'#roleList_tb'
		});  
	})
	
	function searchRolePaginationList() {
		$('#admin_roleList_datagrid').datagrid('load', {
			name: $("#name").val()
		});
	}
	
	function deleteRole() {
		var data = $("#admin_roleList_datagrid").datagrid('getSelected');
		if (data == null) {
			alert("请选择一条需要删除的信息");
			return;
		}
		if (confirm("确定要删除吗?")) {
			$.ajax({
				type: 'post',
				url: '../sysRole/deleteRole',
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
	
	//
	function roleAndPermission() {
		var data = $("#admin_roleList_datagrid").datagrid('getSelected');
		if (data == null) {
			alert("请选择一条角色进行权限分配！");
			return ;
		}
		parent.$("#sysRoleList_dialog").dialog('open');
		parent.$('#index_sysPermissionList').tree({    
		    url:'sysPermission/initTree?roleId=' + data.id,
		    checkbox:true
		});  
		
		parent.$("#sysRoleList_dialog").dialog({
			buttons:[{
				text:'保存',
				handler:function(){
					//1、获得所有的权限id
					var nodes = parent.$('#index_sysPermissionList').tree('getChecked');
					var ids = [];
					for (var i = 0; i < nodes.length; i++) {
						ids.push(nodes[i].id);
					}
					
					$.ajax({
						type:'post',
						url:'../sysPermission/addRoleAndPermission',
						data: {'roleId': data.id, 'ids': ids.toString()},
						dataType:'json',
						success: function(result) {
							if (result.success) {
								alert(result.message);
								parent.$("#sysRoleList_dialog").dialog('close');
							} else {
								alert(result.message);
							}
						},
						error: function() {
							alert("系统 错误，请联系管理员！");
						}
					})
				}
			},{
				text:'关闭',
				handler:function(){
					parent.$("#sysRoleList_dialog").dialog('close');
				}
			}]
		})

		
		
	}
	
</script>
</body>
</html>