package za.co.pattyBakery.resources;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import za.co.pattyBakery.Employee;
import za.co.pattyBakery.Order;
import za.co.pattyBakery.ShoppingCart;
import za.co.pattyBakery.dao.EmployeeDAO;
import za.co.pattyBakery.dao.OrderDAO;
import za.co.pattyBakery.dao.RecipeDAO;
import za.co.pattyBakery.exception.OrderException;
import za.co.pattyBakery.model.Recipe;
import za.co.pattyBakery.service.impl.EmployeeServImpl;
import za.co.pattyBakery.service.impl.OrderServImpl;
import za.co.pattyBakery.service.impl.RecipeServImpl;

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
        RecipeDAO recipeServImpl = new RecipeServImpl();
        String[] recipeIds = {"16RES", "17RES", "18RES"};
//        String[] strings = {"vanila", "chocolate", "plain"};
        Recipe recipe = recipeServImpl.getRecipeById(recipeIds[0]);

        return Response.status(200).entity(recipe.getIngredients()).build();
    }
    @Path("/order_add")
    @POST
    public Response addOrder(@FormParam("orderNumber") String orderNumber,@FormParam("productId") String productId,
            @FormParam("qty") Integer qty,@FormParam("status") String status){
        OrderDAO orderServImpl = new OrderServImpl();
        try{
        ShoppingCart cart = orderServImpl.getShoppingCartByOrderId(orderNumber);
        for(Order order: cart.getOrders()){
           if(order.getProduct().getProductId().equals(productId)){
               order.setQuantity(qty);
           }
        }
        cart.setStatus(true);
        orderServImpl.addOrder(cart);
        }
        catch(OrderException ex){
            System.out.println("Error: " + ex.getMessage());
        }
        return Response.status(200).entity("").build();
    }
    @Path("/employee_add")
    @POST
    public Response addEmployee(@FormParam("name") String name, @FormParam("surname") String surname,
       @FormParam("tittle") String tittle, @FormParam("id") String id, @FormParam("tel") String tel,
       @FormParam("email") String email, @FormParam("address") String address){
        EmployeeDAO employeeSevImpl = new EmployeeServImpl();
        
        return Response.status(200).entity("").build();
    }
}
