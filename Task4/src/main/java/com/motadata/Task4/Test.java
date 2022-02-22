package com.motadata.Task4;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test
{
    public static void main(String[] args)
    {

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Task4?autoReconnect=true&useSSL=false", "root", "Mind@123");
            DatabaseAccess obj=new DatabaseAccess();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
