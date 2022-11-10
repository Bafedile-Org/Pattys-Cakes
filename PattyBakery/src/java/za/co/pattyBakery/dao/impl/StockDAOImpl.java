package za.co.pattyBakery.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import za.co.pattyBakery.database.DatabaseConnect;
import za.co.pattyBakery.Product;
import za.co.pattyBakery.dao.StockDAO;
import za.co.pattyBakery.exception.OrderException;
import za.co.pattyBakery.exception.ProductException;
import za.co.pattyBakery.model.Stock;

/**
 *
 * @author Hlawulani
 */
public class StockDAOImpl implements StockDAO {

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Connection con = null;

    public StockDAOImpl() {
        con = DatabaseConnect.getInstance().getConnection();
    }

    public StockDAOImpl(Connection con) {
        this.con = con;
    }

    @Override
    public void addStock(Product product, Integer quantity) {
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("INSERT IGNORE INTO stock  VALUES(?,?)");
                preparedStatement.setString(1, product.getProductId());
                preparedStatement.setInt(2, quantity);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException sql) {
            System.out.println("Error: " + sql.getMessage());
        } finally {
            close(preparedStatement, resultSet);
        }
    }

    @Override
    public void addStockById(String productId, Integer quantity) {
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("INSERT IGNORE INTO stock  VALUES(?,?)");
                preparedStatement.setString(1, productId);
                preparedStatement.setInt(2, quantity);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException sql) {
            System.out.println("Error: " + sql.getMessage());
        } finally {
            close(preparedStatement, resultSet);
        }
    }

    @Override
    public void updateStockQuantity(String productId, Integer quantity) {
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("UPDATE stock SET quantity = ? WHERE prod_id = ?");
                preparedStatement.setInt(1, quantity);
                preparedStatement.setString(2, productId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException sql) {
            System.out.println("Error: " + sql.getMessage());
        } finally {
            close(preparedStatement, resultSet);
        }
    }

    @Override
    public List<Stock> getAllStocks() {
        List<Stock> stocks = new ArrayList<>();
        Product product = null;
        Stock stock = null;
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("SELECT * FROM stock");
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    product = new ProductDAOImpl().getProductById(resultSet.getString("prod_id"));
                    stock = new Stock(product, resultSet.getInt("quantity"), product.getPrice());
                    stocks.add(stock);
                }
            }
        } catch (SQLException | OrderException sql) {
            System.out.println("Error: " + sql.getMessage());
        } finally {
            close(preparedStatement, resultSet);
        }
        return stocks;
    }

}
