package task1.ci;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("task1-config.xml");
        Desktop officePC = (Desktop) context.getBean("officePC");
        Desktop gamingPC = (Desktop) context.getBean("gamingPC");

        System.out.println(officePC.toString());
        System.out.println(gamingPC.toString());
        System.out.println();
        officePC.executeTask();
        gamingPC.executeTask();
        officePC.executeTask();
    }
}
