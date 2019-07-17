<%-- 
    Document   : create_employee_profile
    Created on : Jul 15, 2019, 3:21:57 PM
    Author     : E238958
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Profile Page</title>
    </head>
    <body>

        <h1>Welcome to Tax Application System!</h1>
        <h3>Create your employee profile</h3>

        <form method="POST" action="EmployeeCreatorServlet">
            <table>
                <tr>
                    <td>Employee ID </td>
                    <td><input type="text" name="employee_id" value="employee_id" placeholder="Employee ID" required /></td>
                </tr>
                <tr>
                    <td>Email Address</td>
                    <td><input type="email" name="email_address" value="email_address" placeholder="Email Address" required /></td>
                </tr>
                <tr>
                    <td>Marital Status</td>
                    <td><input type="text" name="marital_status" value="marital_status" placeholder="Marital Status" required /></td>
                </tr>
                <tr>
                    <td>Monthly Wage</td>
                    <td><input type="text" name="monthly_wage" value="monthly_wage" placeholder="Monthly Wage" required /></td>
                </tr>
                <tr>
                    <td>Company</td>
                    <td><input type="text" name="company" value="company" placeholder="Company Name" required /></td>
                </tr>
                <tr>
                    <td>Department</td>
                    <td><input type="text" name="department" value="department" placeholder="Department" required /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" name="submit" value="SUBMIT" /></td>
                </tr>
            </table>
        </form>
        
        <a href="index.html">Home Page</a>
    </body>
</html>
