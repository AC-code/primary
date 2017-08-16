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
			<h1>班级名称:<font id="classname"></font>&nbsp;&nbsp;<a class="color-warning badge" id="classChange" href="#" >更改</a></h1>
			<h2>班级ID:<font id="classid"></font></h2>
		</div>
</div>

<div id="studentWin" class="easyui-window" title="学生添加" data-options="modal:true,collapsible:false,closed:true,maximizable:false,minimizable:false,resizable:false" style="width:1000px;height:430px">
	<div class="easyui-layout" data-options="fit:true">
		<table id="studentWin_tt" class="easyui-datagrid" style="width:100%;height:100%"
				url="../../student/findStudent.do" toolbar="#studentWin_tb" pageList='[1,10,20,30,50]' singleSelect="true"
				rownumbers="true" pagination="true">
			<thead>
				<tr>
					<th field="stuid" width="80">学生ID</th>
					<th field="stuname" width="80">学生姓名</th>
				</tr>
			</thead>
		</table>
		
		<div id="studentWin_tb" style="padding:3px">
			<span>学生ID:FROM</span>
			<input id="studentWin_fstuid" style="line-height:26px;border:1px solid #ccc">
			<span>TO</span>
			<input id="studentWin_tstuid" style="line-height:26px;border:1px solid #ccc">
			<span>学生姓名:</span>
			<input id="studentWin_stuname" style="line-height:26px;border:1px solid #ccc">
			<a href="#" class="easyui-linkbutton" plain="true" onclick="studentWin_doSearch()">查找</a>
			<a href="#" class="easyui-linkbutton" plain="true" onclick="studentWin_doReSet()">重置</a>
		</div>
		
		<script type="text/javascript">
			$(function(){
				$("#studentWin_tt").datagrid({
					onClickRow: function (index, row) {
						var classid = $("#classid").html();
						var stuid = row.stuid;
						
						$.messager.prompt('插入学生' + row.stuname, '请输入该学生的编号', function(number){
							if (number){
								$.post("../../classStu/addClassStudent.do",{classid : classid, stuid : stuid, number : number}, function(data){
									var data = eval('(' + data + ')');
									
									$.messager.alert('结果', data.message, 'info');
									
									$("#student_tt").datagrid("reload");
								});
							}
						});
					}
				});
			});
			
			function studentWin_doSearch(){
				$('#studentWin_tt').datagrid('load',{
					fstuid: $('#studentWin_fstuid').val(),
					tstuid: $('#studentWin_tstuid').val(),
					stuname: $('#studentWin_stuname').val(),
				});
				
				function studentWin_doReSet(){
					$('#studentWin_fstuid').val("");
					$('#studentWin_tstuid').val("");
					$('#studentWin_stuname').val("");
					studentWin_doSearch();
				};
			}
			
		</script>
	</div>
</div>

