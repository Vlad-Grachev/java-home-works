package servlets;

import users.UserManager;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        String userStatus = (String) req.getSession().getAttribute("userStatus");
        String useCookies = req.getParameter("useCookies");

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        if (login.equals("") && password.equals("")) {
            if (userStatus != null && userStatus.equals("auth")) {
                login = (useCookies == null) ? getSessionAttribute(req, "userLogin") :
                        getCookieValueByName(req, "userLogin");
                password = (useCookies == null) ? getSessionAttribute(req, "userPassword") :
                        getCookieValueByName(req, "userPassword");
            } else {
                req.getSession().setAttribute("userStatus", "reg");
                resp.sendRedirect("registrate.html");
            }
        }

        UserManager manager = new UserManager(getServletContext().getRealPath("users.txt"));

        if(userStatus != null && userStatus.equals("reg")){
            manager.addUser(login, password);
            req.getSession().setAttribute("userStatus", null);
            resp.sendRedirect("login.html");
        } else {
            if (manager.isLoginCorrect(login)) {
                if (manager.isPasswordCorrect(login, password)) {
                    req.getSession().setAttribute("userStatus", "auth");
                    if(useCookies == null)
                        addAttributes(req, login, password);
                    else
                        addCookies(resp, login, password);
                    writer.println("<h1>Welcome back, " + login + "</h1>");
                } else {
                    req.getSession().setAttribute("userStatus", null);
                    writer.println("<h1>You've entered a wrong password</h1>");
                }
            } else {
                req.getSession().setAttribute("userStatus", "reg");
                resp.sendRedirect("registrate.html");
            }
        }

    }

    private String getCookieValueByName(HttpServletRequest req, String cookieName){
        String cookieValue = null;
        Cookie[] cookies = req.getCookies();
        int i = 0;
        while (cookies != null && i < cookies.length) {
            if(cookies[i].getName().equals(cookieName)) {
                cookieValue = cookies[i].getValue();
                break;
            }
            i++;
        }
        return cookieValue;
    }

    private void addCookies(HttpServletResponse resp, String... values){
        Cookie loginCookie = new Cookie("userLogin", values[0]);
        loginCookie.setMaxAge(60);
        Cookie passwordCookie = new Cookie("userPassword", values[1]);
        passwordCookie.setMaxAge(60);
        resp.addCookie(loginCookie);
        resp.addCookie(passwordCookie);
    }

    private String getSessionAttribute(HttpServletRequest req, String attributeName){
        return (String) req.getSession().getAttribute(attributeName);
    }

    private void addAttributes(HttpServletRequest req, String... attributes){
        req.getSession().setAttribute("userLogin", attributes[0]);
        req.getSession().setAttribute("userPassword", attributes[1]);
    }
}
