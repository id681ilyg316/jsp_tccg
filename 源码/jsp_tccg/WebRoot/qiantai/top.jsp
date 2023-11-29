<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
  String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
      <style rel="stylesheet" type="text/css">
			.c1-bline{border-bottom:#999 1px dashed;border-top:1px;}
			.f-right{float:right}
			.f-left{float:left}
			.clear{clear:both}
	  </style>
	
	  <script type="text/javascript">
	       function zhongxin()
		   {
			    var targetWinUrl="<%=path %>/auser/index.jsp";
				var targetWinName="newWin";
				var features="width="+screen.width+" ,height="+screen.height+" ,toolbar=yes, top=0, left=0, menubar=yes, scrollbars=yes, resizable=yes,location=no, status=yes";
				var new_win=window.open(targetWinUrl,targetWinName,features);
		   }
      </script>
</head>
  
<body>
	    <div class="tzFirHeader">
			<div class="wrapper midHeader">
				<%-- <p align="right">
				     <c:if test="${sessionScope.userType !=1 }">
			         <a href="<%=path %>/qiantai/userlogin/userlogin.jsp" style="font-family: 微软雅黑;color: white">用户登录</a>&nbsp;&nbsp;
			         <a href="<%=path %>/qiantai/userreg/userreg.jsp" style="font-family: 微软雅黑;color: white">立即注册</a>
				     </c:if>
				     
				     <c:if test="${sessionScope.userType ==1 }">
				                          欢迎您：${sessionScope.user.xingming }&nbsp;&nbsp;&nbsp;
				        <a href="<%=path %>/user?type=userLogout" style="color: white">安全退出</a>&nbsp;&nbsp;&nbsp;
				        <a href="#" style="color: white" onclick="zhongxin()">个人中心</a>&nbsp;&nbsp;&nbsp;
				     </c:if>
				</p> --%>
				<h1><a href="#" style="margin-left: 66px;margin-top: 30px;"><!-- <img src="<%=path %>/images/logo.png" alt=""> -->基于JSP的火车站停车场车位自动管理系统 </a></h1>
				<div class="tzFirNav">
					<ul class="clearfix">
						<li class="clearfix"><a href="<%=path %>/qiantai/default.jsp" class="default">系统首页</a><span></span></li>
						<li class="clearfix"><a href="<%=path %>/liuyan?type=liuyanAll">留言模块</a><span></span></li>
						
						<c:if test="${sessionScope.userType !=1 }">
						<li class="clearfix"><a href="<%=path %>/qiantai/userreg/userreg.jsp" class="default">立即注册</a><span></span></li> 
						<li class="clearfix"><a href="<%=path %>/qiantai/userlogin/userlogin.jsp" class="default">用户登录</a><span></span></li> 
						</c:if>
						
						<c:if test="${sessionScope.userType ==1 }">
						<li class="clearfix" style="width: 150px;"><a href="#" class="default">欢迎您：${sessionScope.user.xingming }</a><span></span></li> 
						<li class="clearfix"><a href="<%=path %>/user?type=userLogout" class="default">安全退出</a><span></span></li> 
						<li class="clearfix"><a href="#" class="default" onclick="zhongxin()">个人中心</a><span></span></li> 
						</c:if>
					</ul>
				</div>
			</div>
		</div>
</body>
</html>
