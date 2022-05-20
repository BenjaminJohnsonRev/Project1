package org.example.services;

import org.example.dao.DaoFactory;
import org.example.dao.EmployeeDao;
import org.example.dao.ManagerDao;
import org.example.entity.Employee;
import org.example.entity.Manager;
//import org.example.menu.EmployeeMenu;
//import org.example.menu.InitialMenu;
//import org.example.menu.ManagerMenu;

import java.util.Scanner;

//This is the class that handles checking for valid logins and passes the user to the correct menu.

public class Login {

    String username;
    String password;

    public static boolean validateLogin(boolean managerCheck, String username, String password){

        if (managerCheck){
            //getmanagername and getmanagerpassword from manager table

            ManagerDao managerDao = DaoFactory.getManagerDao();
            Manager manager = managerDao.getManagerByCredentials(username,password);
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
            Employee employee = employeeDao.getEmployeeByCredentials(username,password);
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
