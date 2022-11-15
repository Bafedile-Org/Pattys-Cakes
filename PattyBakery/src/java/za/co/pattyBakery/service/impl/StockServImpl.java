package za.co.pattyBakery.service.impl;

import java.util.List;
import za.co.pattyBakery.Product;
import za.co.pattyBakery.dao.StockDAO;
import za.co.pattyBakery.dao.impl.StockDAOImpl;
import za.co.pattyBakery.model.Stock;

/**
 *
 * @author Bridget Bapela
 */
public class StockServImpl implements StockDAO {

    private StockDAO stockDAOImpl;

    public StockServImpl() {
        this.stockDAOImpl = new StockDAOImpl();
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

    @Override
    public void addStockById(String productId, Integer quantity) {
        if (productId == null || quantity <= 0) {
            return;
        }
        stockDAOImpl.addStockById(productId, quantity);
    }

}
