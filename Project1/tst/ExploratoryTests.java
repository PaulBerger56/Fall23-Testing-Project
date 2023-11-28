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


    @BeforeClass
    public static void setup() {
        uniqueAirlines = new HashSet<>();

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

    @AfterClass
    public static void tearDown() throws SQLException {
        connection.close();
    }
}
