package org.example.menu;

import org.example.entity.Employee;
import org.example.entity.User;
import org.example.services.EmployeeService;

import java.util.Scanner;

public class employeeMenu {
    import java.util.Scanner;

    public class CustomerMenu {
        CustomerService customerService = new CustomerService();
        InitialMenu initialMenu = new InitialMenu();

        public void menu(User user){

            boolean loggedIn = true;
            Customer customer = (Customer) user;

            System.out.println("Select an option: ");
            System.out.println("1: Apply for a new bank account with a starting balance ");
            System.out.println("2: View the balance of a specific account ");
            System.out.println("3: View all account for this username ");
            System.out.println("4: Make a withdrawal from a specific account ");
            System.out.println("8: Log out ");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    customerService.applyForAccount();
                    break;
                case 2:
                    customerService.viewAccount();
                    break;
                case 3:
                    customerService.viewMyAccounts(customer);
                    break;
                case 4:
                    customerService.withdrawMoney(customer);
                    break;
                case 5:
                    customerService.depositMoney(customer);
                    break;
                case 6:
                    customerService.postReceive(customer);
                    break;
                case 7:
                    customerService.postTransfer(customer);
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
                menu(customer);
            } else {
                initialMenu.iMenu();
            }
        }
    }
}
