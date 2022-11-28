package za.co.pattyBakery.dao;

import java.util.List;
import za.co.pattyBakery.Product;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface ProductDAO extends Close {

    void addProduct(Product product);

    public void addProductByIds(Product product);

    Product getProductById(String productId);

    public String getProductIdByName(String name);

    void removeProduct(String productId);

    void updateProductPrice(String productId, Double price);

    void updateProductIngredient(String productId, String ingredient);

    void updateProductCategory(String productId, String category);

    List<Product> getAllProducts();

    public List<Product> getAllProductsByCategoryId(Integer categoryId);

    public List<String> getAllProductsIds();
}
