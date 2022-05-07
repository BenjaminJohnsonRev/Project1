package org.example;

import java.sql.Timestamp;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Timestamp timestamp1 = java.sql.Timestamp.valueOf("2007-09-23 10:10:10.02");
        Timestamp timestamp2 = java.sql.Timestamp.valueOf("2007-09-23 10:10:10.01999");
        System.out.println(timestamp2.compareTo(timestamp1));
    }
}
