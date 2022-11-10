package za.co.pattyBakery.service.impl;

import java.util.List;
import za.co.pattyBakery.Product;
import za.co.pattyBakery.dao.ProductDAO;
import za.co.pattyBakery.dao.impl.ProductDAOImpl;

/**
 *
 * @author Bridget Bapela
 */
public class ProductServImpl implements ProductDAO {

    private ProductDAO productDAOImpl;

    public ProductServImpl() {
        this.productDAOImpl = new ProductDAOImpl();
    }

    @Override
    public void addProduct(Product product) {
        if (product == null) {

        }
        productDAOImpl.addProduct(product);
    }

    @Override
    public Product getProductById(String productId) {
        if (productId == null) {
            return null;
        }
        return productDAOImpl.getProductById(productId);
    }

    @Override
    public void removeProduct(String productId) {

        if (productId == null) {
            return;
        }
        productDAOImpl.removeProduct(productId);
    }

    @Override
    public void updateProductPrice(String productId, Double price) {
        if (price <= 0 || price == null) {
            return;
        }
        productDAOImpl.updateProductPrice(productId, price);
    }

    @Override
    public void updateProductIngredient(String productId, String ingredient) {
        if (ingredient == null && productId == null) {
            return;
        }
        productDAOImpl.updateProductIngredient(productId, ingredient);
    }

    @Override
    public void updateProductCategory(String productId, String category) {
        if (category == null && productId == null) {
            return;
        }
        productDAOImpl.updateProductCategory(productId, category);
    }

    @Override
    public List<Product> getAllProducts() {
        return productDAOImpl.getAllProducts();
    }

    @Override
    public void addProductByIds(Product product) {
        if (product == null) {

        }
        productDAOImpl.addProductByIds(product);
    }

    @Override
    public List<String> getAllProductsIds() {
        return productDAOImpl.getAllProductsIds();
    }

}
