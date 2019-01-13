package task1.ci;

public class Desktop {
    private IProcessor processor;
    private int memory;
    private double price;
    private int taskCount;

    public Desktop(IProcessor processor, int memory, double price) {
        this.processor = processor;
        this.memory = memory;
        this.price = price;
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
