package task5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private static Parallelepiped getBeanWiredByType(){
        ApplicationContext context = new ClassPathXmlApplicationContext("task5-config/by-type.xml");
        return (Parallelepiped) context.getBean("pppd");
    }

    private static Parallelepiped getBeanWiredByName(){
        ApplicationContext context = new ClassPathXmlApplicationContext("task5-config/by-name.xml");
        return (Parallelepiped) context.getBean("pppd");
    }

    private static ConstructedParallelepiped getConstructorWiredBean(){
        ApplicationContext context = new ClassPathXmlApplicationContext("task5-config/constructor.xml");
        return (ConstructedParallelepiped) context.getBean("pppd");
    }

    private static Parallelepiped getBeanWithoutAutowaring(){
        ApplicationContext context = new ClassPathXmlApplicationContext("task5-config/no.xml");
        return (Parallelepiped) context.getBean("pppd");
    }

    public static void main(String[] args) {
        Parallelepiped wiredByTypePppd = getBeanWiredByType();
        System.out.println("Result for autowiring by type: " +
                wiredByTypePppd.getVolume());

        Parallelepiped wiredByNamePppd = getBeanWiredByName();
        System.out.println("Result for autowiring by name: " +
                wiredByNamePppd.getVolume());

        ConstructedParallelepiped constructorWiredPppd = getConstructorWiredBean();
        System.out.println("Result for constructor wired one: " +
                constructorWiredPppd.getVolume());

        Parallelepiped noWaringPppd = getBeanWithoutAutowaring();
        System.out.println("Result for no-autowiring one: " +
                noWaringPppd.getVolume());
    }
}
