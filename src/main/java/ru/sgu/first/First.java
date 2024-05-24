package main.java.ru.sgu.first;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class First {
    public static void main(String[] args) throws SQLException {
        First first = new First();
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            first.firstQuery(connection);
            first.secondQuery(connection);
            first.thirdQuery(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    private void firstQuery(Connection con) throws SQLException {
        String selectQuery = "SELECT * FROM employeesAge where age > 20";
        Statement statement = con.createStatement();

        // execute the query and get the result set
        ResultSet resultSet = statement.executeQuery(selectQuery);
        System.out.println("RESULT #1:");

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String employeeName = resultSet.getString("employeeName");
            int age = resultSet.getInt("age");
            System.out.println(STR."id: \{id} employeeName: \{employeeName} age: \{age}");
        }
    }

    private void secondQuery(Connection con) throws SQLException {
        String selectQuery = "SELECT avg(salary) as s_avg, departmentName FROM departmentSalary group by (departmentName)";
        Statement statement = con.createStatement();

        // execute the query and get the result set
        ResultSet resultSet = statement.executeQuery(selectQuery);
        System.out.println("RESULT #2:");

        while (resultSet.next()) {
            String departmentName = resultSet.getString("departmentName");
            int avg = resultSet.getInt("s_avg");
            System.out.println(STR."department: \{departmentName} s_avg: \{avg}");
        }
    }

    private void thirdQuery(Connection con) throws SQLException {
        String selectQuery = "SELECT employeeName, departmentName, location " +
                "FROM departmentEmployee " +
                "LEFT JOIN departmentLocation ON departmentEmployee.departmentId = departmentLocation.departmentId";
        Statement statement = con.createStatement();

        // execute the query and get the result set
        ResultSet resultSet = statement.executeQuery(selectQuery);
        System.out.println("RESULT #3:");

        while (resultSet.next()) {
            String employeeName = resultSet.getString("employeeName");
            String departmentName = resultSet.getString("departmentName");
            String location = resultSet.getString("location");
            System.out.println(STR."\{employeeName} \{departmentName} \{location}");
        }
    }
}
