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


@WebServlet(urlPatterns = "/create/*", loadOnStartup = 1)
public class CreateServlet extends HttpServlet{
    public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException
    {
        int flag=0;
        int c=0;
        PrintWriter pw=res.getWriter();
        pw.println("<html>");
        pw.println("<body bgcolor='orange'>");
        pw.println("<center>");

        String age= req.getParameter("age");
        int ageInt=Integer.parseInt(age);
        String f= req.getParameter("first");
        String l= req.getParameter("last");
        System.out.println("::::"+age+"::::"+f+"::::"+l);
        Connection con= DBInfo.con;
        String str="insert into employees(id,age,first,last) values (?,?,?,?)";
        try
        {
            PreparedStatement ps=con.prepareStatement(str);
            ps.setInt(1,100+c++);
            //ps.setInt(2,10);
            ps.setInt(2,ageInt);
            //ps.setString(3,"DemoCreateF");
            ps.setString(3,f);
            //ps.setString(4,"DemoCreateL");
            ps.setString(4,l);
            flag=ps.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        System.out.println(c+":::"+flag);
        if(flag!=0)
        {
            pw.println("<h2>Record Created!</h2>");
            pw.println("<a href=/showall>BACK</a>");
        }
        else
        {
            pw.println("<h2>Record Not Created!</h2>");
            pw.println("<a href=/all>BACK</a>");
        }

        pw.println("</center>");
        pw.println("</body></html>");


    }
}
