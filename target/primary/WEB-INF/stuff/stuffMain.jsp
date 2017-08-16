<%@ page language="java" contentType="text/html; charset=utf-8" 
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>教职工后台</title>

<%@include file="../../publicHead.jsp"%>

</head>
<body>

	<div id="master-layout">
        <div data-options="region:'north',border:false,bodyCls:'theme-header-layout'">
        	<div class="theme-navigate">
				<div class="right">
					<a href="#" class="easyui-menubutton theme-navigate-user-button"
						data-options="menu:'.theme-navigate-user-panel'">${sessionScope.stuff.name }</a>

					<div class="theme-navigate-user-panel">
						<dl>
							<dd>
								<img src="../themes/insdep/images/portrait86x86.png" width="86"
									height="86"> <b class="badge-prompt">${sessionScope.stuff.name }</b> 
									<span>id:&nbsp;<font id="stuffid">${sessionScope.stuff.stuffid }</font></span>
							</dd>
							<dt>
								<a class="theme-navigate-user-modify">修改资料</a>
								<a class="theme-navigate-user-logout" href="../login/logOut.do">注销</a>
							</dt>
						</dl>
					</div>
				</div>
			</div>
        </div>

        <!--开始左侧菜单-->
        <div data-options="region:'west',border:false,bodyCls:'theme-left-layout'" style="width:200px;">
            <!--正常菜单--> 
            <div class="theme-left-normal">

                <!--start class="easyui-layout"-->
                <div class="easyui-layout" data-options="border:false,fit:true"> 

                    <!--start region:'center'-->
                    <div data-options="region:'center',border:false" id="menu">

                        <!--start easyui-accordion--> 
                        <div class="easyui-accordion" data-options="border:false,fit:true">   
                        	<c:if test="${sessionScope.stuff.authority % 2 == 1 }">
                            <div title="教职工管理">   
                                <ul class="easyui-datalist" data-options="border:false,fit:true">
                                    <li><a  id="stuffMana" href="#" rel="admin/stuffMana.do">教职工管理</a></li>
                                </ul>  
                            </div>   
                            <div title="学生管理">   
                                <ul class="easyui-datalist" data-options="border:false,fit:true">
                                	<li><a  id="lotStu" href="#" rel="student/lotStu.do">批量生成</a></li>
                                    <li><a  id="stuMana" href="#" rel="student/stuMana.do">学生管理</a></li>
                                </ul>      
                            </div>   
                            <div title="家长管理">   
                                <ul class="easyui-datalist" data-options="border:false,fit:true">
                                    <li><a  id="parentMana" href="#" rel="parent/parentMana.do">家长管理</a></li>
                                </ul>      
                            </div>
                            <div title="课程管理">   
                                <ul class="easyui-datalist" data-options="border:false,fit:true">
                                    <li><a  id="courseMana" href="#" rel="course/courseMana.do">课程管理</a></li>
                                </ul>      
                            </div>
                            <div title="年段管理">   
                                <ul class="easyui-datalist" data-options="border:false,fit:true">
                                    <li><a  id="sessionMana" href="#" rel="session/sessionMana.do">年段管理</a></li>
                                    <li><a  id="sessionGrade" href="#" rel="session/sessionGrade.do">段级管理</a></li>
                                </ul>      
                            </div>
                            </c:if>
                            <div title="年级管理">   
                                <ul class="easyui-datalist" data-options="border:false,fit:true">
                                    <li><a  id="gradeMana" href="#" rel="grade/gradeMana.do">年级管理</a></li>
                                    <li><a  id="gradeCourseMana" href="#" rel="grade/gradeCourseMana.do">年级课程管理</a></li>
                                    <li><a  id="classCourseTeacherMana" href="#" rel="class/classCourseTeacherMana.do">课程教师任命</a></li>
                                </ul>      
                            </div>
        					<div title="班级管理">   
                                <ul class="easyui-datalist" data-options="border:false,fit:true">
                                    <li><a  id="classMana" href="#" rel="class/classMana.do">班级管理</a></li>
                                </ul>      
                            </div>  
                            <div title="课程管理">   
                                <ul class="easyui-datalist" data-options="border:false,fit:true">
                                    <li><a  id="myCourse" href="#" rel="course/myCourse.do">我的课程</a></li>
                                </ul>      
                            </div>                  

                        </div>
                        <!--end easyui-accordion--> 

                    </div>
                    <!--end region:'center'-->
                </div>  
                <!--end class="easyui-layout"-->

            </div>

        </div>
        <!--结束左侧菜单-->

		<div region="center">
			<div id="tabs" class="easyui-tabs" fit="true" border="false">
			</div>
		</div>

		<div id="userWindow" class="easyui-window" title="修改资料" data-options="modal:true,collapsible:false,closed:true,maximizable:false,minimizable:false,resizable:false" style="width:550px;height:400px;padding:10px;">
			<div style="width: 400px; padding: 30px 60px;">
				<form id="ff" method="post"
					action="../stuff/stuffUpdate.do">
					<div style="margin-bottom: 20px">
						<input
							class="easyui-textbox theme-textbox-radius validatebox-readonly"
							readonly="readonly" value="${sessionScope.stuff.stuffid }" name="stuffid" id="id"
							style="width: 100%" data-options="label:'ID:'" />
					</div>
					<div style="margin-bottom: 20px">
						<input class="easyui-textbox theme-textbox-radius validatebox-readonly " id="stuname"
							name="name" value="${sessionScope.stuff.name }" style="width: 100%"
							data-options="required:true, label:'姓名:'" />
					</div>
					<input type="hidden" name="authority" value="${sessionScope.stuff.authority }"/>
					<div id="password-panel">
						<div style="margin-bottom: 20px">
							<input
								class="easyui-passwordbox easyui-validatebox theme-textbox-radius" name="password"
								id="ipassword1" validType="length[1,16]"  iconWidth="28" style="width: 100%"
								data-options="label:'密码:'" />
						</div>
						<div style="margin-bottom: 20px">
							<input
								class="easyui-passwordbox easyui-validatebox theme-textbox-radius"
								id="ipassword2" style="width: 100%"  iconWidth="28" data-options="label:'重复密码:'"
								validType="equalTo['#ipassword1']" invalidMessage="两次输入密码不匹配" />
						</div>
					</div>
				</form>
				<div style="padding: 5px 0">
					 <a href="javascript:void(0)" class="easyui-linkbutton" id="on-submit"
						style="width: 80px; float: right">提交更改</a>
				</div>
			</div>
		</div>
    </div>
	<script type="text/javascript">
	$(function(){
			/*布局部分*/
			$('#master-layout').layout({
				fit:true/*布局框架全屏*/
			});   
			
			    $("#menu a").click(function(){
			        var title=$(this).text();
			        var url=$(this).attr("rel");
			        var tabId = $(this).attr("id") + "tab";
			        var name = $(this).attr("id") + "tab_name";
			        f_addTab(name,tabId,title,url);
			        return false;    //使超链接的单击事件失效
			    });


            /*右侧菜单控制部分*/

            var left_control_status=true;
            var left_control_panel=$("#master-layout").layout("panel",'west');

            $(".left-control-switch").on("click",function(){
                if(left_control_status){
                    left_control_panel.panel('resize',{width:70});
                    left_control_status=false;
                    $(".theme-left-normal").hide();
                    $(".theme-left-minimal").show();
                }else{
                    left_control_panel.panel('resize',{width:200});
                    left_control_status=true;
                    $(".theme-left-normal").show();
                    $(".theme-left-minimal").hide();
                }
                $("#master-layout").layout('resize', {width:'100%'})
            });

            /*右侧菜单控制结束*/


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

	//userful
			$(".theme-navigate-user-modify").on("click",function(){
                $('.theme-navigate-user-panel').menu('hide');
                $('#userWindow').window('open');
            }); 
			//$.insdep.control("list.html");
			
			

			var cc1=$('#cc1').combo('panel');
			cc1.panel({cls:"theme-navigate-combobox-panel"}); 
			var cc2=$('#cc2').combo('panel');
			cc2.panel({cls:"theme-navigate-combobox-panel"}); 
			
			

			/*$("#open-layout").on("click",function(){
					var option = {
						"region":"west",
						"split":true,
                        "title":"title",
						"width":180
					};
					$('#master-layout').layout('add', option);
					
			});*/
			
			 
		});
		
		$("#on-submit").click(function() {
			$("#ff").submit();
		});
		
		$.extend($.fn.validatebox.defaults.rules, {
		    /*必须和某个字段相等*/
		    equalTo: { validator: function (value, param) { return $(param[0]).val() == value; }, message: '字段不匹配' }
		   });
		
		//有必要
		$('#tabs').tabs({
		    onSelect:function(title){
		    	if (title == '时间列表' || title == '课程列表' || title == '当前计划') {
		    		$.post("../SystemServlet?method=isLoad",function(data){
						 var data = eval('(' + data + ')');  // change the JSON string to javascript object      
			                if (data.success){  
			                    if (data.message == false) {
			                    	alert("当前未挂载选课计划,请前往计划列表中挂载");
			                    	$('#tabs').tabs('close', title);
			                    	$("#planList").click();
			                    }  
			                }  
					  });
		    	}
		    	
		    }
		});
		
		function tabsClose(){  
		    var tab=$('#tabs').tabs('getSelected');//获取当前选中tabs  
		    var index = $('#tabs').tabs('getTabIndex',tab);//获取当前选中tabs的index  
		    $('#tabs').tabs('close',index);//关闭对应index的tabs  
		}  
		
		function f_addTab(name,tabId,title,url){
			if (url == null) {
				return;
			}
			 if ($("#tabs").tabs('exists', title)) {
			  	$('#tabs').tabs('select', title);
			  	refreshTab({tabTitle:title,url:url});
			 } else {
			  $('#tabs').tabs('add',{
				   id:tabId,
				   title:title,
				   content:'<iframe name="'+name+'" src="'+url+'" frameborder="0" style="height:100%;width:100%;" "></iframe>',
				   closable:true,//tab显示关闭键
				   cache:true //设置缓存，如果为false，在每次选中所选的tab时，都会加载一次页面内容
			  	});
			 } 
		}
		
		/**     
		 * 刷新tab 
		 * @cfg  
		 *example: {tabTitle:'tabTitle',url:'refreshUrl'} 
		 *如果tabTitle为空，则默认刷新当前选中的tab 
		 *如果url为空，则默认以原来的url进行reload 
		 */  
		function refreshTab(cfg){  
		    var refresh_tab = cfg.tabTitle?$('#tabs').tabs('getTab',cfg.tabTitle):$('#tabs').tabs('getSelected');  
		    if(refresh_tab && refresh_tab.find('iframe').length > 0){  
		    var _refresh_ifram = refresh_tab.find('iframe')[0];  
		    var refresh_url = cfg.url?cfg.url:_refresh_ifram.src;  
		    //_refresh_ifram.src = refresh_url;  
		    _refresh_ifram.contentWindow.location.href=refresh_url;  
		    }  
		} 
    </script>
</body>
</html>