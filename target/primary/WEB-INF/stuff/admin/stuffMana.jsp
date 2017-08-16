<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>教职工管理</title>

<%@include file="../../../publicHead.jsp" %>

</head>
<body>

<table id="tt" class="easyui-datagrid" style="width:100%;height:100%"
		url="../findStuff.do" toolbar="#tb" pageList='[1,10,20,30,50]' singleSelect="true"
		rownumbers="true" pagination="true">
	<thead>
		<tr>
			<th field="stuffid" width="80">职工ID</th>
			<th field="name" width="80">职工姓名</th>
			<th field="authority" width="80" formatter="myformatter"> 职工权限</th>
			<th field="password" width="80">职工密码</th>
		</tr>
	</thead>
</table>

<div id="tb" style="padding:3px">
	<span>职工ID:</span>
	<input id="stuffid" style="line-height:26px;border:1px solid #ccc">
	<span>职工姓名:</span>
	<input id="name" style="line-height:26px;border:1px solid #ccc">
	<span>职工权限:</span>
	<input id="authority" style="line-height:26px;border:1px solid #ccc">
	<a href="#" class="easyui-linkbutton" plain="true" onclick="doSearch()">查找</a>
	<a href="#" class="easyui-linkbutton" plain="true" onclick="doReSet()">重置</a>
</div>

<div id="ajaxWin" class="easyui-window" title="修改资料" data-options="modal:true,collapsible:false,closed:true,maximizable:false,minimizable:false,resizable:false" style="width:550px;height:430px;padding:10px;">
	<div style="width: 400px; padding: 30px 60px;">
	<form id="ff" name="ff" method="post">
		<div style="margin-bottom: 20px">
			<input class="easyui-textbox theme-textbox-radius" id="fstuffid" name="stuffid" style="width: 100%" data-options="required:true, label:'职工ID:'" />
		</div>
		<div style="margin-bottom: 20px">
			<input class="easyui-textbox theme-textbox-radius" id="fname" name="name" style="width: 100%" data-options="required:true, label:'职工姓名:'" />
		</div>
			<input name="authority" id="subauthority" type="hidden" />
		<div style="margin-bottom: 20px">
			<select panelHeight="55" class="easyui-combobox" id="fauthority" style="width: 100%" data-options="label:'职工姓名:'" >
				<option value="0" selected>非管理员</option>
				<option value="1">管理员</option>
			</select>
		</div>
		<div style="margin-bottom: 20px">
			<input class="easyui-passwordbox easyui-validatebox theme-textbox-radius" name="password" id="ipassword1" validType="length[1,16]"  iconWidth="28" style="width: 100%"
				   data-options="required:true,label:'密码:'" />
		</div>
		<div style="margin-bottom: 20px">
			<input class="easyui-passwordbox easyui-validatebox theme-textbox-radius" id="ipassword2" style="width: 100%"  iconWidth="28" data-options="required:true,label:'重复密码:'"
				   validType="equalTo['#ipassword1']" invalidMessage="两次输入密码不匹配" />
		</div>
		<div style="text-align:center;padding:5px">
            <a href="javascript:void(0)" class="easyui-linkbutton" style="width: 100%" onclick="submitForm()">提交</a>
        </div>
    </form>
	</div>
</div>

<script type="text/javascript">
$(function(){
$('#ff').form({      
	success:function(data){     // 提交成功后的回调函数。  
		//alert(data);  
		var data = eval('(' + data + ')');  // change the JSON string to javascript object      
		
		$.messager.alert('结果', data.message, 'info');
	}  
});
	
var pager = $('#tt').datagrid().datagrid('getPager');	// get the pager of datagrid
pager.pagination({
	buttons:[{
		iconCls:'icon-add',
		handler:function(){
			initForm("", "", "", 0);
			
			$('#fstuffid').textbox('textbox').attr('readonly',false);
			
			windowOpen("增加教职工", "../stuffAdd.do");
		}
	},{
		iconCls:'icon-edit',
		handler:function(){
			row = $("#tt").datagrid('getSelected');
			
			if (row == null) {
				$.messager.alert('警告', '请选中需要修改的职工', 'info');
				return;
			}
			
			initForm(row.stuffid, row.password, row.name, row.authority);
			
			$('#fstuffid').textbox('textbox').attr('readonly',true);
			
		//	alert(row.stuffid);
			
			windowOpen("修改教职工", "../stuffUpdate.do");	
		}
	},{
		iconCls:'icon-remove',
		handler:function(){
			row = $("#tt").datagrid('getSelected');
			
			if (row == null) {
				$.messager.alert('警告', '请选中需要删除的职工', 'info');
				return;
			}
			
			$.messager.confirm('警告', '确定删除该职工吗', function(r){
				if (r){
					$.post("../stuffDelete.do",{stuffid : row.stuffid}, function(data){
						var data = eval('(' + data + ')');
						
						$.messager.alert('结果', data.message, 'info');
					});
				}
			});
			
			
		}
	}]
});	
	
$.extend($.fn.validatebox.defaults.rules, {
	/*必须和某个字段相等*/
	 equalTo: { validator: function (value, param) { return $(param[0]).val() == value; }, message: '字段不匹配' }
	});
});

function doSearch(){
	$('#tt').datagrid('load',{
		stuffid: $('#stuffid').val(),
		name: $('#name').val(),
		authority: $('#authority').val()
	});
}

function initForm(stuffid, password, name, authority) {
	$("#subauthority").val(authority);
	$("#fstuffid").textbox('setValue', stuffid);
	$("#fname").textbox('setValue', name);
	$("#ipassword1").textbox('setValue', password);
	$("#ipassword2").textbox('setValue', password);
	$('#fauthority').combobox('setValue', authority & 1);
}

function windowOpen(title, ajax_url) {
	$('#ajaxWin').panel({title : title});
	
	$("#ff").attr("action", ajax_url);
	
	$('#ajaxWin').window('open');
}

function submitForm() {
	var subauthority = parseInt($("#subauthority").val() / 2) * 2;
	if ($('#fauthority').combobox('getValue') == 1) {
		subauthority += 1;
	} 
	
	$("#subauthority").val(subauthority);
	
	$("#ff").submit();

}

function myformatter(value,row){
	if (value % 2 == 1) {
		return '管理员';
	}
	
	return '非管理员';
};

function doReSet(){
	$('#stuffid').val("");
	$('#name').val("");
	$('#authority').val("");
	doSearch();
}
</script>

</body>
</html>