package za.co.pattyBakery.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Hlawulani
 */
public interface Close {

    public default void close(PreparedStatement preparedStatement, ResultSet resultsSet) {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException sql) {
            System.out.println(String.format("ERROR: %s%n", sql.getMessage()));
        }
        try {
            if (resultsSet != null) {
                resultsSet.close();
            }
        } catch (SQLException sql) {
            System.out.println(String.format("ERROR: %s%n", sql.getMessage()));
        }
    }
}
