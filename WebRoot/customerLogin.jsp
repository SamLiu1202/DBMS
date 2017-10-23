<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
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
  <h3>Boston Best-restaurant Query</h3>
   <body>  
        <form action="/5200project/CustomerLoginServlet" method="post">  
            <table align="center">  
                <tr>  
                    <td>user：</td>  
                    <td>  
                        <input type="text" name="username"/>  
                    </td>  
                </tr>  
                <tr>  
                    <td>password：</td>  
                    <td>  
                        <input type="password" name="telephone"/>  
                    </td>  
                </tr>  
                <tr>  
                    <td colspan="2">  
                        <input type="submit" value="sign-in"/>  
                    </td>  
                </tr>  
            </table>  
        </form>  
    </body>  
</html>
