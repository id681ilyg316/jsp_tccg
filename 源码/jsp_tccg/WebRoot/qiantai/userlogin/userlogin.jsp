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
    
    <script type='text/javascript' src='<%=path %>/dwr/interface/loginService.js'></script>
    <script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
    <script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
	
    
    <script language="javascript" type="text/javascript">
		function userlogin()
	        {
	           if(document.userLogin.loginname.value=="")
	           {
	               alert("请输入账号");
	               return;
	           }
	           if(document.userLogin.loginpw.value=="")
	           {
	               alert("请输入密码");
	               return;
	           }
	           document.getElementById("indicator").style.display="block";
	           loginService.userlogin(document.userLogin.loginname.value,document.userLogin.loginpw.value,1,callback);
	        }
	        
	        function callback(data)
			{
			    document.getElementById("indicator").style.display="none";
			    if(data=="no")
			    {
			        alert("账号或密码错误");
			    }
			    if(data!="no")//返回的data就是用户的id
			    {
			        alert("通过验证,登录成功");
			        var url="<%=path %>/qiantai/default.jsp";
			        window.location.href=url;
			    }
			}
	</script>    
</head>
  
<body>
		<jsp:include flush="true" page="/qiantai/top.jsp"></jsp:include>
		
		<img src="<%=path %>/images/bg.jpg" alt="" class="bg">
		
		
		<!-- 详细页面 -->
		<div class="tzWzyArticle2">
			<div class="tzWzyDiv wrapper"  style="border:1px solid  #CCCCCC;height: 170px;">
					<form name="userLogin" action="">
					      <table cellspacing="0" cellpadding="0" width="98%" align="center" border="0">
					          <tr>
					            <td align="center" colspan="2" height="10"></td>
					          </tr>
					          <tr>
					            <td align="right" width="10%" height="30" style="font-size: 12px;">账号：</td>
					            <td align="left" width="90%"><input type="text" name="loginname" style="width: 300px;"/></td>
					          </tr>
					          <tr>
					            <td align="right" height="30" style="font-size: 12px;">密码：</td>
					            <td align="left"><input type="password" name="loginpw" style="width: 300px;"/></td>
					          </tr>
					          <tr>
					            <td align="center" colspan="2" height="5"></td>
					          </tr>
					          <tr>
					            <td align="right" height="30" style="font-size: 12px;">&nbsp;</td>
					            <td align="left">
					               <input type="button" value="登 录" onclick="userlogin()" style="border:#ccc 1px solid; background-color:#FFFFFF; width: 60px;" />
								   &nbsp;
								   <input type="reset" value="重 置" style="border:#ccc 1px solid; background-color:#FFFFFF; width: 60px;" />
					               <img id="indicator" src="<%=path %>/images/loading.gif" style="display:none"/>
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
