
import java.sql.Connection;
import za.co.pattyBakery.database.DatabaseConnect;

/**
 *
 * @author Bridget Bapela
 */
public class Main {

    public static void main(String[] args) {
        Connection dbCon = DatabaseConnect.getInstance().getConnection();
        String[] arrIngr = {"Unsalted Butter", "Eggs", "Brown Sugar", "Self Raising Flour", "Instant Coffee Granules", "Walnuts", "Icing Sugar", "Sprinkles", "Quick Muffin Mix",
            "Ground Cinnamon", "Milk", "Apple Sauce", "Vanila Extract", "Blue Berries", "Baking Powder", "Ground Nutmeg", "Baking Soda", "Ground Ginger", "Salt", "Orange Zest", "Shortening", "Orange Juice", "Cranberries",
            "Pecans", "Vegetable Oil", "Carrot", "Raisins", "Caster Sugar", "Gluten Free Self Raising Flour", "Cocoa Powder", "Custard Powder",
            "Dark Chocolate", "Icing Sugar", "Almond Milk", "Dairy Free Milk", "White Wine Vinegar", "Dairy Free Spread", "Chocolate Chips",
            "Dried Cranberries", "Cream Of Tartar", "Emulsifier", "Unsweetened Cocoa", "Dried Yeast", "Creme Fraiche", "Pie Crust", "Cornstartch", "Kosher Salt",
            "Strawberries", "Strawberry Flavored Jell-O"};

        for (int i = 0; i < arrIngr.length; i++) {
            System.out.println(String.format("%d      ------     %s%n", (i), arrIngr[i]));
        }
    }
}
