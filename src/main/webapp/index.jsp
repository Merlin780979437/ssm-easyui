<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./jslib/jquery-easyui-1.4.4/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="./jslib/jquery-easyui-1.4.4/themes/icon.css">
<script type="text/javascript" src="./jslib/jquery-easyui-1.4.4/jquery.min.js"></script>
<script type="text/javascript" src="./jslib/jquery-easyui-1.4.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="./jslib/jquery-easyui-1.4.4/locale/easyui-lang-zh_CN.js"></script>
<title>金科电商后台系统</title>
</head>
<body>
<div id="index_layout" class="easyui-layout" data-options="fit:true">   
    <div data-options="region:'north',split:true" style="height:100px;"></div>   
    <div data-options="region:'south',split:true" style="height:30px;"></div>   
    <div data-options="region:'west',title:'菜单管理',split:true" style="width:200px;">
    	<div id="index_accordion" class="easyui-accordion" data-options="fit:true">   
		    <div title="日常管理" data-options="" style="overflow:auto;padding:10px;">   
		        <div id="index_tree"></div>
		    </div>   
		    <div title="资源管理" data-options="" style="padding:10px;">   
		       
		    </div>   
		    <div title="系统管理">   
		         
		    </div>   
		</div>  
    </div>   
    <div data-options="region:'center'" style="padding:5px;">
    	<div id="index_tabs" class="easyui-tabs" data-options="fit:true">   
		    <div title="欢迎页面" style="padding:1px;">   
		        <h1 align="center">欢迎来到金科教育电商后台管理系统</h1> 
		    </div>  
		</div>  
    </div>   
</div>  
<!-- 用户分配角色 -->
<div id="sysUserList_dialog" class="easyui-dialog" title="用户分配角色" style="width:600px;height:400px;"   
        data-options="iconCls:'icon-man',resizable:true,modal:true">   
    <div id="index_sysRoleList"></div>
</div>  

<div id="sysRoleList_dialog" class="easyui-dialog" title="角色分配权限" style="width:600px;height:400px;"   
        data-options="iconCls:'icon-man',resizable:true,modal:true">   
    <ul id="index_sysPermissionList"></ul>  
</div>  

<script type="text/javascript">
	$(function() {
		$("#sysUserList_dialog").dialog('close');
		$("#sysRoleList_dialog").dialog('close');
	})
	
	$('#index_tree').tree({    
	    url:'tree_data1.json',
	    onClick: function(node){
			var url = "${pageContext.request.contextPath}/" + node.url;
			var bol = $("#index_tabs").tabs('exists', node.text);
			if (bol) {
				$("#index_tabs").tabs('select', node.text);
			} else {
				$("#index_tabs").tabs('add', {
					title: node.text,
					content: '<iframe src="' + url + '" frameBorder="0" style="border:0;width:100%;height:99%;"></iframe>',
					closable: true
				})
			}
		},
		onLoadError: function(result) {
			if(result.responseText == 'loseToken') {
				window.location.href = "login.jsp";
			}
			if (result.responseText == 'noSecurity') {
				window.location.href = "error/noSecurity.jsp";
			}
		}
	}); 
</script>
</body>
</html>