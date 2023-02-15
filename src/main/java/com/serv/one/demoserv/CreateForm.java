package com.serv.one.demoserv;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/createForm/*", loadOnStartup = 1)
public class CreateForm extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException{
        int flag=0;
        int c=0;
        PrintWriter pw=res.getWriter();
        pw.println("<html>");
        pw.println("<body bgcolor='orange'>");
        pw.println("<center>");
        pw.println("<form action=\"/create\" method='post'>\n" +
                "\t\tEnter Age<input type=\"text\" name=\"age\"><br>\n" +
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
    /**
     * <html>
     *   <body bgcolor=cyan>
     *    <h1>Registration page(database connectivity)</h1>
     *    <form action="servlet/RegDB" method='post'>
     * 		Enter username<input type="text" name="fname">
     * 		Enter password<input type="password" name="pass">
     * 		Enter usertype<input type="text" name="utype">
     * 		<input type="submit">
     * 		<BR>
     * 		<a href="LoginDB.html">Already a user,sign in</a>
     *    </form>
     *   </body>
     * </html>
     * **/
}
