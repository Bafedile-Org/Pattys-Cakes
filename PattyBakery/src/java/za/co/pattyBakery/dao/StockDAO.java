package za.co.pattyBakery.dao;

import java.util.List;
import za.co.pattyBakery.Product;
import za.co.pattyBakery.model.Stock;

/**
 *
 * @author Hlawulani
 */
public interface StockDAO extends Close {

    public void addStock(Product product, Integer quantity);

    public void updateStockQuantity(String productId, Integer quantity);

    public void addStockById(String productId, Integer quantity);

    public List<Stock> getAllStocks();
}
