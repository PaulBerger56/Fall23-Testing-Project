import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.sql.*;

@RunWith(JUnitParamsRunner.class)
public class FindCheapestFlightTest {

    private static Connection connection;

    @BeforeClass
    public static void setup() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:flights.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Parameters({"Cancun", "Las Vegas", "Denver", "Rome", "Milan", "Paris", "Madrid", "Amsterdam", "Singapore"})
    public void cheapestFlightTest(String city) {
        Flight cheapestFlight = findCheapestFlight(city);

        if (cheapestFlight != null) {
            System.out.println("Cheapest flight from Atlanta to " + city + ": ");
            System.out.println(cheapestFlight+"\n");
        } else {
            System.out.println("No data found for the cheapest flight from Atlanta to " + city);
        }

    }

    private Flight findCheapestFlight(String destinationCity) {
        Flight cheapestFlight = null;

        try(PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM flights WHERE destination_city = ? ORDER BY price ASC LIMIT 1"
        )) {
            preparedStatement.setString(1, destinationCity);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                String airline = resultSet.getString("airline");
                String departureCity = resultSet.getString("departure_city");
                String destination = resultSet.getString("destination_city");
                String departueDate = resultSet.getString("departure_date");
                String returnDate = resultSet.getString("return_date");
                String price = String.valueOf(resultSet.getInt("price"));
                boolean nonstop = Boolean.parseBoolean(resultSet.getString("nonstop"));

                cheapestFlight = new Flight(airline, departureCity, destination, departueDate, returnDate, nonstop, price);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  cheapestFlight;
    }
}
