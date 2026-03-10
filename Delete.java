package com.test;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends GenericServlet {
	private static final long serialVersionUID = 1L;
   
    public Delete() {
        super();
       
    }


	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("id");

		
		
		
	    PrintWriter writer= response.getWriter();
	    response.setContentType("text/html");
	    
	  
	    writer.println("<h1 style=\"color:red;\">Email:"+email +"</h1>");
	   

	    
	    
	    try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/63rjdbc","root","Root");
		

		PreparedStatement preparedstatement =
		        con.prepareStatement("DELETE FROM person WHERE email=?");

	preparedstatement.setString(1, email);

	


	int row = preparedstatement.executeUpdate();

			
			
			//writer.println( " <h1 style=\"color: blue;\">:" + row+" /h1>");
			writer.println("<html>");
			writer.println("<head>");
			writer.println("<style>");
			writer.println("body { font-family: Arial; background-color: #f2f2f2; text-align: center; }");
			writer.println(".box { margin: 100px auto; width: 400px; padding: 20px; background: white; border-radius: 10px; box-shadow: 0 0 10px gray; }");
			writer.println(".success { color: green; font-size: 22px; font-weight: bold; }");
			writer.println(".btn { display: inline-block; margin-top: 20px; padding: 10px 15px; background: #007bff; color: white; text-decoration: none; border-radius: 5px; }");
			writer.println(".btn:hover { background: #0056b3; }");
			writer.println("</style>");
			writer.println("</head>");
			writer.println("<body>");

			writer.println("<div class='box'>");
			writer.println("<div class='success'>" + row + " row deleted successfully</div>");

			writer.println("<a href='managment.html' class='btn'>Go Home</a>");

			writer.println("</div>");
			writer.println("</body>");
			writer.println("</html>");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    writer.close(); 
	}


	
	}


