<%@ page language="java" import="java.util.*,Entities.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%List<Object> list= (List<Object>)request.getAttribute("comment");%>

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
    <form action ="/5200project/CommentServlet" method = "post">
        <table border ="1" align = "center" style="border-collapse:collapse;">
            <tr align="center">
                <td colspan="2">
                    Comment
                </td>
            </tr>
            <tr align="center">
                <td>ID</td>
                <td>Content</td>
            </tr>
			
            <%
            if(list.isEmpty()){
            out.print("No comment!"); 
            }
            
            else{
            
            for(Object obj:list){
            
            Comment cmt=(Comment)obj;
            %>

            <tr align="center" >
                <td><%=cmt.getCommentId()%></td>
                <td><%=cmt.getContent()%></td>
            </tr>
            <%
            }
            
            }
            %>
        </table>

        <table align = "center" >
            <tr>
                <td><input type ="text" name="cont"/>write comment</td>
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