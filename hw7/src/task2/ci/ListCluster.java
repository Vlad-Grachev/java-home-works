package task2.ci;

import task1.ci.IProcessor;

import java.util.List;

public class ListCluster {
    private List<IProcessor> processors;

    public ListCluster(List<IProcessor> processors) {
        this.processors = processors;
    }

    public void calculateTogether() {
        for (IProcessor processor: processors)
            processor.calculate();
    }
}
