<%@ page language="java" import="java.util.*,Entities.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%Restaurant r=(Restaurant)request.getSession().getAttribute("rest");%>

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
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

</head>

<body>
<div id = "main">
    <table border ="1" align = "center" style="border-collapse:collapse;">
        <tr align="center">
            <td colspan="5">
                Your restaurant
            </td>
        </tr>
        <tr align="center">
            <td>Name</td>
            <td>Style</td>
            <td>Address</td>
            <td colspan="2"></td>
        </tr>
 	
        <tr align="center" >

            <td><%=r.getName()%></td>
            <td><%=r.getAddress() %></td>
            <td><%=r.getStyle() %></td>
            <td><a href="/5200project/RestaurantServlet">edit info</a></td>
            <td><a href="/5200project/MenuUpdateServlet?para=<%=r.getName()%>">edit menu</a></td>	

        </tr>

    </table>

</div>
</body>
</html>

