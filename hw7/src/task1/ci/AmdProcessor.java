package task1.ci;

import java.util.Objects;

public class AmdProcessor implements IProcessor{
    private String model;
    private double frequency;

    public AmdProcessor(String model, double frequency) {
        this.frequency = frequency;
        this.model = model;
    }

    public void calculate() {
        System.out.println("Calculated by AMD processor. Model: " + model);
    }

    @Override
    public String toString() {
        return "AmdProcessor{" +
                "model='" + model + '\'' +
                ", frequency=" + frequency +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AmdProcessor that = (AmdProcessor) o;
        return Double.compare(that.frequency, frequency) == 0 &&
                model.equals(that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, frequency);
    }
}
