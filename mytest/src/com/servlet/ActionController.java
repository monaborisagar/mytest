package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.employee;
import com.dao.employeeDao;
import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;
import com.util.utility;

/**
 * Servlet implementation class SaveServlet
 */
@WebServlet("/ActionController")
public class ActionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Date birthdate;
	private static final Double salary = null;
	private static final Byte gender = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("insert")) {
			System.out.println("inside insert");
			
			
			
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Invalid Username or Password');");
			pw.println("</script>");
			
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			// String birthdate=request.getParameter("");
			String birthdate = request.getParameter("birthdate");
			System.out.println("hh" + birthdate);
			String date2 = "";
			java.util.Date choseDate = null;

			SimpleDateFormat availDate = new SimpleDateFormat("yyyy-MM-dd");

			try {
				// General.getFormatedDateddMMyyyy(
				choseDate = (java.util.Date) availDate.parse(birthdate);
				SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
				date2 = formater.format(choseDate);
				System.out.println("aa:" + date2);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				System.out.println("aacat:");

				e1.printStackTrace();

			}
			byte gender = Byte.parseByte(request.getParameter("gender"));
			Double salary = Double.parseDouble(request.getParameter("salary"));
			String lang[] = request.getParameterValues("lang");
			System.out.println(name + " _" + address + "_" + "_" + birthdate + "_" + "_" + gender + "_" + salary);
			employee e = new employee();

			e.setName(name);
			e.setAddress(address);
			e.setBirthdate(choseDate);
			e.setGender(gender);
			e.setSalary(salary);
			int status = employeeDao.save(e);
			System.out.println("the status is " + status);
			if (status > 0) {
				out.print("<p>Record Insert successfully!</p>");
				request.getRequestDispatcher("index.jsp").include(request, response);
			} else {
				out.println("Sorry! unable to insert record");
			}

			employeeDao.storeEmployeSkilltable(lang);
		}
		if (action.equalsIgnoreCase("edit")) {

			String sid = request.getParameter("id");
			int id = Integer.parseInt(sid);
			System.out.println("Edit Servlet id " + id);
			employee e = employeeDao.getEmployeeById(id);
			request.setAttribute("emp", e);
			request.getRequestDispatcher("update.jsp").forward(request, response);
		}
		if (action.equalsIgnoreCase("update")) {

			String sid = request.getParameter("employeeid");
			int eid = Integer.parseInt(sid);
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String birthdate = request.getParameter("birthdate");
			System.out.println("hh" + birthdate);
			String date2 = "";
			java.util.Date choseDate = null;
			SimpleDateFormat availDate = new SimpleDateFormat("yyyy-MM-dd");
			try {
				choseDate = (java.util.Date) availDate.parse(birthdate);
				SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
				date2 = formater.format(choseDate);
				System.out.println("aa:" + date2);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				System.out.println("aacat:");

				e1.printStackTrace();

			}

			byte gender = Byte.parseByte(request.getParameter("gender"));
			out.print("gender" + gender);
			Double salary = Double.parseDouble(request.getParameter("salary"));

			int skilllanguage = 0;
			String languages = "";
			String lang[] = request.getParameterValues("lang");

			System.out.println(name + " _" + address + "_" + "_" + birthdate + "_" + "_" + gender + "_" + salary);
			employee e = new employee();
			System.out.println("editservlet 222");
			e.setEmployeeId(eid);
			e.setName(name);
			e.setAddress(address);
			e.setBirthdate(choseDate);
			// e.setGender(gender);
			e.setGender(gender);
			e.setSalary(salary);

			int status = employeeDao.update(e);
			if (status > 0) {
				out.print("<p>Record Update successfully!</p>");
				response.sendRedirect("view.jsp");
				
				// request.getRequestDispatcher("/ViewSevlet").include(request, response);
			} else {
				out.println("Sorry! unable to Update record");
			}

			try {
				System.out.println("employee id" + eid);
				// update EmployeeSkill15 set skillId=5 where employeeId=2011
				Connection con = utility.getConnection();
				PreparedStatement ps = con.prepareStatement("delete  from EmployeeSkill15 where employeeId=?");
				ps.setInt(1, eid);
				status = ps.executeUpdate();
				System.out.println("delete EmployeeSkill id" + eid);
				for (int i = 0; i < lang.length; i++) {
					// languages+=lang[i]+",";
					languages = lang[i];
					skilllanguage = Integer.parseInt(languages);
					System.out.println("skilllllllllllll" + skilllanguage);

					/*
					 * PreparedStatement
					 * ps1=con.prepareStatement("delete  from EmployeeSkill15 where employeeId=?");
					 * ps1.setInt(1,eid); status=ps1.executeUpdate();
					 */

					PreparedStatement ps1 = con
							.prepareStatement("insert into EmployeeSkill15(employeeId,skillId) values (?,?)");
					ps1.setInt(1, eid);
					ps1.setInt(2, skilllanguage);
					int m = ps1.executeUpdate();
					out.print("sss" + m);
					System.out.println("Raju" + eid);

					System.out.println("okk===========");

				}
				con.close();
			} catch (Exception ex) {
				System.out.println("eroooooooooooo");
				ex.printStackTrace();
			}

		}
		if (action.equalsIgnoreCase("delete")) {

			String sid = request.getParameter("id");
			int id = Integer.parseInt(sid);
			int status = employeeDao.delete(id);
			if (status > 0) {
				out.print("<p>Record Delete successfully!</p>");
				// request.getRequestDispatcher("index.html").include(request, response);
			} else {
				out.println("Sorry! unable to Delete record");
			}

			response.sendRedirect("view.jsp");
		}

	}
}
