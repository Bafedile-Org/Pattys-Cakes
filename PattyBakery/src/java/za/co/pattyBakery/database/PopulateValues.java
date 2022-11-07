package za.co.pattyBakery.database;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static za.co.pattyBakery.database.DatabaseConnect.con;

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
        try {
            for (int i = 0; i < nutrients.size(); i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO nutrients(nutr_id,nutrient) VALUES('%s','%s')", nutrientsId.get(i), nutrients.get(i))).executeUpdate();
            }

        } catch (SQLException ex) {
            System.out.println("Failed to add nutrients...." + ex.getMessage());
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
        try {
            for (int i = 0; i < ingredients.size(); i++) {
                con.prepareStatement(String.format("INSERT IGNORE INTO ingredients(ingr_id,ingredient,quantity) VALUES('%s','%s',%d)", ingredientId.get(i), ingredients.get(i), random.nextInt(20))).executeUpdate();
            }

        } catch (SQLException ex) {
            System.out.println("Failed to add ingredients" + ex.getMessage());
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

}
