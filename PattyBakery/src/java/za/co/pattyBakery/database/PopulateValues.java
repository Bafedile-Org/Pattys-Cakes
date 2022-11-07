package za.co.pattyBakery.database;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import za.co.pattybakery.dao.impl.IngredientsDAOImpl;
import za.co.pattybakery.dao.impl.NutrientsDAOImpl;

/**
 *
 * @author Dimakatso Sebatane
 */
public class PopulateValues {

    Connection con;

    public PopulateValues(Connection con) {
        this.con = con;
    }

    public void populateNutr() {
        String[] arrNutr = {"Calories", "Fat", "Carbohydrates", "Protein", "Saturated Fat", "Trans Fat", "Cholesterol", "Fiber", "Sugar", "Sodium"};
        List<String> nutrients = new ArrayList<>(Arrays.asList(arrNutr));
        List<String> nutrientsId = getNutrIdList(nutrients);
        PreparedStatement stat;
        for (int i = 0; i < nutrients.size(); i++) {
            new NutrientsDAOImpl(con).addNutrient(nutrientsId.get(i), nutrients.get(i));
        }

        System.out.println("Nutrients Added");
    }

    public void populateIngr() {
        String[] arrIngr = {"Unsalted Butter", "Eggs", "Brown Sugar", "Self Raising Flour", "Instant Coffee Granules", "Walnuts", "Icing Sugar", "Sprinkles", "Quick Muffin Mix",
            "Ground Cinnamon", "Milk", "Apple Sauce", "Vanila Extract", "Blue Berries", "Baking Powder", "Ground Nutmeg", "Baking Soda", "Ground Ginger", "Salt", "Orange Zest", "Shortening", "Orange Juice", "Cranberries",
            "Pecans", "Vegetable Oil", "Carrot", "Raisins", "Caster Sugar", "Gluten Free Self Raising Flour", "Cocoa Powder", "Custard Powder",
            "Dark Chocolate", "Icing Sugar", "Almond Milke", "Dairy Free Milk", "White Wine Vinegar", "Dairy Free Spread", "Chocolate Chips",
            "Dried Cranberries", "Cream Of Tartar", "Emulsifier", "Unsweetened Cocoa", "Dried Yeast", "Creme Fraiche"};
        List<String> ingredients = new ArrayList<>(Arrays.asList(arrIngr));
        List<String> ingredientId = getIngredientIdList(ingredients);
        SecureRandom random = new SecureRandom();
        PreparedStatement stat;

        for (int i = 0; i < ingredients.size(); i++) {
            new IngredientsDAOImpl(con).addIngridient(ingredientId.get(i), ingredients.get(i), random.nextInt(20));
        }

        System.out.println("Ingredients Added");
    }

    public List<String> getIngredientIdList(List<String> IngredientList) {
        List<String> IngredientIdList = new ArrayList<>();
        for (int i = 0; i < IngredientList.size(); i++) {
            IngredientIdList.add((i + 1) + "ING");
        }

        return IngredientIdList;
    }

    public List<String> getNutrIdList(List<String> nutrientsList) {
        List<String> nutrientIdList = new ArrayList<>();
        for (int i = 0; i < nutrientsList.size(); i++) {
            nutrientIdList.add((i + 1) + "NT");
        }

        return nutrientIdList;
    }

    public List<String> getRecipeIdList() {
        List<String> recipeIdList = new ArrayList<>();
        for (int i = 0; i < 18; i++) {
            recipeIdList.add((i + 1) + "RES");
        }

        return recipeIdList;
    }

    public void addCakeRecipies() {

        List<String> recipeIdList = getRecipeIdList();
//        List<String> ingredientsIdList = new IngredientsDAOImpl().getAllIngredientsId();
        Integer caramelCakeIngrId[] = {3, 1, 2, 4, 15, 19, 36, 13};
        Integer marigueCakeIngrId[] = {3, 2, 4, 15, 42, 41};
        Integer chocolateCakeIngrId[] = {3, 1, 2, 4, 43, 19};

        try {
            for (int i = 0; i < caramelCakeIngrId.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe(recp_id, ingr_id) VALUES ('%s','%s')", "1RES", caramelCakeIngrId[i] + "ING")).executeUpdate();
            }
            for (int i = 0; i < marigueCakeIngrId.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe(recp_id, ingr_id) VALUES ('%s','%s')", "2RES", marigueCakeIngrId[i] + "ING")).executeUpdate();
            }
            for (int i = 0; i < chocolateCakeIngrId.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe(recp_id, ingr_id) VALUES ('%s','%s')", "3RES", chocolateCakeIngrId[i] + "ING")).executeUpdate();
            }

        } catch (SQLException sql) {

        }

    }

    public void addCookiesRecipe() {
        // List<String> ingredientIdList = new IngredientsDAOImpl().getAllIngredient();
        List<String> recipeIdList = getRecipeIdList();
        Integer[] chocolateCookiesIdList = {4, 39, 23, 1, 3, 2, 17, 13, 19};
        Integer[] plainCoffeeCookiesIdList = {4, 39, 23, 1, 3, 2, 17, 1, 19};
        Integer[] vanilaCookiesIdList = {4, 39, 23, 1, 3, 2, 17, 13, 19};

        try {
            for (int i = 0; i < chocolateCookiesIdList.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe(recp_id, ingr_id) VALUES ('%s','%s')", "7RES", chocolateCookiesIdList[i] + "ING")).executeUpdate();
            }
            for (int i = 0; i < plainCoffeeCookiesIdList.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe(recp_id, ingr_id) VALUES ('%s','%s')", "8RES", plainCoffeeCookiesIdList[i] + "ING")).executeUpdate();
            }
            for (int i = 0; i < vanilaCookiesIdList.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe(recp_id, ingr_id) VALUES ('%s','%s')", "9RES", vanilaCookiesIdList[i] + "ING")).executeUpdate();
            }

        } catch (SQLException sql) {
            System.out.println(sql.getMessage());
        }

    }

    public void addCupcakesRecipe() {
        //List<String> ingredientIdList = new IngredientsDAOImpl().getAllIngredient();
        List<String> recipeIdList = getRecipeIdList();
        Integer[] coffeeWalnutCupcakeIdList = {1, 2, 3, 4, 5, 6, 7, 8};
        Integer[] gluttenFreeChocolateIdList = {1, 28, 2, 29, 30, 31, 13, 35, 32, 7};
        Integer[] veganVanilaCupcakeIdList = {4, 28, 35, 13, 25, 37, 38, 34, 8};

        try {
            for (int i = 0; i < coffeeWalnutCupcakeIdList.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe(recp_id, ingr_id) VALUES ('%s','%s')", "7RES", coffeeWalnutCupcakeIdList + "ING")).executeUpdate();
            }
            for (int i = 0; i < gluttenFreeChocolateIdList.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe(recp_id, ingr_id) VALUES ('%s','%s')", "8RES", gluttenFreeChocolateIdList[i] + "ING")).executeUpdate();
            }
            for (int i = 0; i < veganVanilaCupcakeIdList.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe(recp_id, ingr_id) VALUES ('%s','%s')", "9RES", veganVanilaCupcakeIdList[i] + "ING")).executeUpdate();
            }

        } catch (SQLException sql) {
            System.out.println(sql.getMessage());
        }

    }
}
