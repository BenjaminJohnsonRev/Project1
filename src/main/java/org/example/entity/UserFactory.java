package org.example.entity;

import java.util.Scanner;

//This should be the only place we create "new" users. It also passes users into the data layer.

public class UserFactory {

    ManagerDaoImpl managerDao;

    public static void makeNewUser(boolean managerStatus){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter new username: ");
        String username = scanner.nextLine();

        System.out.println("Enter new password: ");
        String password = scanner.nextLine();

        System.out.println("Confirm new password: ");
        String passwordConfirm = scanner.nextLine();

        if(password.equals(passwordConfirm)){
            if (managerStatus){
                Manager manager = new Manager(username, password);

                System.out.println("New manager account created.");

                ManagerDao managerDao = DaoFactory.getManagerDao();

            } else {
                Employee employee = new Employee(username, password);

                EmployeeDao employeeDao = DaoFactory.getEmployeeDao();

                employeeDao.insert(employee);

                System.out.println("New employee account created. Log in to continue. ");
            }
        } else {
            System.out.println("Password does not match. ");
            makeNewUser(managerStatus);
        }

    }
}
