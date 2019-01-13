package task1.si;

public class Desktop {
    private IProcessor processor;
    private int memory;
    private double price;
    private int taskCount;

    public void setProcessor(IProcessor processor) {
        this.processor = processor;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public IProcessor getProcessor() {
        return processor;
    }

    public int getMemory() {
        return memory;
    }

    public double getPrice() {
        return price;
    }

    public void executeTask(){
        processor.calculate();
        System.out.println("Tasks executed: " + ++taskCount);
    }

    @Override
    public String toString() {
        return "Desktop{" +
                "processor=" + processor +
                ", memory=" + memory +
                ", price=" + price +
                '}';
    }
}
