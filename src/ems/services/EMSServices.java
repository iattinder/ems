/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ems.services;

import ems.db.DBConnection;
import ems.beans.EmpBean;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class EMSServices
{
    static public boolean addEmployee(EmpBean objbean)
    {
	Connection con=null;
	PreparedStatement pstmt=null;
        
	try
	{
		con=DBConnection.connect();
                
                
                
		pstmt=con.prepareStatement("insert into empmaster(empid,username,password,emptype,empstatus,name,dob,address,email,gender) values(?,?,?,?,?,?,?,?,?,?)");
		pstmt.setInt(1,objbean.getEmpid());
                pstmt.setString(2,objbean.getUsername());
		pstmt.setString(3,objbean.getPassword());
                pstmt.setString(4,objbean.getEmptype());
                pstmt.setBoolean(5,objbean.isEmpstatus());
		pstmt.setString(6,objbean.getName());
                pstmt.setDate(7,Date.valueOf(objbean.getDob()));
                pstmt.setString(8,objbean.getAddress());
                pstmt.setString(9,objbean.getEmail());
                pstmt.setBoolean(10,objbean.isGender());
		int i=pstmt.executeUpdate();
		if(i>0)
		{
			return true;
		}	
	}
                    catch(Exception e)
                    {
                        e.printStackTrace(System.out);
                    } 
                finally
                {
                     try
                     {
                         pstmt.close();
                         con.close();
                         
                     }
                        catch(Exception e)
                        {
                        System.out.println(e);	
                        }
                }
        return false;
    }

static public ArrayList getAllEmployees()
{
	ArrayList<EmpBean>al=null;
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try
	{
		con=DBConnection.connect();
		pstmt=con.prepareStatement("select * from empmaster");
		rs=pstmt.executeQuery();
		al=new ArrayList<EmpBean>();
		while(rs.next())
		{
			EmpBean objbean=new EmpBean();
                        objbean.setEmpid(rs.getInt("empid"));
                        objbean.setUsername(rs.getString("username"));
                        objbean.setPassword(rs.getString("password"));
                        objbean.setEmptype(rs.getString("emptype"));
                        objbean.setEmpstatus(rs.getBoolean("empstatus"));
                        objbean.setName(rs.getString("name"));
                        objbean.setDob(rs.getString("dob"));
                        objbean.setAddress(rs.getString("address"));
                        objbean.setEmail(rs.getString("email"));
                        objbean.setGender(rs.getBoolean("gender"));
			al.add(objbean);
		}
                return al;
	}
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }  
                        finally
                        {
                             try
                             {
                                pstmt.close();
                                con.close();
                                rs.close();
                             }
                               catch(Exception e)
                                {
                                    System.out.println(e);	
                                }
                        }
        return null;
 }

static public boolean updateEmployee(EmpBean objbean)
    {
        
        Connection con=null;
       PreparedStatement ps=null;
        
        try{
            
            
            con=DBConnection.connect();
            ps=con.prepareStatement("update empmaster set username =?,password =?,emptype =?,empstatus =?,name =?,dob=?,address=?,email=?,gender =? where empid=?");
            ps.setInt(10,objbean.getEmpid());
            ps.setString(1,objbean.getUsername());
            ps.setString(2,objbean.getPassword());
            ps.setString(3,objbean.getEmptype());
            ps.setBoolean(4,objbean.isEmpstatus());
            ps.setString(5,objbean.getName());
            ps.setDate(6,Date.valueOf(objbean.getDob()));
            ps.setString(7,objbean.getAddress());
            ps.setString(8,objbean.getEmail());
            ps.setBoolean(9,objbean.isGender());
            
            
            
            
            
            int i=ps.executeUpdate();
            
            if(i>0)
            {
                
                
                return true;
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
        
        
        return false;
    }

static public int maxId()
{

    
    Connection con=null;
	PreparedStatement ps=null;
        ResultSet rs=null;
        int idcount=0;
	try
	{
		con=DBConnection.connect();
                ps=con.prepareStatement("select max(empid) from empmaster");
                rs=ps.executeQuery();
                
                if(rs.next())
                {
                    idcount=rs.getInt("max(empid)");
                    
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
        return idcount;
}
        
       

static public String forgotPassword(String s)
{

    return s;
}
    
static public EmpBean getById(int empId)
{

    
    
    
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try
	{
		con=DBConnection.connect();
		pstmt=con.prepareStatement("select * from empmaster where empid =?");
                pstmt.setInt(1,empId);
		rs=pstmt.executeQuery();
                EmpBean objbean=new EmpBean();
		
		while(rs.next())
		{
			
                        objbean.setEmpid(rs.getInt("empid"));
                        objbean.setUsername(rs.getString("username"));
                        objbean.setPassword(rs.getString("password"));
                        objbean.setEmptype(rs.getString("emptype"));
                        objbean.setEmpstatus(rs.getBoolean("empstatus"));
                        objbean.setName(rs.getString("name"));
                        objbean.setDob(rs.getString("dob"));
                        objbean.setAddress(rs.getString("address"));
                        objbean.setEmail(rs.getString("email"));
                        objbean.setGender(rs.getBoolean("gender"));
			
		}
                return objbean;
	}
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }  
                        finally
                        {
                             try
                             {
                                pstmt.close();
                                con.close();
                                rs.close();
                             }
                               catch(Exception e)
                                {
                                    System.out.println(e);	
                                }
                        }
        return null;
    

}
    
        
    


}



