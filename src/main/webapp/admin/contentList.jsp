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
<title>广告管理</title>
</head>
<body>

<table id="admin_contentList_datagrid"></table> 


<script type="text/javascript">
	$(function() {
		
		$("#admin_contentList_datagrid").datagrid({    
		    title:'广告管理',
			url:'../content/findAll',  
		    columns:[[    
				{field:'',checkbox:true},  
		        {field:'id',title:'序号',width:100},    
		        {field:'title',title:'标题',width:100},
		        {field:'name',title:'广告类型名称',width:100}
		    ]],
		    fit: true
		}); 
	})
</script>
</body>
</html>