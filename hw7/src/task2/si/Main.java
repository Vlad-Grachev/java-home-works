package task2.si;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("task2-config.xml");
        ListCluster listCluster = (ListCluster) context.getBean("siListCluster");
        SetCluster setCluster = (SetCluster) context.getBean("siSetCluster");
        MapCluster mapCluster = (MapCluster) context.getBean("siMapCluster");

        listCluster.calculateTogether();
        System.out.println();
        setCluster.calculateTogether();
        System.out.println();
        mapCluster.calculateTogether();
    }
}
