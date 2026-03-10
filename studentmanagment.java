package com.pet;

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
import java.sql.ResultSet;

@WebServlet("/Display01")
public class studentmanagment extends GenericServlet {

    private static final long serialVersionUID = 1L;

    public void service(ServletRequest request, ServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        writer.println("<html><head>");
        writer.println("<title>Display Students</title>");

        // Matching your homepage design
        writer.println("<style>");
        writer.println("body{background:#00ffff;font-family:Arial;text-align:center;}");
        writer.println("h1{color:black;}");
        writer.println("table{margin:auto;background:white;border-collapse:collapse;}");
        writer.println("th,td{border:1px solid black;padding:8px;}");
        writer.println("th{background:blue;color:white;}");
        writer.println("</style>");
        writer.println("</head><body>");

        writer.println("<h1>STUDENT DETAILS 🎓</h1>");

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/63rjdbc", "root", "Root");

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM person");

            ResultSet rs = ps.executeQuery();

            writer.println("<table>");
            writer.println("<tr>");
            writer.println("<th>Initial</th>");
            writer.println("<th>Full Name</th>");
            writer.println("<th>Father Name</th>");
            writer.println("<th>Mother Name</th>");
            writer.println("<th>Age</th>");
            writer.println("<th>Gender</th>");
            writer.println("<th>Email</th>");
            writer.println("<th>Phone</th>");
            writer.println("<th>Qualification</th>");
            writer.println("<th>Location</th>");
            writer.println("</tr>");

            while (rs.next()) {
                writer.println("<tr>");
                writer.println("<td>" + rs.getString(1) + "</td>");
                writer.println("<td>" + rs.getString(2) + "</td>");
                writer.println("<td>" + rs.getString(3) + "</td>");
                writer.println("<td>" + rs.getString(4) + "</td>");
                writer.println("<td>" + rs.getInt(5) + "</td>");
                writer.println("<td>" + rs.getString(6) + "</td>");
                writer.println("<td>" + rs.getString(7) + "</td>");
                writer.println("<td>" + rs.getString(8) + "</td>");
                writer.println("<td>" + rs.getString(9) + "</td>");
                writer.println("<td>" + rs.getString(10) + "</td>");
                writer.println("</tr>");
            }

            writer.println("</table>");

            rs.close();
            ps.close();
            connection.close();

        } catch (Exception e) {
            writer.println("<h2 style='color:red;'>ERROR: " + e.getMessage() + "</h2>");
        }

        writer.println("<br><br>");
        writer.println("<a href='index.html' style='text-decoration:none;'>⬅ Back to Home</a>");
        writer.println("</body></html>");
    }
}
 

