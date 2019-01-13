package task2.si;

import task1.si.IProcessor;

import java.util.Set;

public class SetCluster {
    private Set<IProcessor> processors;

    public void setProcessors(Set<IProcessor> processors) {
        this.processors = processors;
    }

    public void calculateTogether() {
        for (IProcessor processor: processors)
            processor.calculate();
    }
}
