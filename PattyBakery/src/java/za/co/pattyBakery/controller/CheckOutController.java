package za.co.pattyBakery.controller;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.co.pattyBakery.Order;
import za.co.pattyBakery.Person;
import za.co.pattyBakery.Product;
import za.co.pattyBakery.ShoppingCart;
import static za.co.pattyBakery.controller.BakeryController.orderServImpl;
import static za.co.pattyBakery.controller.BakeryController.session;
import static za.co.pattyBakery.controller.BakeryController.totalItemsInCart;
import za.co.pattyBakery.service.impl.OrderServImpl;

/**
 *
 * @author Dimakatso Sebatane
 */
@WebServlet(name = "CheckOutController", urlPatterns = {"/checkout_control"})
public class CheckOutController extends BakeryController {

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
            sendConfirmationEmail("pattysbakery.shop@gmail.com", "hnetsedhsxyhqtsx", person.getEmail());
            response.sendRedirect("home");
        }
    }

    private void getShoppingCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        redirectToPage(request, response, "confirm");

    }

    private void sendConfirmationEmail(String from, String password, String to) {
        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";
        // Get system properties
        Properties properties = System.getProperties();
        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);  //special GMAIL generated password for your email account
            }
        });
        // Used to debug SMTP issues
        session.setDebug(true);
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));
            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Order Confirmation");

            List<Order> orders = cart.getAllOrders();

            String msg = String.format("<table><tr>"
                    + "<th style='width:90px'>Items</th>"
                    + "<th style='width:90px'>Quantity</th>"
                    + "<th style='width:90px'>Total Price</th>"
                    + "</tr>");
            for (int i = 0; i < orders.size(); i++) {
                Product product = orders.get(i).getProduct();
                msg += String.format("<tr><td style='width:90px'>%s</td><td style='width:90px'>%s</td><td style='width:90px'>%s</td></tr>", product.getProductName(), orders.get(i).getQuantity(), orders.get(i).getTotalPrice());
            }
            msg += String.format("</table><h3>Total Price R%.2f</h3>", cart.getTotalprice());
            message.setContent(msg, "text/html");
            // Now set the actual message
//            message.setText(msg);
            // ----------------------------------------------
            //This is to send an attachemnet --
//            Multipart multipart = new MimeMultipart();
//            MimeBodyPart attachmentPart = new MimeBodyPart();
//            MimeBodyPart textPart = new MimeBodyPart();
//            try {
//                File f = new File("C:\\Users\\TRAIN 08\\Downloads\\Evaluation_of_possibilities_of_java.pdf");
//                attachmentPart.attachFile(f);
//                textPart.setText("This is text and I have sent you something attached");
//                multipart.addBodyPart(textPart);
//                multipart.addBodyPart(attachmentPart);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            message.setContent(multipart);
            // ----------------------------------------------
            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

}
