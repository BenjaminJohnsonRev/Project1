package org.example.dao;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class ConnectionFactoryTest extends TestCase {

    @Test
    public void testGetConnection() {
        Connection connection = ConnectionFactory.getConnection();
        assertNotNull(connection);
    }

}