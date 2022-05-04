package org.example.dao;

public class DaoFactory {
    private static ManagerDao managerDao;
    private static PostTicketDao postTicketDao;
    private static EmployeeDao employeeDao;
    private static PastTicketDao pastTicketDao;


    // private constructor, intentionally disallow instantiation of this class:
    private DaoFactory() {
    }

    public static ManagerDao getManagerDao() {
        if (managerDao == null) {
            managerDao = new ManagerDaoImpl();
        }
        return managerDao;
    }

    public static PostTicketDao getPostTicketDao() {
        if (postTicketDao == null) {
            postTicketDao = new PostTicketDaoImpl();
        }
        return postTicketDao;
    }

    public static EmployeeDao getEmployeeDao() {
        if (employeeDao == null) {
            employeeDao = new EmployeeDaoImpl();
        }
        return employeeDao;
    }

    public static PastTicketDao getPastTicketDao() {
        if (pastTicketDao == null) {
            pastTicketDao = new PastTicketDaoImpl();
        }
        return pastTicketDao;
    }


}
