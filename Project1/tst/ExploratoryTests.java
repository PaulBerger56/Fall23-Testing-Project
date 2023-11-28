import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@RunWith(JUnitParamsRunner.class)
public class ExploratoryTests {

    private static Connection connection;
    private static Set<String> uniqueAirlines;
    private static Map<String, Integer> cityFlightAverages;
    private static Map<String, Map<String, Integer>> cityTableAverages;

    @BeforeClass
    public static void setup() {
        uniqueAirlines = new HashSet<>();
        cityFlightAverages = new HashMap<>();
        cityTableAverages = new HashMap<>();
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:flights.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Parameters({"flights","black_friday_flights","thanksgiving_eve_flights"})
    public void differentAirlineTest(String tableName) {
        String sql = "SELECT airline FROM " + tableName;

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                while(resultSet.next()) {
                    String airline = resultSet.getString("airline");
                    if(airline != null && !airline.isEmpty()) {
                        String[] parts = airline.split("[•,]");

                        for(String part: parts){
                            String cleanedAirline = part.trim();
                            if(!cleanedAirline.isEmpty()) {
                                uniqueAirlines.add(cleanedAirline);
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(uniqueAirlines.size() + " Unique Airlines from table " + tableName +"\n");
        for(String s: uniqueAirlines){
            System.out.println(s);
        }
    }

    @Test
    @Parameters({"flights","black_friday_flights","thanksgiving_eve_flights"})
    public void averagePricePerCityTest(String tableName){
        String sql = "SELECT destination_city, price FROM " + tableName;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String destinationCity = resultSet.getString("destination_city");
                    int price = resultSet.getInt("price");

                    // Update average price for the destination city in the map
                    updateCityAverage(destinationCity, price);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Average Prices for Destination Cities from table " + tableName);
        for (Map.Entry<String, Integer> entry : cityFlightAverages.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
    }

    private void updateCityAverage(String destinationCity, int price) {
        if (destinationCity != null && !destinationCity.isEmpty()) {
            // Normalize the city name (e.g., convert to lowercase) for consistency
            String normalizedCity = destinationCity.toLowerCase();

            // Update the average price in the map
            cityFlightAverages.merge(normalizedCity, price, (existingValue, newValue) ->
                    (existingValue + newValue) / 2);
        }
    }

    @AfterClass
    public static void tearDown() throws SQLException {
        connection.close();
    }
}
