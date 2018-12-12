package task4;

import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.email.Recipient;
import org.simplejavamail.mailer.MailerBuilder;

import javax.mail.Message;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class MailSender extends HttpServlet {
    private final String login = "16xq7y@gmail.com";
    private final String password = "ro9svlcq";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String to = req.getParameter("address");
        String cc = req.getParameter("cc");
        String subject = req.getParameter("subject");
        String content = req.getParameter("content");

        Email email = EmailBuilder.startingBlank()
                .from(login)
                .to(to)
                .cc(extractCCs(cc))
                .withSubject(subject)
                .withPlainText(content)
                .buildEmail();

        MailerBuilder
                .withSMTPServer("smtp.gmail.com", 25, login, password)
                .buildMailer()
                .sendMail(email);
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<h1>Message sent</h2>");
    }

    public List<Recipient> extractCCs(String cc){
        List<Recipient> recipients = new LinkedList<>();
        if (cc.length() != 0) {
            String[] ccArr = cc.split("\\s*,\\s*");
            for (String addr : ccArr) {
                recipients.add(new Recipient("", addr, Message.RecipientType.CC));
            }
        }
        return recipients;
    }
}
