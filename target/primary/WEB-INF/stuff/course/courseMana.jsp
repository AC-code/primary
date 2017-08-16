<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>课程管理</title>

<%@include file="../../../publicHead.jsp" %>

</head>
<body>

<table id="tt" class="easyui-datagrid" style="width:100%;height:100%"
		url="../../course/findCourse.do" toolbar="#tb" pageList='[1,10,20,30,50]' singleSelect="true"
		rownumbers="true" pagination="true">
	<thead>
		<tr>
			<th field="courseid" width="80">课程ID</th>
			<th field="coursename" width="80">课程名称</th>
		</tr>
	</thead>
</table>

<div id="tb" style="padding:3px">
	<span>课程ID</span>
	<input id="scourseid" style="line-height:26px;border:1px solid #ccc">
	<span>课程名称:</span>
	<input id="scoursename" style="line-height:26px;border:1px solid #ccc">
	<a href="#" class="easyui-linkbutton" plain="true" onclick="doSearch()">查找</a>
	<a href="#" class="easyui-linkbutton" plain="true" onclick="doReSet()">重置</a>
</div>

<div id="ajaxWin" class="easyui-window" title="修改资料" data-options="modal:true,collapsible:false,closed:true,maximizable:false,minimizable:false,resizable:false" style="width:550px;height:430px;padding:10px;">
	<div style="width: 400px; padding: 30px 60px;">
	<form id="ff" name="ff" method="post">
		<div style="margin-bottom: 20px">
			<input class="easyui-textbox theme-textbox-radius" id="ffcourseid" name="courseid" style="width: 100%" data-options="required:true, label:'课程ID:'" />
		</div>
		<div style="margin-bottom: 20px">
			<input class="easyui-textbox theme-textbox-radius" id="ffcoursename" name="coursename" style="width: 100%" data-options="required:true, label:'课程名称:'" />
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
			initForm("", "");
			
			$('#ffcourseid').textbox('textbox').attr('readonly',false);
			
			windowOpen("增加课程", "../../course/courseAdd.do");
		}
	},{
		iconCls:'icon-edit',
		handler:function(){
			row = $("#tt").datagrid('getSelected');
			
			if (row == null) {
				$.messager.alert('警告', '请选中需要修改的课程', 'info');
				return;
			}
			
			initForm(row.courseid, row.coursename);
			
			$('#ffcourseid').textbox('textbox').attr('readonly',true);
			
		//	alert(row.stuffid);
			
			windowOpen("修改课程", "../../course/courseUpdate.do");	
		}
	},{
		iconCls:'icon-remove',
		handler:function(){
			row = $("#tt").datagrid('getSelected');
			
			if (row == null) {
				$.messager.alert('警告', '请选中需要删除的课程', 'info');
				return;
			}
			
			$.messager.confirm('警告', '确定删除该课程吗', function(r){
				if (r){
					$.post("../../course/courseDelete.do",{courseid : row.courseid}, function(data){
						var data = eval('(' + data + ')');
						
						$.messager.alert('结果', data.message, 'info');
						doSearch();
					});
				}
			});
			
			
		}
	}]
});	

});
	
function doSearch(){
	$('#tt').datagrid('load',{
		courseid: $('#scourseid').val(),
		coursename: $('#scoursename').val(),
	});
}

function initForm(courseid, coursename) {
	$("#ffcourseid").textbox('setValue', courseid);
	$("#ffcoursename").textbox('setValue', coursename);
};

function windowOpen(title, ajax_url) {
	$('#ajaxWin').panel({title : title});
	
	$("#ff").attr("action", ajax_url);
	
	$('#ajaxWin').window('open');
};

function submitForm() {
	$("#ff").submit();
};

function doReSet(){
	$('#scourseid').val("");
	$('#scoursename').val("");
	doSearch();
};
</script>

</body>
</html>