<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>家长后台</title>

<%@include file="../../../publicHead.jsp" %>

</head>
<body>
<div id="master-layout">
		<div data-options="region:'north',border:false,bodyCls:'theme-header-layout'">
        	<div class="theme-navigate">
				<div class="right">
					<a href="#" class="easyui-menubutton theme-navigate-user-button"
						data-options="menu:'.theme-navigate-user-panel'">${sessionScope.parent.stuname }家长</a>

					<div class="theme-navigate-user-panel">
						<dl>
							<dd>
								<img src="../themes/insdep/images/portrait86x86.png" width="86"
									height="86"> <b class="badge-prompt">${sessionScope.parent.stuname }家长</b> 
									<span>id:&nbsp;${sessionScope.parent.parentid }</span>
							</dd>
							<dt>
								<a class="theme-navigate-user-modify" id = "passwordChange">修改密码</a>
								<a class="theme-navigate-user-logout" id="logout" href="../login/logOut.do">注销</a>
							</dt>
						</dl>
					</div>
				</div>
			</div>
        </div>
        
        <div data-options="region:'center',border:false"  id="control" style="background:#fff;">
			<table id="tt" class="easyui-datagrid" style="width:100%;height:100%"
					url="../stuScore/findScore.do" toolbar="#tb" pageList='[1,10,20,30,50]' singleSelect="true"
					rownumbers="true" pagination="true">
				<thead>
					<tr>
						<th field="sessnname" width="80">年届名称</th>
						<th field="gradename" width="80">年级名称</th>
						<th field="classname" width="80">班级名称</th>
						<th field="number" width="80">编号</th>
						<th field="coursename" width="80">课程名称</th>
						<th field="name" width="80">成绩名称</th>
						<th field="mark" width="80">成绩</th>
					</tr>
				</thead>
			</table>
			<div id="tb" style="padding:3px">
				<span>年届名称:</span>
				<input id="ssessnname" style="line-height:26px;border:1px solid #ccc">
				<span>年级名称:</span>
				<input id="sgradename" style="line-height:26px;border:1px solid #ccc">
				<span>班级名称:</span>
				<input id="sclassname" style="line-height:26px;border:1px solid #ccc">
				<span>编号:</span>
				<input id="snumber" style="line-height:26px;width:40px;border:1px solid #ccc">
				<span>课程名称:</span>
				<input id="scoursename" style="line-height:26px;border:1px solid #ccc">
				<span>成绩名称:</span>
				<input id="sname" style="line-height:26px;border:1px solid #ccc">
				<span>成绩:</span>
				<input id="smark" style="line-height:26px;border:1px solid #ccc">
				<a href="#" class="easyui-linkbutton" plain="true" onclick="doSearch()">查找</a>
				<a href="#" class="easyui-linkbutton" plain="true" onclick="doReSet()">重置</a>
			</div>
        </div>
	</div>
	<div id="userWindow" class="easyui-window" title="修改密码" data-options="modal:true,collapsible:false,closed:true,maximizable:false,minimizable:false,resizable:false" style="width:550px;height:400px;padding:10px;">
			<div style="width: 400px; padding: 30px 60px;">
				<form id="ff" method="post"
					action="../parent/parentUpdate.do">
					<div style="margin-bottom: 20px">
					<div style="margin-bottom: 20px">
						<input
							class="easyui-textbox theme-textbox-radius validatebox-readonly"
							readonly="readonly" value="${sessionScope.parent.parentid }" name="parentid" id="id"
							style="width: 100%" data-options="label:'ID:'" />
						</div>
						<div style="margin-bottom: 20px">
						<input
							class="easyui-textbox theme-textbox-radius validatebox-readonly"
							readonly="readonly" value="${sessionScope.parent.stuname }家长"
							style="width: 100%" data-options="label:'姓名:'" />
						</div>
							
						<div id="password-panel">
							<div style="margin-bottom: 20px">
								<input
									class="easyui-passwordbox easyui-validatebox theme-textbox-radius"
									id="ipassword1" validType="length[1,16]" name="password" iconWidth="28" style="width: 100%"
									data-options="label:'密码:'" />
							</div>
							<div style="margin-bottom: 20px">
								<input
									class="easyui-passwordbox easyui-validatebox theme-textbox-radius"
									id="ipassword2" style="width: 100%"  iconWidth="28" data-options="label:'重复密码:'"
									validType="equalTo['#ipassword1']" invalidMessage="两次输入密码不匹配" />
							</div>
						</div>
					</div>
				</form>
				<div style="padding: 5px 0">
					<a href="javascript:void(0)" class="easyui-linkbutton" id="on_submit"
						style="width: 80px; float: right">提交更改</a>
				</div>
			</div>
		</div>
		
	<script>
	$.extend($.fn.validatebox.defaults.rules, {
	    /*必须和某个字段相等*/
	    equalTo: { validator: function (value, param) { return $(param[0]).val() == value; }, message: '字段不匹配' }
	   });
		 $(function(){
			/*布局部分*/
			$('#master-layout').layout({
				fit:true/*布局框架全屏*/
			});   
			
			$('#ff').form({      
		        success:function(data){     // 提交成功后的回调函数。  
		            //alert(data);  
		            var data = eval('(' + data + ')');  // change the JSON string to javascript object      
		           
		            alert(data.message);
		            
		            if (data.message == '修改成功') {
		            	window.location="../login/logOut.do";
		            }
		             
		        }  
		    }); 

			$("#passwordChange").click(function(){
				$("#userWindow").window('open');
			});
			
			$("#on_submit").click(function(){
				$("#ff").submit();
			});
			
			doSearch();
		});
		 
		 function doSearch() {
			 $('#tt').datagrid('load',{
				stuid : ${sessionScope.parent.parentid },				
				sessnname: $('#ssessnname').val(),
				gradename: $('#sgradename').val(),
				classname: $('#sclassname').val(),
				number: $('#snumber').val(),
				coursename: $('#scoursename').val(),
				name: $('#sname').val(),
				mark: $('#smark').val(),
			});
		 };
		 
		 function doReSet() {
			 $('#ssessnname').val("");
			 $('#sgradename').val("");
			 $('#sclassname').val("");
			 $('#snumber').val("");
			 $('#scoursename').val("");
			 $('#sname').val("");
			 $('#smark').val("");
			 doSearch();
		 }
	
    </script>

</body>
</html>