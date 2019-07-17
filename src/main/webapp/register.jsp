<%-- 
    Document   : register
    Created on : Jul 2, 2019, 11:41:53 AM
    Author     : E238958
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
    </head>
    <body>
        <h1>Welcome to Tax Application System!</h1>
        <h3>Register to create your employee profile</h3>

        <form method="post" action="RegistrationControl">
            <table>
                <tbody>
                    <tr>
                        <td>First Name</td>
                        <td><input type="text" name="first_name" required /></td>
                    </tr>
                    <tr>
                        <td>Middle Name</td>
                        <td><input type="text" name="middle_name" value="middle_name" placeholder="Middle Name" required /></td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td><input type="text" name="last_name" required /></td>
                    </tr>
                    <tr>
                        <td>Email Address</td>
                        <td><input type="email" name="emailAddress" required /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" required /></td>
                    </tr>
                    <tr>
                        <td>Confirm Password</td>
                        <td><input type="password" name="confirmPassword" required /></td>
                    </tr>
                    <tr>
                        <td>Phone Number</td>
                        <td><input type="text" name="phoneNumber" required /></td>
                    </tr>
                    <tr>
                        <td>Company</td>
                        <td><input type="text" name="company" required /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" name="REGISTER" /></td>
                    </tr>
                </tbody>
            </table>
        </form>

        <a href="index.html"><h3>Cancel registration</h3></a>
    </body>
</html>
