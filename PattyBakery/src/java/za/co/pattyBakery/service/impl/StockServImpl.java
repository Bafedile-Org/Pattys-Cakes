package za.co.pattyBakery.service.impl;

import java.util.List;
import za.co.pattybakery.Product;
import za.co.pattybakery.dao.StockDAO;
import za.co.pattybakery.model.Stock;

/**
 *
 * @author Bridget Bapela
 */
public class StockServImpl implements StockDAO {

    private StockDAO stockDAOImpl;

    public StockServImpl(StockDAO stockDAOImpl) {
        this.stockDAOImpl = stockDAOImpl;
    }

    @Override
    public void addStock(Product product, Integer quantity) {
        if (product == null || quantity <= 0) {
            return;
        }
        stockDAOImpl.addStock(product, quantity);
    }

    @Override
    public void updateStockQuantity(String productId, Integer quantity) {
        if (productId == null || quantity <= 0) {
            return;
        }
        stockDAOImpl.updateStockQuantity(productId, quantity);
    }

    @Override
    public List<Stock> getAllStocks() {
        return stockDAOImpl.getAllStocks();
    }

}
