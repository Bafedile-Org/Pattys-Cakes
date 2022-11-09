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
import za.co.pattyBakery.dao.impl.StockDAOImpl;
import za.co.pattyBakery.exception.ProductException;
import za.co.pattyBakery.model.ProductImpl;

/**
 *
 * @author Dimakatso Sebatane
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
        addDoughnutsRecipies();
        addMuffinsRecipies();
        addCookiesRecipies();
        addPersonalRecipies();
        addCupcakesRecipies();

        // add products
        addCakesProduct();
        addDoughnutsProduct();
        addMuffinsProduct();
        addCookiesProduct();
        addPersonalPiesProduct();
        addCupCakesProduct();

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

        Integer glazedSimpsonsIngrId[] = {45, 4, 28, 11, 1, 2, 46};
        Integer chocolateDoughnutsIngrId[] = {45, 4, 28, 11, 1, 2, 46, 32};

        try {
            for (int i = 0; i < glazedSimpsonsIngrId.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe(recp_id, ingr_id) VALUES ('%s','%s')", "4RES", glazedSimpsonsIngrId[i] + "ING")).executeUpdate();
            }
            for (int i = 0; i < glazedSimpsonsIngrId.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe(recp_id, ingr_id) VALUES ('%s','%s')", "5RES", glazedSimpsonsIngrId[i] + "ING")).executeUpdate();
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

        Integer blueberryIngrId[] = {14, 45, 3, 46};
        Integer appleIngrId[] = {4, 46, 3, 1, 2, 10};
        Integer strawberryIngrId[] = {47, 48, 3, 46, 49};

        try {
            for (int i = 0; i < blueberryIngrId.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe(recp_id, ingr_id) VALUES ('%s','%s')", "13RES", blueberryIngrId[i] + "ING")).executeUpdate();
            }
            for (int i = 0; i < appleIngrId.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe(recp_id, ingr_id) VALUES ('%s','%s')", "14RES", appleIngrId[i] + "ING")).executeUpdate();
            }
            for (int i = 0; i < strawberryIngrId.length; i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO recipe(recp_id, ingr_id) VALUES ('%s','%s')", "15RES", strawberryIngrId[i] + "ING")).executeUpdate();
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

    public void addCakesProduct() {
        Integer cat = 2;
        Double[] prices = {256.50, 449.50, 159.50};
        String[] nutrientsIds = {"1NT"};
        String[] recipeIds = {"1RES", "2RES", "3RES"};
        try {
            Product caramelCake = new ProductImpl("1PRO", "Caramel Cake", prices[0], cat, nutrientsIds[0], recipeIds[0]);
            Product MargueCake = new ProductImpl("2PRO", "Margue Cake", prices[1], cat, nutrientsIds[0], recipeIds[1]);
            Product chocolateCake = new ProductImpl("3PRO", "Chocolate Cake", prices[2], cat, nutrientsIds[0], recipeIds[2]);

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
        String[] recipeIds = {"16RES", "17RES", "18RES"};
        try {
            Product vanilaCookie = new ProductImpl("4PRO", "Vanila Cookies", prices[0], cat, nutrientsIds[0], recipeIds[0]);
            Product chocolateCookie = new ProductImpl("5PRO", "Chocolate Cookies", prices[1], cat, nutrientsIds[0], recipeIds[1]);
            Product plainCookie = new ProductImpl("6PRO", "Plain Coffee Cookies", prices[2], cat, nutrientsIds[0], recipeIds[2]);

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
        try {
            Product walnutCupcakes = new ProductImpl("7PRO", "Walnut Cupcakes", prices[0], cat, nutrientsIds[0], recipeIds[0]);
            Product chocolateCupcakes = new ProductImpl("8PRO", "Gluten Free Chocolate Cupcakes", prices[1], cat, nutrientsIds[0], recipeIds[1]);
            Product vanillaCupcakes = new ProductImpl("9PRO", "Vegan Vanilla Cupcakes", prices[2], cat, nutrientsIds[0], recipeIds[2]);

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
        try {
            Product blueberryPies = new ProductImpl("10PRO", "Blueberry Pies", prices[0], cat, nutrientsIds[0], recipeIds[0]);
            Product applePies = new ProductImpl("11PRO", "Apple Pies", prices[1], cat, nutrientsIds[0], recipeIds[1]);
            Product strawberryPies = new ProductImpl("12PRO", "Strawberry Pies", prices[2], cat, nutrientsIds[0], recipeIds[2]);

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
        try {
            Product blueberryMuffins = new ProductImpl("13PRO", "Blueberry Muffins", prices[0], cat, nutrientsIds[0], recipeIds[0]);
            Product cranberryMuffins = new ProductImpl("14PRO", "Cranbery Muffins", prices[1], cat, nutrientsIds[0], recipeIds[1]);
            Product carrotMuffins = new ProductImpl("15PRO", "Carrot Muffins", prices[2], cat, nutrientsIds[0], recipeIds[2]);

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
        try {
            Product glazedDoughnutsLove = new ProductImpl("16PRO", "Glazed Simpsons Love Doughnuts", prices[0], cat, nutrientsIds[0], recipeIds[0]);
            Product glazedDoughnuts = new ProductImpl("17PRO", "Glazed Simpsons  Doughnuts", prices[1], cat, nutrientsIds[0], recipeIds[1]);
            Product chocolateDoughnuts = new ProductImpl("18PRO", "Chocolate Doughnuts", prices[2], cat, nutrientsIds[0], recipeIds[2]);

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