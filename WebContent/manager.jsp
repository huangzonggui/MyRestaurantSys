<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<frameset rows="25%,75%" frameborder="no" border="0" framespacing="0">

<frame src="top.jsp" name="manager_topFrame" scrolling="no" noresize="noresize" id="manager_topFrame" title="manager_topFrame" >

<frameset cols="25%,75%">
<frame src="manager_left.jsp" name="manager_leftFrame" scrolling="no" noresize="noresize" id="manager_leftFrame" title="manager_leftFrame">
<frame src="main.jsp" name="manager_mainFrame" scrolling="no" noresize="noresize" id="manager_mainFrame" title="manager_mainFrame">
</frameset>

</frameset>
<noframes>
<body>

</body></noframes>
</html>