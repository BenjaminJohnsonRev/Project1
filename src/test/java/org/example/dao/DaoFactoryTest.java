package org.example.dao;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

public class DaoFactoryTest extends TestCase {
    @Test
    public void testGetManagerDao() {
        assertNotNull(DaoFactory.getManagerDao());
    }
    @Test
    public void testGetPostTicketDao() {
        assertNotNull(DaoFactory.getPostTicketDao());
    }
    @Test
    public void testGetEmployeeDao() {
        assertNotNull(DaoFactory.getEmployeeDao());
    }
    @Test
    public void testGetPastTicketDao() {
        assertNotNull(DaoFactory.getPastTicketDao());
    }
}