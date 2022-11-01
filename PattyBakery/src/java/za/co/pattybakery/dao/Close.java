
package za.co.pattybakery.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Hlawulani
 */
public interface Close {
    public void close(PreparedStatement preparedStatement, ResultSet resultsSet);
}
