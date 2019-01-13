package task1.si;

import java.util.Objects;

public class AmdProcessor implements IProcessor {
    private String model;
    private double frequency;

    public void setModel(String model) {
        this.model = model;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public String getModel() {
        return model;
    }

    public double getFrequency() {
        return frequency;
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
