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
<title>用户登录</title>
</head>
<body>
	<div id="login_dialog" class="easyui-dialog" title="用户登录" style="width:280px;height:170px;padding-left: 14px; padding-top: 12px; "   
        data-options="iconCls:'icon-user',closable:false,modal:true">   
	    <form id="login_form" method="post" action="">
	    	用户名：<input class="easyui-textbox" id="usercode" name="usercode" data-options="iconCls:'icon-man'" style="width:182px"><br><br>
	    	密&nbsp;&nbsp;&nbsp;码：<input class="easyui-textbox" id="password" name="password" data-options="iconCls:'icon-lock'" style="width:182px"> 
	    </form>  
	</div> 
	
	<script type="text/javascript">
		$("#login_dialog").dialog({
			buttons:[{
				text:'登录',
				handler:function(){
					$('#login_form').form('submit', {    
					    url:'login/login',    
					    success:function(data){    
					    	var data = eval('(' + data + ')');  
					    	if (data.success) {
					    		window.location.href = "index.jsp";
					    	} else {
					    		$.messager.show({
					    			title:'提示！',
					    			msg:data.message,
					    			timeout:3000,
					    			showType:'slide'
					    		});
					    	}
					    }    
					});  
				}
			}]
		});
	</script> 
</body>
</html>