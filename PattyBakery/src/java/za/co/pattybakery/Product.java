package za.co.pattybakery;

import za.co.pattybakery.exception.ProductException;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface Product {

    String CATEGORY_ERROR_MSG = "";
    String INGREDIENTS_ERROR_MSG = "";
    String NUTRIENT_INFO_ERROR_MSG = "";
    String PRODUCT_PRICE_ERROR_MSG = "";
    String PRODUCT_ID_ERROR_MSG = "";

    void setProductId(Integer productId) throws ProductException;

    Integer getProductId();

    void setPrice(Double price) throws ProductException;

    Double getPrice();

    void setNutrientInfo(String nutrientInfo) throws ProductException;

    String getNutrientInfo();

    void setIngredients(String ingredients) throws ProductException;

    String getIngredients();

    void setCategory(String category) throws ProductException;

    String getCategory();
}
