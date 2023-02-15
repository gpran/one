package com.serv.one.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBInfo {
    public static Connection con;
    static
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost/tutorialspoint","root","root");
            System.out.println("Database Connected");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
