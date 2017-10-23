<%@ page language="java" import="java.util.*,Entities.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%Restaurant res = (Restaurant)request.getSession().getAttribute("R_name");
	
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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
	<div id = "main">
        <table border ="1" align = "center" style="border-collapse:collapse;">
            <tr align="center">
                <td colspan="6">
                    Restaurant You Search
                </td>
            </tr>
            <tr align="center">
                <td>Name</td>
                <td>Style</td>
                <td>Address</td>
                <td>Menu</td>
                <td colspan="2"></td>
            </tr>


			<%
			if(res==null){
					out.write("The restaurant do not exist!");
			
			}else{
			
 				HashMap<String,Restaurant> hm=new HashMap<String,Restaurant>();
				String param=Integer.toString(1);         
            	hm.put(param, res);	
           		
           		%>
           		<tr align="center" >
           						
                <td><%=res.getName() %></td>
                <td><%=res.getAddress() %></td>
                <td><%=res.getStyle() %></td>
              	<td><a href="/5200project/MenuServlet?param=<%=param%>">Menu</a></td>
                <td><a href="/5200project/CommentServlet?param=<%=param%>">Comment</a></td>
                <td><a href="/5200project/ReserveServlet?param=<%=param%>">Reserve</a></td>
				<%
				request.getSession().setAttribute("restaurants", hm);
				} 				
				%>
				
            </tr>
 
        </table>

        <table align = "center" >
            <tr>
                <td><a href="/5200project/main.jsp">return main</a></td>
            </tr>
        </table>
</div>
</body>
</html>
