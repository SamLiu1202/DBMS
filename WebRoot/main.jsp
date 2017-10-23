<%@ page language="java" import="java.util.*,Entities.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%List<Restaurant> list = (List<Restaurant>)request.getSession().getAttribute("rests");%>

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
    <form action ="/5200project/Main" method = "post">
        <table border ="1" align = "center" style="border-collapse:collapse;">
            <tr align="center">
                <td colspan="6">
                    Restaurant List
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
            HashMap<String,Restaurant> hm=new HashMap<String,Restaurant>();
            
            for(int i=0;i<list.size();i++){
            Restaurant res = (Restaurant)(list.get(i));            
            
            String param=Integer.toString(i);         
            hm.put(param, res);
            
            %>
					
            <tr align="center" >
				
				
                <td><%=res.getName() %></td>
                <td><%=res.getAddress() %></td>
                <td><%=res.getStyle() %></td>
                
                <td><a href="/5200project/MenuServlet?param=<%=param%>">Menu</a></td>
                <td><a href="/5200project/CommentServlet?param=<%=param%>">Comment</a></td>
                <td><a href="/5200project/ReserveServlet?param=<%=param%>">Reserve</a></td>
					
            </tr>
            <%
            }
            %>
            <% 
            request.getSession().setAttribute("restaurants", hm);
            %>
        </table>

        <table align = "center" >
            <tr>
                <td><input type ="text" name="Rname"/></td>
                <td><input type ="submit" value ="Search"/></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

