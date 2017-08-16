<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>批量导入学生</title>

<%@include file="../../../publicHead.jsp" %>

</head>
<body>

<div style="margin:20px 0;"></div>

<div class="easyui-panel" style="width:100%;padding:30px 70px 50px 70px;text-align:center">
	<form id="form" name="form" action="../../student/lotStu.do" method="post"  enctype="multipart/form-data">
	<div style="margin-bottom:20px">
		<input class="easyui-textbox theme-textbox-radius" name="start_id" style="width:400px" data-options="required:true,label:'学号开始:'" />
	</div>
	<div style="margin-bottom:20px">
		<input class="easyui-filebox theme-textbox-radius" name=file data-options="prompt:'选择一个xls文件',buttonText:'选择文件'" style="width:400px">
	</div>
	<div>
		<a href="#" id="upload" class="easyui-linkbutton" style="width:400px" onclick="submitForm()">批量生成</a>
	</div>
	</form>
</div>



<script type="text/javascript">
$(function(){
	$('#form').form({      
		success:function(data){     // 提交成功后的回调函数。  
			//alert(data);  
			var data = eval('(' + data + ')');  // change the JSON string to javascript object      
			
			$.messager.alert('结果', data.message, 'info');
		}  
	});
});

function submitForm() {
	$('#form').submit();
}
</script>

</body>
</html>