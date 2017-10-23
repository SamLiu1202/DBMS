<%@ page language="java" import="java.util.*,Entities.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%List<Object> list= (List<Object>)request.getSession().getAttribute("Umenu");%>
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

<form action="/5200project/MenuUpdateServlet" method="post">
     <table border ="1" align = "center" style="border-collapse:collapse;">
            <tr align="center">
                <td colspan="3">
                    Menu
                </td>
            </tr>
            <tr align="center">
                <td>Dish</td>
                <td>Price</td>
                <td>Description</td>  
            </tr>
			
            <%
            if(list.isEmpty()){
            out.print("No Dishes!"); 
            }
            
            else{
            
            for(Object obj:list){
            
            Dishes dis=(Dishes)obj;
            %>

            <tr align="center" >
                <td><%=dis.getDishName()%></td>
                <td><%=dis.getPrice()%></td>
                <td><%=dis.getDescription()%></td>
            </tr>
            <%
            }
            
            }
            %>
  </table>

    <table align="center">
        <tr>
            <td>dish:</td>
            <td>
                <input type="text" name="dish"/>
            </td>
        </tr>
        <tr>
            <td>price:</td>
            <td>
                <input type="text" name="price"/>
            </td>
        </tr>
        <tr>
            <td>description:</td>
            <td>
                <input type="text" name="desc"/>
            </td>
        </tr>
        <tr>
            <td colspan="3">
                <input type="submit" value="submit"/>
            </td>
        </tr>
    </table>
    
    <table align ="center" >
            <tr>
                <td><a href="/5200project/restaurant.jsp">return main</a></td>
            </tr>
     </table>       
</form>
</body>
</html>