package za.co.pattybakery.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import za.co.pattyBakery.Person;
import za.co.pattybakery.Product;
import za.co.pattybakery.dao.ProductDAO;
import za.co.pattybakery.exception.ProductException;
import za.co.pattybakery.model.PersonImpl;
import za.co.pattybakery.model.ProductImpl;

/**
 *
 * @author Dimakatso Sebatane
 */
public class ProductDAOImpl implements ProductDAO {

    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private Connection conn = null;

    public ProductDAOImpl() {
    }

    @Override
    public void addProduct(Product product) {
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("INSERT INTO product  VALUES(?,?,"
                        + "(SELECT nutr_id FROM nutrients WHERE nutrient =?),"
                        + "(SELECT ingr_id FROM ingredients WHERE ingredient=?),"
                        + "(SELECT cat_id FROM category WHERE category= ?));");
                preparedStatement.setString(1, product.getProductId());
                preparedStatement.setDouble(2, product.getPrice());
                preparedStatement.setString(3, product.getNutrientInfo());
                preparedStatement.setString(4, product.getIngredients());
                preparedStatement.setString(5, product.getCategory());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));

        } finally {
            close(preparedStatement, resultSet);

        }
    }

    @Override
    public Product getProductById(String productId) {
        Product product = null;
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("SELECT * FROM product WHERE prod_id = ?");
                preparedStatement.setString(1, productId);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    product = new ProductImpl(resultSet.getString("prod_id"), resultSet.getDouble("price"), resultSet.getString("category"), resultSet.getString("nutrient_info"),
                            resultSet.getString("ingredient"));
                }
            }
        } catch (SQLException | ProductException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));
        } finally {
            close(preparedStatement, resultSet);

        }
        return product;
    }

    @Override
    public void removeProduct(String productId) {
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("DELETE  FROM product WHERE prod_id = ?");
                preparedStatement.setString(1, productId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));
        } finally {
            close(preparedStatement, resultSet);

        }
    }

    @Override
    public void updateProductPrice(String productId, Double price) {
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("UPDATE product SET  price =?  WHERE prod_id = ?");
                preparedStatement.setDouble(1, price);
                preparedStatement.setString(2, productId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));
        } finally {
            close(preparedStatement, resultSet);

        }
    }

    @Override
    public void updateProductIngredient(String productId, String ingredient) {
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("UPDATE product SET  ingr_id =(SELECT ingr_id FROM ingredients WHERE ingredient=?)  WHERE prod_id = ?");
                preparedStatement.setString(1, ingredient);
                preparedStatement.setString(2, productId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));
        } finally {
            close(preparedStatement, resultSet);

        }
    }

    @Override
    public void updateProductCategory(String productId, String category) {
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("UPDATE product SET  cat_id =(SELECT cat_id FROM category WHERE category=?)  WHERE prod_id = ?");
                preparedStatement.setString(1, category);
                preparedStatement.setString(2, productId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));
        } finally {
            close(preparedStatement, resultSet);

        }
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        Product product = null;
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("SELECT * FROM product;");
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    product = new ProductImpl(resultSet.getString("prod_id"),
                            resultSet.getDouble("price"),
                            new CategoryDAOImpl().getCategoryById(resultSet.getInt("cat_id")),
                            new NutrientsDAOImpl().getNutrientById(resultSet.getString("nutr_id")),
                            new IngredientsDAOImpl().getIngredientById(resultSet.getString("ingredient")));
                    products.add(product);
                }
            }
        } catch (SQLException | ProductException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));
        } finally {
            close(preparedStatement, resultSet);

        }
        return products;
    }

}
