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
    
    <script type='text/javascript' src='<%=path %>/js/lunbo.js'></script>
    <script language="javascript">
           function down1(fujianPath,fujianYuashiMing)
           {
               var url="<%=path %>/updown/updown.jsp?fujianPath="+fujianPath+"&fujianYuashiMing="+fujianYuashiMing;
		       url=encodeURI(url); 
               url=encodeURI(url); 
               window.open(url,"_self");
           }
       </script>
</head>
  
<body>
		<jsp:include flush="true" page="/qiantai/top.jsp"></jsp:include>
		
		<img src="<%=path %>/images/bg.jpg" alt="" class="bg">
		
		
		<!-- 详细页面 -->
		<div class="tzWzyArticle2">
			<div class="tzWzyDiv wrapper"  style="border:1px solid  #CCCCCC;">
				<div class="section">
					<h3>${requestScope.zhengce.biaoti}</h3><p>${requestScope.zhengce.shijian}</p>
					<img src="<%=path %>/${requestScope.zhengce.fujian}" style="width: 990px;height: 350px;">
					<div align="left">
					   <c:out value="${requestScope.zhengce.neirong}" escapeXml="false"></c:out>
					</div>
					<%-- <div align="left">
					    ${zhengce.fujian}&nbsp;&nbsp;
					    <a href="#" onclick="down1('${zhengce.fujian}','${zhengce.fujian}')" style="font-size: 13px;color: red">附件下载</a>
					</div> --%>
				</div>
			</div>
		</div>
		<!-- 详细页面 -->
		
		<div class="tzFooter" style="height: 30px;">
			<div>
				<p><jsp:include flush="true" page="/qiantai/down.jsp"></jsp:include></p>
			</div>
		</div>
	</body>
</html>
