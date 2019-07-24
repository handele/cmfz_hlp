<%@page pageEncoding="UTF-8" %>

<script>
	$(function(){
		$("#userTable").datagrid({    
	   		pagination:true,
		    pageSize:5,
		    pageList:[5,10,15,20], 
		    fitColumns:true,
	   	 	url:"${pageContext.request.contextPath}/user/userpage",
	    	columns:[[ 
		        {field:'id',title:'ID',width:100},    
		        {field:'name',title:'用户名',width:100},   
		        {field:'sex',title:'性别',width:100},    
		        {field:'status',title:'状态',width:100,
		        	formatter: function(value,row,index){
						if (value==1){
							return "<input class='userbutton' value='"+row.id+"' checked/>";
						} else {
							return "<input class='userbutton' value='"+row.id+"' />";
						}
					}
					},     
		        {field:'guru_id',title:'师傅',width:100,align:'right'},  
		        {field:'reg_date',title:'日期',width:100}
		    ]],
		    view: detailview, 
			detailFormatter: function(rowIndex, rowData){ 
			return '<table><tr>' + 
			'<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}'+rowData.head_img+'"></td>' + 
			'<td style="border:0">' + 
			'<p>名字: ' + rowData.legal_name + '</p>' + 
			'<p>状态: ' + rowData.status + '</p>' + 
			'<p>城市: ' + rowData.city  + '</p>' + 
			'</td>' + 
			'</tr></table>'; 
			},
			onLoadSuccess:function(data){
				$(".userbutton").switchbutton({
					onText:"在线",				
					offText:"冻结",
					width:50,
					height:20,
					onChange:function(dat){
						if(dat){
							$.ajax({
								type:"POST",
								datatype:"JSON",
								url:"${pageContext.request.contextPath}/user/userUpadte",
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
								url:"${pageContext.request.contextPath}/user/userUpadte",
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
						$("#userTable").datagrid('load');
					}
				});
			}
		}); 
	});
</script>

<table id="userTable"></table>
