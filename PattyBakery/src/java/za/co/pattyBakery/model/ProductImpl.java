package za.co.pattybakery.model;

import za.co.pattybakery.Product;
import za.co.pattybakery.exception.ProductException;

/**
 *
 * @author Dimakatso Sebatane
 */
public class ProductImpl implements Product {

    private String productId;
    private Double price;
    private String nutrientInfo, ingredients, category;

    public ProductImpl() {
    }

    public ProductImpl(String productId, Double price, String category, String nutrientInfo, String ingredients) throws ProductException {
        this.setCategory(category);
        this.setIngredients(ingredients);
        this.setNutrientInfo(nutrientInfo);
        this.setPrice(price);
        this.setProductId(productId);
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

}