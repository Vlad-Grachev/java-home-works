package task6;

import task5.Parallelepiped;
import task5.Rectangle;

public class ParallelepipedFactory {
    public Parallelepiped createParallelepiped(){
        Rectangle base = new Rectangle(20, 12);
        int height = 10;
        Parallelepiped pppd = new Parallelepiped();
        pppd.setBase(base);
        pppd.setHeight(height);
        return pppd;
    }
}
