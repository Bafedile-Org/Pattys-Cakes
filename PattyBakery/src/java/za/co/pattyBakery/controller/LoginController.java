package za.co.pattyBakery.controller;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.co.pattyBakery.Person;
import za.co.pattyBakery.dao.CustomerDAO;
import za.co.pattyBakery.dao.EmployeeDAO;
import za.co.pattyBakery.model.PersonImpl;
import za.co.pattyBakery.service.impl.CustomerServImpl;
import za.co.pattyBakery.service.impl.EmployeeServImpl;

/**
 *
 * @author Dimakatso Sebatane
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login_control",})
public class LoginController extends BakeryController {

    private String email, password, name, surname, tel, conPassword, address, idNum;
    private CustomerDAO customerServImpl = new CustomerServImpl();
    private EmployeeDAO employeeServImpl = new EmployeeServImpl();
    private Person person;

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        loginUserIn(request, response);
        logAdminIn(request, response);
        signUserIn(request, response);
        ResetAdminPassword(request, response);
        ResetUserPassword(request, response);

    }

    private void logUserIn(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        email = request.getParameter("email");
        password = request.getParameter("password");
        person = customerServImpl.getCustomerByEmail(email);

    }

    private Boolean checkIfUserExists() {
        person = customerServImpl.getCustomerByEmail(email);
        return (person != null && customerServImpl.getCustomerPassword(person.getPersonId(), email) != null);
    }

    private Boolean checkIfAdminExists() {
        person = employeeServImpl.getEmployeeByEmail(email);
        return (person != null && employeeServImpl.getCustomerPassword(person.getPersonId(), email) != null);
    }

    private void loginUserIn(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("login") != null) {

            logUserIn(request, response);
            if (checkIfUserExists()) {
                String hashedPassword = hashPassword(password);
                String userPassword = customerServImpl.getCustomerPassword(person.getPersonId(), email);
                if (hashedPassword.contains(userPassword)) {
                    session.setAttribute("customer", person);

                    if (request.getParameter("checkout") != null) {
                        redirectToPage(request, response, "confirm");
                    } else {
                        redirectToPage(request, response, "home");
                    }
                } else {
                    redirectToPage(request, response, "login");
                }
            } else {
                redirectToPage(request, response, "signup");
            }
        }
    }

    private void signUserIn(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("signup") != null) {
            name = request.getParameter("name");
            surname = request.getParameter("surname");
            idNum = request.getParameter("idNum");
            email = request.getParameter("email");
            address = request.getParameter("address");
            tel = request.getParameter("tel");
            password = request.getParameter("password");
            conPassword = request.getParameter("conPassword");

            // check if the user already exists
            if (checkIfUserExists()) {
                redirectToPage(request, response, "check-out");
            } else {
                if (password.equals(conPassword)) {
                    customerServImpl.addCustomer(new PersonImpl(name, surname, idNum, address, tel, email));

                    Person customer = customerServImpl.getCustomerByEmail(email);

                    customerServImpl.addCustomerLogins(customer.getPersonId(), email, hashPassword(password));
                    redirectToPage(request, response, "login");
                } else {
                    redirectToPage(request, response, "signup");
                }
            }
        }
    }

    private void ResetUserPassword(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("reset") != null) {
            email = request.getParameter("email");
            password = request.getParameter("password");
            customerServImpl.updateCustomerPassword(email, hashPassword(password));
            redirectToPage(request, response, "login");
        } else {
            redirectToPage(request, response, "admin/home");
        }
    }

    private void ResetAdminPassword(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("resetAdmin") != null) {
            email = request.getParameter("email");
            password = request.getParameter("password");
            employeeServImpl.updateCustomerPassword(email, hashPassword(password));
            redirectToPage(request, response, "login");
        }
    }

    private void logAdminIn(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession(true);
        if (request.getParameter("admin_login") != null) {
            if (session != null) {
                if ((Boolean) session.getAttribute("loggedIn") != null) {
                    redirectToPage(request, response, "admin/home");
                } else {
                    email = request.getParameter("email");
                    password = request.getParameter("password");
                    person = employeeServImpl.getEmployeeByEmail(email);
                    if (checkIfAdminExists()) {
                        String hashedPassword = hashPassword(password);
                        String userPassword = employeeServImpl.getCustomerPassword(person.getPersonId(), email);
                        if (hashedPassword.contains(userPassword)) {

                            session.setAttribute("loggedIn", Boolean.TRUE);
                            redirectToPage(request, response, "admin/home");
                        }
                    } else {
                        redirectToPage(request, response, "admin");
                    }
                }
            }
        }
    }

    private String hashPassword(String input) {
        try {
            // getInstance() method is called with algorithm SHA-512
            MessageDigest md = MessageDigest.getInstance("SHA-512");

            // digest() method is called
            // to calculate message digest of the input string
            // returned as array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);

            // Add preceding 0s to make it 32 bit
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            // return the HashText
            return hashtext;
        } // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
