package com.example.employee_tax.controller;

import com.example.employee_tax.boundary.EmployeeTAXFacade;
import com.example.employee_tax.entity.EmployeeTAX;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author E238958
 */
@WebServlet(name = "ReportServlet", urlPatterns = {"/report"})
public class ReportServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    @EJB
    private EmployeeTAXFacade employeeTAXFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/pdf");

        String employeeID = request.getParameter("employeeID");
        EmployeeTAX employee = employeeTAXFacade.find(employeeID);
        
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();
            document.addAuthor("Rhume");
            document.addCreationDate();
            document.addTitle("Monthly Tax Report");
            
            
            String ID = employee.getEmployeeID();
            Double grossTax = employee.getGrossTaxableIncome();
            Double netTax = employee.getNetTaxableIncome();
            Double tax_exempt = employee.getTaxExempts();
            Double allowance = employee.getTaxableAllowance();
            
            document.add(new Paragraph("Hi  " + ID + ", here is your monthly Tax Report"));
            document.add(new Paragraph(""));
            document.add(new Paragraph(""));
            document.add(new Paragraph(""));
            
            document.add(new Paragraph("Date:              " + new Date().toString()));
            document.add(new Paragraph("Employee ID:       " + ID));
            document.add(new Paragraph("Gross Tax amount:  " + String.format("$%.2f", grossTax)));
            document.add(new Paragraph("Net Tax amount:    " + String.format("$%.2f", netTax)));
            document.add(new Paragraph("Tax Exempt amount: " + String.format("$%.2f", tax_exempt)));
            document.add(new Paragraph("Total Allowances:  " + String.format("$%.2f", allowance)));
            document.close();

        } catch (DocumentException ex) {
            throw new IOException(ex.getMessage());
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
    }

}
