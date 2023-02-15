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

@WebServlet(urlPatterns = "/delete/*", loadOnStartup = 1)
public class DeleteValues extends HttpServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException
    {
        int flag=0;
        PrintWriter pw=res.getWriter();
        String uname=req.getParameter("id1");
        pw.println("<html>");
        pw.println("<body bgcolor='orange'>");
        pw.println("<center>");


        Connection con= DBInfo.con;
        String str="delete from employees where id=?";
        try
        {
            PreparedStatement ps=con.prepareStatement(str);
            ps.setString(1,uname);
            flag=ps.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        System.out.println(uname+":::"+flag);
        if(flag!=0)
        {
            pw.println("<h2>Record Deleted!</h2>");
            pw.println("<a href=/showall>BACK</a>");
        }
        else
        {
            pw.println("<h2>Record Not Deleted!</h2>");
            pw.println("<a href=/showall>BACK</a>");
        }

        pw.println("</center>");
        pw.println("</body></html>");


    }
}
