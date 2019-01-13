package task2.si;

import task1.si.IProcessor;

import java.util.List;

public class ListCluster {
    private List<IProcessor> processors;

    public void setProcessors(List<IProcessor> processors) {
        this.processors = processors;
    }

    public void calculateTogether() {
        for (IProcessor processor: processors)
            processor.calculate();
    }
}
