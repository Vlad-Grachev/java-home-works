package task1.ci;

import java.util.Objects;

public class IntelProcessor implements IProcessor{
    private String model;
    private double frequency;

    public IntelProcessor(String model, double frequency) {
        this.frequency = frequency;
        this.model = model;
    }

    public void calculate() {
        System.out.println("Calculated by Intel processor. Model: " + model);
    }

    @Override
    public String toString() {
        return "IntelProcessor{" +
                "model='" + model + '\'' +
                ", frequency=" + frequency +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntelProcessor that = (IntelProcessor) o;
        return Double.compare(that.frequency, frequency) == 0 &&
                model.equals(that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, frequency);
    }
}
