package com.example.employee.control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author E238958
 */
@WebServlet(name = "EmployeeCreatorServlet", urlPatterns = {"/EmployeeCreatorServlet"})
public class EmployeeCreatorServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
        
            RequestDispatcher dispatcher ;
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EmployeeCreatorServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Employee Creator Servlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            if (request.getParameter("SUBMIT").equals("SUBMIT")) {
                
                dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);               
                
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
