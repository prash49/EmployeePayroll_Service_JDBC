package com.bridgelabz.employeepayrollservicejdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

public class EmployeePayrollService {
    public static void main(String[] args) {
        EmployeePayrollService service = new EmployeePayrollService();
        service.insertData();

    }

    private void insertData() {
        EmployeeInfo info = new EmployeeInfo();
        info.setName("Prashanth");
        info.setGender('M');
        info.setAddress("Bengaluru");
        info.setPhone("9876543210");
        info.setStartDate(LocalDate.of(2020, 10, 12));
        EmployeeRepo employeeRepo = new EmployeeRepo();
        employeeRepo.insertData(info);
    }
}
