<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>已完成订单</title>
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
	
  <body  bgcolor="#DABFAD">
   <table id="dg" title="已完成订单列表" class="easyui-datagrid" style="width:550px;height:250px"
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
			<th field="menu" width="50" sortable="true">已点菜式  </th>
		</tr>
	</thead>
</table>
  </body>
</html>
