package task6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import task5.Parallelepiped;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("task6-config.xml");
        Parallelepiped pppd = (Parallelepiped) context.getBean("pppd");
        System.out.println("Parallelepiped volume: " + pppd.getVolume());
    }
}
