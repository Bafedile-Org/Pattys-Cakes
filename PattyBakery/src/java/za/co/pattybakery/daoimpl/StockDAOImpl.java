
package za.co.pattybakery.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import za.co.pattybakery.Product;
import za.co.pattybakery.dao.StockDAO;

/**
 *
 * @author Hlawulani
 */
public class StockDAOImpl implements StockDAO{
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public StockDAOImpl(PreparedStatement preparedStatement, ResultSet resultSet) {
        this.preparedStatement = preparedStatement;
        this.resultSet = resultSet;
    }
    
    @Override
    public void addStock(Product productId) {
    }

    @Override
    public void updateStockQuantity(Integer productId, Integer quantity) {
        
    }

    @Override
    public List<Product> getAllStocks() {
        return getAllStocks();
    }

    @Override
    public void close(PreparedStatement preparedStatement, ResultSet resultsSet) {
        
    }
}
