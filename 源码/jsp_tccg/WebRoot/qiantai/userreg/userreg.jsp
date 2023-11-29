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
		<jsp:include flush="true" page="/qiantai/top.jsp"></jsp:include>
		
		<img src="<%=path %>/images/bg.jpg" alt="" class="bg">
		
		
		<!-- 详细页面 -->
		<div class="tzWzyArticle2">
			<div class="tzWzyDiv wrapper"  style="border:1px solid  #CCCCCC;height: 170px;">
					<form action="<%=path %>/user?type=userReg" name="form1" method="post">
						<table width="98%" border="0" align="left" cellpadding="0" cellspacing="1">
							<tr>
								<td width="10%" height="30" align="right" bgcolor="#F9F9F9" style="font-size: 12px;">
									账号：
								</td>
								<td width="90%" bgcolor="#FFFFFF">
									&nbsp;
									<input type="text" name="loginname" style="width: 266px;"/>
								</td>
							</tr>
							<tr>
								<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 12px;">
									密码：
								</td>
								<td bgcolor="#FFFFFF">
									&nbsp;
									<input type="password" name="loginpw" style="width: 266px;"/>
								</td>
							</tr>
							<tr>
								<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 12px;">
									姓名：
								</td>
								<td bgcolor="#FFFFFF">
									&nbsp;
									<input type="text" name="xingming" style="width: 266px;"/>
								</td>
							</tr>
							<tr>
								<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 12px;">
									住址：
								</td>
								<td bgcolor="#FFFFFF">
									&nbsp;
									<input type="text" name="zhuzhi" style="width: 266px;"/>
								</td>
							</tr>
							<tr>
								<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 12px;">
									电话：
								</td>
								<td bgcolor="#FFFFFF">
									&nbsp;
									<input type="text" name="dianhua" style="width: 266px;"/>
								</td>
							</tr>
							<tr>
								<td height="30" align="right" bgcolor="#F9F9F9">
									&nbsp;
								</td>
								<td bgcolor="#FFFFFF">
									&nbsp;
									<input type="button" value="注册" onclick="check1();" style="width: 60px;"/>
									<input type="reset" value="重置" style="width: 60px;"/>
								</td>
							</tr>
						</table>
				      </form>
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
