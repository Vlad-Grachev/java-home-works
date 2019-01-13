package task7;

public abstract class RightPrism {
    private IShape base;
    private int height;

    abstract public IShape getBase();

    public RightPrism(IShape base, int height) {
        this.base = base;
        this.height = height;
    }

    public double getVolume(){
        return base.getArea() * height;
    }
}
