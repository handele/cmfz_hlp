<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>持名法州后台管理中心</title>
			
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
	<link rel="icon" href="img/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" href="css/common.css" type="text/css"></link>
	<link rel="stylesheet" href="css/login.css" type="text/css"></link>
	<script type="text/javascript" src="script/jquery.js"></script>
	<script type="text/javascript" src="script/common.js"></script>
	<script type="text/javascript">
	
		$(function(){
			//点击更换验证码：
			$("#captchaImage").click(function(){//点击更换验证码
					$("#captchaImage").attr("src","${pageContext.request.contextPath}/ValidationCodeAction/code.do?flag="+Math.random()); 
				});
				
			$("#butt").click(function(){
				var name = $("#user").val();
				var pass = $("#pass").val();
				var code = $("#enCode").val();
				console.log(name+pass+code);
					$.ajax({
						type:"POST",
						url:"${pageContext.request.contextPath}/admin/login", //你的请求程序页面随便
						data:{"username":name,"password":pass,"code":code},   //请求需要发送的处理数据
						success:function(data){
							
							if (data.message=="ok") {   //根据返回值进行跳转
								location.href ="/cmfz_hlp/main/main.jsp";
							}else{
								if(data.message=="no1"){
									$("#pw").text("密码错误");
								}else{
									$("#pw").text("验证码错误");
								}
							}
							
						}			
				});
			});
		});
	</script>
</head>
<body>
	
		<div class="login">
			<form id="loginForm">
				
				<table>
					<tbody>
						<tr>
							<td width="190" rowspan="2" align="center" valign="bottom">
								<img src="img/header_logo.gif" />
							</td>
							<th>
								用户名:
							</th>
							<td>
								<input type="text" id="user" name="username" class="text"  maxlength="20"/>
							</td>
					  </tr>
					  <tr>
							<th>
								密&nbsp;&nbsp;&nbsp;码:
							</th>
							<td>
								<input type="password" id="pass" name="password" class="text"  maxlength="20" autocomplete="off"/>
							</td>
					  </tr>
					
						<tr>
							<td>&nbsp;</td>
							<th>验证码:</th>
							<td>
								<input type="text" id="enCode" name="code" class="text captcha" maxlength="4" autocomplete="off"/>
								<img id="captchaImage" class="captchaImage" src="${pageContext.request.contextPath}/ValidationCodeAction/code" title="点击更换验证码"/>
							</td>
						</tr>					
					<tr>
						<td>
							&nbsp;
						</td>
						<th>
							&nbsp;
						
						</th>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<th>&nbsp;</th>
						<td>
							
							<span id="pw" style="color: red" ></span>
							<br/>
							<input type="button" class="homeButton" value="" onclick="location.href='/'"><input id="butt" type="button" class="loginButton" value="登录">
						</td>
					</tr>
				</tbody></table>
				<div class="powered">COPYRIGHT © 2008-2017.</div>
				<div class="link">
					<a href="http://www.chimingfowang.com/">持名佛网首页</a> |
					<a href="http://www.chimingbbs.com/">交流论坛</a> |
					<a href="">关于我们</a> |
					<a href="">联系我们</a> |
					<a href="">授权查询</a>
				</div>
			</form>
		</div>
</body>
</html>