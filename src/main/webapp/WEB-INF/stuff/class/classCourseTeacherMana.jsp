<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>班级课程教师任命</title>

<%@include file="../../../publicHead.jsp" %>

</head>
<body>
<div class="easyui-layout" data-options="fit:true">
<div data-options="region:'north',border:false" style="height:135px">
	
		<div class="center" style="padding:20px;">
			<h1>班级名称:<font id="classname"></font>&nbsp;&nbsp;<a class="color-warning badge" id="classChange" href="#" >更改</a></h1>
			<h2>班级ID:<font id="classid"></font></h2>
		</div>
</div>

<script type="text/javascript">
$(function(){
	$("#classChange").click(function(){
		$("#classWin").window('open');
	});
});
</script>

<div id="teacherWin" class="easyui-window" title="科任任命" data-options="modal:true,collapsible:false,closed:true,maximizable:false,minimizable:false,resizable:false" style="width:1000px;height:430px">
	<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'west',border:false" style="width:40%" >
			<table id="teacher_tt" class="easyui-datagrid" title="已任命教师" style="width:100%;height:100%" singleSelect="true" url="../../classCourse/findCourseTeacher.do"
				rownumbers="true">
				<thead>
					<tr>
						<th field="stuffid" width="80">教师ID</th>
						<th field="name" width="80">教师姓名</th>
					</tr>
				</thead>
			</table>
		</div>
		
		<div data-options="region:'east',border:false" style="width:60%" >
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
			$(function(){
				$('#teacherWin').window({
				    onClose:function(){ 
				    	$("#course_tt").datagrid("reload");
				    }
				});
				
				$("#stuff_tt").datagrid({
					onClickRow: function (index, row) {
						var classid = $("#classid").html();
						var gCId = $("#course_tt").datagrid('getSelected').gCId;
						var stuffid = row.stuffid;
						
						$.post("../../classCourse/addClassCourseTeacher.do", {classid : classid, gCId : gCId, stuffid : stuffid}, function(data){
							var data = eval('(' + data + ')');
							
							$.messager.alert('结果', data.message, 'info');
							
							$("#teacher_tt").datagrid("reload");
						});
					}
				});
				
				$("#teacher_tt").datagrid({
					onClickRow: function (index, row) {
						var classid = $("#classid").html();
						var gCId = $("#course_tt").datagrid('getSelected').gCId;
						var stuffid = row.stuffid;
						
						$.post("../../classCourse/deleteClassCourseTeacher.do", {classid : classid, gCId : gCId, stuffid : stuffid}, function(data){
							var data = eval('(' + data + ')');
							
							$.messager.alert('结果', data.message, 'info');
							
							$("#teacher_tt").datagrid("reload");
						});
					}
				});
			});

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
			};
		</script>
		
		</div>
	</div>
</div>

<div data-options="region:'center',border:false" id="course_view">
	<table id="course_tt" class="easyui-datagrid" style="width:100%;height:100%"
		url="../../classCourse/findClassCourse.do" toolbar="#course_tb" pageList='[1,10,20,30,50]' singleSelect="true"
		rownumbers="true" pagination="true">
		<thead>
			<tr>
				<th field="coursename" width="80">课程名称</th>
				<th field="stuffnames" width="80">任课教师</th>
			</tr>
		</thead>
		
		<div id="course_tb" style="padding:3px">
			<span>课程名称:</span>
			<input id="course_scoursename" style="line-height:26px;border:1px solid #ccc">
			<a href="#" class="easyui-linkbutton" plain="true" onclick="course_doSearch()">查找</a>
			<a href="#" class="easyui-linkbutton" plain="true" onclick="course_doReSet()">重置</a>
		</div>
		<script type="text/javascript">
		$(function(){
			$("#course_view").hide();
			
			$('#course_tt').datagrid().datagrid('getPager').pagination({
				buttons:[{
					iconCls:'icon-man',
					handler:function(){
						row = $("#course_tt").datagrid('getSelected');
						
						if (row == null) {
							$.messager.alert('警告', '请选中需要任命课任的班級', 'info');
							return;
						}
						
						$("#teacherWin").window('open');
						
						$("#teacher_tt").datagrid("load", {
							gCId : $("#course_tt").datagrid('getSelected').gCId,
							classid : $("#classid").html(),
						});
					}
				}]
			});
		});
		
		
		function course_doSearch() {
			$('#course_tt').datagrid('load',{
				classid : $("#classid").html(),
				coursename : $("#course_scoursename").val(),
			});
		};
		function course_doReSet() {
			$("#course_scoursename").val("");
			course_doSearch();
		};
	</script>
		
	</table>
