package task3;

public class NewDesktop {
    private String cpu;
    private int memory;
    private String gpu;
    private int ssdVolume;

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public void setSsdVolume(int ssdVolume) {
        this.ssdVolume = ssdVolume;
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

    public int getSsdVolume() {
        return ssdVolume;
    }

    @Override
    public String toString() {
        return "NewDesktop{" +
                "cpu='" + cpu + '\'' +
                ", memory=" + memory +
                ", gpu='" + gpu + '\'' +
                ", ssdVolume=" + ssdVolume +
                '}';
    }
}
