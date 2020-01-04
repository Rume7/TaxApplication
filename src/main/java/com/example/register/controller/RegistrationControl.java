package com.example.register.controller;

import com.example.login.boundary.LoginUserFacade;
import com.example.login.entity.LoginUser;
import com.example.register.boundary.RegisterUserFacade;
import com.example.register.entity.RegisterUser;
import com.example.email_tin_services.model.PasswordHash;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "RegistrationControl", urlPatterns = {"/RegistrationControl"})
public class RegistrationControl extends HttpServlet {

    @EJB
    private LoginUserFacade loginUserFacade;

    @EJB
    private RegisterUserFacade registerUserFacade;

    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {

        response.setContentType("text/html;charset=UTF-8");

        RequestDispatcher dispatcher;

        String first_name = request.getParameter("first_name");
        String middle_name = request.getParameter("middle_name");
        String last_name = request.getParameter("last_name");
        String emailAdd = request.getParameter("emailAddress");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String phoneNumber = request.getParameter("phoneNumber");
        String company = request.getParameter("company");

        if (!password.equals(confirmPassword)) {
            // Instruct user to input same password in password and confirm password textfield using Javascript 
            dispatcher = request.getRequestDispatcher("/register.jsp");
            dispatcher.forward(request, response);
        } else {
            // Check if the registration email is in the database
            RegisterUser registeredPerson = registerUserFacade.find(emailAdd);

            if (registeredPerson == null) {             // if user not in database

                // Encrypt the password by hashing
                String hashedPassword = PasswordHash.getSaltedHash(password);
                
                RegisterUser registration = new RegisterUser();
                LoginUser loginUser = new LoginUser();

                registration.setFirstName(first_name);
                registration.setMiddleName(middle_name);
                registration.setLastName(last_name);
                registration.setEmail(emailAdd);
                registration.setPassword(hashedPassword);
                registration.setPhoneNumber(phoneNumber);
                registration.setCompany(company);

                loginUser.setEmailAddress(emailAdd);
                loginUser.setPassword(hashedPassword);

                registerUserFacade.create(registration);
                loginUserFacade.create(loginUser);

                dispatcher = request.getRequestDispatcher("/confirm_registration.jsp");
                //dispatcher = request.getRequestDispatcher("/create_employee_profile.jsp");
                dispatcher.forward(request, response);
            } else {
                // Print individual has been registered by stating that user exists
                dispatcher = request.getRequestDispatcher("/register.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(RegistrationControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
