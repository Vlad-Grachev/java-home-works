package hw1;

import java.util.ArrayList;
import java.util.Arrays;

public class MyTriangle {
    private MyPoint v1, v2, v3;

    public MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3){
        v1 = new MyPoint(x1, y1);
        v2 = new MyPoint(x2, y2);
        v3 = new MyPoint(x3, y3);
    }

    public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    @Override
    public String toString() {
        return "MyTriangle[v1=" + v1.toString() + "," +
                v2.toString() + "," + v3.toString() + "]";
    }

    public double getPerimeter(){
        return v1.distance(v2) + v2.distance(v3) + v3.distance(v1);
    }
    
    private boolean areClose(double d1, double d2){
        return Math.abs(d1 - d2) < 0.001;
    }
    
    public String getType(){
        String type = "Scalene";
        if(areClose(v1.distance(v2), v2.distance(v3)) &&
           areClose(v1.distance(v2), v1.distance(v3))) {
            type = "Equilateral";
        } else
            if(areClose(v1.distance(v2), v2.distance(v3)) ||
               areClose(v1.distance(v2), v1.distance(v3)) ||
               areClose(v1.distance(v3), v2.distance(v3))) {
                type = "Isosceles";
            }
        return type;
    }

    /* Стороны треугольника имеют тип double, поэтому при написании
      equals() нужно было бы сравнивать их с некоторой точностью. Однако
      в таком случае метод hashCode(), написанный по "рецепту",
      мог бы возвращать разные значения для вроде бы равных треугольников.
       Если пользователю потребуется сравнить треугольники, он может
      вызвать метод getSides() для каждого из них и провести сравнение
      длин сторон самостоятельно*/

    double[] getSides(){
        double[] sides = {v1.distance(v2),
                v2.distance(v3), v3.distance(v1)};
        return sides;
    }
}
