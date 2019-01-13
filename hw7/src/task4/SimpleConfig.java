package task4;

public class SimpleConfig {
    private String cpu = "Intel Core i7-8700";
    private int memory = 16;
    private String gpu = "MSI GeForce GTX 1060";
    private int ssdVolume = 256;

    public String getCpu() {
        return cpu;
    }

    public int getMemory() {
        return memory;
    }

    public String getGpu() {
        return gpu;
    }

    public int getSsdVolume() {
        return ssdVolume;
    }
}
