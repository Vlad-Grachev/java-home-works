package task5;

public class Rectangle{
    private int length, width;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getArea(){
        return length * width;
    }
}
