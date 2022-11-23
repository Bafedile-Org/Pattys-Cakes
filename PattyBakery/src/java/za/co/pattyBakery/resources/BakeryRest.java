package za.co.pattyBakery.resources;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import za.co.pattyBakery.Employee;
import za.co.pattyBakery.Product;
import za.co.pattyBakery.dao.EmployeeDAO;
import za.co.pattyBakery.dao.OrderDAO;
import za.co.pattyBakery.dao.ProductDAO;
import za.co.pattyBakery.dao.StockDAO;
import za.co.pattyBakery.dao.impl.OrderDAOImpl;
import za.co.pattyBakery.exception.ProductException;
import za.co.pattyBakery.model.EmployeeImpl;
import za.co.pattyBakery.model.ProductImpl;
import za.co.pattyBakery.service.impl.CategoryServImpl;
import za.co.pattyBakery.service.impl.EmployeeServImpl;
import za.co.pattyBakery.service.impl.ProductServImpl;
import za.co.pattyBakery.service.impl.StockServImpl;

/**
 *
 * @author Dimakatso Sebatane
 */
@Path("/bakery_res")
public class BakeryRest {

    @GET
    public Response getString() {
        return Response.status(200).entity("Hello World").build();
    }

    @POST
    @Path("/addStock")
    public Response addStock(@FormParam("prodId") String prodId, @FormParam("quantity") Integer quantity,
            @FormParam("which") String which, @FormParam("prodName") String prodName,
            @FormParam("image") String image,
            @FormParam("price") Double price,
            @FormParam("cat") String cat, @FormParam("recipeId") String recipeId) {
        StockDAO stockServImpl = new StockServImpl();
        ProductDAO productServImpl = new ProductServImpl();
        java.net.URI location = null;
        try {
            location = new java.net.URI("http://localhost:8080/bakery/admin/stock");
            if (prodId == null) {
                System.out.println("Please enter product Id");
                return Response.temporaryRedirect(location).build();
            } else {
                switch (which) {
                    case "add":
                        Product product = new ProductImpl(prodId, prodName, price, new CategoryServImpl().getCategoryIdByName(cat), "1NT", recipeId, String.format("assets/%s/%s", cat.toLowerCase(), image));
                        productServImpl.addProduct(product);
                        stockServImpl.addStockById(prodId, quantity);
                        break;
                    case "update":
                        if (quantity != null) {
                            stockServImpl.updateStockQuantity(prodId, quantity);
                        }
                        if (prodId != null && price != null) {
                            productServImpl.updateProductPrice(prodId, price);
                        }

                        break;
                    case "remove":
                        stockServImpl.removeProductFromStock(prodId);
                        productServImpl.removeProduct(prodId);
                }
                System.out.println("Successfully added to product " + prodId + " " + quantity + " items");
            }
        } catch (URISyntaxException | ProductException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return Response.temporaryRedirect(location).build();
    }

    @POST
    @Path("/addEmployee")
    public Response addEmployee(@FormParam("name") String name, @FormParam("surname") String surname,
            @FormParam("title") String title, @FormParam("id") String id, @FormParam("tel") String tel,
            @FormParam("email") String email, @FormParam("address") String address, @FormParam("todo") String todo, @FormParam("password") String password) {
        EmployeeDAO employeeSevImpl = new EmployeeServImpl();
        Employee employee;
        java.net.URI location = null;
        try {
            location = new java.net.URI("http://localhost:8080/bakery/admin/employee");
        } catch (URISyntaxException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        if (todo.equalsIgnoreCase("remove")) {

            employee = employeeSevImpl.getEmployeeByEmail(email);
            employeeSevImpl.removeCustomerLogins(employee.getPersonId(), email);
            removeEmployee(todo, employee.getPersonId());
        } else if (todo.equalsIgnoreCase("add")) {
            employee = new EmployeeImpl(name, surname, id, address, tel, email, title);
            employeeSevImpl.addEmployee(employee);
            employee = employeeSevImpl.getEmployeeByEmail(email);
            employeeSevImpl.addCustomerLogins(employee.getPersonId(), email, hashPassword(password));
        }
        return Response.temporaryRedirect(location).build();
    }

    public void removeEmployee(String todo, Integer employeeId) {
        EmployeeDAO employeeSevImpl = new EmployeeServImpl();
        employeeSevImpl.removeEmployee(employeeId);
    }

    @POST
    @Path("/updateOrder")
    public Response updateOrder(@FormParam("order_id") String orderId, @FormParam("status") String status, @FormParam("date") String date) {
        java.net.URI location = null;
        OrderDAO orderDAOImpl = new OrderDAOImpl();

        try {
            location = new java.net.URI("http://localhost:8080/bakery/admin/orders");
            if (status.equalsIgnoreCase("delivered")) {
                orderDAOImpl.updateOrderDeliveryStatus(orderId, Boolean.TRUE);

                LocalDate localDate = LocalDate.parse(date);
                orderDAOImpl.updateOrderDeliveryDate(orderId, localDate);
            }

        } catch (URISyntaxException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return Response.temporaryRedirect(location).build();

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
