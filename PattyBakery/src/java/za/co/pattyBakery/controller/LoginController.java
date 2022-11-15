package za.co.pattyBakery.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.co.pattyBakery.Person;
import za.co.pattyBakery.dao.CustomerDAO;
import za.co.pattyBakery.service.impl.CustomerServImpl;

/**
 *
 * @author Dimakatso Sebatane
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login_control"})
public class LoginController extends BakeryController {

    private String email, password, name, surname, tel, conPassword, address, idNum;
    private CustomerDAO customerServImpl = new CustomerServImpl();

    private Person person;

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("login") != null || request.getAttribute("login") != null) {
            logUserIn(request, response);
            if (checkIfUserExists()) {
                redirectToPage(request, response, "cookies_control");
            } else {
                redirectToPage(request, response, "signup");
            }
        } else if (request.getParameter("signup") != null) {
            name = request.getParameter("name");
            surname = request.getParameter("surname");
            idNum = request.getParameter("idNum");
            email = request.getParameter("email");
            address = request.getParameter("addres");
            tel = request.getParameter("tel");
            password = request.getParameter("password");
            conPassword = request.getParameter("conPassword");

            // check if the user already exists
            if (checkIfUserExists()) {
                request.setAttribute("login", "login");
                redirectToPage(request, response, "cookies_control");
            }

        }
    }

    public void redirectToPage(HttpServletRequest request, HttpServletResponse response, String redirectPage)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(redirectPage);
        dispatcher.forward(request, response);
    }

    private void logUserIn(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        email = request.getParameter("email");
        password = request.getParameter("password");
    }

    private Boolean checkIfUserExists() {
        person = customerServImpl.getCustomerByEmail(email);
        return (person != null && customerServImpl.getCustomerPassword(email) != null);
    }
}
