public class Circle {
    private double radius = 1.0;
    String color = "red";

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString(){
        return "Circle[radius=" + radius + ", color=" + color + "]";
    }

    public double getArea(){
        return Math.PI * Math.pow(radius, 2.0);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;

        Circle circle = (Circle) obj;
        return (Double.compare(radius, circle.radius) == 0) &&
                color.equals(circle.color);
    }

    @Override
    public int hashCode() {
        int result = 17;
        long r = Double.doubleToLongBits(radius);
        result = 31 * result + (int)(r ^ (r >>> 32));
        result = 31 * result + color.hashCode();
        return result;
    }
}
