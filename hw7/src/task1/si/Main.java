package task1.si;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("task1-config.xml");
        Desktop cheapPC = (Desktop) context.getBean("cheapPC");
        Desktop expensivePC = (Desktop) context.getBean("expensivePC");

        System.out.println(cheapPC.toString());
        System.out.println(expensivePC.toString());
        System.out.println();
        cheapPC.executeTask();
        expensivePC.executeTask();
        cheapPC.executeTask();
    }
}
