package hw3;

public class NestedLoopTest {
    public static void printSquare(int size){
        for (int row = 1; row <= size; row++) {
            for(int col = 1; col <= size; col++){
                System.out.print("# ");
            }
            System.out.println();
        }
    }

    public static void printFigureA(int size){
        for(int row = 1; row <= size; row++){
            for(int col = 1; col <= size; col++){
                if(col <= row)
                    System.out.print("# ");
            }
            System.out.println();
        }
    }

    public static void printFigureD(int size){
        for(int row = 1; row <= size; row++){
            for(int col = 1; col <= size; col++){
                if(col + row > size)
                    System.out.print("# ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }

    static void printFigureI(int size){
        for(int row = 1; row <= size; row++){
            for(int col = 1; col <= size; col++){
                if(col == row || col == size - row + 1 ||
                    col == 1 || col == size || row == 1 || row == size)
                    System.out.print("# ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        NestedLoopTest.printSquare(5);
        System.out.println();

        NestedLoopTest.printFigureA(7);
        System.out.println();

        NestedLoopTest.printFigureD(7);
        System.out.println();

        NestedLoopTest.printFigureI(7);
    }
}
