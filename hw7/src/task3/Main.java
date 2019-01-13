package task3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("task3-config.xml");
        OldDesktop oldDesktop = (OldDesktop) context.getBean("oldPC");
        NewDesktop newDesktop = (NewDesktop) context.getBean("newPC");

        System.out.println(oldDesktop);
        System.out.println(newDesktop);
    }
}
