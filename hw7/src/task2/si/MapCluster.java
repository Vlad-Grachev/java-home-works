package task2.si;

import task1.si.IProcessor;

import java.util.Map;

public class MapCluster {
    Map<Integer, IProcessor> processors;

    public void setProcessors(Map<Integer, IProcessor> processors){
        this.processors = processors;
    }

    public void calculateTogether() {
        for(int socketNumber = 0; socketNumber < processors.size(); socketNumber++)
            processors.get(socketNumber).calculate();
    }
}