</div>

<div id="classWin" class="easyui-window" title="班级选定" data-options="modal:true,collapsible:false,closed:false,maximizable:false,minimizable:false,resizable:false" style="width:1000px;height:430px">
	<div class="easyui-layout" data-options="fit:true">
	<div data-options="region:'west',border:false" style="width:50%" >
	<table id="gradeWin_tt" class="easyui-datagrid" style="width:100%;height:100%"
		toolbar="#gradeWin_tb" pageList='[1,10,20,30,50]' singleSelect="true" title="年段选择"
		rownumbers="true" pagination="true">
		<thead>
			<tr>
				<th field="sessnname" width="80">年段名称 </th>
				<th field="gradename" width="80">年级名称</th>
			</tr>
		</thead>
		
		<div id="gradeWin_tb" style="padding:3px">
			<span>年段名称:</span>
			<input id="gradeWin_ssessnname" style="line-height:26px;width:100px;border:1px solid #ccc">
			<span>年级名称:</span>
			<input id="gradeWin_sgradename" style="line-height:26px;width:100px;border:1px solid #ccc">
			<a href="#" class="easyui-linkbutton" plain="true" onclick="gradeWin_doSearch()">查找</a>
			<a href="#" class="easyui-linkbutton" plain="true" onclick="gradeWin_doReSet()">重置</a>
		</div>
	</table>
	
	<script type="text/javascript">
		$(function(){
			$('#gradeWin_tt').datagrid({  
			    url:'../../prefect/findPrefect.do',  
			    queryParams:{  
			    	stuffid : ${sessionScope.stuff.stuffid }
			    }  
			}); 
			
			$("#gradeWin_tt").datagrid({
				onClickRow: function (index, row) {
					$('#class_tt').datagrid({  
					    url:'../../class/findClassWithTeachers.do',  
					    queryParams:{  
					    	gradeid : row.gradeid,
					    }  
					});
				}
			});
		});
		
		function gradeWin_doSearch() {
			$('#gradeWin_tt').datagrid('load',{
				stuffid : 2,
				sessnname : $("#gradeWin_ssessnname").val(),
				gradename : $("#gradeWin_sgradename").val(),
			});
		};
	
		function gradeWin_doReSet() {
			$("#gradeWin_ssessnname").val("");
			$("#gradeWin_sgradename").val("");
			gradeWin_doSearch();
		};
	</script>
	</div>
	<div data-options="region:'east',border:false" style="width:50%" >
		<table id="class_tt" class="easyui-datagrid" style="width:100%;height:100%" title='班级选择'
			toolbar="#class_tb" pageList='[1,10,20,30,50]' singleSelect="true"
			rownumbers="true" pagination="true">
			<thead>
				<tr>
					<th field="classname" width="80">班級名称</th>
				</tr>
			</thead>
			
			<div id="class_tb" style="padding:3px">
				<span>班级名称:</span>
				<input id="class_sclassname" style="line-height:26px;border:1px solid #ccc">
				<a href="#" class="easyui-linkbutton" plain="true" onclick="class_doSearch()">查找</a>
				<a href="#" class="easyui-linkbutton" plain="true" onclick="class_doReSet()">重置</a>
			</div>
		</table>
		
		<script type="text/javascript">
		$(function(){
			$("#class_tt").datagrid({
				onClickRow: function (index, row) {
					$("#classid").html(row.classid);
					$("#classname").html(row.classname);
					$("#course_view").show();
					course_doSearch();
				}
			});
		});
		
		function class_doSearch() {
			$('#class_tt').datagrid('load',{
				classname : $("#class_sclassname").val(),
			});
		};

		function class_doReSet() {
			$("#class_sclassname").val("");
			class_doSearch();
		};
	</script>
	</div>
	</div>
</div>
</div>

</body>
</html>