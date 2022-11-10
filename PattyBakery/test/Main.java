
import java.sql.Connection;
import za.co.pattyBakery.dao.impl.RecipeDAOImpl;
import za.co.pattyBakery.database.DatabaseConnect;
import za.co.pattyBakery.model.Recipe;

/**
 *
 * @author Bridget Bapela
 */
public class Main {

    public static void main(String[] args) {
        Connection dbCon = DatabaseConnect.getInstance().getConnection();

        Recipe recipe = new RecipeDAOImpl(dbCon).getRecipeById("13RES");
        System.out.println(recipe.toString());
    }
}
