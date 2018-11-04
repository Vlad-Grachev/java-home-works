package hw2;

public class Container {
    private int x1, y1, x2, y2;

    public Container(int x1, int y1, int width, int height) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x1 + width;
        this.y2 = y1 - height;
    }

    public int getX() {
        return x1;
    }

    public int getY() {
        return y1;
    }

    public int getWidth(){
        return x2 - x1;
    }

    public int getHeight(){
        return y1 - y2;
    }

    public boolean collides(Ball ball){
        int r = ball.getRadius();
        if((ball.getX() + r < x2)&&(ball.getX() - r > x1)&&
                (ball.getY() + r > y2)&&(ball.getY() - r < y1))
            return false;
        else
            return true ;
    }

    @Override
    public String toString() {
        return "Container[(" + x1 + "," + y1 +
                "),(" + x2 + "," + y2 + ")]";
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;

        Container c = (Container) obj;
        return (getHeight() == c.getHeight()) && (getWidth() == c.getWidth());
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + getHeight();
        result = 31 * result + getWidth();
        return result;
    }
}
