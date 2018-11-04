package hw1;

public class Rectangle {
    private float length = 1.0f;
    private float width = 1.0f;

    public Rectangle() {
    }

    public Rectangle(float length, float width) {
        this.length = length;
        this.width = width;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public double getArea(){
        return (double) (length * width);
    }

    public double getPerimeter(){
        return (double) (2.0f * length + 2.0f * width);
    }

    @Override
    public String toString() {
        return "Rectangle[length=?" + length + " ,width=" + width + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;

        Rectangle rect = (Rectangle) obj;
        return Float.compare(width, rect.width) == 0  &&
                Float.compare(length, rect.length) == 0;
    }

    @Override
    public int hashCode() {
        int result = 17;

        result = 31 * result + Float.floatToIntBits(width);
        result = 31 * result + Float.floatToIntBits(length);
        return result;
    }
}
