<%-- 
    Document   : view_tax_page
    Created on : Jul 2, 2019, 1:59:44 AM
    Author     : E238958
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tax Report</title>
    </head>
    <body>
        
        <h2>Tax Statement page</h2>
        
        <input type="hidden" name="empID" value=empID<%=request.getParameter("employeeID")%> />
        
        <!--
        <h3>To view tax report, <a href="report?employeeID=<%=request.getParameter("employeeID")%>" onclick="javascript:nextAction(empID);">
                Click here</a></h3>
        -->
        <h3>To view tax report, <a href="#anchor" onclick="javascript:nextAction(empID);">
                Click here</a></h3>
                
        <a href="login.jsp">Logout</a>
        
    </body>
    <script type="text/javascript">
        function nextAction(empID) {
            document.location.href("report?" + empID);
        }
    </script>
    
</html>
