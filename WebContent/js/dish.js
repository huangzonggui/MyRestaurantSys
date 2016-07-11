function newBook(){
	$('#dlg').dialog('open').dialog('setTitle','添加新菜品');
	$('#fm').form('clear');
	url = 'DishServlet.do?action=save';
}

function editBook(){
	var row = $('#dg').datagrid('getSelected');
	if (row){
		$('#dlg').dialog('open').dialog('setTitle','修改菜品资料');
		$('#fm').form('load',row);
		url = 'DishServlet.do?action=update';
	}else
		alert('请选择要修改的记录！');
}

function saveBook(){
	$('#fm').form('submit',{
		url: url,
		onSubmit: function(){
			return $(this).form('validate');
		},
		success: function(result){
			var result = eval('('+result+')');
			if (result.errorMsg){
				$.messager.show({
				title: '错误',
				msg: result.errorMsg
				});
			} else {
				$('#dlg').dialog('close'); // close the dialog
				$('#dg').datagrid('reload');// reload the user data
			}
		}
	});
}
 
function delBook(){
	var row = $('#dg').datagrid('getSelected');
	if (row){
		$.messager.confirm('Confirm','确定要删除这条记录吗?',function(r){
			if (r){
				$.post('DishServlet.do?action=delete',{dishesId:row.dishesId},function(result){
					if (result.success){
						$('#dg').datagrid('reload');	// reload the user data
					} else {
						$.messager.show({	// show error message
							title: '错误',
							msg: result.errorMsg
						});
					}
				},'json');
			}
		});
	}else
		alert('请选择要删除的记录！');	
}
