<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>人事管理</title>
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
	<script src="js/userinfo.js"></script>
	
  <body>
   <table id="dg" title="人员列表" class="easyui-datagrid" style="width:550px;height:250px"
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
			<th field="userId" width="50" sortable="true">编号</th>
			<th field="userAccount" width="50" sortable="true">账号</th>
			<th field="role" width="50" sortable="true">角色</th>
			<th field="locked" width="50" sortable="true">锁定状态</th>
		</tr>
	</thead>
</table>
<div id="toolbar">
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">添加</a>
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUserRole()">修改职位</a>
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUserPW()">修改密码</a>
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="delUser()">删除</a>
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-lock" plain="true" onclick="lockUser()">加/解锁</a>
</div>
<!-- 创建添加的表单对话框aa -->
<div id="addDlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
		closed="true" buttons="#dlg-buttons0">
	<div class="ftitle"></div>
	<form id="add" method="post">
	 <br/>
		<div class="fitem">
			<label>编号:</label>
			<input name="userId" class="easyui-validatebox" required="true">
		</div>
		<div class="fitem">
			<label>账号:</label>
			<input name="userAccount" class="easyui-validatebox">
		</div>
		<div class="fitem">
			<label>职位:</label>
			<select name="role">
			<option>管理员</option>
			<option>后厨</option>
			<option>服务员</option>
			</select>
		</div>
		<div class="fitem">
			<label>密码:</label>
			<input type="password" name="userPass" class="easyui-validatebox" validType="number">
		</div>
		<div class="fitem">
			<label>是否锁定:</label>
			<input type="checkbox" name="locked" class="easyui-validatebox" validType="number">
		</div>
	</form>
</div>
<div id="dlg-buttons0">
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">保存</a>
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#addDlg').dialog('close')">取消</a>
</div>
<!-- 创建修改的表单对话框 -->
<div id="editPWDlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
		closed="true" buttons="#dlg-buttons1">
	<div class="ftitle"></div>
	<form id="editPW" method="post">
	<input type="hidden" name="userAccount">
	 <br/>
		<div class="fitem">
			<label>密码:</label>
			<input type="password" name="userPass" class="easyui-validatebox" validType="number">
		</div>
	</form>
</div>
<div id="dlg-buttons1">
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUserPW()">保存</a>
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#editPWDlg').dialog('close')">取消</a>
</div>
<!-- 创建修改的表单对话框 -->
<div id="editRoleDlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
		closed="true" buttons="#dlg-buttons2">
	<div class="ftitle"></div>
	<form id="editRole" method="post">
	<input type="hidden" name="userAccount">
	 <br/>
		<div class="fitem">
			<label>职位:</label>
			<select name="role">
			<option>管理员</option>
			<option>后厨</option>
			<option>服务员</option>
			</select>
		</div>
	</form>
</div>
<div id="dlg-buttons2">
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUserRole()">保存</a>
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#editRoleDlg').dialog('close')">取消</a>
</div>
<br/>
  </body>
</html>

