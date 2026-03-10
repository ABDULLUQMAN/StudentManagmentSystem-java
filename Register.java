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


@WebServlet("/Register")
public class Register extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Register() {
        super();
        
    }

	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int s_no = Integer.parseInt(request.getParameter("s_no"));
		String fullname=request.getParameter("fullname");
		String fname=request.getParameter("fname");
		String mname=request.getParameter("mname");
		int age=Integer.parseInt(request.getParameter("age"));
		String gender=request.getParameter("gender");
		String mail=request.getParameter("mail");
		String phone=request.getParameter("phone");
		String qualification=request.getParameter("qualification");
		
		String location=request.getParameter("location");
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		writer.println("<h1 style=\"color:red;\">Serial_No: " + s_no+"</h1>");
		writer.println("<h1 style=\"color:red;\">fullname: " + fullname+"</h1>");
		writer.println("<h1 style=\"color:red;\">fname: " + fname+"</h1>");
		writer.println("<h1 style=\"color:red;\">mname: " + mname+"</h1>");
		writer.println("<h1 style=\"color:black;\">age: " + age+"</h1>");
		writer.println("<h1 style=\"color:red;\">gender: " + gender+"</h1>");
		writer.println("<h1 style=\"color:red;\">email: " + mail+"</h1>");
		writer.println("<h1 style=\"color:red;\">phone: " + phone+"</h1>");
		writer.println("<h1 style=\"color:red;\">qualification: " +qualification +"</h1>");
		writer.println("<h1 style=\"color:red;\">location: " + location+"</h1>");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/63rjdbc", "root","Root");
			PreparedStatement preparedstatement=connection.prepareStatement("insert into person values(?,?,?,?,?,?,?,?,?,?)");
			
			preparedstatement.setInt(1,s_no);
			preparedstatement.setString(2,fullname);
			preparedstatement.setString(3,fname);
			preparedstatement.setString(4,mname);
			preparedstatement.setInt(5,age);
			preparedstatement.setString(6,gender);
			preparedstatement.setString(7,mail);
			preparedstatement.setString(8,phone);
			preparedstatement.setString(9,qualification);
			preparedstatement.setString(10,location);
			int row = preparedstatement.executeUpdate();
			if (row > 0) {
	            writer.println("<h1 style='color:green;'>1 Row Inserted Successfully</h1>");
	        } else {
	            writer.println("<h1 style='color:red;'>Insert Failed</h1>");
	        }
			//writer.println("<h1 style=\"color:green;\">:"+ row + ": row inserted </h1>");
			//preparedstatement.close();
			//connection.close();

			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			 writer.println("<h2 style='color:red;'>ERROR: " + e.getMessage() + "</h2>");
			//writer.println("<h1 style=\"color:green;\">:"+ row + ": row inserted </h1>");
			e.printStackTrace();
			
		}
	
		writer.close();
		
	}	



	}


