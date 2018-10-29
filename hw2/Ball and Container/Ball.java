public class Ball {
    private float x;
    private float y;
    private int radius;
    private float xDelta;
    private float yDelta;

    public Ball(float x, float y, int radius,
                int speed, int direction) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        xDelta = (float) (speed * Math.cos(Math.toRadians(direction)));
        yDelta = (float) (-1.0 * speed * Math.sin(Math.toRadians(direction)));
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public float getXDelta() {
        return xDelta;
    }

    public void setXDelta(float xDelta) {
        this.xDelta = xDelta;
    }

    public float getYDelta() {
        return yDelta;
    }

    public void setYDelta(float yDelta) {
        this.yDelta = yDelta;
    }

    public void move(){
        x += xDelta;
        y += yDelta;
    }

    public void reflectHorizontal(){
        x = -1.0f * x;
    }

    public void reflectVertical(){
        y = -1.0f *y;
    }

    @Override
    public String toString() {
        return "Ball[(" + x + "," + y + "), speed=(" +
                xDelta + "," + yDelta + ")]";
    }
}
