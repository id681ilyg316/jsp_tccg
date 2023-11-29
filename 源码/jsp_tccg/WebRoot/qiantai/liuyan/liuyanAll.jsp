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
    
    <script language="javascript" type="text/javascript">
		function liuyanAdd()
	        {
		             <c:if test="${sessionScope.userType!=1}">
	                    alert("请先登录");
	                 </c:if>
	                 <c:if test="${sessionScope.userType==1}">
	                    var strUrl = "<%=path %>/qiantai/liuyan/liuyanAdd.jsp";
		                var ret = window.showModalDialog(strUrl,"","dialogWidth:800px; dialogHeight:500px; dialogLeft: status:no; directories:yes;scrollbars:yes;Resizable=no;");
		                window.location.reload();
	                 </c:if>
	        }
	        
	        function liuyanDetail(id)
	        {
	             var strUrl = "<%=path %>/liuyan?type=liuyanDetail&id="+id;
	             var ret = window.showModalDialog(strUrl,"","dialogWidth:800px; dialogHeight:500px; dialogLeft: status:no; directories:yes;scrollbars:yes;Resizable=no;");
	        }
	</script>    
</head>
  
<body>
		<jsp:include flush="true" page="/qiantai/top.jsp"></jsp:include>
		
		<img src="<%=path %>/images/bg.jpg" alt="" class="bg">
		
		
		<!-- 详细页面 -->
		<div class="tzWzyArticle2">
			<div class="tzWzyDiv wrapper"  style="border:1px solid  #CCCCCC;">
					                     <c:forEach items="${requestScope.liuyanList}" var="liuyan">
										   <div class="c1-bline" style="padding:9px 0px;">
										       <div class="f-left">
											       <img src="<%=path %>/img/head-mark4.gif" align="middle" class="img-vm" border="0"/> 
										           <a href="#" onclick="liuyanDetail(${liuyan.id })">${liuyan.neirong}</a>
										       </div>
										      <div class="f-right" style="margin-right: 10px;">${liuyan.liuyanshi}</div>
										      <div class="clear">
										                               回复信息：${liuyan.huifu}<br/>回复时间：${liuyan.huifushi}
										      </div>
										  </div>
										</c:forEach>
										<br/>
										<center>
										   <a href="#" onclick="liuyanAdd()" style="color: red">留言咨询</a>
										</center>
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
