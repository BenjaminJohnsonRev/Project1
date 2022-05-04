package org.example.dao;

import org.example.entity.Manager;

public interface ManagerDao {
    public void insert(Manager manager);
    public Manager getManagerByCredentials(String username, String password);
}
