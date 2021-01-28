package utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCUtils {
     /* STATIC METHODS
    .establishConnection();
    .runQuery(String query); -> returns list of maps
    .countRows(String query);
    .closeDatabase();
     */

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    /**
     * This method will establish connection with Oracle SQL database
     */
    public static void establishConnection(){
        try {
            connection = DriverManager.getConnection(
                    CommonUtils.getProperty("DBURL"),
                    CommonUtils.getProperty("DBUsername"),
                    CommonUtils.getProperty("DBPassword")
            );
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * This method will return list of map as a result of executed query
     *
     * @param query
     * @return
     * @throws SQLException
     */
    public static List<Map<String, Object>> runQuery(String query) throws SQLException {
        List<Map<String, Object>> data =new ArrayList<>();

        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
//            connection.close();
//            statement.close();
        }

        ResultSetMetaData rMetaData = resultSet.getMetaData();

        // looping through rows of that table
        while(resultSet.next()){
            Map<String, Object> map = new HashMap<>();
            // It is looping through each column of current row and stores to map
            for (int i=1; i<=rMetaData.getColumnCount(); i++){
                map.put(rMetaData.getColumnName(i), resultSet.getObject(rMetaData.getColumnName(i)));
            }
            data.add(map);
        }
        return data;
    }

    /**
     * This method will return the number of rows in provided query
     * @param query
     * @return
     * @throws SQLException
     */
    public static int countRows(String query) throws SQLException {
        resultSet = statement.executeQuery(query);
        resultSet.last();
        return resultSet.getRow();
    }

    /**
     * This method will close connection to database
     * @throws SQLException
     */
    public static void closeDatabase() throws SQLException {
        if(connection!=null){
            connection.close();
        }
        if(statement!=null){
            statement.close();
        }
        if(resultSet!=null){
            resultSet.close();
        }
    }
}
