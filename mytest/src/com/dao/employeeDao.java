package com.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.employee;
import com.util.utility;



public class employeeDao {
	
	
	
	
	
	  public static int save(employee e){  
	        int status=0;  
	        
	        try{  
	        	System.out.println("raj");
	        	System.out.println("name ="+e.getName()+"date = "+e.getBirthdate2()+"add ="+e.getAddress()+"gender ="+e.getGender()+"salary ="+e.getSalary());
	        	
	            
	        	
      java.sql.Date sqlDate = new java.sql.Date(e.getBirthdate().getTime());
	        	Connection con=utility.getConnection();
	            System.out.println("test1");
	           PreparedStatement ps=con.prepareStatement(  
	                         "insert into Employee15(name,address,gender,salary,birthDate) values (?,?,?,?,?)");  
	            ps.setString(1,e.getName());  
	            ps.setString(2,e.getAddress());  
	            ps.setByte(3,e.getGender());  
	            ps.setDouble(4, e.getSalary());
	            ps.setDate(5, sqlDate);
	            System.out.println("test1");
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
	  
	  public static int update(employee e){  
	        int status=0;  
	        try{ 
	            java.sql.Date sqlDate = new java.sql.Date(e.getBirthdate().getTime());

	        	   System.out.println("editservlet update");
	        //	java.sql.Date sqlDate = new java.sql.Date(e.getBirthdate().getTime());
	            Connection con=utility.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "update Employee15 set name=?,address=?,gender=?,salary=?,birthDate=? where employeeId=?"); 
	          //  name,address,gender,salary,birthDate
	            ps.setString(1,e.getName());  
	            ps.setString(2,e.getAddress());  
	            ps.setByte(3,e.getGender());  
	            ps.setDouble(4,e.getSalary()); 
	            ps.setDate(5,sqlDate);
	            ps.setInt(6,e.getEmployeeId());  
	              
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
	  
	  
	  public static employee getEmployeeById(int id){  
	       employee e=new employee();  
	       System.out.println("employeeDao id "+id);

	       //raju
	       List<employee> list2=new ArrayList<employee>();  
	        //System.out.println("okkkkkkkkkkkkkk");  
	        try{  
	          //  System.out.println("try");  
	            Connection con=utility.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from EmployeeSkill15 where employeeId=?"); 
	            ps.setInt(1,id);
	            ResultSet rs=ps.executeQuery();  
	           // System.out.println("try");  
	            while(rs.next()){  
	            	employee e1=new employee();  
	                e1.setEmployeeSkillid(rs.getInt(1));  
	                e1.setSkillemployeeid(rs.getInt(2));  
	                
	                list2.add(e1);
	               
	                
	            }
	            System.out.println("size"+list2.size());
	           // System.out.println("dddddddddd"+list1.size());
	            con.close(); 
	           // return list1;
	        }catch(Exception e1){e1.printStackTrace();}  
	          
	          

	       //raju
	       
	        try{  
	            Connection con=utility.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from Employee15 where employeeId=?");  
	            ps.setInt(1,id);  
	            ResultSet rs=ps.executeQuery();  
	            if(rs.next()){  
	                e.setEmployeeId(rs.getInt(1));  
	                e.setName(rs.getString(2));  
	                e.setAddress(rs.getString(3));  
	                e.setGender(rs.getByte(4));  
	                e.setSalary(rs.getDouble(5));  
	                e.setBirthdate(rs.getDate(6));
	             }  
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return e;  
	    }  
	  
	  
	  public static int delete(int id){  
	        int status=0; 
	       // delete  from EmployeeSkill15 where employeeId=1014;
	        try
	        {
	        	Connection con=utility.getConnection();  
	            PreparedStatement ps=con.prepareStatement("delete  from EmployeeSkill15 where employeeId=?");  
	            ps.setInt(1,id);  
	            status=ps.executeUpdate();  
	             System.out.println("delete EmployeeSkill id"+id); 
	            con.close();	
	        }catch(Exception e){e.printStackTrace();}
	        try{  
	            Connection con=utility.getConnection();  
	            PreparedStatement ps=con.prepareStatement("delete from Employee15 where employeeId=?");  
	            ps.setInt(1,id);  
	            status=ps.executeUpdate();  
	            System.out.println("delete Employee15 id"+id); 
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return status;  
	    }  
	  
	  
	  public static List<employee> getAllEmployees(){  
	        List<employee> list=new ArrayList<employee>();  
	          
	        try{  
	            Connection con=utility.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from Employee15");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	            	employee e=new employee();  
	                e.setEmployeeId(rs.getInt(1));  
	                e.setName(rs.getString(2));  
	                e.setAddress(rs.getString(3));  
	                e.setGender(rs.getByte(4));  
	                e.setSalary(rs.getDouble(5));
	                e.setBirthdate(rs.getDate(6));
	                list.add(e);  
	            }  
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    }
	  
	  public static List<employee> getAllEmployeeSkill(){  
	        List<employee> list1=new ArrayList<employee>();  
	        //System.out.println("okkkkkkkkkkkkkk");  
	        try{  
	          //  System.out.println("try");  
	            Connection con=utility.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from EmployeeSkill15");  
	            ResultSet rs=ps.executeQuery();  
	           // System.out.println("try");  
	            while(rs.next()){  
	            	employee e=new employee();  
	                e.setEmployeeSkillid(rs.getInt(1));  
	                e.setSkillemployeeid(rs.getInt(2));  
	                
	                list1.add(e);
	                
	            }  
	           // System.out.println("dddddddddd"+list1.size());
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list1;  
	    }
	  
	  
	
	  public static List<employee> getAllSkill(){  
		  ArrayList<employee> skillMasterArrayList = new ArrayList<employee>();
	          
	        try{  
	            Connection con=utility.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from SkilMaster");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	            	employee e=new employee();  
	            	e.setSkillId(rs.getInt("skillid"));
					e.setSkillname(rs.getString("name"));
	                skillMasterArrayList.add(e); 
	                System.out.println(e.getSkillname());
					System.out.println(e.getSkillId());
	            } 
	/*            request.setAttribute("skillMasterArrayList", skillMasterArrayList);
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);

*/				System.out.println(skillMasterArrayList.size());
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return skillMasterArrayList;  
	    }
	  
	  
	  public static void storeEmployeSkilltable(String[] lang)
	  {
		  String languages;
		  int skilllanguage;
		  int a=0;
			try {
				System.out.println("okkkkkkkkk44");

				Connection con1 = utility.getConnection();
				PreparedStatement ps1 = con1.prepareStatement(
						"SELECT employeeId FROM    Employee15 WHERE  employeeId = IDENT_CURRENT('Employee15')");
				System.out.println("okkkkkkkkk55");
				
				ResultSet rs1 = ps1.executeQuery();
				while(rs1.next())
				{
					 a = rs1.getInt("employeeId");
					System.out.println("okkkkkkkkk"+a);
				}
					
					for (int i = 0; i < lang.length; i++) {
						 languages = lang[i];
						skilllanguage = Integer.parseInt(languages);

						PreparedStatement ps = con1
								.prepareStatement("insert into EmployeeSkill15(employeeId,skillId) values (?,?)");
						ps.setInt(1, a);
						ps.setInt(2, skilllanguage);
						int m = ps.executeUpdate();
						System.out.println("okkkkkkkkk1"+m);

					}

				con1.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		  
		  
		  
	  }
	  
}
