package com.serv.one.demoserv;

import jakarta.servlet.annotation.WebServlet;
import com.serv.one.db.DBInfo;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
@WebServlet(urlPatterns = "/showall/*", loadOnStartup = 1)
public class DisplayAll extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Connection con=DBInfo.con;
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.println("<html>");
        pw.println("<body bgcolor='orange'>");
        pw.println("<center>");
        pw.println("<h2>View All Student Data</h2><BR><BR>");
        pw.println("<table border=1>");
        pw.println("<tr>");
        pw.println("<th>ID</th>");
        pw.println("<th>Age</th>");
        pw.println("<th>First</th>");
        pw.println("<th>Last</th>");
        pw.println("<th>Update</th>");
        pw.println("<th>Delete</th>");
        pw.println("</tr>");
        String str="select * from employees";
        try {
            PreparedStatement ps = con.prepareStatement(str);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String s1 = rs.getString("id");
                String s2 = rs.getString("age");
                String s3 = rs.getString("first");
                String s4 = rs.getString("last");
                pw.println("<tr>");
                pw.println("<td>" + s1 + "</td>");
                pw.println("<td>" + s2 + "</td>");
                pw.println("<td>" + s3 + "</td>");
                pw.println("<td>" + s4 + "</td>");
                pw.println("<td><a href=/updateForm?id1="+s1+">Update</a></td>");
                pw.println("<td><a href=/delete?id1=" + s1 + ">Delete</a></td>");
                pw.println("</tr>");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        pw.println("</table>");
        pw.println("<button onclick=\"window.location='/createForm';\">Create New Record</button>");
        pw.println("</center>");
        pw.println("</body></html>");

    }
}
