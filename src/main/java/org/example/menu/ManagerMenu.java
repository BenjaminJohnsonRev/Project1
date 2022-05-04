package org.example.menu;

import java.util.Scanner;

public class ManagerMenu implements Menu{

    ManagerService managerService = new ManagerService();
    InitialMenu initialMenu = new InitialMenu();

    public void menu(){
        boolean loggedIn = true;

        System.out.println("Select an option: ");
        System.out.println("1: View all ticket applications ");
        System.out.println("2: Approve ticket application ");
        System.out.println("3: Deny ticket application ");
        System.out.println("4: View all logs ");
        System.out.println("5: View accounts for a specified user ");
        System.out.println("6: View all user accounts ");
        System.out.println("7: Log out ");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch(choice) {
            case 1:
                managerService.viewTicketApplications();
                break;
            case 2:
                managerService.confirmAccount();
                break;
            case 3:
                managerService.rejectAccount();
                break;
            case 4:
                //TODO implement or remove logs
                //managerService.viewLogs();
                break;
            case 5:
                managerService.viewCustomerAccounts();
                break;
            case 6:
                managerService.viewAllAccounts();
                break;
            case 7:
                System.out.println("You have logged out.");
                loggedIn = false;
                break;
            default:
                System.out.println("You must enter a number (1-7) from the menu. Enter 7 to log out. ");
                break;
        }

        if(loggedIn){
            menu();
        } else {
            initialMenu.iMenu();
        }

    }

    public void menu(User user){}
}
