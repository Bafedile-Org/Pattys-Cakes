
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
    private PreparedStatement ps;
    private ResultSet rs;

    public StockDAOImpl(PreparedStatement preparedStatement, ResultSet resultSet) {
        this.ps = preparedStatement;
        this.rs = resultSet;
    }
    
    @Override
    public void addStock(Product productId) {
        ps.addBatch();
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
