package za.co.pattyBakery.resources;

import java.net.URISyntaxException;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import za.co.pattyBakery.service.impl.IngredientsServImpl;
import za.co.pattyBakery.service.impl.StockServImpl;

/**
 *
 * @author Dimakatso Sebatane
 */
@Path("/bakery_res")
public class BakeryRest {

    @POST
    public Response getString() {
        return Response.status(200).entity("Hello World").build();
    }

    @Path("/get_ingr")
    @GET
    public Response getIngredients() {
//        RecipeDAO recipeServImpl = new RecipeServImpl();
//        String[] recipeIds = {"16RES", "17RES", "18RES"};
////        String[] strings = {"vanila", "chocolate", "plain"};
//        Recipe recipe = recipeServImpl.getRecipeById(recipeIds[0]);

        return Response.status(200).entity("hello bree").build();
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

    @POST
    @Path("/addIngredient")
    public Response addIngredient(@FormParam("ingrId") String ingrId, @FormParam("ingredient") String ingredient, @FormParam("quantity") Integer quantity,
            @FormParam("which") String which) {
        IngredientsServImpl ingredientsServImpl = new IngredientsServImpl();
        java.net.URI location = null;
        try {
            location = new java.net.URI("http://localhost:8080/bakery/ingredient_page.jsp");
        } catch (URISyntaxException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        if (ingrId == null) {
            System.out.println("Please enter ingredient Id");
            return Response.temporaryRedirect(location).build();
        } else {
            if (which.equals("add")) {
                ingredientsServImpl.addIngridient(ingrId, ingredient, quantity);
            } else if (which.equals("update")) {
                ingredientsServImpl.updateIngredient(ingrId, quantity);
            } else {
                ingredientsServImpl.removeIngredient(ingrId);
            }
            System.out.println("Successfully added to ingredient " + ingrId + " " + quantity + " items");
            return Response.temporaryRedirect(location).build();
        }
    }

}
