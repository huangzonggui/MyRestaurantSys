<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<frameset rows="25%,75%" frameborder="no" border="0" framespacing="0">

<frame src="top.jsp" name="waiter_topFrame" scrolling="no" noresize="noresize" id="waiter_topFrame" title="waiter_topFrame" >

<frameset cols="25%,75%">
<frame src="waiter_left.jsp" name="waiter_leftFrame" scrolling="no" noresize="noresize" id="waiter_leftFrame" title="waiter_leftFrame">
<frame src="main.jsp" name="waiter_mainFrame" scrolling="no" noresize="noresize" id="waiter_mainFrame" title="waiter_mainFrame">
</frameset>

</frameset>
<noframes>
<body>

</body></noframes>
</html>