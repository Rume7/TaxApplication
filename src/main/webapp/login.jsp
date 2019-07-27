<%-- 
    Document   : login
    Created on : Jul 2, 2019, 11:37:28 AM
    Author     : E238958
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h2>Welcome to the Login page</h2>
        
        <form method="POST" action="LoginControl">
            <table>
                <tbody>
                    <tr>
                        <td>Email:</td>
                        <td><input type="email" name="emailAddress" required /></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="password" name="password" required /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" name="login" value="LOGIN" /></td>
                    </tr>
                </tbody>
            </table>            
        </form>      
        <br/><br />
        <a href="index.html">Index page</a>
    </body>
</html>
