<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.warning{
color:#FF0000;}
.div{
margin:()auto;position;relative;
padding-top:0px;padding-left:0px;
}
.div1{
margin:()auto;position;relative;
padding-top:10%;padding-left: 10%;}
.login{
margin:()auto;position;relative;
padding-top:15%;padding-left: 60%;
}
.div2{
	color:#000000;}

</style>
</head>
<script>
function check(){
	var flag=true;
	var username=document.getElementById("userAccount").value;
	if (username==null||username=="")
	{
		document.getElementById("nameMsg").innerHTML=("用户名不能为空" );
	 flag=false;
	}
	var passwd=document.getElementById("passwd").value;
  
	if (passwd==null||passwd=="")
	{
		document.getElementById("pwdMsg").innerHTML=("密码不能为空" );
	 flag=false;
	}
	return flag;
}
function clean(){
	document.getElementById("nameMsg").innerHTML=("");
	document.getElementById("pwdMsg").innerHTML=("");
}
</script>
<body  bgcolor="#ECE4C8"> 
<div class="div1">
<table  border="0">
<tr>
		<td width="500"><img src="img/door.png" ></td>
<td width="414">
<form  method="post" action="LoginServlet.do" onSubmit="return check()" onClick="return clean()">
  <table width="417" height="126" border="0"  >
    <tr>
      <td width="87" align="right"  > <p class="div2"> 用户名：</p></td>
      <td width="320"><input type="text" id="userAccount"  name="userAccount"/>
      <br/>
        <span id="nameMsg"  class="warning">${errMsg }</span> </td>
    </tr>
    <tr>
      <td align="right"><p  class="div2" >密码：</p></td>
      <td><input type="password" id="passwd" name="passwd" />
          <br/>
          <span id="pwdMsg" class="warning"  ></span> </td>
    </tr>
    <tr>
    <td height="34"></td>
     <td align="center" valign="middle"><input type="submit" name="login" id="login" value="登录" /></td>
    </tr>
  </table>
</form>
</td>
</tr>
</table>
</div>
</body>
</html>