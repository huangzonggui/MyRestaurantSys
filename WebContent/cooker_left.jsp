<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
	.STYLE5 {font-size: 30px}
</style>
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
<body  bgcolor="#ECE4C8">
<table border="0">
  <tr>
    <td width="187" align="center" ><span class="STYLE5">Hello！</span></td>
  </tr>
  <tr>
<td width="187"><img src="img/breakfast.png" class="png" ></td>
    <td>• <a href="cooker_infor.jsp"  target="cooker_mainFrame">个人信息：</a></td>
  </tr>
  <tr>
    <td><img src="img/lunch.png" class="png"></td>
    <td>▶  <a href="#" onClick="openShutManager(this,'box')">订单：</a>
      <table width="163" border="0">
        <tr>
          <td> <p id="box" style="display:none">┅
          <a href="cooker_order_ing.jsp"  target="cooker_mainFrame">&nbsp;&nbsp;未完成订单：</a>
          <br/>┅<a href="cooker_order_ed.jsp"  target="cooker_mainFrame">&nbsp;&nbsp;已完成订单：</a></p></td>
        </tr>
      </table>
     </td>
  </tr>
</table>
</body>
</html>