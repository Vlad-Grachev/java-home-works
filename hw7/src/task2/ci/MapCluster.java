package task2.ci;

import task1.ci.IProcessor;

import java.util.Map;

public class MapCluster {
    Map<Integer, IProcessor> processors;

    public MapCluster(Map<Integer, IProcessor> processors){
        this.processors = processors;
    }

    public void calculateTogether() {
        for(int socketNumber = 0; socketNumber < processors.size(); socketNumber++)
            processors.get(socketNumber).calculate();
    }
}
