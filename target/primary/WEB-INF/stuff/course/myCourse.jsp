<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>我的课程</title>

<%@include file="../../../publicHead.jsp" %>

</head>
<body>
<div class="easyui-layout" data-options="fit:true">
<div data-options="region:'north',border:false" style="height:135px">
		<div class="center" style="padding:20px;">
			<h1>课程名称:<font id="coursename"></font>&nbsp;&nbsp;<a class="color-warning badge" id="courseChange" href="#" >更改</a></h1>
			<h2>年级课程ID:<font id="gCId"></font>&nbsp;&nbsp;班级ID:<font id="classid"></font></h2>
		</div>
</div>

<script type="text/javascript">
	$(function() {
		$("#courseChange").click(function() {
			$("#classCourseWin").window('open');
		});
	});
</script>

<div id="scoreWin" class="easyui-window" title="成绩录入" data-options="modal:true,collapsible:false,closed:true,maximizable:false,minimizable:false,resizable:false" style="width:550px;height:430px">
	<table id="scoreWin_tt" class="easyui-datagrid" style="width:100%;height:100%" data-options="onClickRow: onClickRow" 
		singleSelect="true" url='../../score/findScore.do', 
		rownumbers="true" >
		<thead>
			<tr>
				<th field="number" width="80">学生学号 </th>
				<th field="stuname" width="80">学生姓名</th>
				<th field="mark" width="80" data-options="editor:{
							type:'numberbox',
							options:{
								min:0,
    							precision:1
							}
						}">分数 </th>
			</tr>
		</thead>
	</table>
	<script type="text/javascript">

	var editIndex = undefined;
	function endEditing(){
			$.post('../../score/updateScore.do', {
					mark : $($('#scoreWin_tt').datagrid('getEditor', {index:editIndex,field:'mark'}).target).numberbox('getValue'),
					id : $('#courseGrade_tt').datagrid('getSelected').id,
					number : $('#scoreWin_tt').datagrid('getRows')[editIndex].number,
					classid : $('#scoreWin_tt').datagrid('getSelected').classid,
				}, function (data){
				var data = eval('(' + data + ')');
				
				if (data.message != 'success') {
					$.messager.alert('结果', data.message, 'info');
				}
			});
			
			
	};
	function onClickRow(index){
		if (editIndex != undefined) {
			endEditing();
			$('#scoreWin_tt').datagrid('endEdit', editIndex);
		}
		
		if (editIndex != index) {
			$('#scoreWin_tt').datagrid('selectRow', index)
			.datagrid('beginEdit', index);
			editIndex = index;
		} else {
			editIndex = undefined;
		}
	};
	</script>
</div>

<div id="ajaxWin" class="easyui-window" title="修改资料" data-options="modal:true,collapsible:false,closed:true,maximizable:false,minimizable:false,resizable:false" style="width:550px;height:430px;padding:10px;">
	<div style="width: 400px; padding: 30px 60px;">
	<form id="ff" name="ff" method="post">
		<div style="margin-bottom: 20px">
			<input class="easyui-textbox theme-textbox-radius" id="ffname" name="name" style="width: 100%" data-options="required:true, label:'成绩名称:'" />
		</div>
		<input type="hidden" id="ffclassid" name="classid" />
		<input type="hidden" id="ffgCId" name="gCId" />
		<div style="text-align:center;padding:5px">
            <a href="javascript:void(0)" class="easyui-linkbutton" style="width: 100%" onclick="submitForm()">提交</a>
        </div>
    </form>
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
		        courseGrade_doSearch();
		    }
		});
	});
	
	function initForm(ffname) {
		$("#ffname").textbox('setValue', ffname);
		$("#ffclassid").val($("#classid").html());
		$("#ffgCId").val($("#gCId").html());
	};
	
	function windowOpen(title, ajax_url) {
		$('#ajaxWin').panel({title : title});
		
		$("#ff").attr("action", ajax_url);
		
		$('#ajaxWin').window('open');
	};
	
	function submitForm() {
		$("#ff").submit();
	};

	</script>
</div>

<div data-options="region:'center',border:false" id="courseGrade_view">
	<table id="courseGrade_tt" class="easyui-datagrid" style="width:100%;height:100%"
		url="../../classCourseGrade/findClassCourseGrade.do" toolbar="#courseGrade_tb" pageList='[1,10,20,30,50]' singleSelect="true"
		rownumbers="true" pagination="true">
		<thead>
			<tr>
				<th field="name" width="80">成绩名称</th>
			</tr>
		</thead>
		
		<div id="courseGrade_tb" style="padding:3px">
			<span>成绩名称:</span>
			<input id="courseGrade_sname" style="line-height:26px;border:1px solid #ccc">
			<a href="#" class="easyui-linkbutton" plain="true" onclick="courseGrade_doSearch()">查找</a>
			<a href="#" class="easyui-linkbutton" plain="true" onclick="courseGrade_doReSet()">重置</a>
		</div>
		<script type="text/javascript">
		$(function(){
			$("#courseGrade_view").hide();
			
			$('#courseGrade_tt').datagrid().datagrid('getPager').pagination({
				buttons:[{
					iconCls:'icon-add',
					handler:function(){
						initForm("");
						
						windowOpen("添加成绩", "../../classCourseGrade/addClassCourseService.do");
					}
				},{
					iconCls:'icon-remove',
					handler:function(){
						row = $("#courseGrade_tt").datagrid('getSelected');
						
						if (row == null) {
							$.messager.alert('警告', '请选中需要删除的成绩', 'info');
							return;
						}
						
						$.messager.confirm('警告', '确定删除该成绩吗', function(r){
							if (r){
								$.post("../../classCourseGrade/deleteClassCourseService.do",{id : row.id}, function(data){
									var data = eval('(' + data + ')');
									
									$.messager.alert('结果', data.message, 'info');
									
									$("#courseGrade_tt").datagrid("reload");
								});
							}
						});
						
						
					}
				},{
					iconCls:'icon-man',
					handler:function(){
						row = $("#courseGrade_tt").datagrid('getSelected');
						
						if (row == null) {
							$.messager.alert('警告', '请选中需要录入的成绩', 'info');
							return;
						}
						
						editIndex = undefined;
						
						$("#scoreWin").window('open');
						
				//		$('#scoreWin_tt').datagrid({  
				//		    url:'../../score/findScore.do',  
				//		    queryParams:{  
				//		    	id : row.id,
				//		    }  
				//		});	
						
						$('#scoreWin_tt').datagrid('load', {
							id : row.id,
						});
					}
				}]
			});	
		});
		
		
		function courseGrade_doSearch() {
			$('#courseGrade_tt').datagrid('load',{
				stuffid : ${sessionScope.stuff.stuffid },	
				classid : $("#classid").html(),
				gCId : $("#gCId").html(),
				name : $("#courseGrade_sname").val(),
			});
		};
		function courseGrade_doReSet() {
			$("#courseGrade_sname").val("");
			courseGrade_doSearch();
		};
	</script>
		
	</table>
