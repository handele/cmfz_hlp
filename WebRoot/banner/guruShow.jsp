<%@ page pageEncoding="UTF-8" %>

<script>
	$(function(){
		$("#guruTable").datagrid({
			pagination:true,
		    pageSize:5,
		    pageList:[5,10,15,20], 
		    fitColumns:true,
	   	 	url:"${pageContext.request.contextPath}/guru/guruPage",
	    	columns:[[ 
		        {field:'id',title:'ID',width:100},    
		        {field:'legal_name',title:'用户名',width:100},   
		        {field:'head_img',title:'图片',width:100,
                    formatter:function(value,row,index){
                        return "<img width='30px' height='20px' src='${pageContext.request.contextPath}/"+row.head_img+"'/>";
                    }
		        },
		        {field:'status',title:'状态',width:100,
		        	formatter: function(value,row,index){
						if (value==1){
							return "<input class='gurubutton' value='"+row.id+"' checked/>";
						} else {
							return "<input class='gurubutton' value='"+row.id+"' />";
						}
					}
		        },    
		        {field:'reg_date',title:'注册时间',width:100},   
			]],
			onLoadSuccess:function(data){
				$(".gurubutton").switchbutton({
					onText:"在线",				
					offText:"冻结",
					width:50,
					height:20,
					onChange:function(dat){
						if(dat){
							$.ajax({
								type:"POST",
								datatype:"JSON",
								url:"${pageContext.request.contextPath}/guru/update",
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
								url:"${pageContext.request.contextPath}/guru/update",
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
						$("#guruTable").datagrid('load');
					}
				});
			}
		});
		
	});
</script>

<table id="guruTable"></table>

