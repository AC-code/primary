<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>段级管理</title>

<%@include file="../../../publicHead.jsp" %>

</head>
<body>

<div class="easyui-layout" data-options="fit:true">
<div data-options="region:'north',border:false" style="height:135px">
	
		<div class="center" style="padding:20px;">
			<h1>年段名称:<font id="sessnname"></font>&nbsp;&nbsp;<a class="color-warning badge" id="sessnidChange" href="#" >更改</a></h1>
			<h2>年段ID:<font id="sessnid"></font></h2>
		</div>
	
</div>

<div data-options="region:'center',border:false" id="grade_view">
	<table id="grade_tt" class="easyui-datagrid" style="width:100%;height:100%"
		url="../../grade/findGrade.do" toolbar="#grade_tb" pageList='[1,10,20,30,50]' singleSelect="true"
		rownumbers="true" pagination="true">
		<thead>
			<tr>
				<th field="gradeid" width="80">年級ID</th>
				<th field="gradename" width="80">年級名称</th>
				<th field="stuffnames" width="160">级长</th>
			</tr>
		</thead>
		
		<div id="grade_tb" style="padding:3px">
			<span>年級ID</span>
			<input id="grade_sgradeid" style="line-height:26px;border:1px solid #ccc">
			<span>年級名称:</span>
			<input id="grade_sgradename" style="line-height:26px;border:1px solid #ccc">
			<a href="#" class="easyui-linkbutton" plain="true" onclick="grade_doSearch()">查找</a>
			<a href="#" class="easyui-linkbutton" plain="true" onclick="grade_doReSet()">重置</a>
		</div>
	</table>
</div>
</div>

<div id="sessnWin" class="easyui-window" title="年段选定" data-options="modal:true,collapsible:false,closed:false,maximizable:false,minimizable:false,resizable:false" style="width:550px;height:430px">
	<table id="sessnWin_tt" class="easyui-datagrid" style="width:100%;height:100%"
		url="../../session/findSession.do" toolbar="#sessnWin_tb" pageList='[1,10,20,30,50]' singleSelect="true"
		rownumbers="true" pagination="true">
		<thead>
			<tr>
				<th field="sessnid" width="80">年段ID</th>
				<th field="sessnname" width="80">年段名称</th>
			</tr>
		</thead>
		
		<div id="sessnWin_tb" style="padding:3px">
			<span>年段ID</span>
			<input id="sessnWin_ssessnid" style="line-height:26px;border:1px solid #ccc">
			<span>年段名称:</span>
			<input id="sessnWin_ssessnname" style="line-height:26px;border:1px solid #ccc">
			<a href="#" class="easyui-linkbutton" plain="true" onclick="sessnWin_doSearch()">查找</a>
			<a href="#" class="easyui-linkbutton" plain="true" onclick="sessnWin_doReSet()">重置</a>
		</div>
	</table>
</div>

<div id="ajaxWin" class="easyui-window" title="修改资料" data-options="modal:true,collapsible:false,closed:true,maximizable:false,minimizable:false,resizable:false" style="width:550px;height:430px;padding:10px;">
	<div style="width: 400px; padding: 30px 60px;">
	<form id="ff" name="ff" method="post">
		<div style="margin-bottom: 20px">
			<input class="easyui-textbox theme-textbox-radius" id="ffgradeid" name="gradeid" style="width: 100%" data-options="required:true, label:'年级ID:'" />
		</div>
		<div style="margin-bottom: 20px">
			<input class="easyui-textbox theme-textbox-radius" id="ffgradename" name="gradename" style="width: 100%" data-options="required:true, label:'年级名称:'" />
		</div>
		<input type="hidden" id="ffsessnid" name="sessnid" />
		<div style="text-align:center;padding:5px">
            <a href="javascript:void(0)" class="easyui-linkbutton" style="width: 100%" onclick="submitForm()">提交</a>
        </div>
    </form>
	</div>
</div>

<div id="prefectWin" class="easyui-window" title="级长任命" data-options="modal:true,collapsible:false,closed:true,maximizable:false,minimizable:false,resizable:false" style="width:1000px;height:430px">
	<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'west',border:false" style="width:35%" >
			<table id="prefect_tt" class="easyui-datagrid" title="已任命级长" style="width:100%;height:100%" singleSelect="true" url="../../prefect/findPrefect.do"
				rownumbers="true">
				<thead>
					<tr>
						<th field="stuffid" width="80">员工ID</th>
						<th field="name" width="80">员工姓名</th>
					</tr>
				</thead>
			</table>
		</div>
		
		<div data-options="region:'east',border:false" style="width:65%" >
		<table id="stuff_tt" class="easyui-datagrid" style="width:100%;height:100%"
				url="../findStuff.do" toolbar="#stuff_tb" pageList='[1,10,20,30,50]' singleSelect="true"
				rownumbers="true" pagination="true">
			<thead>
				<tr>
					<th field="stuffid" width="80">职工ID</th>
					<th field="name" width="80">职工姓名</th>
				</tr>
			</thead>
		</table>
		
		<div id="stuff_tb" style="padding:3px">
			<span>职工ID:</span>
			<input id="stuff_stuffid" style="line-height:26px;border:1px solid #ccc">
			<span>职工姓名:</span>
			<input id="stuff_name" style="line-height:26px;border:1px solid #ccc">
			<a href="#" class="easyui-linkbutton" plain="true" onclick="stuff_doSearch()">查找</a>
			<a href="#" class="easyui-linkbutton" plain="true" onclick="stuff_doReSet()">重置</a>
		</div>
		
		<script type="text/javascript">
			function stuff_doSearch() {
				$('#stuff_tt').datagrid('load',{
					stuffid: $('#stuff_stuffid').val(),
					name: $('#stuff_name').val(),
				});
			};
			
			function stuff_doReSet() {
				$('#stuff_stuffid').val("");
				$('#stuff_name').val("");
				stuff_doSearch();
			}
		</script>
		
		</div>
	</div>
