<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		
        <script language="javascript">
           function tingDel(id,chewei_id)
           {
               if(confirm('您确定删除吗？'))
               {
                   var url="<%=path %>/ting?type=tingDel&id="+id+"&chewei_id="+chewei_id;
                   window.location.href=url;
               }
           }
           
           function jiesuanPre(id)
           {
               var url="<%=path %>/ting?type=jiesuanPre&id="+id;
               window.location.href=url;
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#EEF4EA">
			        <td colspan="13" background="<%=path %>/images/wbg.gif" class='title'><span>&nbsp;</span></td>
			    </tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="4%">序号</td>
					<td width="10%">车位</td>
					<td width="10%">车型</td>
					<td width="10%">车牌</td>
					
					<td width="10%">驶入时间</td>
					<td width="10%">离开时间</td>
					<td width="10%">费用</td>
					<td width="10%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.tingList}" var="ting" varStatus="ss">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${ss.index+1}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${ting.chewei.bianhao}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${ting.chexing}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${ting.chepai}
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
						${ting.kaishishijian}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${ting.jieshushijian}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<c:if test="${ting.feiyong==0}">
						   <a onclick="jiesuanPre(${ting.id})" style="color: red;" >费用结算</a>
						</c:if>
						<c:if test="${ting.feiyong!=0}">
						   ${ting.feiyong}
						</c:if>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<input type="button" value="删除" onclick="tingDel(${ting.id},${ting.chewei_id})"/>
					</td>
				</tr>
				</c:forEach>
			</table>
	</body>
</html>
