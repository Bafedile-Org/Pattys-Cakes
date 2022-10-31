package za.co.pattybakery.dao;

import java.util.List;
import za.co.pattybakery.Product;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface ProductDAO {

    void addProduct(Product product);

    Product getProductById(Integer productId);

    void removeProduct(Integer productId);

    void updateProductPrice(Integer productId, Double price);

    void updateProductIngredient(Integer productId, String ingredient);

    void updateProductCategory(Integer productId, String category);

    List<Product> getAllProducts();
}
