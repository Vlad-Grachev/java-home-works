package task7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("task7-config.xml");
        RightPrism parallelepiped = (RightPrism) context.getBean("parallelepiped");
        RightPrism cylinder = (RightPrism) context.getBean("cylinder");

        System.out.println("Parallelepiped's base: " + parallelepiped.getBase());
        System.out.println("Parallelepiped's volume: " +
                String.format("%.2f", parallelepiped.getVolume()));
        System.out.println();
        System.out.println("Cylinder's base: " + cylinder.getBase());
        System.out.println("Cylinder's volume: " +
                String.format("%.2f", cylinder.getVolume()));
    }
}
