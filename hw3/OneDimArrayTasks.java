package hw3;

import java.util.Arrays;
import java.util.Random;

public class OneDimArrayTasks {
    public static void taskA(){
        int[] arr = new int[50];
        int j = 0;
        for(int i = 1; i <= 99; i++)
            if(i % 2 == 1)
                arr[j++] = i;
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
        System.out.print("[ ");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    public static void taskB(){
        int[] arr = new int[20];
        Random random = new Random();
        int numEven = 0, numOdd = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(11);
            if(arr[i] % 2 == 0)
                numEven++;
            else
                numOdd++;
        }
        System.out.print("[");
        for(int a: arr)
            System.out.print(a + " ");
        System.out.println("]");
        System.out.println("Amount of even numbers: " + numEven);
        System.out.println("Amount of odd numbers: " + numOdd);

    }

    public static void taskC(){
        int[] arr = new int[10];
        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100) + 1;
        }
        System.out.println(Arrays.toString(arr));
        for(int i = 0; i < arr.length; i++) {
            if(i % 2 == 1)
                arr[i] = 0;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void taskD(){
        int[] arr = new int[15];
        int minInd = 0, maxInd = 0;
        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(101) - 50;
        }
        System.out.println(Arrays.toString(arr));
        for(int i = 0; i < arr.length; i++){
            if(arr[minInd] >= arr[i])
                minInd = i;
            if(arr[maxInd] <= arr[i])
                maxInd = i;
        }
        System.out.println("Max element: " + arr[maxInd]
                + "; Last index: " + maxInd);
        System.out.println("Min element: " + arr[minInd]
                + "; Last index: " + minInd);

    }

    public static void taskE(){
        int size = 10;
        int[] arr1 = new int[size];
        int[] arr2 = new int[size];
        double sum1 = 0.0, sum2 = 0.0;
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            arr1[i] = random.nextInt(11);
            arr2[i] = random.nextInt(11);
        }

        System.out.println("First array: " + Arrays.toString(arr1));
        System.out.println("Second array: " + Arrays.toString(arr2));
        for (int i = 0; i < size; i++){
            sum1 += arr1[i];
            sum2 += arr2[i];
        }
        sum1 /= size;
        sum2 /= size;
        System.out.println("First average: "
                + String.format("%.1f", sum1));
        System.out.println("Second average: "
                + String.format("%.1f", sum2));
        if(sum1 - sum2 > 0.01)
            System.out.println("First average is bigger");
        else
            if(sum2 - sum1 > 0.01)
            System.out.println("Second average is bigger");
            else
                System.out.println("Averages are equal");
    }

    public static void taskF(){
        int[] arr = new int[20];
        Random random = new Random();
        int[] stats = {0, 0, 0}; // stats[0] ~ -1, stats[1] ~ 0, ...
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(3) - 1;
        }
        System.out.println(Arrays.toString(arr));

        for(int a: arr) {
            switch (a) {
                case -1: stats[0]++; break;
                case  0: stats[1]++; break;
                case  1: stats[2]++; break;
            }
        }
        int max;
        if(stats[0] > stats[1]){
            if(stats[0] > stats[2])
                max = stats[0];
            else
                max = stats[2];
        }
        else
            if(stats[1] > stats[2])
                max = stats[1];
            else
                max = stats[2];
        System.out.print("Found most often: ");
        for(int i = 0; i < stats.length; i++)
            if(stats[i] == max)
                System.out.print(i - 1 + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        taskA();
        System.out.println();

        taskB();
        System.out.println();

        taskC();
        System.out.println();

        taskD();
        System.out.println();

        taskE();
        System.out.println();

        taskF();
    }
}
