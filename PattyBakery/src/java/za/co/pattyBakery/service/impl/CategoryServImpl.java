package za.co.pattyBakery.service.impl;

import java.util.List;
import za.co.pattybakery.dao.CategoryDAO;

/**
 *
 * @author Bridget Bapela
 */
public class CategoryServImpl implements CategoryDAO {

    private CategoryDAO categoryDAOImpl;

    public CategoryServImpl(CategoryDAO categoryDAOImpl) {
        this.categoryDAOImpl = categoryDAOImpl;
    }

    @Override
    public void addCategory(String category) {
        if (category == null) {

        }
        categoryDAOImpl.addCategory(category);
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

}
