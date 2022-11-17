package za.co.pattyBakery.resources;

import java.net.URISyntaxException;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import za.co.pattyBakery.Employee;
import za.co.pattyBakery.Order;
import za.co.pattyBakery.ShoppingCart;
import za.co.pattyBakery.dao.EmployeeDAO;
import za.co.pattyBakery.dao.OrderDAO;
import za.co.pattyBakery.exception.OrderException;
import za.co.pattyBakery.model.EmployeeImpl;
import za.co.pattyBakery.service.impl.EmployeeServImpl;
import za.co.pattyBakery.service.impl.OrderServImpl;
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

    @Path("/get_ingr")
    @GET
    public Response getIngredients() {
//        RecipeDAO recipeServImpl = new RecipeServImpl();
//        String[] recipeIds = {"16RES", "17RES", "18RES"};
//        String[] strings = {"vanila", "chocolate", "plain"};
//        Recipe recipe = recipeServImpl.getRecipeById(recipeIds[0]);

        return Response.status(200).entity("hello bree").build();
    }

    @POST
    @Path("/addOrder")
    public Response addOrder(@FormParam("orderNumber") String orderNumber, @FormParam("productId") String productId,
            @FormParam("qty") Integer qty, @FormParam("status") String status, @FormParam("adding") String adding) {
        OrderDAO orderServImpl = new OrderServImpl();
        java.net.URI location = null;
        try {
            location = new java.net.URI("http://localhost:8080/bakery/order_page.jsp");
        } catch (URISyntaxException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        try {
            ShoppingCart cart = orderServImpl.getShoppingCartByOrderId(orderNumber);
            for (Order order : cart.getOrders()) {
                if (order.getProduct().getProductId().equals(productId)) {
                    order.setQuantity(qty);
                }
            }
            cart.setStatus(true);
            orderServImpl.addOrder(cart);
        } catch (OrderException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return Response.temporaryRedirect(location).build();
    }

    @POST
    @Path("/addEmployee")
    public Response addEmployee(@FormParam("name") String name, @FormParam("surname") String surname,
            @FormParam("title") String title, @FormParam("id") String id, @FormParam("tel") String tel,
            @FormParam("email") String email, @FormParam("address") String address, @FormParam("todo") String todo) {
        EmployeeDAO employeeSevImpl = new EmployeeServImpl();
        java.net.URI location = null;
        try {
            location = new java.net.URI("http://localhost:8080/bakery/employee_page.jsp");
        } catch (URISyntaxException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        if (todo.equalsIgnoreCase("remove")) {
            removeEmployee(todo, id);
        } else if (todo.equalsIgnoreCase("add")) {
            Employee employee = new EmployeeImpl(name, surname, id, address, tel, email, title);
            employeeSevImpl.addEmployee(employee);
        }
        return Response.temporaryRedirect(location).build();
    }

    public void removeEmployee(String todo, String employeeId) {
        EmployeeDAO employeeSevImpl = new EmployeeServImpl();
        employeeSevImpl.removeEmployee(employeeId);
    }

    @POST
    @Path("/addStock")
    public Response addStock(@FormParam("prodId") String prodId, @FormParam("quantity") Integer quantity,
            @FormParam("which") String which) {
        StockServImpl stockServImpl = new StockServImpl();
        java.net.URI location = null;
        try {
            location = new java.net.URI("http://localhost:8080/bakery/stock");
        } catch (URISyntaxException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        if (prodId == null) {
            System.out.println("Please enter product Id");
            return Response.temporaryRedirect(location).build();
        } else {
            if (which.equals("add")) {
                stockServImpl.addStockById(prodId, quantity);
            } else {
                stockServImpl.updateStockQuantity(prodId, quantity);
            }
            System.out.println("Successfully added to product " + prodId + " " + quantity + " items");
            return Response.temporaryRedirect(location).build();
        }
    }

    @GET
    @Path("/prodId")
    public Response getProdId(@QueryParam("prodId") String prodId) {
        String responseMsg = "The product ID you selected is " + prodId + ".";
        return Response.status(200).entity(responseMsg).build();
    }

    @GET
    @Path("/quantity")
    public Response getQuantity(@DefaultValue("77") @QueryParam("quantity") Integer quantity) {
        String responseMsg = "The quantity you want to add to product " + quantity + " is " + quantity + ".";
        return Response.status(200).entity(responseMsg).build();
    }
}
