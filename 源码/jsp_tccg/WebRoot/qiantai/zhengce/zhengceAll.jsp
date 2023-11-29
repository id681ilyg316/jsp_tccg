<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%String path = request.getContextPath();%>

<!doctype html>
<html>
<head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="<%=path %>/css/qiantai.css">
    <link rel="stylesheet" href="<%=path %>/css/list.css">
    
    
    <style rel="stylesheet" type="text/css">
		.c1-bline{border-bottom:#999 1px dashed;border-top:1px;}
		.f-right{float:right}
		.f-left{float:left}
		.clear{clear:both}
    </style>

</head>
  
<body>
		<jsp:include flush="true" page="/qiantai/top.jsp"></jsp:include>
		
		<img src="<%=path %>/images/bg.jpg" alt="" class="bg">
		
		
		<!-- 其他版块 -->
		<div class="tzFirArticle2">
			<div class="clearfix wrapper txFirDiv">
					<div class="tzFirContent">
						<%-- <div class="title clearfix" style="width: 1000px;">
							<h3 style="margin-left: 20px;">通知公告</h3>
							<a href="<%=path %>/xinwen?type=xinwenAll">More>></a>
						</div> --%>
						<div style="width: 1000px;line-height:20px">
						    <div style="margin-top: 10px;">
							    <c:forEach items="${requestScope.zhengceList}" var="zhengce">
								   <div class="c1-bline" style="padding:13px 0px;">
								       <div class="f-left">
									     <img src="<%=path %>/img/head-mark4.gif" align="middle" class="img-vm" border="0"/> 
								             <a href="<%=path %>/zhengce?type=zhengceDetailQian&id=${zhengce.id}">${zhengce.biaoti}</a>
								       </div>
								      <div class="f-right">${zhengce.shijian}</div>
								      <div class="clear"></div>
								  </div>
								</c:forEach>
							</div>
						</div>
					</div>
			</div>
		</div>
		<!-- 其他版块 -->
		<!-- 详细页面 1-->
		<!-- <div class="tzWzyArticle2">
			<div class="tzWzyDiv wrapper"  style="border:1px solid  #CCCCCC;">
				<div class="section">
					<h3>张贵春教授受聘为职业教育学院客座教授</h3><p>2019-12-01</p>
					<img src="images/img10.jpg" alt="">
					<p class="tzWzyP">
					   11月27日上午，辽宁师范大学张桂春教授受聘为华南师范大学职业教育共同见证了座，并与师生进行了广泛、热烈的互动。
					</p>
				</div>
			</div>
		</div> -->
		<!-- 详细页面1 -->
		
		<div class="tzFooter" style="height: 30px;">
			<div>
				<p><jsp:include flush="true" page="/qiantai/down.jsp"></jsp:include></p>
			</div>
		</div>
</body>
</html>
