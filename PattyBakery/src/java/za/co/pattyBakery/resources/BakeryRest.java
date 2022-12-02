package za.co.pattyBakery.resources;

import java.math.BigInteger;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.List;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import za.co.pattyBakery.Employee;
import za.co.pattyBakery.Product;
import za.co.pattyBakery.dao.EmployeeDAO;
import za.co.pattyBakery.dao.IngredientsDAO;
import za.co.pattyBakery.dao.NutrientsDAO;
import za.co.pattyBakery.dao.OrderDAO;
import za.co.pattyBakery.dao.ProductDAO;
import za.co.pattyBakery.dao.RecipeDAO;
import za.co.pattyBakery.dao.StockDAO;
import za.co.pattyBakery.dao.impl.IngredientsDAOImpl;
import za.co.pattyBakery.dao.impl.OrderDAOImpl;
import za.co.pattyBakery.dao.impl.ProductNutrientDAOImpl;
import za.co.pattyBakery.dao.impl.RecipeDAOImpl;
import za.co.pattyBakery.exception.ProductException;
import za.co.pattyBakery.model.EmployeeImpl;
import za.co.pattyBakery.model.ProductImpl;
import za.co.pattyBakery.model.Recipe;
import za.co.pattyBakery.service.impl.CategoryServImpl;
import za.co.pattyBakery.service.impl.EmployeeServImpl;
import za.co.pattyBakery.service.impl.NutrientsServImpl;
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
    public Response addStock(@FormParam("quantity") Integer quantity,
            @FormParam("which") String which, @FormParam("prodName") String prodName,
            @FormParam("image") String image,
            @FormParam("price") Double price,
            @FormParam("cat") String cat, @FormParam("recipe") String recipe, @FormParam("nutrients") List<String> nutrients) {
        StockDAO stockServImpl = new StockServImpl();
        ProductDAO productServImpl = new ProductServImpl();
        RecipeDAO recipeServImpl = new RecipeDAOImpl();
        NutrientsServImpl nutrientsServImpl = new NutrientsServImpl();
        java.net.URI location = null;
        try {
            location = new java.net.URI("http://localhost:8080/bakery/admin/stock");
            String productId = productServImpl.getProductIdByName(prodName);
            List< String> productIds = productServImpl.getAllProductsIds();
            if (prodName == null) {
                System.out.println("Please enter product Id");
                return Response.temporaryRedirect(location).build();
            } else {
                Boolean isValid = false;
                Product product;
                switch (which) {
                    case "add":

                        String prod_id = "";
                        String recipeId = "";
                        if (productId == null || productId.length() == 0) {
                            loop:
                            while (!isValid) {
                                Integer randomNumber = new SecureRandom().nextInt(150);
                                while (randomNumber == 0) {
                                    randomNumber = new SecureRandom().nextInt(150);
                                }
                                prod_id = randomNumber + "PRO";
                                if (productIds.contains(prod_id)) {
                                    break loop;
                                }
                                isValid = true;
                            }
                            productId = prod_id;

                        }

                        recipeId = recipeServImpl.getRecipeIdByDescription(recipe);
                        if (nutrients != null) {
                            for (String nutrient : nutrients) {
                                String nutrientId = nutrientsServImpl.getNutrientIdByName(nutrient);
                                nutrientsServImpl.addProductNutrient(productId, nutrientId, Double.valueOf(String.format("%.2f", new SecureRandom().nextDouble())));
                            }
                        }
                        product = new ProductImpl(productId, prodName, price, new CategoryServImpl().getCategoryIdByName(cat),
                                "1NT", recipeId, String.format("assets/%s/%s", cat.toLowerCase(), image));
                        productServImpl.addProduct(product);
                        stockServImpl.addStockById(productId, quantity);
                        break;
                    case "update":
                        if (quantity != null) {
                            stockServImpl.updateStockQuantity(productId, quantity);
                        }
                        if (price != null) {
                            productServImpl.updateProductPrice(productId, price);
                        }

                        if (image != null) {
                            productServImpl.updateProductImage(productId, String.format("assets/%s/%s", cat.toLowerCase(), image));
                        }

                        break;
                    default:
                        stockServImpl.removeProductFromStock(productId);
                        new ProductNutrientDAOImpl().removeProduct(productId);
                        productServImpl.removeProduct(productId);
                        break;
                }
                System.out.println("Successfully added to product " + productServImpl.getProductIdByName(prodName) + " " + quantity + " items");
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
    @Path("/addRecipe")
    public Response addRecipe(@FormParam("recipe") String recipe, @FormParam("ingredients") List<String> ingredients, @FormParam("which") String which) {
        java.net.URI location = null;
        try {

            location = new java.net.URI("http://localhost:8080/bakery/admin/recipe");
            RecipeDAOImpl recipeServImpl = new RecipeDAOImpl();
            String recipeId = recipeServImpl.getRecipeIdByDescription(recipe);
            if (which.equalsIgnoreCase("add")) {
                List<String> recipeIds = recipeServImpl.getAllRecipieIds();
                String recp_id = "";
                Boolean isValid = false;
                if (recipeId == null || recipeId.length() == 0) {
                    loop:
                    while (!isValid) {
                        Integer randomNumber = new SecureRandom().nextInt(150);
                        while (randomNumber == 0) {
                            randomNumber = new SecureRandom().nextInt(150);
                        }
                        recp_id = randomNumber + "RES";
                        if (recipeIds.contains(recp_id)) {
                            break loop;
                        }
                        isValid = true;
                    }
                }
                recipeId = recp_id;
                recipeServImpl.addRecipe(new Recipe(recipeId, ingredients, recipe));
            } else {
                recipeServImpl.updateRecipeIngredients(recipeId, ingredients);
            }

        } catch (URISyntaxException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return Response.temporaryRedirect(location).build();
    }

    @POST
    @Path("/addIngredient")
    public Response addIngredient(@FormParam("ingr") String ingredient, @FormParam("quantity") Integer quantity, @FormParam("which") String which) {
        java.net.URI location = null;
        IngredientsDAO ingredientsDAOImpl = new IngredientsDAOImpl();
        try {
            location = new java.net.URI("http://localhost:8080/bakery/admin/ingredients");
            Boolean isValid = false;
            if (which.equalsIgnoreCase("add")) {
                String ingredientId = ingredientsDAOImpl.getIngredientByIdName(ingredient);
                List<String> ingredientIds = ingredientsDAOImpl.getAllIngredientsId();
                String ingr_id = "";
                if (ingredientId == null || ingredientId.length() == 0) {
                    loop:
                    while (!isValid) {
                        Integer randomNumber = new SecureRandom().nextInt(150);
                        while (randomNumber == 0) {
                            randomNumber = new SecureRandom().nextInt(150);
                        }
                        ingr_id = randomNumber + "ING";
                        if (ingredientIds.contains(ingr_id)) {
                            break loop;
                        }
                        isValid = true;
                    }
                }
                ingredientId = ingr_id;
                ingredientsDAOImpl.addIngridient(ingredientId, ingredient, quantity);

            } else if (which.equalsIgnoreCase("remove")) {
                ingredientsDAOImpl.removeIngredient(ingredientsDAOImpl.getIngredientByIdName(ingredient));
            } else {
                ingredientsDAOImpl.updateIngredientQuantity(ingredientsDAOImpl.getIngredientByIdName(ingredient), quantity);
            }
        } catch (URISyntaxException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return Response.temporaryRedirect(location).build();
    }

    @POST
    @Path("/addNutrient")
    public Response addNutrient(@FormParam("nutrient") String nutrient, @FormParam("which") String which) {
        java.net.URI location = null;
        try {
            location = new java.net.URI("http://localhost:8080/bakery/admin/nutrients");
            NutrientsDAO nutrientServImpl = new NutrientsServImpl();
            String nutrientId = nutrientServImpl.getNutrientIdByName(nutrient);
            if (which.equalsIgnoreCase("add")) {
                List<String> nutrientIds = nutrientServImpl.getAllNutrientsIds();
                String nutr_id = "";
                Boolean isValid = false;
                if (nutrientId == null || nutrientId.length() == 0) {
                    loop:
                    while (!isValid) {
                        Integer randomNumber = new SecureRandom().nextInt(150);
                        while (randomNumber == 0) {
                            randomNumber = new SecureRandom().nextInt(150);
                        }
                        nutr_id = randomNumber + "NT";
                        if (nutrientIds.contains(nutr_id)) {
                            break loop;
                        }
                        isValid = true;
                    }
                }
                nutrientId = nutr_id;
                nutrientServImpl.addNutrient(nutrientId, nutrient);
            } else {

                nutrientServImpl.removeNutrient(nutrientServImpl.getNutrientIdByName(nutrient));
            }
        } catch (URISyntaxException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return Response.temporaryRedirect(location).build();
    }

    @POST
    @Path("/updateOrder")
    public Response updateOrder(@FormParam("order_id") String orderId,
            @FormParam("status") String status,
            @FormParam("date") String date) {
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
