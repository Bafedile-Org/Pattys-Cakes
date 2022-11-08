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
            "Dark Chocolate", "Icing Sugar", "Almond Milk", "Dairy Free Milk", "White Wine Vinegar", "Dairy Free Spread", "Chocolate Chips",
            "Dried Cranberries", "Cream Of Tartar", "Emulsifier", "Unsweetened Cocoa", "Dried Yeast", "Creme Fraiche", "Pie Crust", "Cornstartch", "Kosher Salt",
            "Strawberries", "Strawberry Flavored Jell-O"};

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
            System.out.println("Cake table created");
        } catch (SQLException sql) {
            System.out.println(String.format("ERROR: cake table failed at creation time\t%s", sql.getMessage()));
        }

    }

    public void addDoughnutsRecipies() {

        Integer glzedSimpsonsIngrId[] = {45, 4, 28, 11, 1, 2, 46};
        Integer chocolateDoughnutsIngrId[] = {45, 4, 28, 11, 1, 2, 46, 32};

        try {
            for (int i = 0; i < glzedSimpsonsIngrId.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe(recp_id, ingr_id) VALUES ('%s','%s')", "4RES", glzedSimpsonsIngrId[i] + "ING")).executeUpdate();
            }
            for (int i = 0; i < glzedSimpsonsIngrId.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe(recp_id, ingr_id) VALUES ('%s','%s')", "5RES", glzedSimpsonsIngrId[i] + "ING")).executeUpdate();
            }
            for (int i = 0; i < chocolateDoughnutsIngrId.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe(recp_id, ingr_id) VALUES ('%s','%s')", "6RES", chocolateDoughnutsIngrId[i] + "ING")).executeUpdate();
            }
            System.out.println("doughnuts table created");
        } catch (SQLException sql) {
            System.out.println(String.format("ERROR: doughnuts table failed at creation time\t%s", sql.getMessage()));
        }

    }

    public void addMuffinsRecipies() {

        Integer blueberryIngrId[] = {9, 3, 10, 11, 2, 12, 13, 14};
        Integer cranberriesIngrId[] = {3, 15, 16, 10, 17, 18, 19, 20, 21, 22, 2, 13, 23, 24};
        Integer carrotIngrId[] = {4, 15, 17, 10, 18, 16, 19, 2, 3, 25, 13, 26, 27, 24};

        try {
            for (int i = 0; i < blueberryIngrId.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe(recp_id, ingr_id) VALUES ('%s','%s')", "10RES", blueberryIngrId[i] + "ING")).executeUpdate();
            }
            for (int i = 0; i < cranberriesIngrId.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe(recp_id, ingr_id) VALUES ('%s','%s')", "11RES", cranberriesIngrId[i] + "ING")).executeUpdate();
            }
            for (int i = 0; i < carrotIngrId.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe(recp_id, ingr_id) VALUES ('%s','%s')", "12RES", carrotIngrId[i] + "ING")).executeUpdate();
            }
            System.out.println("Muffins table created");
        } catch (SQLException sql) {
            System.out.println(String.format("ERROR: muffins table failed at creation time\t%s", sql.getMessage()));
        }

    }

    public void addPersonalRecipies() {

        Integer blueberryIngrId[] = {9, 3, 10, 11, 2, 12, 13, 14};
        Integer cranberriesIngrId[] = {3, 15, 16, 10, 17, 18, 19, 20, 21, 22, 2, 13, 23, 24};
        Integer carrotIngrId[] = {4, 15, 17, 10, 18, 16, 19, 2, 3, 25, 13, 26, 27, 24};

        try {
            for (int i = 0; i < blueberryIngrId.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe(recp_id, ingr_id) VALUES ('%s','%s')", "13RES", blueberryIngrId[i] + "ING")).executeUpdate();
            }
            for (int i = 0; i < cranberriesIngrId.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe(recp_id, ingr_id) VALUES ('%s','%s')", "14RES", cranberriesIngrId[i] + "ING")).executeUpdate();
            }
            for (int i = 0; i < carrotIngrId.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe(recp_id, ingr_id) VALUES ('%s','%s')", "15RES", carrotIngrId[i] + "ING")).executeUpdate();
            }

            System.out.println("Personal pies table created");
        } catch (SQLException sql) {
            System.out.println(String.format("ERROR: personal pies table failed at creation time\t%s", sql.getMessage()));
        }

    }

    public void addCookiesRecipies() {

        Integer vanilaCookiesIngrId[] = {4, 39, 23, 1, 3, 2, 17, 13, 17};
        Integer chocolateCookiesIngrId[] = {4, 39, 23, 1, 3, 2, 17, 13, 19};
        Integer plainCookiesIngrId[] = {4, 39, 23, 1, 3, 2, 17, 19};

        try {
            for (int i = 0; i < vanilaCookiesIngrId.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe(recp_id, ingr_id) VALUES ('%s','%s')", "16RES", vanilaCookiesIngrId[i] + "ING")).executeUpdate();
            }
            for (int i = 0; i < chocolateCookiesIngrId.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe(recp_id, ingr_id) VALUES ('%s','%s')", "17RES", chocolateCookiesIngrId[i] + "ING")).executeUpdate();
            }
            for (int i = 0; i < plainCookiesIngrId.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe(recp_id, ingr_id) VALUES ('%s','%s')", "18RES", plainCookiesIngrId[i] + "ING")).executeUpdate();
            }
            System.out.println("Cookies table created");
        } catch (SQLException sql) {
            System.out.println(String.format("ERROR: cookies table failed at creation time\t%s", sql.getMessage()));
        }

    }

    public void addCupcakesRecipies() {

        Integer coffeeWalnutIngrId[] = {1, 2, 3, 4, 5, 6, 7, 8};
        Integer glutenFreeChocolateCupcakesId[] = {1, 28, 2, 29, 30, 31, 13, 35, 32, 7};
        Integer veganVanilaCupcakesIngrId[] = {4, 28, 35, 13, 25, 37, 38, 34, 8};

        try {
            for (int i = 0; i < coffeeWalnutIngrId.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe(recp_id, ingr_id) VALUES ('%s','%s')", "7RES", coffeeWalnutIngrId[i] + "ING")).executeUpdate();
            }
            for (int i = 0; i < glutenFreeChocolateCupcakesId.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe(recp_id, ingr_id) VALUES ('%s','%s')", "8RES", glutenFreeChocolateCupcakesId[i] + "ING")).executeUpdate();
            }
            for (int i = 0; i < veganVanilaCupcakesIngrId.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe(recp_id, ingr_id) VALUES ('%s','%s')", "9RES", veganVanilaCupcakesIngrId[i] + "ING")).executeUpdate();
            }

        } catch (SQLException sql) {
            System.out.println("Cupcakes recipe failed to added" + sql.getMessage());
        }
        System.out.println("Cupcakes recipe added");
    }

}
