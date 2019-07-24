<%@page pageEncoding="UTF-8"%>

<div id="albumShow" align="center">
		<form>
			标题：<input id="title" value="${param.title}" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:300px">  <br/><br/>
			评分：<input id="scope" value="${param.scope}" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:300px">  <br/><br/>
			作者：<input id="author" value="${param.author}" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:300px">  <br/><br/>
			头像：<img id="img_path" width="60px" height="50px" src="${pageContext.request.contextPath}${param.img_path}"><br/><br/>
			播音：<input id="beam" value="${param.beam}" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:300px">  <br/><br/>
			集数：<input id="count" value="${param.count}" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:300px">  <br/><br/>
			详情：<input id="content" value="${param.content}" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:300px">  <br/><br/>
		   发布日期：<input id="pub_date" value="${param.pub_date}" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:300px">  <br/><br/>
		</form>
	</div>