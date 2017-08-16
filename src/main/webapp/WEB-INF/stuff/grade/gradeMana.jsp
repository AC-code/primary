<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>年级管理</title>

<%@include file="../../../publicHead.jsp" %>

</head>
<body>

<div class="easyui-layout" data-options="fit:true">
<div data-options="region:'north',border:false" style="height:135px">
	
		<div class="center" style="padding:20px;">
			<h1>年级名称:<font id="gradenname"></font>&nbsp;&nbsp;<a class="color-warning badge" id="gradeChange" href="#" >更改</a></h1>
			<h2>年段ID:<font id="gradeid"></font></h2>
		</div>
</div>

<div data-options="region:'center',border:false" id="class_view">
	<table id="class_tt" class="easyui-datagrid" style="width:100%;height:100%"
		url="../../class/findClassWithTeachers.do" toolbar="#class_tb" pageList='[1,10,20,30,50]' singleSelect="true"
		rownumbers="true" pagination="true">
		<thead>
			<tr>
				<th field="classid" width="80">班级級ID</th>
				<th field="classname" width="80">班級名称</th>
				<th field="stuffnames" width="160">班主任</th>
			</tr>
		</thead>
		
		<div id="class_tb" style="padding:3px">
			<span>班级ID</span>
			<input id="class_sclassid" style="line-height:26px;border:1px solid #ccc">
			<span>班级名称:</span>
			<input id="class_sclassname" style="line-height:26px;border:1px solid #ccc">
			<a href="#" class="easyui-linkbutton" plain="true" onclick="class_doSearch()">查找</a>
			<a href="#" class="easyui-linkbutton" plain="true" onclick="class_doReSet()">重置</a>
		</div>
	</table>
</div>
</div>

<div id="ajaxWin" class="easyui-window" title="修改资料" data-options="modal:true,collapsible:false,closed:true,maximizable:false,minimizable:false,resizable:false" style="width:550px;height:430px;padding:10px;">
	<div style="width: 400px; padding: 30px 60px;">
	<form id="ff" name="ff" method="post">
		<div style="margin-bottom: 20px">
			<input class="easyui-textbox theme-textbox-radius" id="ffclassid" name="classid" style="width: 100%" data-options="required:true, label:'班级ID:'" />
		</div>
		<div style="margin-bottom: 20px">
			<input class="easyui-textbox theme-textbox-radius" id="ffclassname" name="classname" style="width: 100%" data-options="required:true, label:'班级名称:'" />
		</div>
		<input type="hidden" id="ffgradeid" name="gradeid" />
		<div style="text-align:center;padding:5px">
            <a href="javascript:void(0)" class="easyui-linkbutton" style="width: 100%" onclick="submitForm()">提交</a>
        </div>
    </form>
	</div>
</div>

<div id="gradeWin" class="easyui-window" title="年级选定" data-options="modal:true,collapsible:false,closed:false,maximizable:false,minimizable:false,resizable:false" style="width:1000px;height:430px">
	<table id="gradeWin_tt" class="easyui-datagrid" style="width:100%;height:100%"
		toolbar="#gradeWin_tb" pageList='[1,10,20,30,50]' singleSelect="true"
		rownumbers="true" pagination="true">
		<thead>
			<tr>
				<th field="gradeid" width="80">年级ID</th>
				<th field="sessnname" width="80">年段名称 </th>
				<th field="gradename" width="80">年级名称</th>
			</tr>
		</thead>
		
		<div id="gradeWin_tb" style="padding:3px">
			<span>年级ID</span>
			<input id="gradeWin_sgradeid" style="line-height:26px;border:1px solid #ccc">
			<span>年段名称:</span>
			<input id="gradeWin_ssessnname" style="line-height:26px;border:1px solid #ccc">
			<span>年级名称:</span>
			<input id="gradeWin_sgradename" style="line-height:26px;border:1px solid #ccc">
			<a href="#" class="easyui-linkbutton" plain="true" onclick="gradeWin_doSearch()">查找</a>
			<a href="#" class="easyui-linkbutton" plain="true" onclick="gradeWin_doReSet()">重置</a>
		</div>
	</table>
</div>

