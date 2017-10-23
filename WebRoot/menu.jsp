<%@ page language="java" import="java.util.*,Entities.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%List<Dishes> list = (List<Dishes>)request.getSession().getAttribute("menu");%>
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
                <td colspan="3">
                    Menu
                </td>
            </tr>
            <tr align="center">
                <td>DishName</td>
                <td>Price</td>
                <td>Description</td>
            </tr>
			<% for(int i=0;i<list.size();i++){
            Dishes dis = (Dishes)(list.get(i)); 
            %>

            <tr align="center" >

                <td><%=dis.getDishName() %></td>
                <td><%=dis.getPrice() %></td>
                <td><%=dis.getDescription() %></td>
            </tr>
  			<%
            }
            %>
        </table>

        <table align ="center" >
            <tr>
                <td><a href="/5200project/main.jsp">return main</a></td>
            </tr>
        </table>
	</div> 
  </body>
</html>
