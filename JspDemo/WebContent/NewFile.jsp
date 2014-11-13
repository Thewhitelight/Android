<%@page import="java.text.SimpleDateFormat"%>
<%@page import="javax.print.attribute.standard.DateTimeAtCompleted"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%
		SimpleDateFormat formatter = new SimpleDateFormat(
				"yyyy-mm-dd HH:mm:ss");
		Date curentTime = new Date();
		String data1 = formatter.format(curentTime);
		String data2 = curentTime.toString();
		out.println("<h1>Data:" + data2 + "</n1>");
	%>
</body>
</html>