package za.co.pattyBakery.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import za.co.pattyBakery.database.DatabaseConnect;
import za.co.pattyBakery.Product;
import za.co.pattyBakery.dao.ProductDAO;
import za.co.pattyBakery.exception.ProductException;
import za.co.pattyBakery.model.ProductImpl;

/**
 *
 * @author Dimakatso Sebatane
 */
public class ProductDAOImpl implements ProductDAO {

    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private Connection con = null;

    public ProductDAOImpl() {
        con = DatabaseConnect.getInstance().getConnection();
    }

    public ProductDAOImpl(Connection con) {
        this.con = con;
    }

    @Override
    public void addProduct(Product product) {
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("INSERT IGNORE INTO product VALUES(?,?,?,?,?,?);");
                preparedStatement.setString(2, product.getProductName());
                preparedStatement.setDouble(3, product.getPrice());
                preparedStatement.setString(4, product.getNutrientId());
                preparedStatement.setString(5, product.getRecipeId());
                preparedStatement.setInt(6, product.getCategoryId());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));

        } finally {
            close(preparedStatement, resultSet);

        }
    }

    @Override
    public void addProductByIds(Product product) {
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("INSERT IGNORE INTO product VALUES(?,?,?,?,?,?);");
                preparedStatement.setString(1, product.getProductId());
                preparedStatement.setString(2, product.getProductName());
                preparedStatement.setDouble(3, product.getPrice());
                preparedStatement.setString(4, product.getNutrientId());
                preparedStatement.setString(5, product.getRecipeId());
                preparedStatement.setInt(6, product.getCategoryId());
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
            if (con != null) {
                preparedStatement = con.prepareStatement("SELECT * FROM product WHERE prod_id = ?");
                preparedStatement.setString(1, productId);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    product = new ProductImpl(resultSet.getString("prod_id"), resultSet.getString("prod_name"), resultSet.getDouble("price"),
                            new CategoryDAOImpl(con).getCategoryById(resultSet.getInt("cat_id")),
                            new ProductNutrientDAOImpl(con).getNutrientsByProductId(productId),
                            new RecipeDAOImpl(con).getRecipeById(resultSet.getString("recp_id")));
                }
            }
        } catch (SQLException | ProductException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));
        } finally {
            close(preparedStatement, resultSet);

        }
        return product;
    }

    public String getProductDescriptionById(String recipeId) {
        String description = null;
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("SELECT descriptions FROM recipe WHERE recp_id = ?");
                preparedStatement.setString(1, recipeId);
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    description = resultSet.getString("descriptions");
                }
            }

        } catch (SQLException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));
        } finally {
            close(preparedStatement, resultSet);

        }
        return description;
    }

    @Override
    public void removeProduct(String productId) {
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("DELETE  FROM product WHERE prod_id = ?");
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
            if (con != null) {
                preparedStatement = con.prepareStatement("UPDATE product SET  price =?  WHERE prod_id = ?");
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
            if (con != null) {
                preparedStatement = con.prepareStatement("UPDATE product SET  ingr_id =(SELECT ingr_id FROM ingredients WHERE ingredient=?)  WHERE prod_id = ?");
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
            if (con != null) {
                preparedStatement = con.prepareStatement("UPDATE product SET  cat_id =(SELECT cat_id FROM category WHERE category=?)  WHERE prod_id = ?");
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
            if (con != null) {
                preparedStatement = con.prepareStatement("SELECT * FROM product;");
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    product = getProductById(resultSet.getString("prod_id"));
                    products.add(product);
                }
            }
        } catch (SQLException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));
        } finally {
            close(preparedStatement, resultSet);

        }
        return products;
    }

    @Override
    public List<String> getAllProductsIds() {
        List<String> productIds = new ArrayList<>();
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("SELECT prod_id FROM product;");
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    productIds.add(resultSet.getString("prod_Id"));
                }
            }
        } catch (SQLException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));
        } finally {
            close(preparedStatement, resultSet);

        }
        return productIds;
    }
}
