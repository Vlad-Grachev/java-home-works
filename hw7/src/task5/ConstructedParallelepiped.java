package task5;

public class ConstructedParallelepiped{
    private int height;
    private Rectangle base;

    public ConstructedParallelepiped(Rectangle base, int height){
        this.base = base;
        this.height = height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setBase(Rectangle base) {
        this.base = base;
    }

    public int getVolume() {
        return height * base.getArea();
    }
}
