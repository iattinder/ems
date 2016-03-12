/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ems.services;

import ems.beans.EmpBean;
import ems.db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author attinder
 */
public class LoginServices {
    
    public static EmpBean authenticateUser(String ur,String pass)
    {
    Connection con=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
     try{
            
            
            con=DBConnection.connect();
            ps=con.prepareStatement("select empid,emptype,empstatus,password from empmaster where username=?");
            
            ps.setString(1,ur);
           rs= ps.executeQuery();
            
            
            
            if(rs.next())
            {
                String pwd1=rs.getString("password");
                if(pass.equals(pwd1))
                {
                EmpBean objbean=new EmpBean();
                objbean.setEmpid(rs.getInt("empid"));
                objbean.setEmptype(rs.getString("emptype"));
                objbean.setEmpstatus(rs.getBoolean("empstatus"));
                
                return objbean;
                
                }
            }
            
            
        }
        catch(Exception e)
        {
            
             System.out.println(e);
        }
        
        
        finally{
            
            try{
                
                con.close();
                ps.close();
                
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        
        
        return null;
    }
    
    
    
    
    
}
