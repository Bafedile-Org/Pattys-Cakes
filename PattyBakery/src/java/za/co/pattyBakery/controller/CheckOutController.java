package za.co.pattyBakery.controller;

import java.io.IOException;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.co.pattyBakery.Person;
import za.co.pattyBakery.ShoppingCart;
import static za.co.pattyBakery.controller.BakeryController.orderServImpl;
import static za.co.pattyBakery.controller.BakeryController.session;
import static za.co.pattyBakery.controller.BakeryController.totalItemsInCart;
import za.co.pattyBakery.service.impl.OrderServImpl;
import javax.mail.*;
import javax.mail.internet.*;
import za.co.pattyBakery.Order;

/**
 *
 * @author Dimakatso Sebatane
 */
@WebServlet(name = "CheckOutController", urlPatterns = {"/checkout_control"})
public class CheckOutController extends BakeryController {

    ShoppingCart cart;
    Person person;

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        cart = (ShoppingCart) session.getAttribute("cart");
        person = (Person) session.getAttribute("customer");
        if (request.getParameter("checkout") != null) {
            if ((Person) session.getAttribute("customer") == null) {
                redirectToPage(request, response, "login");
            }
            getShoppingCart(request, response);
        }
        if (request.getParameter("confirmOrder") != null) {
//            sendConfirmationEmail(person.getEmail(), cart);
            redirectToPage(request, response, "check-out");
        }

        if (request.getParameter("pay") != null) {

            orderServImpl = new OrderServImpl();
            if (cart != null) {
                orderServImpl.addOrder(cart);
            }
            cart = null;
            session.setAttribute("cart", cart);
            totalItemsInCart = 0;
            response.sendRedirect("home");
        }
    }

    private void getShoppingCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        redirectToPage(request, response, "confirm");

    }

    private void sendConfirmationEmail(String customerEmail, ShoppingCart cart) {
        // Recipient's email ID needs to be mentioned.
        String to = customerEmail;

        // Sender's email ID needs to be mentioned
        String from = "ddimakatso30@gmail.com";

        // Assuming you are sending email from localhost
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", host);

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Order Confirmation");

            // Now set the actual message
            String msg = String.format("Dear customer %s%n"
                    + "Your order is confirmed for the following items%n", person.getName());
            for (Order order : cart.getAllOrders()) {
                msg += String.format("%s%n", order.getProduct().getProductName());
            }
            message.setText(msg);

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

}
