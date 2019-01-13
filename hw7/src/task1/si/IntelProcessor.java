package task1.si;

import java.util.Objects;

public class IntelProcessor implements IProcessor {
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
