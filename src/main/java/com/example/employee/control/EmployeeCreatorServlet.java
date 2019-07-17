package com.example.employee.control;

import com.example.employee.boundary.EmployeeEntityFacade;
import com.example.employee.entity.EmployeeEntity;
import com.example.utility.EmailUtil;
import com.example.utility.TINGenerator;
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
@WebServlet(name = "EmployeeCreatorServlet", urlPatterns = {"/EmployeeCreatorServlet"})
public class EmployeeCreatorServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @EJB
    private EmployeeEntityFacade employeeEntityFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        RequestDispatcher dispatcher;

        if (request.getParameter("submit").equals("SUBMIT")) {

            // Get employee parameters
            String employeeID = request.getParameter("employee_id");
            String emailAddress = request.getParameter("email_address");
            String maritalStatus = request.getParameter("marital_status");
            Double monthlyWage = Double.parseDouble(request.getParameter("monthly_wage"));
            String company = request.getParameter("company");
            String department = request.getParameter("department");

            EmployeeEntity employeeInDatabase = employeeEntityFacade.find(employeeID);
            
            if (employeeInDatabase == null) {
                
                // Create a Tax Identification number for the employee.
                String taxNumber = TINGenerator.getTaxIdentificationNumber();

                EmployeeEntity employeeEntity = new EmployeeEntity();
                employeeEntity.setEmployeeID(employeeID);
                employeeEntity.setEmployeeEmail(emailAddress);
                employeeEntity.setMaritalStatus(maritalStatus);
                employeeEntity.setMonthlyWage(monthlyWage);
                employeeEntity.setCompany(company);
                employeeEntity.setDepartment(department);
                employeeEntity.setTIN(taxNumber);

                employeeEntityFacade.create(employeeEntity);

                // Send confirmation email to employee containing his Tax ID
                EmailUtil emailUtility = new EmailUtil();
                emailUtility.setSubject("Your Tax Identification Number (TIN)");
                String message = "Dear " + employeeID + ", \n\n"
                        + "Congratulations on your successful registration.\n"
                        + "Your Tax ID is: " + taxNumber + "\n\nRegards,\nRubellite Inc.";
                
                emailUtility.setMessageBody(message);
                
                String sender = "@gmail";
                String passwordSender = "";
                String recipientEmail = "@gmail.com";
                //String recipientEmail = emailAddress;
                //emailUtility.sendEmail(sender, passwordSender, recipientEmail);

                dispatcher = request.getRequestDispatcher("/login.jsp");
                dispatcher.forward(request, response);
            } else {
                // Inform employee that he already exist in the database
                // route to create employee profile page
                dispatcher = request.getRequestDispatcher("/create_employee_profile.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

    private boolean isEmployeeInDatabase(String empID) {
        return employeeEntityFacade.find(empID).getEmployeeID() != null;
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
