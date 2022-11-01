package za.co.pattybakery.dao;

import java.util.List;
import za.co.pattybakery.Product;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface ProductDAO extends Close {

    void addProduct(Product product);

    Product getProductById(String productId);

    void removeProduct(String productId);

    void updateProductPrice(String productId, Double price);

    void updateProductIngredient(String productId, String ingredient);

    void updateProductCategory(String productId, String category);

    List<Product> getAllProducts();
}
