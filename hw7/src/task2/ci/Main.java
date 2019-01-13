package task2.ci;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("task2-config.xml");
        ListCluster listCluster = (ListCluster) context.getBean("ciListCluster");
        SetCluster setCluster = (SetCluster) context.getBean("ciSetCluster");
        MapCluster mapCluster = (MapCluster) context.getBean("ciMapCluster");

        listCluster.calculateTogether();
        System.out.println();
        setCluster.calculateTogether();
        System.out.println();
        mapCluster.calculateTogether();
    }
}
