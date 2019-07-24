<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<script>
	$(function(){
		$("#albumTable").treegrid({    
		    url:'${pageContext.request.contextPath}/album/albumPage',    
		    idField:'id', 
		    treeField:'title', 
		    pagination:true,
		    pageSize:5,
		    pageList:[5,10,15,20], 
		    fitColumns:true,
		    toolbar:'#albumDiv',
		    columns:[[    
		        {field:'title',title:'标题',align:'left'},    
		        {field:'url',title:'路径',width:80},    
		        {field:'size',title:'大小',width:80},    
		        {field:'duration',title:'时长',width:80},    
		        {field:'pub_date',title:'上传时间',width:80}   
		    ]]    
		}); 
	});
	
	//添加专辑
	function albumAdd(){
		$('#albumInsert').dialog({
			title:"添加专辑",
			buttons:[{
				text:'提交',
				handler:function(){
					$("#albumFormAdd").form('submit',{
						url:"${pageContext.request.contextPath}/album/insert",    
					    onSubmit: function(){    
						 	return $("#albumFormAdd").form('validate');
					    },    
					    success:function(data){    
						 	$("#albumInsert").dialog('close');
							$("#albumTable").datagrid('load');
						}   
					});    
						
				}
			}]
		})
	}
	
	
	//添加章节
	function chapterAdd(){
		var row= $("#albumTable").treegrid('getSelected');
			if(row==null){
				$.messager.confirm('提示信息','请选择一行');
			}else{
			if(row.count==null){
				$.messager.confirm('提示信息','请选择专辑');
			}else{
				$('#chapterInsert').dialog({
				title:"添加章节",
				buttons:[{
					text:'提交',
					handler:function(){
						$("#chapterFormAdd").form('submit',{
							
							url:"${pageContext.request.contextPath}/chapter/insert?id="+row.id,    
						    onSubmit: function(){    
							 	return $("#chapterFormAdd").form('validate');
						    },    
						    success:function(data){    
							 	$("#chapterInsert").dialog('close');
								$("#albumTable").treegrid('load');
							}   
						});    
					}
				}]
			})
			}
		}
	
	}
	
	//详细专辑
	function albumMinute(){
		var row= $("#albumTable").treegrid('getSelected');
		if(row==null){
			$.messager.confirm('提示信息','请选择一行');
		}else{
			if(row.count==null){
				$.messager.confirm('提示信息','请选择专辑');
			}else{
				$('#albumShow').dialog({    
				   width:450,
				   height:450,
				   href:"${pageContext.request.contextPath}/banner/Albumform.jsp",    
				 	queryParams: {
						"title":row.title,
						"scope":row.scope,
						"author":row.author,
						"img_path":row.img_path,
						"beam":row.beam,
						"count":row.count,
						"content":row.content,
						"pub_date":row.pub_date,
					}
				});
			}
		}
	}
	
	//下载音频
	function chapterDownload(){
		var row= $("#albumTable").treegrid('getSelected');	
		if(row==null){
			$.messager.confirm('提示信息','请选择一行');
		}else{
			if(row.album_id==null){
				$.messager.confirm('提示信息','请选择专辑');
			}else{
				location.href ="${pageContext.request.contextPath}/chapter/download?yn=y&fileName="+row.url;
			}
		}
	}
	
	//在线播放音频
	function chapterOn(){
		var row= $("#albumTable").treegrid('getSelected');	
		if(row==null){
			$.messager.confirm('提示信息','请选择一行');
		}else{
			if(row.album_id==null){
				$.messager.confirm('提示信息','请选择专辑');
			}else{
				location.href ="${pageContext.request.contextPath}/chapter/download?fileName="+row.url;
			}
		}
	}
	
</script>	


	<table id="albumTable"></table>  
	
	<div id="albumDiv">
		<a href="#" class="easyui-linkbutton" onclick="albumMinute();" data-options="iconCls:'icon-edit',plain:true">专辑详情</a>
		<a href="#" class="easyui-linkbutton" onclick="albumAdd();" data-options="iconCls:'icon-help',plain:true">添加专辑</a>
		<a href="#" class="easyui-linkbutton" onclick="chapterAdd();" data-options="iconCls:'icon-help',plain:true">添加章节</a>
		<a href="#" class="easyui-linkbutton" onclick="chapterDownload();" data-options="iconCls:'icon-help',plain:true">下载音频</a>
		<a href="#" class="easyui-linkbutton" onclick="chapterOn();" data-options="iconCls:'icon-help',plain:true">在线播放</a>
	</div>
	
	<div id="albumInsert" style="display: none;width: 350px;height: 350px;" align="center" >
		<form id="albumFormAdd" method="post" enctype="multipart/form-data">   
		    <div>   
		        <label for="name">标题:</label>   
		        <input class="easyui-validatebox" type="text" name="title" data-options="required:true" />   
		    </div>  
		    <br/> 
		    <div>   
		        <label for="email">作者:</label>   
		        <input class="easyui-validatebox" type="text" name="author" data-options="required:true" />   
		    </div>   <br/>  
		      <div>   
		        <label for="name">播音:</label>   
		        <input class="easyui-validatebox" type="text" name="beam" data-options="required:true" />   
		    </div>    <br/> 
		    <div>   
		        <label for="email">简介:</label>   
		        <input class="easyui-validatebox" type="text" name="content" data-options="required:true" />   
		    </div>   
   			 <div>   
		        <label for="email">上传头像:</label>   
		        <input class="easyui-filebox" type="text" name="ph" data-options="required:true,width:150" />   
		    </div>   <br/>  
		</form>  
	</div>
	
	<div id="chapterInsert" style="display: none;width: 350px;height: 350px;" align="center" >
		<form id="chapterFormAdd" method="post" enctype="multipart/form-data">   
		    <div>   
		        <label for="name">标题:</label>   
		        <input class="easyui-validatebox" type="text" name="title" data-options="required:true" />   
		    </div>  
		    <br/> 
		    <div>   
		        <label for="email">上传章节:</label>   
		        <input class="easyui-filebox" type="text" name="music" data-options="required:true,width:150" />   
		    </div>   <br/>  
		  
		</form>  
	</div>
	<div id="albumShow"></div>
	
	
