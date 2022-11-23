package za.co.pattyBakery.service.impl;

import java.util.List;
import za.co.pattyBakery.dao.CategoryDAO;
import za.co.pattyBakery.dao.impl.CategoryDAOImpl;

/**
 *
 * @author Bridget Bapela
 */
public class CategoryServImpl implements CategoryDAO {

    private CategoryDAO categoryDAOImpl;

    public CategoryServImpl() {
        this.categoryDAOImpl = new CategoryDAOImpl();
    }

    @Override
    public void addCategory(Integer categoryId, String category) {
        if (category == null || categoryId <= 0) {

        }
        categoryDAOImpl.addCategory(categoryId, category);
    }

    @Override
    public void updateCategory(Integer categoryId, String category) {
        if (category == null || categoryId <= 0) {
            return;
        }
        categoryDAOImpl.updateCategory(categoryId, category);
    }

    @Override
    public void removeCategory(Integer categoryId) {
        if (categoryId <= 0) {
            return;
        }
        categoryDAOImpl.removeCategory(categoryId);
    }

    @Override
    public List<String> getAllCategory() {
        return categoryDAOImpl.getAllCategory();
    }

    @Override
    public String getCategoryById(Integer categoryId) {
        return categoryDAOImpl.getCategoryById(categoryId);
    }

    @Override
    public Integer getCategoryIdByName(String category) {
        return categoryDAOImpl.getCategoryIdByName(category);
    }
}
