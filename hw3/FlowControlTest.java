package hw3;

import java.util.Arrays;
import java.util.Random;

import static hw3.GameConsole.*;

public class FlowControlTest {
    public static void enumIfElseTest(GameConsole c){
        if(c == ODYSSEY)
            System.out.println("It's 1st generation console");
        else
            if(c == ATARI2600)
                System.out.println("It's 2nd generation console");
            else
                if(c == FAMICOM)
                    System.out.println("It's 3rd generation console");
                else
                    if(c == MEGADRIVE)
                        System.out.println("It's 4th generation console");
                    else
                        if(c == PSONE)
                            System.out.println("It's 5th generation console");
    };

    public static void enumSwitchTest(GameConsole c){
        switch (c) {
            case ODYSSEY:
                System.out.println("It's 1st generation console");
                break;
            case ATARI2600:
                System.out.println("It's 2nd generation console");
                break;
            case FAMICOM:
                System.out.println("It's 3rd generation console");
                break;
            case MEGADRIVE:
                System.out.println("It's 4th generation console");
                break;
            case PSONE:
                System.out.println("It's 5th generation console");
                break;
        }
    };

    public static void enumTest(){
        GameConsole console = FAMICOM;
        long startTime = System.nanoTime();
        enumIfElseTest(console);
        long ifelseTime = System.nanoTime() - startTime;
        startTime = System.nanoTime();
        enumSwitchTest(console);
        long switchTime = System.nanoTime() - startTime;
        if(ifelseTime > switchTime)
            System.out.println("switch-case is faster with enum ");
        else
            System.out.println("if-else is faster with enum ");
    }

    public static void arrayIfElseTest(int[] arr){
        int[] stats = new int[11];
        Arrays.fill(stats, 0);

        for (int a : arr) {
            if (a == 0)
                stats[0]++;
            else if (a == 1)
                stats[1]++;
            else if (a == 2)
                stats[2]++;
            else if (a == 3)
                stats[3]++;
            else if (a == 4)
                stats[4]++;
            else if (a == 5)
                stats[5]++;
            else if (a == 6)
                stats[6]++;
            else if (a == 7)
                stats[7]++;
            else if (a == 8)
                stats[8]++;
            else if (a == 9)
                stats[9]++;
            else if (a == 10)
                stats[10]++;
        }
    }

    public static void arraySwitchTest(int[] arr){
        int[] stats = new int[11];
        Arrays.fill(stats, 0);

        for(int a: arr){
            switch (a) {
                case 0:
                    arr[0]++;
                    break;
                case 1:
                    arr[1]++;
                    break;
                case 2:
                    arr[2]++;
                    break;
                case 3:
                    arr[3]++;
                    break;
                case 4:
                    arr[4]++;
                    break;
                case 5:
                    arr[5]++;
                    break;
                case 6:
                    arr[6]++;
                    break;
                case 7:
                    arr[7]++;
                    break;
                case 8:
                    arr[8]++;
                    break;
                case 9:
                    arr[9]++;
                    break;
                case 10:
                    arr[10]++;
                    break;
            }
        }
    }

    public static void arrayTest(){
        int[] arr = new int[50];
        Random random = new Random();

        for (int i = 0; i < arr.length; i++)
            arr[i]  = random.nextInt(11);

        long starTime = System.nanoTime();
        arrayIfElseTest(arr);
        long ifelseTime = System.nanoTime() - starTime;
        starTime = System.nanoTime();
        arraySwitchTest(arr);
        long switchTime = System.nanoTime() - starTime;
        if(ifelseTime > switchTime)
            System.out.println("switch-case is faster with array ");
        else
            System.out.println("if-else is faster with array ");
    }

    public static void main(String[] args) {
        enumTest();
        System.out.println();
        arrayTest();
    }
}
