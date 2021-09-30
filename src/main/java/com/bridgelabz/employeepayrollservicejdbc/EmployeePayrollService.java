package com.bridgelabz.employeepayrollservicejdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {

        EmployeePayrollService service = new EmployeePayrollService();
        boolean exit = false;
        while (!exit) {
            System.out.println("\t1 -> Insert Data Into Table\n\t 2 -> Retrieve Data from Table\n\t 3 -> update Salary \n4 -> Exit ");
            switch (scanner.nextInt()) {
                case 1:
                    service.insertData();
                    break;
                case 2:
                    service.retrieveData();
                    break;
                case 3:
                    service.updateSalary();

                case 4:
                    exit = true;
            }
        }
    }


    EmployeeRepo employeeRepo = new EmployeeRepo();
    private void updateSalary() {
        System.out.println("Enter the Salary and Id to Update");
        employeeRepo.updateSalary(scanner.nextInt(),scanner.nextInt());
    }
    private void retrieveData() throws SQLException {
        List<EmployeeInfo> employeeInfoList = employeeRepo.retrieveData();
        System.out.println("\n" + employeeInfoList);

    }


    private void insertData() {
        EmployeeInfo info = new EmployeeInfo();
        System.out.println("Enter the Name of the employee");
        info.setName(scanner.next());
        System.out.println("Enter the gender M for Male F for Female");
        info.setGender(scanner.next().charAt(0));
        System.out.println("Enter the Address");
        info.setAddress(scanner.next());
        System.out.println("Enter Phone Number");
        info.setPhone(scanner.next());
        System.out.println("Enter the Date of Joining (YYYY-MM-DD");
        System.out.println("Enter year , month and Day ex: 2020 02 03");
        info.setStartDate(LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
        System.out.println("enter salary");
        info.setSalary(scanner.nextInt());
        employeeRepo.insertData(info);
    }
}
