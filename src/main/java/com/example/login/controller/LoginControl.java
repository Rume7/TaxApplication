package com.example.login.controller;

import com.example.login.boundary.LoginUserFacade;
import com.example.login.entity.LoginUser;
import com.example.utility.PasswordHash;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
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
@WebServlet(name = "LoginControl", urlPatterns = {"/LoginControl"})
public class LoginControl extends HttpServlet {

    @EJB
    private LoginUserFacade loginUserFacade;

    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoSuchAlgorithmException, InvalidKeySpecException, Exception {

        response.setContentType("text/html;charset=UTF-8");

        String emailAdd = request.getParameter("emailAddress");
        String password = request.getParameter("password");

        RequestDispatcher dispatcher;

        // Find the email address from the database
        LoginUser user = loginUserFacade.find(emailAdd);

        if (user != null) {
            boolean stateOfPassword = PasswordHash.check(password, user.getPassword());

            if (stateOfPassword) {
                dispatcher = request.getRequestDispatcher("/create_tax_page.jsp");
                dispatcher.forward(request, response);
            }
        }
        dispatcher = request.getRequestDispatcher("/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            Logger.getLogger(LoginControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(LoginControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Servlet Login";
    }
}
