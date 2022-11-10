package za.co.pattyBakery.model;

import za.co.pattyBakery.Product;
import za.co.pattyBakery.exception.ProductException;

/**
 *
 * @author Dimakatso Sebatane
 */
public class ProductImpl implements Product {

    private String productId;
    private Double price;
    private String nutrientInfo, ingredients, category, nutrientId, recipeId, productName;
    private Integer categoryId;

    public ProductImpl() {
    }

    public ProductImpl(String productId, String productName,
            Double price, String category, String nutrientInfo, String ingredients) throws ProductException {
        this.setCategory(category);
        this.setProductName(productName);
        this.setIngredients(ingredients);
        this.setNutrientInfo(nutrientInfo);
        this.setPrice(price);
        this.setProductId(productId);
    }

    public ProductImpl(String productId, String productName,
            Double price, Integer categoryId, String nutrientId, String recipeId) throws ProductException {
        this.setCategoryId(categoryId);
        this.setProductName(productName);
        this.setRecipeId(recipeId);
        this.setNutrientId(nutrientId);
        this.setPrice(price);
        this.setProductId(productId);
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
    public void setNutrientInfo(String nutrientInfo) throws ProductException {
        if (nutrientInfo == null) {
            throw new ProductException(NUTRIENT_INFO_ERROR_MSG);
        }
        this.nutrientInfo = nutrientInfo;
    }

    @Override
    public String getNutrientInfo() {
        return nutrientInfo;
    }

    @Override
    public void setIngredients(String ingredients) throws ProductException {
        if (ingredients == null) {
            throw new ProductException(INGREDIENTS_ERROR_MSG);
        }
        this.ingredients = ingredients;
    }

    @Override
    public String getIngredients() {
        return ingredients;
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
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

}
