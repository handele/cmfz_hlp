<%@page pageEncoding="UTF-8"  %>

<script>
	$(function(){
		$("#bannertable").datagrid({
			url:"${pageContext.request.contextPath}/banner/paging",
			pagination:true,
		    pageSize:5,
		    pageList:[5,10,15,20], 
		    fitColumns:true,
		    toolbar:"#bannerdiv",
			columns:[[    
		        {field:'id',title:'id',width:100},    
		        {field:'title',title:'名称',width:100},    
		        {field:'status',title:'状态',width:100,
		        	formatter: function(value,row,index){
						if (value==1){
							return "<input class='swbutton' value='"+row.id+"' checked/>";
						} else {
							return "<input class='swbutton' value='"+row.id+"' />";
						}
					}
		        },    
		        {field:'pub_data',title:'上传时间',width:100}  
		    ]],
		   	view: detailview, 
			detailFormatter: function(rowIndex, rowData){ 
			return '<table><tr>' + 
			'<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}'+rowData.img_path+'" style="height:50px;"></td>' + 
			'<td style="border:0">' + 
			'<p>名字: ' + rowData.title + '</p>' + 
			'<p>状态: ' + rowData.status + '</p>' + 
			'<p>路径: ' + rowData.img_path  + '</p>' + 
			'</td>' + 
			'</tr></table>'; 
			},
			onLoadSuccess:function(data){
				$(".swbutton").switchbutton({
					onText:"在线",				
					offText:"冻结",
					width:50,
					height:20,
					onChange:function(dat){
						if(dat){
							$.ajax({
								type:"POST",
								datatype:"JSON",
								url:"${pageContext.request.contextPath}/banner/update",
								data:{"id":$(this).val(),"status":"1"},
								success:function(data){
									$.messager.show({
										title:'提示信息',
										msg:data.message,
										timeout:5000,
										showType:'slide'
									});
								}
							});
						}else{
							$.ajax({
								type:"POST",
								datatype:"JSON",
								url:"${pageContext.request.contextPath}/banner/update",
								data:{"id":$(this).val(),"status":"0"},
								success:function(data){
									$.messager.show({
										title:'提示信息',
										msg:data.message,
										timeout:5000,
										showType:'slide'
									});
								}
							});
						}
						$("#bannertable").datagrid('load');
					}
				});
			}
		});
	//添加
	$("#addBanner").click(function(){
		$("#bannerform").form({
			url:"${pageContext.request.contextPath}/banner/insert",
			onSubmit:function(param){
					console.log($('#bannerform').form('validate'));
					return $('#bannerform').form('validate');
			},
				success:function(r){
				   	$("#bannerAdd").dialog('close');
					$("#bannertable").datagrid('load');
				}
		});
			//初始化会话窗口
		$("#bannerAdd").dialog({
				title:'编辑',
				iconCls:'icon-edit',
				width:500,
				height:350,
				buttons:[
				         {
				        	 text:'提交',
				        	 iconCls:'icon-ok',
				        	 handler:function(){
				        		 // 提交表单
				        		 $('#bannerform').submit();
				        	 }
				         }
				        ]
			});
	});
	
	
	//删除
	$("#delBanner").click(function(){
		var selRow = $("#bannertable").datagrid("getSelected");
		
		$.ajax({
			type:"GET",
			url:"${pageContext.request.contextPath}/banner/delete?id="+selRow.id,
			success:function(data){
				
			}	
		});		
		$("#bannertable").datagrid('load');
	});
	
});

</script>
	
	<table id="bannertable"></table>
	
	<div id="bannerdiv">
		<a href="#" class="easyui-linkbutton"  id="addBanner" data-options="iconCls:'icon-add',plain:true">轮播图添加</a>
		<a href="#" class="easyui-linkbutton" id="delBanner" data-options="iconCls:'icon-remove',plain:true">轮播图删除</a>
	</div>
	
	
	<div id="bannerAdd" style="display: none;width:500px;height:300px;">
			<form id="bannerform" method="post" enctype="multipart/form-data" align="center">
				标题：<input  name="title"  class="easyui-validatebox" data-options="required:true"><br/>
				图片：<input  name="uplo"  class="easyui-filebox" data-options="required:true" style="width:150px"><br/>
				描述：<input  name="description"  class="easyui-validatebox" data-options="required:true"><br/>
				状态：<input  name="status"  class="easyui-validatebox" data-options="required:true"><br/>
			</form>
	</div> 


