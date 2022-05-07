package org.example.dao;

import org.example.entity.Employee;

public interface EmployeeDao {
    public void insert(Employee employee);
    public Employee getEmployeeByCredentials(String username, String password);
    public Employee getEmployeeById(int userId);

    //initialize and fill tables.
    public void initTables();
    public void fillTables();
}
