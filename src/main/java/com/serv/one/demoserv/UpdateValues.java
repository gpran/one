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

@WebServlet(urlPatterns = "/update/*", loadOnStartup = 1)
public class UpdateValues extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException
    {
        int flag=0;
        PrintWriter pw=res.getWriter();
        String uname=req.getParameter("id1");
        System.out.println("uname is is::::"+uname);
        int id=Integer.parseInt(uname);
        System.out.println("ID is::::"+id);
        pw.println("<html>");
        pw.println("<body bgcolor='orange'>");
        pw.println("<center>");

        String age= req.getParameter("age");
        int ageInt=Integer.parseInt(age);
        String f= req.getParameter("first");
        String l= req.getParameter("last");

        Connection con= DBInfo.con;
        String str="update employees set first= ?, last = ?, age= ? where id=?";
        try
        {
            PreparedStatement ps=con.prepareStatement(str);
            //ps.setString(1,"DemoUpdateF");
            //ps.setString(2,"DemoUpdateL");
            //ps.setInt(3,10);
            ps.setString(1,f);
            ps.setString(2,l);
            ps.setInt(3,ageInt);
            ps.setInt(4,id);
            System.out.println("Update Before");
            flag=ps.executeUpdate();
            System.out.println("Update After");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        System.out.println(uname+":::"+flag);
        if(flag!=0)
        {
            pw.println("<h2>Record Updated!</h2>");
            pw.println("<a href=/showall>BACK</a>");
        }
        else
        {
            pw.println("<h2>Record Not Updated!</h2>");
            pw.println("<a href=/showall>BACK</a>");
        }

        pw.println("</center>");
        pw.println("</body></html>");


    }
}
