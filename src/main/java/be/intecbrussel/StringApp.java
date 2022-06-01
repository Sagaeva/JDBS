package be.intecbrussel;

import org.apache.commons.lang3.StringUtils;

import java.sql.*;

public class StringApp {
    public static void main(String[] args) {

        String url = "moktok.intecbrussel.org";
        String port = "33062";
        String database = "ScrumProjectICry";

        String databaseURL = String.format("jdbc:mysql://%s:%s/%s", url, port, database);
        System.out.println(databaseURL);

        try {

            Connection connection = DriverManager.
                    getConnection(databaseURL, "icryevenmore", "icryevenmore");
            System.out.println(connection.isValid(5));

            String query =  "SELECT * FROM Brewers WHERE Turnover > 5000;";
           PreparedStatement statement = connection.prepareStatement(query);
           ResultSet resultSet = statement.executeQuery();
           while (resultSet.next()) {
               int id = resultSet.getInt("id");
               int turnover = resultSet.getInt("turnover");
               System.out.println("ID" + id + "Turnover"  + turnover);

           }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }


    }
}
