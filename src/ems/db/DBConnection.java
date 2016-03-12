/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ems.db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author admin
 */
public class DBConnection 
{
        public static Connection connect()
		{
			Connection con=null;
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql:///ems";
				con=DriverManager.getConnection(url,"root","attinder");
			}
			catch(Exception e)
			{
				System.out.println("Connect()"+e);
			}
			return con;
		}
    }
    

