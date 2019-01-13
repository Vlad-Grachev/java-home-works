package task3;

public class OldDesktop {
    private String cpu;
    private int memory;
    private String gpu;

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getCpu() {
        return cpu;
    }

    public int getMemory() {
        return memory;
    }

    public String getGpu() {
        return gpu;
    }

    @Override
    public String toString() {
        return "OldDesktop{" +
                "cpu='" + cpu + '\'' +
                ", memory=" + memory +
                ", gpu='" + gpu + '\'' +
                '}';
    }
}