<div id="headWin" class="easyui-window" title="班主任任命" data-options="modal:true,collapsible:false,closed:true,maximizable:false,minimizable:false,resizable:false" style="width:1000px;height:430px">
	<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'west',border:false" style="width:35%" >
			<table id="head_tt" class="easyui-datagrid" title="已任命班主任" style="width:100%;height:100%" singleSelect="true" url="../../headTeacher/findHeadTeacher.do"
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
	$("#class_view").hide();
	
	$("#gradeChange").click(function(){
		$("#gradeWin").window('open');
	});
	
	$('#gradeWin_tt').datagrid({  
	    url:'../../prefect/findPrefect.do',  
	    queryParams:{  
	    	stuffid : ${sessionScope.stuff.stuffid },
	    }  
	}); 
	
	$("#gradeWin").window({
		onBeforeClose: function () { //当面板关闭之前触发的事件
            if ($("#gradenname").html() == "") {
            	$.messager.alert('警告', '请选择需要编辑的年级', 'info');
                return false;
            }
        }
	});
	
	$("#gradeWin_tt").datagrid({
		onClickRow: function (index, row) {
			$("#gradenname").html(row.gradename);
			$("#gradeid").html(row.gradeid);
			class_doSearch();
        	$("#class_view").show();
		}
	});
	
	$('#ajaxWin').window({
	    onClose:function(){ 
	    	$("#class_tt").datagrid("reload");
	    }
	});
	
	$('#headWin').window({
	    onClose:function(){ 
	    	$("#class_tt").datagrid("reload");
	    }
	});
	
	$('#ff').form({      
		success:function(data){     // 提交成功后的回调函数。  
			//alert(data);  
			var data = eval('(' + data + ')');  // change the JSON string to javascript object      
			
			$.messager.alert('结果', data.message, 'info');
		}  
	});
	
	$('#class_tt').datagrid().datagrid('getPager').pagination({
		buttons:[{
			iconCls:'icon-add',
			handler:function(){
				initForm("", "",$("#gradeid").html());
				
				$('#ffclassid').textbox('textbox').attr('readonly',false);
				
				windowOpen("增加班级", "../../class/classAdd.do");
			}
		},{
			iconCls:'icon-edit',
			handler:function(){
				row = $("#class_tt").datagrid('getSelected');
				
				if (row == null) {
					$.messager.alert('警告', '请选中需要修改的班级', 'info');
					return;
				}
				
				initForm(row.classid, row.classname, $("#gradeid").html());
				
				$('#ffclassid').textbox('textbox').attr('readonly',true);
				
			//	alert(row.stuffid);
				
				windowOpen("修改班級", "../../class/classUpdate.do");	
			}
		},{
			iconCls:'icon-remove',
			handler:function(){
				row = $("#class_tt").datagrid('getSelected');
				
				if (row == null) {
					$.messager.alert('警告', '请选中需要删除的班級', 'info');
					return;
				}
				
				$.messager.confirm('警告', '确定删除该班級吗', function(r){
					if (r){
						$.post("../../class/classDelete.do",{classid : row.classid}, function(data){
							var data = eval('(' + data + ')');
							
							$.messager.alert('结果', data.message, 'info');
							
							$("#class_tt").datagrid("reload");
						});
					}
				});
				
				
			}
		},{
			iconCls:'icon-man',
			handler:function(){
				row = $("#class_tt").datagrid('getSelected');
				
				if (row == null) {
					$.messager.alert('警告', '请选中需要任命班主任的班級', 'info');
					return;
				}
				
				$("#head_tt").datagrid("load", {
					classid : row.classid,
				});
				
				$("#headWin").window('open');
			}
		}]
	});	
	
	$("#stuff_tt").datagrid({
		onClickRow: function (index, row) {
			var classid = $("#class_tt").datagrid('getSelected').classid;
			var stuffid = row.stuffid;
			
			$.post("../../headTeacher/addHeadTeacher.do",{classid : classid, stuffid : stuffid}, function(data){
				var data = eval('(' + data + ')');
				
				$.messager.alert('结果', data.message, 'info');
				
				$("#head_tt").datagrid("reload");
			});
		}
	});
	
	$("#head_tt").datagrid({
		onClickRow: function (index, row) {
			var classid = $("#class_tt").datagrid('getSelected').classid;
			var stuffid = row.stuffid;
			
			$.post("../../headTeacher/removeHeadTeacher.do",{classid : classid, stuffid : stuffid}, function(data){
				var data = eval('(' + data + ')');
				
				$.messager.alert('结果', data.message, 'info');
				
				$("#head_tt").datagrid("reload");
			});
		}
	});
});

function gradeWin_doSearch() {
	$('#gradeWin_tt').datagrid('load',{
		stuffid : 2,
		gradeid : $("#gradeWin_sgradeid").val(),
		sessnname : $("#gradeWin_ssessnname").val(),
		gradename : $("#gradeWin_sgradename").val(),
	});
};

function gradeWin_doReSet() {
	$("#gradeWin_sgradeid").val("");
	$("#gradeWin_ssessnname").val("");
	$("#gradeWin_sgradename").val("");
	gradeWin_doSearch();
};

function class_doSearch() {
	$('#class_tt').datagrid('load',{
		gradeid : $("#gradeid").html(),
		classid : $("#class_sclassid").val(),
		classname : $("#class_sclassname").val(),
	});
};

function class_doReSet() {
	$("#class_sclassid").val("");
	$("#class_sclassname").val("");
	class_doSearch();
};

function submitForm() {
	$("#ff").submit();
};

function initForm(classid, classname, gradeid) {
	$("#ffclassid").textbox('setValue', classid);
	$("#ffclassname").textbox('setValue', classname);
	$("#ffgradeid").val(gradeid);
};

function windowOpen(title, ajax_url) {
	$('#ajaxWin').panel({title : title});
	
	$("#ff").attr("action", ajax_url);
	
	$('#ajaxWin').window('open');
};
</script>

</body>
</html>