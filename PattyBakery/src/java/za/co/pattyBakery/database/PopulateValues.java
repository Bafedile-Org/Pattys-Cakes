package za.co.pattyBakery.database;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import za.co.pattyBakery.Product;
import za.co.pattyBakery.dao.ProductDAO;
import za.co.pattyBakery.dao.impl.CategoryDAOImpl;
import za.co.pattyBakery.dao.impl.IngredientsDAOImpl;
import za.co.pattyBakery.dao.impl.NutrientsDAOImpl;
import za.co.pattyBakery.dao.impl.ProductDAOImpl;
import za.co.pattyBakery.dao.impl.ProductNutrientDAOImpl;
import za.co.pattyBakery.dao.impl.StockDAOImpl;
import za.co.pattyBakery.exception.ProductException;
import za.co.pattyBakery.model.ProductImpl;

/**
 *
 * @author Bridget Bapela
 */
public class PopulateValues {

    Connection con;

    public PopulateValues(Connection con) {
        this.con = con;
    }

    public void addAll() {
        // populate the table 
        populateCategoryTable();
        populateNutr();
        populateIngr();

        // add recipies
        addCakeRecipies();
        addCakeRecipiesIngredients();
        addCookiesRecipies();
        addCookiesRecipiesIngredients();
        addCupcakesRecipies();
        addCupcakesRecipiesIngredients();
        addDoughnutRecipies();
        addDoughnutsRecipiesIngredients();
        addMuffinsRecipies();
        addMuffinsRecipiesIngredients();
        addPersonalPiesRecipies();
        addPersonalRecipiesIngredients();

        // add products
        addCakesProduct();
        addDoughnutsProduct();
        addMuffinsProduct();
        addCookiesProduct();
        addPersonalPiesProduct();
        addCupCakesProduct();

        //add product/nutrient
        addCakeProductNutrient();
        addCookiesProductNutrient();
        addCupcakesProductNutrient();
        addDoughnutsProductNutrient();
        addMuffinsProductNutrient();
        addPersonalPieProductNutrient();

        // add stock
        addStock();
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

    public void populateCategoryTable() {
        String[] arrCategory = {"Cookies", "Cakes", "Doughnuts", "Cupcakes", "Muffins", "Personal Pies"};
        List<String> category = new ArrayList<>(Arrays.asList(arrCategory));
        List<Integer> categoryId = getCategoryIdList(category);
        PreparedStatement stat;
        for (int i = 0; i < category.size(); i++) {
            new CategoryDAOImpl(con).addCategory(categoryId.get(i), category.get(i));
        }

        System.out.println("Categories Added");
    }
//    public void populateEmployeeTable() {
//        List<Integer> categoryId = getCategoryIdList(category);
//        PreparedStatement stat;
//        for (int i = 0; i < category.size(); i++) {
//           new CategoryDAOImpl(con).addCategory(categoryId.get(i), category.get(i));
//            new EmployeeDAOImpl(con).addEmployee(employee);
//        }
//
//        System.out.println("Categories Added");
//    }

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

    public List<Integer> getCategoryIdList(List<String> categoryList) {
        List<Integer> categoryIdList = new ArrayList<>();
        for (int i = 0; i < categoryList.size(); i++) {
            categoryIdList.add(i + 1);
        }

        return categoryIdList;
    }

    public List<String> getAllNutriIdList(List<String> IngredientList) {
        List<String> IngredientIdList = new ArrayList<>();
        for (int i = 0; i < IngredientList.size(); i++) {
            IngredientIdList.add((i + 1) + "ING");
        }

        return IngredientIdList;
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

    //---------------------------------------------------------Recipies
    public void addCakeRecipies() {

        String[] description = {"Caramel Cake Recipe", "Marigue Cake Recipe", "Chocolate Cake Recipe"};
        String[] respId = {"1RES", "2RES", "3RES"};
        try {

            for (int i = 0; i < description.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe(recp_id,descriptions) VALUES ('%s','%s')", respId[i], description[i])).executeUpdate();
            }
            System.out.println("Cake recipe added to table");
        } catch (SQLException sql) {
            System.out.println(String.format("ERROR: cake table failed to create\t%s", sql.getMessage()));
        }
    }

    public void addDoughnutRecipies() {

        String[] description = {"glazed Simpson Doughnuts Recipe", "glazed Simpson Love Doughnuts Recipe", "Chocolate Cream Doughnuts Recipe"};
        String[] respId = {"4RES", "5RES", "6RES"};
        try {

            for (int i = 0; i < description.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe(recp_id,descriptions) VALUES ('%s','%s')", respId[i], description[i])).executeUpdate();
            }
            System.out.println("Doughnuts recipe added to table");
        } catch (SQLException sql) {
            System.out.println(String.format("ERROR: doughnuts table failed to create\t%s", sql.getMessage()));
        }
    }

    public void addCookiesRecipies() {

        String[] description = {"Vanilla Cookies Recipe", "Chocolate Cookies Recipe", "Plain Coffee Cookies Recipe"};
        String[] respId = {"16RES", "18RES", "17RES"};
        try {

            for (int i = 0; i < description.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe(recp_id,descriptions) VALUES ('%s','%s')", respId[i], description[i])).executeUpdate();
                System.out.println("Cookies recipe added to table");
            }
        } catch (SQLException sql) {
            System.out.println(String.format("ERROR: cookies recipe failed to create\t%s", sql.getMessage()));
        }
    }

    public void addCupcakesRecipies() {

        String[] description = {"Coffee and Walnut Cupcakes Recipe", "Gluten Free Chocolate Cupcakes Recipe", "Vegan Vanilla Cupcakes Recipe"};
        String[] respId = {"7RES", "8RES", "9RES"};
        try {

            for (int i = 0; i < description.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe(recp_id,descriptions) VALUES ('%s','%s')", respId[i], description[i])).executeUpdate();
            }
            System.out.println("Cupcakes recipe added to table");
        } catch (SQLException sql) {
            System.out.println(String.format("ERROR: cupcakes recipe failed to create\t%s", sql.getMessage()));
        }
    }

    public void addMuffinsRecipies() {

        String[] description = {"Blue Berries Muffins Recipe", "Carot Muffins Recipe", "Cranberries Muffins Recipe"};
        String[] respId = {"10RES", "11RES", "12RES"};
        try {

            for (int i = 0; i < description.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe(recp_id,descriptions) VALUES ('%s','%s')", respId[i], description[i])).executeUpdate();
            }
            System.out.println("Muffins recipe added to table");
        } catch (SQLException sql) {
            System.out.println(String.format("ERROR: muffins recipe failed to create\t%s", sql.getMessage()));
        }
    }

    public void addPersonalPiesRecipies() {

        String[] description = {"Blue Berries Pie Recipe", "Strawberry Pie Recipe", "Apple Pie Recipe"};
        String[] respId = {"13RES", "14RES", "15RES"};
        try {

            for (int i = 0; i < description.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe(recp_id,descriptions) VALUES ('%s','%s')", respId[i], description[i])).executeUpdate();
            }
            System.out.println("Personal pie recipe added to table");
        } catch (SQLException sql) {
            System.out.println(String.format("ERROR:personal pie recipe failed to create\t%s", sql.getMessage()));
        }
    }

    //---------------------------------------------NUTRIENTS
    public void addCakeProductNutrient() {
        String productIds[] = {"1PRO", "2PRO", "3PRO"};
        Integer[] caramelNutrientIds = {1, 2, 3, 4};
        Integer[] marigueNutrientIds = {1, 3, 2, 4};
        Integer[] chocolateNutrientIds = {1, 2, 3, 4};
        Double[] caramelGrams = {1019.0, 43.0, 155.0, 9.0};
        Double[] marigueGrams = {79.0, 19.0, 1.0, 35.0};
        Double[] chocolateGrams = {79.0, 37.0, 58.0, 6.0};
        for (int i = 0; i < caramelNutrientIds.length; i++) {
            new ProductNutrientDAOImpl(con).addProductNutrient(productIds[0], caramelNutrientIds[i] + "NT", caramelGrams[i]);
        }
        for (int i = 0; i < marigueNutrientIds.length; i++) {
            new ProductNutrientDAOImpl(con).addProductNutrient(productIds[1], marigueNutrientIds[i] + "NT", marigueGrams[i]);

        }
        for (int i = 0; i < chocolateNutrientIds.length; i++) {
            new ProductNutrientDAOImpl(con).addProductNutrient(productIds[2], chocolateNutrientIds[i] + "NT", chocolateGrams[i]);
        }
        System.out.println("cake product/ingredients created");
    }

    public void addCookiesProductNutrient() {
        String productIds[] = {"4PRO", "5PRO", "6PRO"};
        Integer[] vanillaNutrientIds = {10, 4};
        Integer[] chocolateNutrientIds = {10, 4};
        Integer[] plainCoffeeNutrientIds = {10, 4};
        Double[] vanillaGrams = {446.0, 2.9};
        Double[] chocolateGrams = {446.0, 2.9};
        Double[] plainCoffeeGrams = {446.0, 2.9};
        for (int i = 0; i < vanillaNutrientIds.length; i++) {
            new ProductNutrientDAOImpl(con).addProductNutrient(productIds[0], vanillaNutrientIds[i] + "NT", vanillaGrams[i]);
        }
        for (int i = 0; i < chocolateNutrientIds.length; i++) {
            new ProductNutrientDAOImpl(con).addProductNutrient(productIds[1], chocolateNutrientIds[i] + "NT", chocolateGrams[i]);

        }
        for (int i = 0; i < plainCoffeeNutrientIds.length; i++) {
            new ProductNutrientDAOImpl(con).addProductNutrient(productIds[2], plainCoffeeNutrientIds[i] + "NT", plainCoffeeGrams[i]);
        }
        System.out.println("cookies product/ingredients created");
    }

    public void addCupcakesProductNutrient() {
        String productIds[] = {"7PRO", "8PRO", "9PRO"};
        Integer[] coffeeWalnutNutrientIds = {1, 2, 5, 6, 7, 3, 8, 9, 10, 4};
        Integer[] glutFreeChocolateNutrientIds = {1, 2, 5, 6, 7, 3, 8, 9, 10, 4};
        Integer[] veganVanillaNutrientIds = {1, 2, 5, 6, 7, 3, 8, 9, 10};
        Double[] coffeeWalnutGrams = {502.0, 30.0, 15.0, 1.0, 105.0, 56.0, 1.0, 43.0, 26.0, 5.0};
        Double[] glutFreeChocolateGrams = {502.0, 30.0, 15.0, 1.0, 105.0, 56.0, 1.0, 43.0, 26.0, 5.0};
        Double[] veganVanillaGrams = {319.0, 7.0, 0.8, 2.1, 62.0, 0.5, 48.0, 10.0, 2.6};
        for (int i = 0; i < coffeeWalnutNutrientIds.length; i++) {
            new ProductNutrientDAOImpl(con).addProductNutrient(productIds[0], coffeeWalnutNutrientIds[i] + "NT", coffeeWalnutGrams[i]);
        }
        for (int i = 0; i < glutFreeChocolateNutrientIds.length; i++) {
            new ProductNutrientDAOImpl(con).addProductNutrient(productIds[1], glutFreeChocolateNutrientIds[i] + "NT", glutFreeChocolateGrams[i]);

        }
        for (int i = 0; i < veganVanillaNutrientIds.length; i++) {
            new ProductNutrientDAOImpl(con).addProductNutrient(productIds[2], veganVanillaNutrientIds[i] + "NT", veganVanillaGrams[i]);
        }
        System.out.println("cupcakes product/ingredients created");
    }

    public void addMuffinsProductNutrient() {
        String productIds[] = {"13PRO", "14PRO", "15PRO"};
        Integer[] blueBerriesNutrientIds = {1, 2, 5, 6, 7, 3, 8, 9};
        Integer[] carrotNutrientIds = {1, 2, 5, 6, 7, 3, 8, 9, 10};
        Integer[] cranberriesNutrientIds = {1, 2, 5, 6, 7, 3, 8, 9};
        Double[] blueBerriesGrams = {302.0, 4.3, 1.6, 0.2, 29.0, 60.0, 1.8, 34.0};
        Double[] carrotGrams = {170.0, 7.0, 1.1, 33.0, 25.0, 3.0, 8.0, 183.0, 4.8};
        Double[] cranberriesGrams = {226.0, 13.0, 2.2, 0.8, 18.0, 26.0, 1.8, 13.0, 138.0};
        for (int i = 0; i < blueBerriesNutrientIds.length; i++) {
            new ProductNutrientDAOImpl(con).addProductNutrient(productIds[0], blueBerriesNutrientIds[i] + "NT", blueBerriesGrams[i]);
        }
        for (int i = 0; i < carrotNutrientIds.length; i++) {
            new ProductNutrientDAOImpl(con).addProductNutrient(productIds[1], carrotNutrientIds[i] + "NT", carrotGrams[i]);

        }
        for (int i = 0; i < cranberriesNutrientIds.length; i++) {
            new ProductNutrientDAOImpl(con).addProductNutrient(productIds[2], cranberriesNutrientIds[i] + "NT", cranberriesGrams[i]);
        }
        System.out.println("Muffins product/ingredients created");
    }

    public void addPersonalPieProductNutrient() {
        String productIds[] = {"10PRO", "11PRO", "12PRO"};
        Integer[] blueberryNutrientIds = {3, 4};
        Integer[] appleNutrientIds = {3, 4};
        Integer[] strawberryNutrientIds = {3, 4};
        Double[] blueberryGrams = {4.0, 0.2};
        Double[] appleGrams = {4.0, 0.1};
        Double[] strawberryGrams = {4.0, 0.1};
        for (int i = 0; i < blueberryNutrientIds.length; i++) {
            new ProductNutrientDAOImpl(con).addProductNutrient(productIds[0], blueberryNutrientIds[i] + "NT", blueberryGrams[i]);
        }
        for (int i = 0; i < appleNutrientIds.length; i++) {
            new ProductNutrientDAOImpl(con).addProductNutrient(productIds[1], appleNutrientIds[i] + "NT", appleGrams[i]);

        }
        for (int i = 0; i < strawberryNutrientIds.length; i++) {
            new ProductNutrientDAOImpl(con).addProductNutrient(productIds[2], strawberryNutrientIds[i] + "NT", strawberryGrams[i]);
        }
        System.out.println("personal pie product/ingredients created");
    }

    public void addDoughnutsProductNutrient() {
        String productIds[] = {"16PRO", "17PRO", "18PRO"};
        Integer[] glazedSimpsonNutrientIds = {2, 4};
        Integer[] glazedSimpsonLoveNutrientIds = {2, 4};
        Integer[] chocolateNutrientIds = {2, 4};
        Double[] glazedSimpsonGrams = {10.9, 2.1};
        Double[] glazedSimpsonLoveGrams = {9.2, 1.7};
        Double[] chocolateGrams = {10.0, 2.0};
        for (int i = 0; i < glazedSimpsonNutrientIds.length; i++) {
            new ProductNutrientDAOImpl(con).addProductNutrient(productIds[0], glazedSimpsonNutrientIds[i] + "NT", glazedSimpsonGrams[i]);
        }
        for (int i = 0; i < glazedSimpsonLoveNutrientIds.length; i++) {
            new ProductNutrientDAOImpl(con).addProductNutrient(productIds[1], glazedSimpsonLoveNutrientIds[i] + "NT", glazedSimpsonLoveGrams[i]);

        }
        for (int i = 0; i < chocolateNutrientIds.length; i++) {
            new ProductNutrientDAOImpl(con).addProductNutrient(productIds[2], chocolateNutrientIds[i] + "NT", chocolateGrams[i]);
        }
        System.out.println("doughnuts product/ingredients created");
    }

//    public void addVanilaNutrients() {
//        Integer cat = 2;
//        Double[] prices = {256.50, 449.50, 159.50};
//        String[] nutrientsIds = {"1NT"};
//        String[] recipeIds = {"1RES", "2RES", "3RES"};
//        try {
//            Product caramelCake = new ProductImpl("1PRO", "Caramel Cake", prices[0], cat, nutrientsIds[0], recipeIds[0]);
//            Product MargueCake = new ProductImpl("2PRO", "Margue Cake", prices[1], cat, nutrientsIds[0], recipeIds[1]);
//            Product chocolateCake = new ProductImpl("3PRO", "Chocolate Cake", prices[2], cat, nutrientsIds[0], recipeIds[2]);
//
//            ProductDAO productDao = new ProductDAOImpl(con);
//            productDao.addProductByIds(MargueCake);
//            productDao.addProductByIds(caramelCake);
//            productDao.addProductByIds(chocolateCake);
//        } catch (ProductException sql) {
//            System.out.println("product insert failed" + sql.getMessage());
//        }
//        System.out.println("product added");
//    }
//--------------------------------------------INGREDIENTS
    public void addCakeRecipiesIngredients() {
        Integer caramelCakeIngrId[] = {2, 0, 1, 3, 14, 18, 10, 12};
        Integer marigueCakeIngrId[] = {1, 39, 2, 3, 14, 40};
        Integer chocolateCakeIngrId[] = {2, 0, 1, 41, 18};
        Integer[] grams = {};
        try {
            for (int i = 0; i < caramelCakeIngrId.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe_ingredient(recp_id,ingr_id) VALUES ('%s','%s')", "1RES", caramelCakeIngrId[i] + 1 + "ING")).executeUpdate();
            }
            for (int i = 0; i < marigueCakeIngrId.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe_ingredient(recp_id,ingr_id) VALUES ('%s','%s')", "2RES", marigueCakeIngrId[i] + 1 + "ING")).executeUpdate();
            }
            for (int i = 0; i < chocolateCakeIngrId.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe_ingredient(recp_id,ingr_id) VALUES ('%s','%s')", "3RES", chocolateCakeIngrId[i] + 1 + "ING")).executeUpdate();
            }
            System.out.println("cake recipe/ingredient created");
        } catch (SQLException sql) {
            System.out.println(String.format("ERROR: cake recipe/ingredient failed at creation time\t%s", sql.getMessage()));
        }

    }

    public void addDoughnutsRecipiesIngredients() {

        Integer glazedSimpsonsIngrId[] = {42, 3, 27, 10, 0, 1};
        Integer glazedSimpsonsHeartIngrId[] = {42, 3, 27, 10, 0, 1, 43};
        Integer chocolateDoughnutsIngrId[] = {42, 3, 2, 0, 1};

        try {
            for (int i = 0; i < glazedSimpsonsIngrId.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe_ingredient(recp_id, ingr_id) VALUES ('%s','%s')", "4RES", glazedSimpsonsIngrId[i] + 1 + "ING")).executeUpdate();
            }
            for (int i = 0; i < glazedSimpsonsHeartIngrId.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe_ingredient(recp_id,ingr_id) VALUES ('%s','%s')", "5RES", glazedSimpsonsHeartIngrId[i] + 1 + "ING")).executeUpdate();
            }
            for (int i = 0; i < chocolateDoughnutsIngrId.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe_ingredient(recp_id,ingr_id) VALUES ('%s','%s')", "6RES", chocolateDoughnutsIngrId[i] + 1 + "ING")).executeUpdate();
            }
            System.out.println("doughnuts table created");
        } catch (SQLException sql) {
            System.out.println(String.format("ERROR: doughnuts table failed at creation time\t%s", sql.getMessage()));
        }

    }

    public void addMuffinsRecipiesIngredients() {

        Integer blueberryIngrId[] = {8, 2, 9, 10, 1, 11, 12, 13, 22, 23};
        Integer cranberriesIngrId[] = {2, 9, 1, 12, 16, 16, 19, 20, 22, 23};
        Integer carrotIngrId[] = {2, 9, 1, 12, 17, 15, 25, 26, 23};

        try {
            for (int i = 0; i < blueberryIngrId.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe_ingredient(recp_id,ingr_id) VALUES ('%s','%s')", "10RES", blueberryIngrId[i] + 1 + "ING")).executeUpdate();
            }
            for (int i = 0; i < cranberriesIngrId.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe_ingredient(recp_id,ingr_id) VALUES ('%s','%s')", "11RES", cranberriesIngrId[i] + 1 + "ING")).executeUpdate();
            }
            for (int i = 0; i < carrotIngrId.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe_ingredient(recp_id,ingr_id) VALUES ('%s','%s')", "12RES", carrotIngrId[i] + 1 + "ING")).executeUpdate();
            }
            System.out.println("Muffins table created");
        } catch (SQLException sql) {
            System.out.println(String.format("ERROR: muffins table failed at creation time\t%s", sql.getMessage()));
        }

    }

    public void addPersonalRecipiesIngredients() {

        Integer blueberryIngrId[] = {13, 44, 2, 45};
        Integer appleIngrId[] = {2, 1, 0, 3, 46, 9};
        Integer strawberryIngrId[] = {2, 45, 47, 48};

        try {
            for (int i = 0; i < blueberryIngrId.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe_ingredient(recp_id,ingr_id) VALUES ('%s','%s')", "13RES", blueberryIngrId[i] + 1 + "ING")).executeUpdate();
            }
            for (int i = 0; i < appleIngrId.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe_ingredient(recp_id,ingr_id) VALUES ('%s','%s')", "14RES", appleIngrId[i] + 1 + "ING")).executeUpdate();
            }
            for (int i = 0; i < strawberryIngrId.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe_ingredient(recp_id,ingr_id) VALUES ('%s','%s')", "15RES", strawberryIngrId[i] + 1 + "ING")).executeUpdate();
            }

            System.out.println("Personal pies table created");
        } catch (SQLException sql) {
            System.out.println(String.format("ERROR: personal pies table failed at creation time\t%s", sql.getMessage()));
        }

    }

    public void addCookiesRecipiesIngredients() {

        Integer vanilaCookiesIngrId[] = {3, 0, 2, 1, 12, 18};
        Integer chocolateCookiesIngrId[] = {3, 0, 2, 1, 16, 31};
        Integer plainCookiesIngrId[] = {3, 0, 2, 1, 16};

        try {
            for (int i = 0; i < vanilaCookiesIngrId.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe_ingredient(recp_id,ingr_id) VALUES ('%s','%s')", "16RES", vanilaCookiesIngrId[i] + 1 + "ING")).executeUpdate();
            }
            for (int i = 0; i < chocolateCookiesIngrId.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe_ingredient(recp_id,ingr_id) VALUES ('%s','%s')", "18RES", chocolateCookiesIngrId[i] + 1 + "ING")).executeUpdate();
            }
            for (int i = 0; i < plainCookiesIngrId.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe_ingredient(recp_id,ingr_id) VALUES ('%s','%s')", "17RES", plainCookiesIngrId[i] + 1 + "ING")).executeUpdate();
            }
            System.out.println("Cookies table created");
        } catch (SQLException sql) {
            System.out.println(String.format("ERROR: cookies table failed at creation time\t%s", sql.getMessage()));
        }

    }

    public void addCupcakesRecipiesIngredients() {

        Integer coffeeWalnutIngrId[] = {0, 1, 2, 3, 4, 5, 6, 7};
        Integer glutenFreeChocolateCupcakesId[] = {0, 27, 1, 28, 29, 30, 10, 31, 6};
        Integer veganVanilaCupcakesIngrId[] = {3, 27, 33, 34, 12, 24, 35, 36, 6, 7};

        try {
            for (int i = 0; i < coffeeWalnutIngrId.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe_ingredient(recp_id,ingr_id) VALUES ('%s','%s')", "7RES", coffeeWalnutIngrId[i] + 1 + "ING")).executeUpdate();
            }
            for (int i = 0; i < glutenFreeChocolateCupcakesId.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe_ingredient(recp_id,ingr_id) VALUES ('%s','%s')", "8RES", glutenFreeChocolateCupcakesId[i] + "ING")).executeUpdate();
            }
            for (int i = 0; i < veganVanilaCupcakesIngrId.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe_ingredient(recp_id,ingr_id) VALUES ('%s','%s')", "9RES", veganVanilaCupcakesIngrId[i] + 1 + "ING")).executeUpdate();
            }

        } catch (SQLException sql) {
            System.out.println("Cupcakes recipe failed to added" + sql.getMessage());
        }
        System.out.println("Cupcakes recipe added");
    }

//--------------------------------------------------PRODUCTS
    public void addCakesProduct() {
        Integer cat = 2;
        Double[] prices = {256.50, 449.50, 159.50};
        String[] nutrientsIds = {"1NT"};
        String[] recipeIds = {"1RES", "2RES", "3RES"};
        String[] images = {"assets/cakes/caramel-cake-5.jpg", "assets/cakes/Meringue-Cake.jpg", "assets/cakes/cakes_pic.jpg"};
        try {
            Product caramelCake = new ProductImpl("1PRO", "Caramel Cake", prices[0], cat, nutrientsIds[0], recipeIds[0], images[0]);
            Product MargueCake = new ProductImpl("2PRO", "Meringue Cake", prices[1], cat, nutrientsIds[0], recipeIds[1], images[1]);
            Product chocolateCake = new ProductImpl("3PRO", "Chocolate Cake", prices[2], cat, nutrientsIds[0], recipeIds[2], images[2]);

            ProductDAO productDao = new ProductDAOImpl(con);
            productDao.addProductByIds(MargueCake);
            productDao.addProductByIds(caramelCake);
            productDao.addProductByIds(chocolateCake);
        } catch (ProductException sql) {
            System.out.println("product insert failed" + sql.getMessage());
        }
        System.out.println("product added");
    }

    public void addCookiesProduct() {
        Integer cat = 1;
        Double[] prices = {75.99, 32.49, 28.69};
        String[] nutrientsIds = {"1NT"};
        String[] recipeIds = {"16RES", "18RES", "17RES"};
        String[] images = {"assets/cookies/cookies_p.jpg", "assets/cookies/cookies_pic1.jpg", "assets/cookies/cokkies_pic2.jpg"};
        try {
            Product vanilaCookie = new ProductImpl("4PRO", "Vanila Cookies", prices[0], cat, nutrientsIds[0], recipeIds[0], images[0]);
            Product chocolateCookie = new ProductImpl("5PRO", "Chocolate Cookies", prices[1], cat, nutrientsIds[0], recipeIds[1], images[1]);
            Product plainCookie = new ProductImpl("6PRO", "Plain Coffee Cookies", prices[2], cat, nutrientsIds[0], recipeIds[2], images[2]);

            ProductDAO productDao = new ProductDAOImpl(con);
            productDao.addProductByIds(vanilaCookie);
            productDao.addProductByIds(chocolateCookie);
            productDao.addProductByIds(plainCookie);
        } catch (ProductException sql) {
            System.out.println("product insert failed" + sql.getMessage());
        }
        System.out.println("product added");
    }

    public void addCupCakesProduct() {
        Integer cat = 4;
        Double[] prices = {45.99, 48.99, 40.99};
        String[] nutrientsIds = {"1NT"};
        String[] recipeIds = {"7RES", "8RES", "9RES"};
        String[] images = {"assets/cupcakes/coffeecupcake.jfif", "assets/cupcakes/glutten_free_chocolate_cupcakes.jpg", "assets/cupcakes/IMG_3165.webp"};
        try {
            Product walnutCupcakes = new ProductImpl("7PRO", "Walnut Cupcakes", prices[0], cat, nutrientsIds[0], recipeIds[0], images[0]);
            Product chocolateCupcakes = new ProductImpl("8PRO", "Gluten Free Chocolate Cupcakes", prices[1], cat, nutrientsIds[0], recipeIds[1], images[1]);
            Product vanillaCupcakes = new ProductImpl("9PRO", "Vegan Vanilla Cupcakes", prices[2], cat, nutrientsIds[0], recipeIds[2], images[2]);

            ProductDAO productDao = new ProductDAOImpl(con);
            productDao.addProductByIds(walnutCupcakes);
            productDao.addProductByIds(chocolateCupcakes);
            productDao.addProductByIds(vanillaCupcakes);
        } catch (ProductException sql) {
            System.out.println("product insert failed" + sql.getMessage());
        }
        System.out.println("product added");
    }

    public void addPersonalPiesProduct() {
        Integer cat = 6;
        Double[] prices = {59.99, 54.49, 54.49};
        String[] nutrientsIds = {"1NT"};
        String[] recipeIds = {"13RES", "14RES", "15RES"};
        String[] images = {"assets/personal_pies/blueberry pies.jpg", "assets/personal_pies/apple_pie.jpg", "assets/personal_pies/strawberry pie.jpg"};
        try {
            Product blueberryPies = new ProductImpl("10PRO", "Blueberry Pies", prices[0], cat, nutrientsIds[0], recipeIds[0], images[0]);
            Product applePies = new ProductImpl("11PRO", "Apple Pies", prices[1], cat, nutrientsIds[0], recipeIds[1], images[1]);
            Product strawberryPies = new ProductImpl("12PRO", "Strawberry Pies", prices[2], cat, nutrientsIds[0], recipeIds[2], images[2]);

            ProductDAO productDao = new ProductDAOImpl(con);
            productDao.addProductByIds(blueberryPies);
            productDao.addProductByIds(applePies);
            productDao.addProductByIds(strawberryPies);
        } catch (ProductException sql) {
            System.out.println("product insert failed" + sql.getMessage());
        }
        System.out.println("product added");
    }

    public void addMuffinsProduct() {
        Integer cat = 5;
        Double[] prices = {38.99, 45.99, 50.00};
        String[] nutrientsIds = {"1NT"};
        String[] recipeIds = {"10RES", "11RES", "12RES"};
        String[] images = {"assets/muffins/Blueberry-Muffins.jpg", "assets/muffins/Cranberry-Muffins.jpg", "assets/muffins/carrot-muffins.jpg"};
        try {
            Product blueberryMuffins = new ProductImpl("13PRO", "Blueberry Muffins", prices[0], cat, nutrientsIds[0], recipeIds[0], images[0]);
            Product cranberryMuffins = new ProductImpl("14PRO", "Cranbery Muffins", prices[1], cat, nutrientsIds[0], recipeIds[1], images[1]);
            Product carrotMuffins = new ProductImpl("15PRO", "Carrot Muffins", prices[2], cat, nutrientsIds[0], recipeIds[2], images[2]);

            ProductDAO productDao = new ProductDAOImpl(con);
            productDao.addProductByIds(blueberryMuffins);
            productDao.addProductByIds(cranberryMuffins);
            productDao.addProductByIds(carrotMuffins);
        } catch (ProductException sql) {
            System.out.println("product insert failed" + sql.getMessage());
        }
        System.out.println("product added");
    }

    public void addDoughnutsProduct() {
        Integer cat = 3;
        Double[] prices = {90.99, 85.99, 59.99};
        String[] nutrientsIds = {"1NT"};
        String[] recipeIds = {"4RES", "5RES", "6RES"};
        String[] images = {"assets/doughnuts/dougnuts3.jpg", "assets/doughnuts/dougnuts2.jpg", "assets/doughnuts/dougnuts4.jpg"};
        try {
            Product glazedDoughnutsLove = new ProductImpl("16PRO", "Glazed Simpsons Love Doughnuts", prices[0], cat, nutrientsIds[0], recipeIds[0], images[0]);
            Product glazedDoughnuts = new ProductImpl("17PRO", "Glazed Simpsons  Doughnuts", prices[1], cat, nutrientsIds[0], recipeIds[1], images[1]);
            Product chocolateDoughnuts = new ProductImpl("18PRO", "Chocolate Doughnuts", prices[2], cat, nutrientsIds[0], recipeIds[2], images[2]);

            ProductDAO productDao = new ProductDAOImpl(con);
            productDao.addProductByIds(glazedDoughnutsLove);
            productDao.addProductByIds(glazedDoughnuts);
            productDao.addProductByIds(chocolateDoughnuts);
        } catch (ProductException sql) {
            System.out.println("product insert failed" + sql.getMessage());
        }
        System.out.println("product added");
    }

    public void addStock() {
        List<String> productIds = new ProductDAOImpl(con).getAllProductsIds();
        productIds.forEach(productId -> {
            new StockDAOImpl(con).addStockById(productId, new SecureRandom().nextInt(100));
        });

    }

}
