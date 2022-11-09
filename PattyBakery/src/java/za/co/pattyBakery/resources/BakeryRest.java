package za.co.pattyBakery.resources;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import za.co.pattyBakery.dao.RecipeDAO;
import za.co.pattyBakery.model.Recipe;
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

}