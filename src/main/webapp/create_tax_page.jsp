<%-- 
    Document   : create_tax_page
    Created on : Jul 2, 2019, 11:52:48 AM
    Author     : E238958
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Report</title>
    </head>
    <body>
        
        <h2>Create an employee tax profile page</h2>
        <h4>Fill in the form below to view your tax profile for the month</h4>
        
        <form method="post" action="TaxPageController">
            <table>
                <tbody>
                    <tr>
                        <td>Employee ID</td>
                        <td><input type="text" name="employeeID" value="" required /></td>
                    </tr>
                    <tr>
                        <td>First Name</td>
                        <td><input type="text" name="first_name" value="" required /></td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td><input type="text" name="last_name" value="" required /></td>
                    </tr>
                    <tr>
                        <td>Basic Monthly Income</td>
                        <td><input type="text" name="monthly_basic" value="" required /></td>
                    </tr>
                    <tr>
                        <td>Housing</td>
                        <td><input type="text" name="housing" value="" required /></td>
                    </tr>
                    <tr>
                        <td>Transport</td>
                        <td><input type="text" name="transport" value="" required /></td>
                    </tr>
                    <tr>
                        <td>Utility Allowance</td>
                        <td><input type="text" name="utility_allowance" value="" required /></td>
                    </tr>
                    <tr>
                        <td>Pension</td>
                        <td><input type="text" name="pension" value="" required /></td>
                    </tr>
                    <tr>
                        <td>Field Bonus</td>
                        <td><input type="text" name="field_bonus" value="" required /></td>
                    </tr>                   
                    <tr>
                        <td></td>
                        <td><input type="submit" name="tax_report" value="Create_Tax_Report" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
