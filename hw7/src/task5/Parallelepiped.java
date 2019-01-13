package task5;

public class Parallelepiped {
    private Rectangle base;
    private int height;

    public void setBase(Rectangle base) {
        this.base = base;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Rectangle getBase() {
        return base;
    }

    public int getHeight() {
        return height;
    }

    public int getVolume(){
        return base.getArea() * height;
    }
}
