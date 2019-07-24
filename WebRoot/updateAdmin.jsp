<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTf-8" %>
	<script type="text/javascript">
		$(function(){
			
			$("#pwd").blur(function(){
				var password = ${sessionScope.admin.password}
				console.log(password);
				var pwd = $("#pwd").val();
				console.log(password+pwd);
				if(password==pwd){
					$("span").text("输入正确");
				}else{
					$("span").text("输入错误");
				}
			});
		});
	</script>

