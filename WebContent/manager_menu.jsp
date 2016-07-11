<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>菜品管理</title>
    <meta />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="css/themes/icon.css">
	<script src="js/jquery.min.js"></script>
	<script src="js/jquery.easyui.min.js"></script>	
	<script type="text/javascript" src="js/easyui-lang-zh_CN.js" charset="utf-8"></script></head>  
	<script src="js/dish.js"></script>
	
  <body>
   <table id="dg" title="菜品管理" class="easyui-datagrid" style="width:550px;height:250px"
		url="DishServlet.do?action = list"
		toolbar="#toolbar"
		pagination="true"
		pageSize="3"
		pageList="[3,6,9]"
		sortName="dishesId"
		sortOrder="asc"
		rownumbers="true" fit="true" fitColumns="true" singleSelect="true">
	<thead>
	    <tr>
			<th field="dishesId" width="50" sortable="true">编号</th>
			<th field="dishesName" width="50" sortable="true">菜名</th>
			<th field="dishesImg" width="50" sortable="true">图片</th>
			<th field="dishesDiscript" width="50" sortable="true">简介</th>
			<th field="dishesTxt" width="50" sortable="true">详细介绍</th>
		    <th field="recommend" width="50" sortable="true">是否推荐</th>
		    <th field="dishesPrice" width="50" sortable="true">单价</th>
		   
		</tr>
	</thead>
</table>
<div id="toolbar">
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newBook()">添加</a>
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editBook()">修改</a>
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="delBook()">删除</a>
</div>
<!-- 创建添加或修改的表单对话框 -->
<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
		closed="true" buttons="#dlg-buttons">
	<div class="ftitle"></div>
	<form id="fm" method="post">
	 <input name="id" type="hidden" />
	 <br/>
	     <div class="fitem">
			<label>编号:</label>
			<input name="dishesId" class="easyui-validatebox" required="true">
		</div>
		<div class="fitem">
			<label>菜名:</label>
			<input name="dishesName" class="easyui-validatebox" required="true">
		</div>
		<div class="fitem">
			<label>简介:</label>
			<input name="dishesDiscript" class="easyui-validatebox">
		</div>
		<div class="fitem">
			<label>单价:</label>
			<input name="dishesPrice" class="easyui-validatebox" validType="number">
		</div>
		<div class="fitem">
			<label>详细介绍:</label>
			<input name="dishesTxt" class="easyui-validatebox" validType="number">
		</div>
		<div class="fitem">
			<label>是否推荐:</label>
			<input name="recommend" class="easyui-validatebox">
		</div>
		<div class="fitem">
			<label>图片:</label>
			<input name="dishesImg" class="easyui-validatebox">
		</div>
	</form>
</div>
<div id="dlg-buttons">
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveBook()">保存</a>
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
</div>
<br/>
  </body>
</html>
