import javax.xml.transform.Result;
import java.sql.*;

public class Main {
    private static Connection connection;
    public static void main(String[] args) throws SQLException {

        try {
            connection = DriverManager.getConnection("jdbc:sqlite:flights.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        createAverageTable(connection);
        insertAveragePrices(connection);
    }

    public static void createAverageTable(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(
                "CREATE TABLE IF NOT EXISTS average_price_of_flights (" +
                        "destination_city TEXT," +
                        "flights INTEGER," +
                        "thanksgiving_eve_flights INTEGER," +
                        "black_friday_flights INTEGER)"
        );
        statement.close();
    }

    public static void insertAveragePrices(Connection connection) throws SQLException {
        Statement selectStatement = connection.createStatement();
        ResultSet resultSet = selectStatement.executeQuery("SELECT DISTINCT destination_city FROM flights");

        PreparedStatement insertStatement = connection.prepareStatement(
                "INSERT INTO average_price_of_flights(destination_city, flights, thanksgiving_eve_flights, black_friday_flights) " +
                        "VALUES (?, ?, ?, ?)"
        );

        while (resultSet.next()) {
            String destinationCity = resultSet.getString("destination_city");

            int flightsAveragePrice = getAveragePrice(connection, "flights", destinationCity);
            int thanksgivingEveAveragePrice = getAveragePrice(connection, "thanksgiving_eve_flights", destinationCity);
            int blackFridayAveragePrice = getAveragePrice(connection, "black_friday_flights", destinationCity);

            insertStatement.setString(1, destinationCity);
            insertStatement.setInt(2, flightsAveragePrice);
            insertStatement.setInt(3, thanksgivingEveAveragePrice);
            insertStatement.setInt(4, blackFridayAveragePrice);

            insertStatement.executeUpdate();
        }

        resultSet.close();
        selectStatement.close();
        insertStatement.close();
    }

//    public static void addDestinationsToDB(Connection connection) throws SQLException {
//        Statement selectStatement = connection.createStatement();
//        ResultSet resultSet = selectStatement.executeQuery("SELECT DISTINCT destination_city FROM flights");
//
//        PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO average_price_of_flights(destination_city) VALUES (?)");
//
//        while(resultSet.next()) {
//            String destinationCity = resultSet.getString("destination_city");
//            insertStatement.setString(1, destinationCity);
//            insertStatement.executeUpdate();
//        }
//
//        resultSet.close();
//        selectStatement.close();
//        insertStatement.close();
//    }

    public static int getAveragePrice(Connection connection, String tableName, String destinationCity) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT AVG(price) as average_price FROM " + tableName +
                " WHERE destination_city = '" + destinationCity + "'");

        double averagePrice = 0.0;
        if (resultSet.next()) {
            averagePrice = resultSet.getDouble("average_price");
        }
        System.out.println(averagePrice);
        resultSet.close();
        statement.close();

        return (int) averagePrice;
    }

}
