public class ContainerTest {
    public static void main(String[] args) {
        Container container = new Container(0, 0 , 10, 10);
        Ball ball = new Ball(5.0f, -5.0f, 2, 4, 30);
        System.out.println(container);
        System.out.println(ball);
        System.out.println("Container collides ball: " + container.collides(ball));
        if(!container.collides(ball))
            System.out.println("Moving the ball...");
        while (!container.collides(ball)){
            ball.move();
        }
        System.out.println("Container collides ball at next coordinates: (" +
                ball.getX()+ "," + ball.getY() + ")");
    }
}
