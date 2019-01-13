package task4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import task3.NewDesktop;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("task4-config.xml");
        NewDesktop concreteDesktop = (NewDesktop) context.getBean("concretePC");

        System.out.println(concreteDesktop.toString());
    }
}
