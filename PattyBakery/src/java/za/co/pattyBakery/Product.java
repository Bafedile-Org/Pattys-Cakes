package za.co.pattyBakery;

import java.util.List;
import za.co.pattyBakery.exception.ProductException;
import za.co.pattyBakery.model.Recipe;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface Product {

    String CATEGORY_ERROR_MSG = "Category Can Not Be Null!!!";
    String INGREDIENTS_ERROR_MSG = "Ingredients Can Not Be Null!!!";
    String NUTRIENT_INFO_ERROR_MSG = "Nutrient Inforation Can Not Be Null!!!";
    String PRODUCT_PRICE_ERROR_MSG = "Product Price Can Not Be Less Than Zero!!!";
    String PRODUCT_ID_ERROR_MSG = "Product Id  Can Not Be Zero!!!";

    public String getNutrientId();

    public String getProductName();

    public void setProductName(String productName);

    public void setNutrientId(String nutrientId);

    public String getRecipeId();

    public void setRecipeId(String ingredientsId);

    public Integer getCategoryId();

    public void setCategoryId(Integer categoryId);

    void setProductId(String productId) throws ProductException;

    String getProductId();

    void setPrice(Double price) throws ProductException;

    Double getPrice();

    void setCategory(String category) throws ProductException;

    String getCategory();

    public String getImageName();

    public Recipe getRecipe();

    public void setImageName(String imageName);

    public List<String> getNutrientsList();

    public void setNutrientsList(List<String> nutrientsList);
}