<div data-options="region:'center',border:false" id="student_view">
	<table id="student_tt" class="easyui-datagrid" style="width:100%;height:100%"
		url="../../classStu/findClassStudent.do" toolbar="#student_tb" pageList='[1,10,20,30,50]' singleSelect="true"
		rownumbers="true" pagination="true">
		<thead>
			<tr>
				<th field="number" width="80">学号</th>
				<th field="stuname" width="80">学生姓名</th>
				<th field="stuid" width="160">学生ID</th>
			</tr>
		</thead>
		
		<div id="student_tb" style="padding:3px">
			<span>学号:</span>
			<input id="student_snumber" style="line-height:26px;border:1px solid #ccc">
			<span>学生姓名:</span>
			<input id="student_sstuname" style="line-height:26px;border:1px solid #ccc">
			<span>学生ID:</span>
			<input id="student_sstuid" style="line-height:26px;border:1px solid #ccc">
			<a href="#" class="easyui-linkbutton" plain="true" onclick="student_doSearch()">查找</a>
			<a href="#" class="easyui-linkbutton" plain="true" onclick="student_doReSet()">重置</a>
		</div>
		<script type="text/javascript">
		$(function(){
			$("#student_view").hide();
			
			$('#student_tt').datagrid().datagrid('getPager').pagination({
				buttons:[{
					iconCls:'icon-add',
					handler:function(){
						$("#studentWin").window('open');
					}
				},{
					iconCls:'icon-remove',
					handler:function(){
						row = $("#student_tt").datagrid('getSelected');
						
						if (row == null) {
							$.messager.alert('警告', '请选中需要删除的学生', 'info');
							return;
						}
						
						$.messager.confirm('警告', '确定删除该学生吗', function(r){
							if (r){
								$.post("../../classStu/deleteClassStudent.do",{number : row.number, classid : row.classid}, function(data){
									var data = eval('(' + data + ')');
									
									$.messager.alert('结果', data.message, 'info');
									
									$("#student_tt").datagrid("reload");
								});
							}
						});
						
						
					}
				}]
			});	
		});
		
		
		function student_doSearch() {
			$('#student_tt').datagrid('load',{
				classid : $("#classid").html(),
				stuid : $("#student_sstuid").val(),
				stuname : $("#student_sstuname").val(),
				number : $("#student_snumber").val(),
			});
		};
		function student_doReSet() {
			$("#student_sstuid").val("");
			$("#student_sstuname").val("");
			$("#student_snumber").val("");
			student_doSearch();
		};
	</script>
		
	</table>
</div>
</div>

<div id="classWin" class="easyui-window" title="班级选定" data-options="modal:true,collapsible:false,closed:false,maximizable:false,minimizable:false,resizable:false" style="width:1000px;height:430px">
	<table id="classWin_tt" class="easyui-datagrid" style="width:100%;height:100%"
		toolbar="#classWin_tb" pageList='[1,10,20,30,50]' singleSelect="true"
		rownumbers="true" pagination="true">
		<thead>
			<tr>
				<th field="classid" width="80">班级ID</th>
				<th field="sessnname" width="80">年届名称 </th>
				<th field="gradename" width="80">年级名称</th>
				<th field="classname" width="80">班级名称 </th>
			</tr>
		</thead>
		
		<div id="classWin_tb" style="padding:3px">
			<span>班级ID</span>
			<input id="classWin_sclassid" style="line-height:26px;border:1px solid #ccc">
			<span>年届名称:</span>
			<input id="classWin_ssessnname" style="line-height:26px;border:1px solid #ccc">
			<span>年级名称:</span>
			<input id="classWin_sgradename" style="line-height:26px;border:1px solid #ccc">
			<span>班级名称:</span>
			<input id="classWin_sclassname" style="line-height:26px;border:1px solid #ccc">
			<a href="#" class="easyui-linkbutton" plain="true" onclick="classWin_doSearch()">查找</a>
			<a href="#" class="easyui-linkbutton" plain="true" onclick="classWin_doReSet()">重置</a>
		</div>
	</table>
	
	<script type="text/javascript">
		$(function(){
			$('#classWin_tt').datagrid({  
			    url:'../../class/findClassWithDetail.do',  
			    queryParams:{  
			    	stuffid : ${sessionScope.stuff.stuffid }
			    }  
			}); 
			
			$("#classWin_tt").datagrid({
				onClickRow: function (index, row) {
					$("#classname").html(row.classname);
					$("#classid").html(row.classid);
					student_doSearch();
		        	$("#student_view").show();
				}
			});
		});
		
		
		function classWin_doSearch() {
			$('#classWin_tt').datagrid('load',{
				stuffid : 2,
				classid : $("#classWin_sclassid").val(),
				sessnname : $("#gradeWin_ssessnname").val(),
				gradename : $("#gradeWin_sgradename").val(),
				classname : $("#classWin_sclassname").val(),
			});
		};
		function classWin_doReSet() {
			$("#classWin_sclassid").val("");
			$("#gradeWin_ssessnname").val("");
			$("#gradeWin_sgradename").val("");
			$("#classWin_sclassname").val("");
			classWin_doSearch();
		};
	</script>
</div>

</div>

<script type="text/javascript">
$(function(){

});
</script>

</body>
</html>