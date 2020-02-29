
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet implementation class actioncontroller
 */
@WebServlet("/actioncontroller")
public class actioncontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String naw="my name is mona";
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		System.out.println(action);
		if(action.equalsIgnoreCase("login"))
		{
			
			
			String name = request.getParameter("username");
			String password = request.getParameter("password");
			
			if (password.equals("admin") && name.equalsIgnoreCase("admin")) {
				 
				 
				session.setAttribute("name", naw);
				response.sendRedirect("home.jsp");
			}
		}
		
		if(action.equalsIgnoreCase("logout"))
		{
			response.sendRedirect("index.jsp");
			
			session.setAttribute("name", null);
		}
		if(action.equalsIgnoreCase("registration"))
		{
			try{  
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/mona","root","root");  
				//here sonoo is database name, root is username and password  
				Statement stmt=con.createStatement();  
				ResultSet rs=stmt.executeQuery("select * from emp");  
				while(rs.next())  
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
				con.close();  
				}catch(Exception e){ System.out.println(e);}  
				}  
			
			String name = request.getParameter("username");
			String password = request.getParameter("password");
			String phoneno = request.getParameter("phnenumber");
			response.sendRedirect("index.jsp");
			
			session.setAttribute("name", null);
		}
	}
}