</div>

<script type="text/javascript">
$(function(){
	$("#grade_view").hide();
	
	$('#ajaxWin').window({
	    onClose:function(){ 
	    	$("#grade_tt").datagrid("reload");
	    }
	});
	
	$('#prefectWin').window({
	    onClose:function(){ 
	    	$("#grade_tt").datagrid("reload");
	    }
	});
	
	$('#ff').form({      
		success:function(data){     // 提交成功后的回调函数。  
			//alert(data);  
			var data = eval('(' + data + ')');  // change the JSON string to javascript object      
			
			$.messager.alert('结果', data.message, 'info');
		}  
	});

	$("#sessnWin").window({
		onBeforeClose: function () { //当面板关闭之前触发的事件
            if ($("#sessnname").html() == "") {
            	$.messager.alert('警告', '请选择需要编辑的年段', 'info');
                return false;
            }
        }
	});
	
	$("#sessnWin_tt").datagrid({
		onClickRow: function (index, row) {
			$("#sessnname").html(row.sessnname);
			$("#sessnid").html(row.sessnid);
			grade_doSearch();
        	$("#grade_view").show();
		}
	});
	
	$("#stuff_tt").datagrid({
		onClickRow: function (index, row) {
			var gradeid = $("#grade_tt").datagrid('getSelected').gradeid;
			var stuffid = row.stuffid;
			
			$.post("../../prefect/addPrefecet.do",{gradeid : gradeid, stuffid : stuffid}, function(data){
				var data = eval('(' + data + ')');
				
				$.messager.alert('结果', data.message, 'info');
				
				$("#prefect_tt").datagrid("reload");
			});
		}
	});
	
	$("#prefect_tt").datagrid({
		onClickRow: function (index, row) {
			var gradeid = $("#grade_tt").datagrid('getSelected').gradeid;
			var stuffid = row.stuffid;
			
			$.post("../../prefect/removePrefect.do",{gradeid : gradeid, stuffid : stuffid}, function(data){
				var data = eval('(' + data + ')');
				
				$.messager.alert('结果', data.message, 'info');
				
				$("#prefect_tt").datagrid("reload");
			});
		}
	});
	
	$("#sessnidChange").click(function(){
		$("#sessnWin").window('open');
	});
	
	$('#grade_tt').datagrid().datagrid('getPager').pagination({
		buttons:[{
			iconCls:'icon-add',
			handler:function(){
				initForm("", "",$("#sessnid").html());
				
				$('#ffgradeid').textbox('textbox').attr('readonly',false);
				
				windowOpen("增加年級", "../../grade/gradeAdd.do");
			}
		},{
			iconCls:'icon-edit',
			handler:function(){
				row = $("#grade_tt").datagrid('getSelected');
				
				if (row == null) {
					$.messager.alert('警告', '请选中需要修改的年級', 'info');
					return;
				}
				
				initForm(row.gradeid, row.gradename, $("#sessnid").html());
				
				$('#ffgradeid').textbox('textbox').attr('readonly',true);
				
			//	alert(row.stuffid);
				
				windowOpen("修改年級", "../../grade/gradeUpdate.do");	
			}
		},{
			iconCls:'icon-remove',
			handler:function(){
				row = $("#grade_tt").datagrid('getSelected');
				
				if (row == null) {
					$.messager.alert('警告', '请选中需要删除的年級', 'info');
					return;
				}
				
				$.messager.confirm('警告', '确定删除该年級吗', function(r){
					if (r){
						$.post("../../grade/gradeDelete.do",{gradeid : row.gradeid}, function(data){
							var data = eval('(' + data + ')');
							
							$.messager.alert('结果', data.message, 'info');
							
							$("#grade_tt").datagrid("reload");
						});
					}
				});
				
				
			}
		},{
			iconCls:'icon-man',
			handler:function(){
				row = $("#grade_tt").datagrid('getSelected');
				
				if (row == null) {
					$.messager.alert('警告', '请选中需要任命级长的年級', 'info');
					return;
				}
				
				$("#prefect_tt").datagrid("load", {
					gradeid : row.gradeid,
				});
				
				$("#prefectWin").window('open');
			}
		}]
	});	
});

function grade_doSearch() {
	$('#grade_tt').datagrid('load',{
		gradeid: $('#grade_sgradeid').val(),
		gradename: $('#grade_sgradename').val(),
		sessnid: $("#sessnid").html(),
	});
};

function grade_doReSet() {
	$('#grade_sgradeid').val("");
	$('#grade_sgradename').val("");
	grade_doSearch();
};

function sessnWin_doSearch() {
	$('#sessnWin_tt').datagrid('load',{
		sessnid: $('#sessnWin_ssessnid').val(),
		sessnname: $('#sessnWin_ssessnname').val(),
	});
};

function windowOpen(title, ajax_url) {
	$('#ajaxWin').panel({title : title});
	
	$("#ff").attr("action", ajax_url);
	
	$('#ajaxWin').window('open');
};

function submitForm() {
	$("#ff").submit();
};

function sessnWin_doReSet() {
	$('#sessnWin_ssessnid').val("");
	$('#sessnWin_ssessnname').val("");
	sessnWin_doSearch();
};

function initForm(gradeid, gradename, sessnid) {
	$("#ffgradeid").textbox('setValue', gradeid);
	$("#ffgradename").textbox('setValue', gradename);
	$("#ffsessnid").val(sessnid);
};
</script>

</body>
</html>