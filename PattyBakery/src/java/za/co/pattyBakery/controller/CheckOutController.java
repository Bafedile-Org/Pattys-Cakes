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
                request.setAttribute("checkout", "checkout");
                redirectToPage(request, response, "login");
            }
            getShoppingCart(request, response);
        }
        if (request.getParameter("confirmOrder") != null) {
//            sendConfirmationEmail("pattysbakery.shop@gmail.com", "PattyBakery", person.getEmail());
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

    private void sendConfirmationEmail(String from, String password, String to) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        //get Session   
        Session ses = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });
        //compose message    
        try {
            MimeMessage message = new MimeMessage(ses);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Order Confirmation " + cart.getOrderNumber());
            // Now set the actual message
            String msg = String.format("Dear customer %s%n"
                    + "Your order is confirmed for the following items%n", person.getName());
            for (Order order : cart.getAllOrders()) {
                msg += String.format("%s%n", order.getProduct().getProductName());
            }
            message.setText(msg);
            //send message  
            Transport.send(message);
            System.out.println("message sent successfully");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

}
