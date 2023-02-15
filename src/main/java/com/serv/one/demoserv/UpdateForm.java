package com.serv.one.demoserv;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/updateForm/*", loadOnStartup = 1)
public class UpdateForm extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException {
        int flag=0;
        int c=0;
        String uname=req.getParameter("id1");
        PrintWriter pw=res.getWriter();
        pw.println("<html>");
        pw.println("<body bgcolor='orange'>");
        pw.println("<center>");
        pw.println("<form action=\"/update\" method='post'>\n" +
                "\t\tEnter Age<input type=\"text\" name=\"age\"><br>\n" +
                "\t\t<input type=\"hidden\" name =\"id1\" value=\""+uname+"\">\n"+
                "\t\tEnter First Name<input type=\"text\" name=\"first\"><br>\n" +
                "\t\tEnter Last Name<input type=\"text\" name=\"last\"><br>\n" +
                "\t\t<input type=\"submit\">\n" +
                "\t\t<BR>\n" +
                "   </form>");
        //res.sendRedirect();
        pw.println("<a href=/showall>BACK</a>");
        pw.println("</center>");
        pw.println("</body></html>");
    }
}
