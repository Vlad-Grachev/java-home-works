package task1;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;

public class LoginServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        String password = req.getParameter("password");
        if(password.length() > 0){
            String login = req.getParameter("login");
            writer.println("<h1> Hello "  + login + "</h1>");
            writer.println("<h2> Password length is " + password.length() +  "</h2>");
        } else {
            writer.println("You've enetered empty password");
        }
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
