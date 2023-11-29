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
	
	<link rel="stylesheet" href="<%=path %>/css/base.css">
    
    <script language="javascript" type="text/javascript">
		function check1()
	    {
	        if(document.form1.loginname.value=="")
	        {
	            alert("请输入账号");
	            return false;
	        }
	        if(document.form1.loginname.value.length<6)
			{
			    alert("账号不能小于6位");
			    return false;
			}
	        if(document.form1.loginpw.value=="")
	        {
	            alert("请输入密码");
	            return false;
	        }
	        if(document.form1.loginpw.value.length<6)
			{
			    alert("密码不能小于6位");
			    return false;
			}
	        document.form1.submit();
	    }
	</script>    
</head>
  
<body>
		
					<form action="<%=path %>/user?type=userEditMe" name="form1" method="post">
						<table width="98%" border="1" align="left" cellpadding="0" cellspacing="1">
							<tr>
								<td width="10%" height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
									账号：
								</td>
								<td width="90%" bgcolor="#FFFFFF">
									&nbsp;
									<input type="text" name="loginname" style="width: 266px;" value="${sessionScope.user.loginname }" readonly="readonly"/>
								(账号只读)
								</td>
							</tr>
							<tr>
								<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
									密码：
								</td>
								<td bgcolor="#FFFFFF">
									&nbsp;
									<input type="password" name="loginpw" style="width: 266px;" value="${sessionScope.user.loginpw }"/>
								</td>
							</tr>
							<tr>
								<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
									姓名：
								</td>
								<td bgcolor="#FFFFFF">
									&nbsp;
									<input type="text" name="xingming" style="width: 266px;" value="${sessionScope.user.xingming }"/>
								</td>
							</tr>
							<tr>
								<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
									住址：
								</td>
								<td bgcolor="#FFFFFF">
									&nbsp;
									<input type="text" name="zhuzhi" style="width: 266px;" value="${sessionScope.user.zhuzhi }"/>
								</td>
							</tr>
							<tr>
								<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
									电话：
								</td>
								<td bgcolor="#FFFFFF">
									&nbsp;
									<input type="text" name="dianhua" style="width: 266px;" value="${sessionScope.user.dianhua }"/>
								</td>
							</tr>
							<tr>
								<td height="30" align="right" bgcolor="#F9F9F9">
									&nbsp;
								</td>
								<td bgcolor="#FFFFFF">
									&nbsp;
									<input type="hidden" name="id" value="${sessionScope.user.id }">
									<input type="button" value="修改" onclick="check1();"/>
									<input type="reset" value="重置"/>
								</td>
							</tr>
						</table>
				      </form>
			
	</body>
</html>
