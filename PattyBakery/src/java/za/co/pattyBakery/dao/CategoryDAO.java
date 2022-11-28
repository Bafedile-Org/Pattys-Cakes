package za.co.pattyBakery.dao;

import java.util.List;

/**
 *
 * @author Hlawulani
 */
public interface CategoryDAO extends Close {

    public void addCategory(Integer categoryId, String category);

    public void updateCategory(Integer categoryId, String category);

    public void removeCategory(Integer categoryId);

    public String getCategoryById(Integer categoryId);

    public List<String> getAllCategory();

    public Integer getCategoryIdByName(String category);

}