</div>


<div id="classCourseWin" class="easyui-window" title="班级课程选定" data-options="modal:true,collapsible:false,closed:false,maximizable:false,minimizable:false,resizable:false" style="width:1000px;height:430px">
	<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'west',border:false" style="width:50%" >
			<table id="classWin_tt" class="easyui-datagrid" style="width:100%;height:100%"
				toolbar="#classWin_tb" pageList='[1,10,20,30,50]' singleSelect="true"
				rownumbers="true" pagination="true">
				<thead>
					<tr>
						<th field="sessnname" width="80">年届名称 </th>
						<th field="gradename" width="80">年级名称</th>
						<th field="classname" width="80">班级名称 </th>
					</tr>
				</thead>
				
				<div id="classWin_tb" style="padding:3px">
					<span>年届名称:</span>
					<input id="classWin_ssessnname" style="width:130px;line-height:26px;border:1px solid #ccc">
					<span>年级名称:</span>
					<input id="classWin_sgradename" style="width:130px;line-height:26px;border:1px solid #ccc">
					<a href="#" class="easyui-linkbutton" plain="true" onclick="classWin_doSearch()">查找</a>
					<a href="#" class="easyui-linkbutton" plain="true" onclick="classWin_doReSet()">重置</a>
				</div>
			</table>
			
			<script type="text/javascript">
				$(function(){
					$('#classWin_tt').datagrid({  
					    url:'../../teacher/findTeacherClass.do',  
					    queryParams:{  
					    	stuffid : ${sessionScope.stuff.stuffid }
					    }  
					}); 
					
					$("#classWin_tt").datagrid({
						onClickRow: function (index, row) {
							$('#courseWin_tt').datagrid({  
							    url:'../../teacher/findTeacherClassCourse.do',  
							    queryParams:{  
							    	classid : row.classid,
							    	stuffid : ${sessionScope.stuff.stuffid },
							    }  
							});	
						}
					});
				});
				
				
				function classWin_doSearch() {
					$('#classWin_tt').datagrid('load',{
						stuffid : ${sessionScope.stuff.stuffid },
						sessnname : $("#gradeWin_ssessnname").val(),
						gradename : $("#gradeWin_sgradename").val(),
					});
				};
				function classWin_doReSet() {
					$("#gradeWin_ssessnname").val("");
					$("#gradeWin_sgradename").val("");
					classWin_doSearch();
				};
			</script>
		</div>
		
		<div data-options="region:'east',border:false" style="width:50%" >
			<table id="courseWin_tt" class="easyui-datagrid" style="width:100%;height:100%"
					pageList='[1,10,20,30,50]' singleSelect="true"
					toolbar="#course_tb"
					rownumbers="true" pagination="true">
				<thead>
					<tr>
						<th field="coursename" width="80">课程名称</th>
					</tr>
				</thead>
			</table>
			
			<div id="course_tb" style="padding:3px">
				<span>课程名称:</span>
				<input id="course_scoursename" style="line-height:26px;border:1px solid #ccc">
				<a href="#" class="easyui-linkbutton" plain="true" onclick="course_doSearch()">查找</a>
				<a href="#" class="easyui-linkbutton" plain="true" onclick="course_doReSet()">重置</a>
			</div>
				
			<script type="text/javascript">
				$(function(){
					$("#courseWin_tt").datagrid({
						onClickRow: function (index, row) {
							$('#coursename').html(row.coursename);
							$("#gCId").html(row.gCId);
							$("#classid").html($("#courseWin_tt").datagrid("getSelected").classid);
							$("#courseGrade_view").show();
							var item = $('#courseGrade_tt').datagrid('getRows');
				            if (item) {
				                for (var i = item.length - 1; i >= 0; i--) {
				                    var index = $('#courseGrade_tt').datagrid('getRowIndex', item[i]);
				                    $('#courseGrade_tt').datagrid('deleteRow', index);
				                }
				            }
							courseGrade_doSearch();
						}
					});
				});
				
				function course_doSearch() {
					$('#courseWin_tt').datagrid('load',{
						classid : $("#classWin_tt").datagrid('getSelected').classid,
						coursename : $("#course_scoursename").val(),
					});
				};
			
				function course_doReSet() {
					$("#course_scoursename").val("");
					course_doSearch();
				};
			</script>
		</div>
	</div>
</div>
</div>
<script type="text/javascript">
$(function(){

});
</script>

</body>
</html>