package task2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class VerLoginServlet extends HttpServlet {
    private final String PASSWORD = "qwerty123";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        String login = req.getParameter("login");
        if (isLoginCorrect(login)) {
            String password = req.getParameter("password");
            if (isPasswordCorrect(password)){
                writer.println("<h1>Hi " + login + "!</h1>");
            } else {
                writer.println("<h1>Wrong password!</h1>");
            }
        } else {
            writer.println("<h1>Incorrect login! It can't contain digits.</h2>");
        }
        writer.close();
    }

    public boolean isLoginCorrect(String login){
        if (login.length() == 0)
            return false;
        for(int i = 0; i < login.length(); i++){
            char symb = login.charAt(i);
            if(('0' <= symb)&&(symb <= '9')) {
                return false;
            }
        }
        return true;
    }

    public boolean isPasswordCorrect(String password){
        return PASSWORD.equals(password);
    }
}
