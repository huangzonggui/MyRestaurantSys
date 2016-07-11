<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.location1{
margin:()auto;position;relative;width:500px;height:500px;padding-top:15%;padding-left: 10%;}
.STYLE5 {font-size: 30px}
</style>
</head>
<script>
function openShutManager(oSourceObj,oTargetObj,shutAble,oOpenTip,oShutTip){  
	var sourceObj = typeof oSourceObj == "string" ? document.getElementById(oSourceObj) : oSourceObj;  
	var targetObj = typeof oTargetObj == "string" ? document.getElementById(oTargetObj) : oTargetObj;  
	var openTip = oOpenTip || "";  
	var shutTip = oShutTip || "";  
	if(targetObj.style.display!="none"){  
	   if(shutAble) return;  
	   targetObj.style.display="none";  
	   if(openTip  &&  shutTip){  
	    sourceObj.innerHTML = shutTip;   
	   }  
	} else {  
	   targetObj.style.display="block";  
	   if(openTip  &&  shutTip){  
	    sourceObj.innerHTML = openTip;   
	   }  
	}  
}
</script>
<body bgcolor="#ECE4C8">
<table border="0">
  <tr>
    <td width="187" align="center" ><span class="STYLE5">Hello！</span></td>
  </tr>
  <tr>
    <td width="187"><img src="../img/breakfast.png" class="png" ></td>
    <td width="120" >• <a href="manager_infor.jsp"  target="manager_mainFrame">个人信息：</a></td>
  </tr>
  <tr>
    <td><img src="../img/lunch.png" class="png"></td>
    <td>• <a href="manager_person.jsp"  target="manager_mainFrame">人员管理：</a></td>
  </tr>
  <tr>
    <td><img src="../img/afternoontea.png" class="png"></td>
    <td>• <a href="manager_menu.jsp"  target="manager_mainFrame">菜单管理：</a></td>
  </tr>
  <tr>
    <td><img src="../img/dinner.png" class="png"></td>
    <td>▶  <a href="#" onClick="openShutManager(this,'box')">订单管理：</a>
    <table width="163" border="0">
        <tr>
          <td> <p id="box" style="display:none">┅
          <a href="manager_order_ing.jsp"  target="manager_mainFrame">未完成订单：</a>
          <br/>┅<a href="manager_order_ed.jsp"  target="manager_mainFrame">已完成订单：</a></p></td>
        </tr>
      </table>
</table>
</body>
</html>