package org.example.menu;

import java.util.Scanner;

public class EmployeeMenu implements Menu {
    EmployeeService employeeService = new EmployeeService();
    InitialMenu initialMenu = new InitialMenu();

    public void menu(Employee employee){

        boolean loggedIn = true;

        System.out.println("Select an option: ");
        System.out.println("1: Apply for a new bank account with a starting balance ");
        System.out.println("2: View the balance of a specific account ");
        System.out.println("3: View all account for this username ");
        System.out.println("4: Make a withdrawal from a specific account ");
        System.out.println("5: Make a deposit to a specific account ");
        System.out.println("6: Accept a money transfer from another account ");
        System.out.println("7: Post a money transfer to another account ");
        System.out.println("8: Log out ");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch(choice) {
            case 1:
                employeeService.applyForAccount();
                break;
            case 2:
                employeeService.viewAccount();
                break;
            case 3:
                employeeService.viewMyAccounts(employee);
                break;
            case 4:
                employeeService.withdrawMoney(employee);
                break;
            case 5:
                employeeService.depositMoney(employee);
                break;
            case 6:
                employeeService.postReceive(employee);
                break;
            case 7:
                employeeService.postTransfer(employee);
                break;
            case 8:
                System.out.println("You are logged out. Have a nice day!");
                loggedIn = false;
                break;
            default:
                System.out.println("You must enter a number (1-8) from the menu. Enter 8 to log out.");
                break;
        }

        if(loggedIn){
            menu(employee);
        } else {
            initialMenu.menu();
        }
    }

    public void menu() {
        System.out.println("Wrong employee menu.");
    }
}
