package sql.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Sample {

    public static final String URL = "jdbc:mysql://localhost:3306/classicmodels";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "pass123#@!";

    private static final String SQL_EMPLOYEES =
            "SELECT employeeNumber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle" +
                    " FROM classicmodels.employees";

    public static Employee getEmployee(Long employeeNumber) {
        Employee employee = null;

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL_EMPLOYEES + " WHERE employeeNumber = " + employeeNumber)) {

            if (resultSet.next()) {
                employee = new Employee();
                employee.setEmployeeNumber(resultSet.getLong("employeeNumber"));
                employee.setLastName(resultSet.getString("lastName"));
                employee.setFirstName(resultSet.getString("firstName"));
                employee.setExtension(resultSet.getString("extension"));
                employee.setEmail(resultSet.getString("email"));
                employee.setOfficeCode(resultSet.getString("officeCode"));
                employee.setReportsTo(resultSet.getLong("reportsTo"));
                employee.setJobTitle(resultSet.getString("jobTitle"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }


    public static List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL_EMPLOYEES)) {

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setEmployeeNumber(resultSet.getLong("employeeNumber"));
                employee.setLastName(resultSet.getString("lastName"));
                employee.setFirstName(resultSet.getString("firstName"));
                employee.setExtension(resultSet.getString("extension"));
                employee.setEmail(resultSet.getString("email"));
                employee.setOfficeCode(resultSet.getString("officeCode"));
                employee.setReportsTo(resultSet.getLong("reportsTo"));
                employee.setJobTitle(resultSet.getString("jobTitle"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
