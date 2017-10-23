<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>BBQ system</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">


</head>

<body>
<div id = "main">
    <form action ="/5200project/ReserveServlet" method = "post">
        <table align = "center" >
            <tr>
                <td><input type ="text" name="rsv"/>the number of people</td>
                <td><input type ="submit" value ="update"/></td>
            </tr>
        </table>
        <table align ="center" >
            <tr>
                <td><a href="/5200project/main.jsp">return main</a></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>