<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>未完成订单</title>
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
	<script src="js/orderinfo.js"></script>
	
  <body>
   <table id="dg" title="未完成订单列表" class="easyui-datagrid" style="width:550px;height:250px"
		url="UserServlet.do?action=list"
		toolbar="#toolbar"
		pagination="true"
		pageSize="3"
		pageList="[3,6,9]"
		sortName="userId"
		sortOrder="asc"
		rownumbers="true" fit="true" fitColumns="true" singleSelect="true">
	<thead>
		<tr>
			<th field="orderId" width="50" sortable="true">编号</th>
			<th field="tableId" width="50" sortable="true">桌号</th>
			<th field="orderBeginDate" width="50" sortable="true">开始时间</th>
			<th field="waiterId" width="50" sortable="true">点餐员</th>
			<th field="orderState" width="50" sortable="true">订单状态</th>
		</tr>
	</thead>
</table>
<div id="toolbar">
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" plain="true" onclick="finishOrder()">买单</a>
</div>
<!-- 创建买单的表单对话框 -->
<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
		closed="true" buttons="#dlg-buttons">
	<div class="ftitle"></div>
	<form id="fm" method="post">
	 <input name="id" type="hidden" />
	 <br/>
		<div class="fitem">
			<label>编号:</label>
			<input name="orderId" class="easyui-validatebox" required="true">
		</div>
		<div class="fitem">
			<label>桌号:</label>
			<input name="tableId" class="easyui-validatebox">
		</div>
		<div class="fitem">
			<label>已点菜式</label>
			<input name="menu" class="easyui-validatebox" validType="number">
		</div>
	</form>
</div>
<div id="dlg-buttons">
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">保存</a>
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
</div>
<br/>
  </body>
</html>
