package task2.ci;

import task1.ci.IProcessor;

import java.util.Set;

public class SetCluster {
    private Set<IProcessor> processors;

    public SetCluster(Set<IProcessor> processors) {
        this.processors = processors;
    }

    public void calculateTogether() {
        for (IProcessor processor: processors)
            processor.calculate();
    }
}
