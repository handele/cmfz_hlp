<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
<link rel="stylesheet" type="text/css" href="../themes/icon.css"></link>
<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">   
<link rel="stylesheet" type="text/css" href="../themes/IconExtension.css">   
<script type="text/javascript" src="../js/jquery.min.js"></script>   
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>  
<script type="text/javascript" src="../js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../js/datagrid-detailview.js"></script>
<script type="text/javascript">
	//菜单处理
	$(function(){
		$.ajax({
			type:"GET",
			url:"${pageContext.request.contextPath}/menu/menuAll",
			//后台响应过来的对象
			success:function(data){
				//进行遍历
				$.each(data,function(index,menu){
					
					var content="<div align='center'>";
					
					$.each(menu.menu,function(i,child){
							var childs = JSON.stringify(child);
							
							content+="<a class='easyui-linkbutton' onclick='addTab("+childs+")'>"+child.title+"</a>";
					});
					content+="</div>";
					
					$("#aa").accordion('add',{
						title: menu.title,
						iconCls:menu.iconCls,
						content: content,
						selected: false
					});
				});
			
			}
		});
	});
	
	//点击添加选项卡
	function addTab(child){
		var tit = $("#tt").tabs('exists',child.title);
		
		if(!tit){
			$("#tt").tabs('add',{
				
				title:child.title,
				href:"${pageContext.request.contextPath}"+child.url,
				closable:true,
				tools:[{
					  iconCls:'icon-mini-refresh',    
				        handler:function(){    
				            alert('refresh');    
				       }   
				}]
				
			});
		}else{
			$("#tt").tabs('select',child.title);		
		}
	}
	
	//修改密码 	
	function editMain(){
		$("#pwd").blur(function(){
			var password = ${sessionScope.admin.password}
			//console.log(password);
			var pwd = $("#pwd").val();
			console.log(password+pwd);
			if(password==pwd){
				$("#span").text("输入正确");
			}else{
				$("#span").text("输入错误");
			}
		});
		
		$("#userPwd").dialog({
			title:"管理员密码修改",
			width:500,
			height:500,
			buttons:[
			         {
			        	 text:'提交',
			        	 iconCls:'icon-ok',
			        	 handler:function(){
			        		 $('#userForm').form('submit', {
			        			    url:"${pageContext.request.contextPath}/admin/adminUpdate",
			        			    onSubmit: function(){
			        			    	 var span =$("#span").text();
			        			    	console.log(span); 
			        			    	if(span=="输入正确"){
			        						return true;
				        			    	 }else{
			        			    		 return false;
			        			    	 } 
			        			    
			        			    },
				        			 success:function(data){    
				        				 window.location.reload();
				        		    }
			        			   
			        			});
			        			
			        	 }
			         }
			       ]
			
		});
		
	}
</script>

</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:${sessionScope.admin.username} &nbsp;<a href="#" class="easyui-linkbutton" onclick="editMain();" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/admin/quit" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
    </div>   
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 zhangcn@zparkhr.com.cn</div>
    </div>   
       
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    	<div id="aa" class="easyui-accordion" data-options="fit:true">
    		
		</div>  
    </div>   
    
   
    <div data-options="region:'center'">
    	<div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">   
		    <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
		</div>  
    </div>  
    
<div id="userPwd" style="background-image: url('${pageContext.request.contextPath}/upload/c8f7d3210ae3826e22dc9d6455fdb155.jpg');">	
	<br/>	
	<div align="center">
		<font style="color: red"><h1>管理员修改密码</h1></font>
	
	</div>
	<br/><br/>
			<div align="center">
				<form id="userForm" method="post">   
		    <div>   
		      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  <label for="name">请输入原始密码 &nbsp;&nbsp;:</label> 
		        <input class="easyui-validatebox" id="pwd" type="text" name="pwd" data-options="required:true" /> <span id="span"></span>
		    </div>   
		    <div>   
		        <label for="pass">请输入要修改的密码：:</label>   
		        <input class="easyui-validatebox" type="text" name="password" data-options="required:true" />   
		    </div>   
				</form>  
			</div>
	<br/>	<br/>	<br/>
	<div align="center"><font style="color: red;font-size: 6px">温馨提示:修改成功后将会跳转到登录界面</font></div>
	<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

	<div align="center"><font style="font-size: 6px">&copy;:天津市武清区百知146班九组  注</font></div>
</div>
     
</body> 
</html>