package com.bridgelabz.employeepayrollservicejdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeRepo {
    Connection connection;

    private Connection getConnection() {
        String url = "jdbc:mysql://127.0.0.1:3306/employeePayroll_service";
        String username = "root";
        String password = "rootpassword";
        Connection connection = null;
        try {

            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertData(EmployeeInfo info) {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            String sql = "insert into employees_Payroll(name,gender,startDate,phone,address)" +
                    "values('" + info.getName() + "','" + info.getGender() + "','" + info.getStartDate() + "','" + info.getPhone() + "','" + info.getAddress() + "');";

            int result = statement.executeUpdate(sql);
            if (result == 1) {
                System.out.println("Insert Query");
            } else System.out.println("Data Not inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
