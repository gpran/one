package com.serv.one.demoserv;

import com.serv.one.db.DBInfo;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(urlPatterns = "/showone/*", loadOnStartup = 1)
public class DisplayById extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uname=request.getParameter("id1");
        Connection con= DBInfo.con;
        response.setContentType("text/html");

        String str="select * from employees where id=?";
        try {
            PreparedStatement ps = con.prepareStatement(str);
            ps.setString(1,uname);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String s1 = rs.getString("id");
                String s2 = rs.getString("age");
                String s3 = rs.getString("first");
                String s4 = rs.getString("last");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
