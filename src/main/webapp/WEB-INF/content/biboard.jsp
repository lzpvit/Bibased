<%--
  Created by IntelliJ IDEA.
  User: LZP
  Date: 2018/3/28
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String lat = request.getParameter("lat");//用request得到
%>
<html>
<head>
    <title>biboard</title>
</head>
<body>
hi,<%=lat%>

</body>
</html>
