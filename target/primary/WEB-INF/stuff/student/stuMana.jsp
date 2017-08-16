<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生管理</title>

<%@include file="../../../publicHead.jsp" %>

</head>
<body>

<table id="tt" class="easyui-datagrid" style="width:100%;height:100%"
		url="../../student/findStudent.do" toolbar="#tb" pageList='[1,10,20,30,50]' singleSelect="true"
		rownumbers="true" pagination="true">
	<thead>
		<tr>
			<th field="stuid" width="80">学生ID</th>
			<th field="stuname" width="80">学生姓名</th>
			<th field="password" width="80">密码</th>
		</tr>
	</thead>
</table>

<div id="tb" style="padding:3px">
	<span>学生ID:FROM</span>
	<input id="fstuid" style="line-height:26px;border:1px solid #ccc">
	<span>TO</span>
	<input id="tstuid" style="line-height:26px;border:1px solid #ccc">
	<span>学生姓名:</span>
	<input id="stuname" style="line-height:26px;border:1px solid #ccc">
	<a href="#" class="easyui-linkbutton" plain="true" onclick="doSearch()">查找</a>
	<a href="#" class="easyui-linkbutton" plain="true" onclick="doReSet()">重置</a>
</div>

<div id="ajaxWin" class="easyui-window" title="修改资料" data-options="modal:true,collapsible:false,closed:true,maximizable:false,minimizable:false,resizable:false" style="width:550px;height:430px;padding:10px;">
	<div style="width: 400px; padding: 30px 60px;">
	<form id="ff" name="ff" method="post">
		<div style="margin-bottom: 20px">
			<input class="easyui-textbox theme-textbox-radius" id="ffstuid" name="stuid" style="width: 100%" data-options="required:true, label:'学生ID:'" />
		</div>
		<div style="margin-bottom: 20px">
			<input class="easyui-textbox theme-textbox-radius" id="ffname" name="stuname" style="width: 100%" data-options="required:true, label:'学生姓名:'" />
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

$('#ajaxWin').window({
    onClose:function(){ 
        doSearch();
    }
});
	
var pager = $('#tt').datagrid().datagrid('getPager');	// get the pager of datagrid
pager.pagination({
	buttons:[{
		iconCls:'icon-add',
		handler:function(){
			initForm("", "", "");
			
			$('#ffstuid').textbox('textbox').attr('readonly',false);
			
			windowOpen("增加学生", "../../student/studentAdd.do");
		}
	},{
		iconCls:'icon-edit',
		handler:function(){
			row = $("#tt").datagrid('getSelected');
			
			if (row == null) {
				$.messager.alert('警告', '请选中需要修改的学生', 'info');
				return;
			}
			
			initForm(row.stuid, row.password, row.stuname);
			
			$('#ffstuid').textbox('textbox').attr('readonly',true);
			
		//	alert(row.stuffid);
			
			windowOpen("修改学生", "../../student/studentUpdate.do");	
		}
	},{
		iconCls:'icon-remove',
		handler:function(){
			row = $("#tt").datagrid('getSelected');
			
			if (row == null) {
				$.messager.alert('警告', '请选中需要删除的学生', 'info');
				return;
			}
			
			$.messager.confirm('警告', '确定删除该学生吗', function(r){
				if (r){
					$.post("../../student/studentDelete.do",{stuid : row.stuid}, function(data){
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
		fstuid: $('#fstuid').val(),
		tstuid: $('#tstuid').val(),
		stuname: $('#stuname').val(),
	});
}

function initForm(stuffid, password, name) {
	$("#ffstuid").textbox('setValue', stuffid);
	$("#ffname").textbox('setValue', name);
	$("#ipassword1").textbox('setValue', password);
	$("#ipassword2").textbox('setValue', password);
}

function windowOpen(title, ajax_url) {
	$('#ajaxWin').panel({title : title});
	
	$("#ff").attr("action", ajax_url);
	
	$('#ajaxWin').window('open');
}

function submitForm() {
	$("#ff").submit();
}

function doReSet(){
	$('#fstuid').val("");
	$('#tstuid').val("");
	$('#stuname').val("");
	doSearch();
}
</script>

</body>
</html>