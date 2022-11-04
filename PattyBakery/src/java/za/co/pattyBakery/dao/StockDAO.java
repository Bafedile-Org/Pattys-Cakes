package za.co.pattybakery.dao;

import java.util.List;
import za.co.pattybakery.Product;
import za.co.pattybakery.model.Stock;

/**
 *
 * @author Hlawulani
 */
public interface StockDAO extends Close {

    public void addStock(Product product, Integer quantity);

    public void updateStockQuantity(String productId, Integer quantity);

    public List<Stock> getAllStocks();
}
