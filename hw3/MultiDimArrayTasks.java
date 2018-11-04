package hw3;

import java.util.Arrays;
import java.util.Random;

public class MultiDimArrayTasks {
    public static void printArray(int[][] arr, int width){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%" + width + "d", arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void taskA(){
        int[][] arr = new int[8][8];
        Random random = new Random();
        int sum = 0, mult = 1;

        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                arr[i][j] = random.nextInt(99) + 1;
        printArray(arr, 3);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(i == j || j == arr.length - i){
                    sum += arr[i][j];
                    mult *= arr[i][j];
                }
            }
        }
        System.out.println("Sum of elements: " + sum);
        System.out.println("Product of elements: " + mult);
    }

    public static void taskB(){
        int[][] arr = new int[8][5];
        Random random = new Random();
        int max = -100;

        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                arr[i][j] = random.nextInt(199) - 99;
        printArray(arr, 4);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] > max)
                    max = arr[i][j];
            }
        }
        System.out.println("Maximum: " + max);
    }

    public static void taskC() {
        int[][] arr = new int[8][5];
        int[] temp;
        int maxProduct = -1, mIndex = 0;
        Random random = new Random();

        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                arr[i][j] = random.nextInt(21) - 10;
        printArray(arr, 3);

        for (int i = 0; i < arr.length; i++){
            temp = arr[i];
            if(maxProduct < Math.abs(multiplyElems(temp)))
                maxProduct = multiplyElems(temp);
            mIndex = i;
        }
        System.out.println("Max absolute product of elements at row: " + mIndex);
    }

    private static int multiplyElems(int[] arr){
        int product = 1;
        for(int a: arr)
            product *= a;
        return product;
    }

    public static void taskD(){
        int[][] arr = new int[10][7];
        int[] temp;
        Random random = new Random();

        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                arr[i][j] = random.nextInt(101);
        printArray(arr, 3);
        System.out.println();

        for (int i = 0; i < arr.length; i++) {
            temp = arr[i];
            descSort(temp, 0, temp.length - 1);
        }
        printArray(arr, 3);
    }

    private static void descSort(int[] arr, int low, int high){
        int i = low; int j = high, temp;
        int piv = arr[low + (high - low) / 2];

        while (i <= j){
            while (arr[i] > piv)
                i++;
            while (arr[j] < piv)
                j--;
            if (i <= j){
                temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
                i++;
                j--;
            }
        }
        if(low < j)
            descSort(arr, low, j);
        if(i < high)
            descSort(arr, i, high);
    }

    public static void main(String[] args) {
        taskA();
        System.out.println();

        taskB();
        System.out.println();

        taskC();
        System.out.println();

        taskD();
    }
}
