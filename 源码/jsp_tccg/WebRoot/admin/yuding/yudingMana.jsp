<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	    <base target="_self"/>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
       
        <script language="javascript">
           function yudingShouli(id)
           {
               if(confirm('您确定吗？'))
               {
                   window.location.href="<%=path %>/yuding?type=yudingShouli&id="+id;
               }
           }
        </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="42" background="<%=path %>/img/tbg.gif">&nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="4%">序号</td>
					<td width="10%">您的姓名</td>
					<td width="10%">联系方式</td>
					<td width="10%">到达时间</td>
					
					<td width="10%">车位</td>
					<!-- <td width="10%">用户</td> -->
					<td width="10%">状态</td>
					<td width="10%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.yudingList}" var="yuding" varStatus="sta">
				<tr align='center' bgcolor="#FFFFFF">
					<td bgcolor="#FFFFFF" align="center">${sta.index+1}</td>
					<td bgcolor="#FFFFFF" align="center">${yuding.xingming}</td>
					<td bgcolor="#FFFFFF" align="center">${yuding.dianhua}</td>
					<td bgcolor="#FFFFFF" align="center">${yuding.daodashi}</td>
					
					<td bgcolor="#FFFFFF" align="center">${yuding.chewei.bianhao}</td>
					<%-- <td bgcolor="#FFFFFF" align="center">${yuding.user_id}</td> --%>
					<td bgcolor="#FFFFFF" align="center">
					    ${yuding.zt}
					    <c:if test="${yuding.zt=='待受理'}">
					        <a onclick="yudingShouli(${yuding.id})" style="color: red" onmouseover="this.style.cursor='hand'">受理</a>
					    </c:if>	
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
					   <form action="<%=path %>/yuding?type=yudingDel" name="ff" method="post">
					       <input type="hidden" name="id" value="${yuding.id}"/>
					       <input type="submit" value="删除"/>
					   </form>
				    </td>
				</tr>
				</c:forEach>
			</table>
	</body>
</html>
