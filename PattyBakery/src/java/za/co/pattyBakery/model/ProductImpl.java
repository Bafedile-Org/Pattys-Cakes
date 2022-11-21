package za.co.pattyBakery.model;

import java.util.List;
import za.co.pattyBakery.Product;
import za.co.pattyBakery.exception.ProductException;

/**
 *
 * @author Dimakatso Sebatane
 */
public class ProductImpl implements Product {

    private String productId;
    private Double price;
    private String category, nutrientId, recipeId, productName;
    private Integer categoryId;
    private List<String> nutrientsList;
    private Recipe recipe;
    private String imageName;

    public ProductImpl() {
    }

    public ProductImpl(String productId, String productName,
            Double price, String category, List<String> nutrientsList, Recipe recipe, String imageName) throws ProductException {
        this.setPrice(price);
        this.setProductId(productId);
        this.setProductName(productName);
        this.setCategory(category);
        this.setNutrientsList(nutrientsList);
        this.setNutrientId(nutrientId);
        this.recipe = recipe;
        this.setImageName(imageName);
    }

    public ProductImpl(String productId, String productName,
            Double price, String category, List<String> nutrientsList, String nutrientId, String recipeId) throws ProductException {
        this.setPrice(price);
        this.setProductId(productId);
        this.setProductName(productName);
        this.setCategory(category);
        this.setNutrientsList(nutrientsList);
        this.setNutrientId(nutrientId);
        this.setRecipeId(recipeId);
    }

    public ProductImpl(String productId, String productName,
            Double price, String category, List<String> nutrientsList, String nutrientId, String recipeId, String imageName) throws ProductException {
        this.setPrice(price);
        this.setProductId(productId);
        this.setProductName(productName);
        this.setCategory(category);
        this.setNutrientsList(nutrientsList);
        this.setNutrientId(nutrientId);
        this.setRecipeId(recipeId);
        this.setImageName(imageName);
    }

    public ProductImpl(String productId, String productName,
            Double price, Integer categoryId, String nutrientId, String recipeId, String imageName) throws ProductException {
        this.setCategoryId(categoryId);
        this.setProductName(productName);
        this.setRecipeId(recipeId);
        this.setNutrientId(nutrientId);
        this.setPrice(price);
        this.setProductId(productId);
        this.setImageName(imageName);
    }

    /**
     * @return the nutrientId
     */
    @Override
    public String getNutrientId() {
        return nutrientId;
    }

    /**
     * @param nutrientId the nutrientId to set
     */
    @Override
    public void setNutrientId(String nutrientId) {
        this.nutrientId = nutrientId;
    }

    /**
     * @return the recipeId
     */
    @Override
    public String getRecipeId() {
        return recipeId;
    }

    /**
     * @param recipeId the recipeId to set
     */
    @Override
    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    @Override
    public void setProductId(String productId) throws ProductException {
        if (productId == null) {
            throw new ProductException(PRODUCT_ID_ERROR_MSG);
        }
        this.productId = productId;
    }

    @Override
    public String getProductId() {
        return productId;
    }

    @Override
    public void setPrice(Double price) throws ProductException {
        if (price < 0) {
            throw new ProductException(PRODUCT_PRICE_ERROR_MSG);
        }
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return price;
    }

    @Override
    public void setCategory(String category) throws ProductException {
        if (category == null) {
            throw new ProductException(CATEGORY_ERROR_MSG);
        }
        this.category = category;
    }

    @Override
    public String getCategory() {
        return category;
    }

    /**
     * @return the categoryId
     */
    @Override
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId the categoryId to set
     */
    @Override
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return the productName
     */
    @Override
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    @Override
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the nutrientsList
     */
    @Override
    public List<String> getNutrientsList() {
        return nutrientsList;
    }

    /**
     * @param nutrientsList the nutrientsList to set
     */
    @Override
    public void setNutrientsList(List<String> nutrientsList) {
        this.nutrientsList = nutrientsList;
    }

    /**
     * @return the imageName
     */
    public String getImageName() {
        return imageName;
    }

    /**
     * @param imageName the imageName to set
     */
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Recipe getRecipe() {
        return recipe;
    }

}
