package com.example.employee.control;

import com.example.employee_tax.boundary.EmployeeTAXFacade;
import com.example.employee_tax.entity.Allowances;
import com.example.employee_tax.entity.EmployeeTAX;
import com.example.employee_tax.entity.GrossTaxableIncome;
import com.example.employee_tax.entity.PAYE_TAX;
import com.example.employee_tax.entity.TaxExempts;
import com.example.employee_tax.entity.TaxableAllowance;
import java.io.IOException;
import javax.ejb.EJB;
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
@WebServlet(name = "TaxPageController", urlPatterns = {"/TaxPageController"})
public class TaxPageController extends HttpServlet {

    @EJB
    private EmployeeTAXFacade employeeTAXFacade;

    private static final long serialVersionUID = 1L;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        if (request.getParameter("tax_report").equals("Create_Tax_Report")) {
            createTaxReport(request, response);
            routePageTo(request, response, "view_report.jsp");
        }
    }
    
    private void routePageTo(HttpServletRequest request, HttpServletResponse response, String page)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }

    private void createTaxReport(HttpServletRequest request, HttpServletResponse res) {
        String employeeID = request.getParameter("employeeID");
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        Double monthly_basic = Double.parseDouble(request.getParameter("monthly_basic"));
        Double housing = Double.parseDouble(request.getParameter("housing"));
        Double transport = Double.parseDouble(request.getParameter("transport"));
        Double utility_allowance = Double.parseDouble(request.getParameter("utility_allowance"));
        Double pension = Double.parseDouble(request.getParameter("pension"));
        Double field_bonus = Double.parseDouble(request.getParameter("field_bonus"));

        // Create GrossTaxableIncome object
        GrossTaxableIncome taxableIncome = new GrossTaxableIncome();
        taxableIncome.setBasicSalary(monthly_basic);
        taxableIncome.setHousing(housing);
        taxableIncome.setTransport(transport);

        // Create Allowance object
        Allowances allowances = new Allowances();
        allowances.setFieldAllowance(field_bonus);
        allowances.setUtilityAllowance(utility_allowance);
        taxableIncome.setAllowances(allowances);

        // Create TaxExempt object
        TaxExempts taxExempts = new TaxExempts();
        taxExempts.setPension(pension);

        // TaxableAllowance 
        TaxableAllowance taxableAllowance = new TaxableAllowance(taxableIncome);

        // Create EmployeeTax
        EmployeeTAX employeeTax = new EmployeeTAX();
        employeeTax.setEmployeeID(employeeID);
        employeeTax.setGrossTaxableIncome(taxableIncome);
        employeeTax.setTaxExempts(taxExempts);
        employeeTax.setTaxableAllowance(taxableAllowance);

        // Persist to Database
        employeeTAXFacade.create(employeeTax);

        // Calculate the monthly tax
        PAYE_TAX paye = new PAYE_TAX(employeeTax);
        // monthlyTax = paye.getPAYE_AMOUNT();
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
