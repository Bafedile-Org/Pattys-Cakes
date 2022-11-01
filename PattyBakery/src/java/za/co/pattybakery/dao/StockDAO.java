
package za.co.pattybakery.dao;

import java.util.List;
import za.co.pattybakery.Product;

/**
 *
 * @author Hlawulani
 */
public interface StockDAO extends Close{
    public void addStock(Product productId);
    public void updateStockQuantity(Integer productId, Integer quantity);
    public List<Product> getAllStocks();
}
