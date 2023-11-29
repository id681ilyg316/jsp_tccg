<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="<%=path %>/css/login.css" type="text/css"></link>
	
	<style type="text/css">
		ul li{font-size: 30px;color:#2ec0f6;}
		.tyg-div{z-index:-1000;float:left;position:absolute;left:5%;top:20%;}
		.tyg-p{
			font-size: 14px;
		    font-family: 'microsoft yahei';
		    position: absolute;
		    top: 135px;
		    left: 60px;
		}
		.tyg-div-denglv{margin-top: 150px;
			
		}
		.tyg-div-form{
			background-color: #23305a;
			width:500px;
			height:auto;
			margin:120px auto 0 auto;
			color:#2ec0f6;
		}
		.tyg-div-form form {padding:10px;}
		.tyg-div-form form input[type="text"]{
			width: 270px;
		    height: 30px;
		    margin: 25px 10px 0px 0px;
		}
		.tyg-div-form form button {
		    cursor: pointer;
		    width: 270px;
		    height: 44px;
		    margin-top: 25px;
		    padding: 0;
		    background: #2ec0f6;
		    -moz-border-radius: 6px;
		    -webkit-border-radius: 6px;
		    border-radius: 6px;
		    border: 1px solid #2ec0f6;
		    -moz-box-shadow:
		        0 15px 30px 0 rgba(255,255,255,.25) inset,
		        0 2px 7px 0 rgba(0,0,0,.2);
		    -webkit-box-shadow:
		        0 15px 30px 0 rgba(255,255,255,.25) inset,
		        0 2px 7px 0 rgba(0,0,0,.2);
		    box-shadow:
		        0 15px 30px 0 rgba(255,255,255,.25) inset,
		        0 2px 7px 0 rgba(0,0,0,.2);
		    font-family: 'PT Sans', Helvetica, Arial, sans-serif;
		    font-size: 14px;
		    font-weight: 700;
		    color: #fff;
		    text-shadow: 0 1px 2px rgba(0,0,0,.1);
		    -o-transition: all .2s;
		    -moz-transition: all .2s;
		    -webkit-transition: all .2s;
		    -ms-transition: all .2s;
	    }
	</style>

	<script type='text/javascript' src='<%=path %>/dwr/interface/loginService.js'></script>
	<script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
	<script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
	
	<script language="javascript">
         function check1()
		 {                                                                                         
		     if(document.ThisForm.userName.value=="")
			 {
			 	alert("请输入账号");
				document.ThisForm.userName.focus();
				return false;
			 }
			 if(document.ThisForm.userPw.value=="")
			 {
			 	alert("请输入密码");
				document.ThisForm.userName.focus();
				return false;
			 }
			 
			 var leixing1=0;
			 /* var j=document.ThisForm.leixing;
			 for(i=0;i<j.length;i++)
			 {
			    if(j[i].checked==true)
			    {
			        leixing1=j[i].value
			    }
			 }  */
			 
			 document.getElementById("indicator").style.display="block";
			 loginService.login(document.ThisForm.userName.value,document.ThisForm.userPw.value,leixing1,callback);
		}
		
		function callback(data)
		{
		    document.getElementById("indicator").style.display="none";
		    if(data=="yanzhenmacuowu")
		    {
		        alert("验证码输入错误");
		    }
		    if(data=="no")
		    {
		        alert("用户名或密码错误");
		    }
		    if(data=="yes")
		    {
		        alert("通过验证,系统登录成功");
		        window.location.href="<%=path %>/loginSuccess.jsp";
		    }
		    
		}
    </script>
</head>
  
<body>
<div id="contPar" class="contPar">
	<div id="page1"  style="z-index:1;">
		<div class="title1">&nbsp;</div>
		<%-- <img alt="" class="img3 png" src="<%=path %>/img/page1_3.jpg"> --%>
	</div>
</div>
<div class="tyg-div-denglv" align="center">
		<h1>火车站停车场车位自动管理系统</h1>

	<div class="tyg-div-form">
		<form action="<%=path %>/admin/index.jsp" name="ThisForm" method="post">
			<!-- <h2>登录</h2><p class="tyg-p">&nbsp;</p> -->
			<div style="margin:5px 0px;">
				<input type="text" name="userName"/>
			</div>
			<div style="margin:20px 0px;">
				<input type="password" name="userPw" style="width: 270px;height: 30px;margin-left: -10px;"/>
			</div>
			<div style="margin:20px 0px;display: none">
                <input type="radio" name="leixing" value="0" checked="checked" style="margin-left: -20px;"/>0
				&nbsp;
				<input type="radio" name="leixing" value="2"/>2
				&nbsp;
				<input type="radio" name="leixing" value="3"/>3
			</div>
			<button type="button" onclick="check1()" style="margin-left: -15px;">登录</button>
			<img id="indicator" src="<%=path %>/images/loading.gif" style="display:none"/>
		</form>
		<br/><br/>
	</div>
</div>
</body>
</html>
