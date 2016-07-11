function newUser(){
	$('#addDlg').dialog('open').dialog('setTitle','添加新用户');
	$('#add').form('clear');
	url = 'UserServlet.do?action=save';
}

function editUserRole(){
	var row = $('#dg').datagrid('getSelected');
	if (row){
		$('#editRoleDlg').dialog('open').dialog('setTitle','修改用户资料');
		$('#editRole').form('load',row);
		url = 'UserServlet.do?action=updateRole';
	}else
		alert('请选择要修改的记录！');
}

function editUserPW(){
	var row = $('#dg').datagrid('getSelected');
	if (row){
		$('#editPWDlg').dialog('open').dialog('setTitle','修改用户资料');
		$('#editPW').form('load',row);
		url = 'UserServlet.do?action=updatePW';
	}else
		alert('请选择要修改的记录！');
}

function saveUser(){
	$('#add').form('submit',{
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
				$('#addDlg').dialog('close'); // close the dialog
				$('#dg').datagrid('reload');// reload the user data
			}
		}
	});
}
function saveUserPW(){
	$('#editPW').form('submit',{
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
				$('#editPWDlg').dialog('close'); // close the dialog
				$('#dg').datagrid('reload');// reload the user data
			}
		}
	});
}
	function saveUserRole(){
		$('#editRole').form('submit',{
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
					$('#editRoleDlg').dialog('close'); // close the dialog
					$('#dg').datagrid('reload');// reload the user data
				}
			}
		});
	}
function delUser(){
	var row = $('#dg').datagrid('getSelected');
	if (row){
		$.messager.confirm('Confirm','确定要删除这位用户吗?',function(r){
			if (r){
				$.post('UserServlet.do?action=delete',{userAccount:row.userAccount},function(result){
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

function lockUser(){
	var row = $('#dg').datagrid('getSelected');
	if (row){
		$.messager.confirm('Confirm','确定要加/解锁这位用户吗?',function(r){
			if (r){
				$.post('UserServlet.do?action=lock',{userAccount:row.userAccount},function(result){
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