<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>

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

<div id="courseWin" class="easyui-window" title="课程添加" data-options="modal:true,collapsible:false,closed:true,maximizable:false,minimizable:false,resizable:false" style="width:1000px;height:430px">
	<div class="easyui-layout" data-options="fit:true">
		<table id="courseWin_tt" class="easyui-datagrid" style="width:100%;height:100%"
				url="../../course/findCourse.do" toolbar="#courseWin_tb" pageList='[1,10,20,30,50]' singleSelect="true"
				rownumbers="true" pagination="true">
			<thead>
				<tr>
					<th field="courseid" width="80">课程ID</th>
					<th field="coursename" width="80">课程名称</th>
				</tr>
			</thead>
		</table>
		
		<div id="courseWin_tb" style="padding:3px">
			<span>课程ID</span>
			<input id="courseWin_scourseid" style="line-height:26px;border:1px solid #ccc">
			<span>课程名称:</span>
			<input id="courseWin_scoursename" style="line-height:26px;border:1px solid #ccc">
			<a href="#" class="easyui-linkbutton" plain="true" onclick="courseWin_doSearch()">查找</a>
			<a href="#" class="easyui-linkbutton" plain="true" onclick="courseWin_doReSet()">重置</a>
		</div>
		
		<script type="text/javascript">
			$(function(){
				$("#courseWin_tt").datagrid({
					onClickRow: function (index, row) {
						var gradeid = $("#gradeid").html();
						var courseid = row.courseid;
						
						$.post("../../gradeCourse/addGradeCourse.do",{gradeid : gradeid, courseid : courseid}, function(data){
							var data = eval('(' + data + ')');
							
							$.messager.alert('结果', data.message, 'info');
							
							$("#course_tt").datagrid("reload");
						});
						
						
					}
				});
			});
			
			function courseWin_doSearch(){
				$('#courseWin_tt').datagrid('load',{
					courseid: $('#courseWin_scourseid').val(),
					coursename: $('#courseWin_scoursename').val(),
				});
				
				function courseWin_doReSet(){
					$('#courseWin_scourseid').val("");
					$('#courseWin_scoursename').val("");
					courseWin_doSearch();
				};
			}
			
		</script>
	</div>
</div>

<div data-options="region:'center',border:false" id="course_view">
	<table id="course_tt" class="easyui-datagrid" style="width:100%;height:100%"
		url="../../gradeCourse/findGradeCourse.do" toolbar="#course_tb" pageList='[1,10,20,30,50]' singleSelect="true"
		rownumbers="true" pagination="true">
		<thead>
			<tr>
				<th field="courseid" width="80">课程ID</th>
				<th field="coursename" width="80">课程名称</th>
			</tr>
		</thead>
		
		<div id="course_tb" style="padding:3px">
			<span>课程ID</span>
			<input id="course_scourseid" style="line-height:26px;border:1px solid #ccc">
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
					iconCls:'icon-add',
					handler:function(){
						$("#courseWin").window('open');
					}
				},{
					iconCls:'icon-remove',
					handler:function(){
						row = $("#course_tt").datagrid('getSelected');
						
						if (row == null) {
							$.messager.alert('警告', '请选中需要删除的课程', 'info');
							return;
						}
						
						$.messager.confirm('警告', '确定删除该课程吗', function(r){
							if (r){
								$.post("../../gradeCourse/deleteGradeCourse.do",{gCId : row.gCId}, function(data){
									var data = eval('(' + data + ')');
									
									$.messager.alert('结果', data.message, 'info');
									
									$("#course_tt").datagrid("reload");
								});
							}
						});
						
						
					}
				}]
			});	
		
		});
		
		function course_doSearch() {
			$('#course_tt').datagrid('load',{
				gradeid : $("#gradeid").html(),
				courseid : $("#course_scourseid").val(),
				coursename : $("#course_scoursename").val(),
			});
		};
	
		function course_doReSet() {
			$("#course_scourseid").val("");
			$("#course_scoursename").val("");
			course_doSearch();
		};
	</script>
	</table>
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
	
	<script type="text/javascript">
		$(function(){
			$('#gradeWin_tt').datagrid({  
			    url:'../../prefect/findPrefect.do',  
			    queryParams:{  
			    	stuffid : ${sessionScope.stuff.stuffid },
			    }  
			}); 
			
			$("#gradeWin_tt").datagrid({
				onClickRow: function (index, row) {
					$("#gradenname").html(row.gradename);
					$("#gradeid").html(row.gradeid);
					course_doSearch();
		        	$("#course_view").show();
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
	</script>
</div>

<script type="text/javascript">
$(function(){

});
</script>

</body>
</html>