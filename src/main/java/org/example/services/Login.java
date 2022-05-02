package org.example.services;

import java.util.Scanner;

//This is the class that handles checking for valid logins and passes the user to the correct menu.

public class Login {

    String username;
    String password;

    public void login1(boolean managerCheck){


        // could create MenuFactory
        InitialMenu initialMenu = new InitialMenu();
        EmployeeMenu employeeMenu = new EmployeeMenu();
        ManagerMenu managerMenu = new ManagerMenu();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your username: ");
        String username = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        boolean validLogin = validateLogin(managerCheck, username, password);

        if(validLogin){
            if(managerCheck){
                managerMenu.menu();
            } else{
                Employee employee = new Employee(username, password);
                employeeMenu.menu(employee);
            }
        }
    }

    public static boolean validateLogin(boolean managerCheck, String username, String password){

        if (managerCheck){

            //getmanagername and getmanagerpassword from manager table

            ManagerDao managerDao = DaoFactory.getManagerDao();
            Manager manager = managerDao.getManagerByUsername(username);
            //System.out.println("Here is the manager: " + manager.toString());

            if(manager.getUsername().equals(username) && manager.getPassword().equals(password)){
                return true;
            } else {
                System.out.println("Your username and password were invalid, please try again.");
                return false;
            }

        } else{
            //getemployeename and getemployeepassword from employee table

            EmployeeDao employeeDao = DaoFactory.getEmployeeDao();
            Employee employee = employeeDao.getEmployeeByUsername(username);
            //System.out.println("Here is the employee: " + employee.toString());

            if(employee.getUsername().equals(username) && employee.getPassword().equals(password)){
                return true;
            } else {
                System.out.println("Your username and password were invalid, please try again.");
                return false;
            }
        }
    }
}
